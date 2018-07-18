package cn.benzfungus.supermarket.user.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cn.benzfungus.supermarket.dao.utils.JDBCUtils;
import cn.benzfungus.supermarket.entity.User;
import cn.benzfungus.supermarket.user.dao.UserDAO;
import cn.benzfungus.supermarket.web.form.user.InsertUserWebForm;
import cn.benzfungus.supermarket.web.form.user.UpdateUserWebForm;
/**
 * 商品数据访问对象
 * @author benzfungus
 *
 */
public class UserDAOImpl implements UserDAO {
	
	@Override
	public List<User> getAllUsers() {
		String sql = " SELECT id, username, sex, age, mobilePhoneNumber, email, userType from User ";
		List<User> userList = new ArrayList<>();
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			try (PreparedStatement ps = conn.prepareStatement(sql)){
				try (ResultSet rs = ps.executeQuery()) {
					// 获取结果集的每一组结果
					while (rs.next()) {
						String id = rs.getString("id");
						String username = rs.getString("username");
						int sex = rs.getInt("sex");
						int age = rs.getInt("age");
						String mobilePhoneNumber = rs.getString("mobilePhoneNumber");
						String email = rs.getString("email");
						int userType = rs.getInt("userType");
						User user = new User(id, username, sex, age, mobilePhoneNumber, email, userType);
						userList.add(user);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.close(conn);
			}
		}
		return userList;
	}

	@Override
	public User getUserByUserId(String userId) {
		User user = null;
		String sql = " SELECT id, username, sex, age, birthOfDate, mobilePhoneNumber, address, email, userType FROM user WHERE id = ?";
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, userId);
				try (ResultSet rs = ps.executeQuery()){
					// 获取查询结果
					if(rs.next()) {
						String id = rs.getString("id");
						String username = rs.getString("username");
						int sex = rs.getInt("sex");
						int age = rs.getInt("age");
						String birthOfDate = rs.getDate("birthOfDate").toString();
						String mobilePhoneNumber = rs.getString("mobilePhoneNumber");
						String address = rs.getString("address");
						String email = rs.getString("email");
						int userType = rs.getInt("userType");
						user = new User(id, username, sex, age, birthOfDate, mobilePhoneNumber, address, email, userType);
					}
				}
			}catch (SQLException e) {
				e.getMessage();
			}finally {
				JDBCUtils.close(conn);
			}
		}
		return user;
	}

	@Override
	public User validateUser(String username, String password) {
		String sql = " SELECT id, sex, age, mobilePhoneNumber, email, userType FROM user WHERE username = ? AND password = ?";
		User user = null;
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, username);
				ps.setString(2, password);
				try (ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
						String id = rs.getString("id");
						int sex = rs.getInt("sex");
						int age = rs.getInt("age");
						String mobilePhoneNumber = rs.getString("mobilePhoneNumber");
						String email = rs.getString("email");
						int userType = rs.getInt("userType");
						user = new User(id, username, password, sex, age, mobilePhoneNumber, email, userType);
					}
				}
			}catch (SQLException e) {
				e.getMessage();
			}finally {
				JDBCUtils.close(conn);
			}
		}
		return user;
	}

	@Override
	public int insertUser(InsertUserWebForm insertUserWebForm) {
		int succeed = 0;
		String id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		String sql = " INSERT INTO user(id, username, password, sex, age, birthOfDate, mobilePhoneNumber, address, email, userType) VALUE(?, ?, ?, ?, ?, ?, ? ,?, ?, ?)";
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, id);
				ps.setString(2, insertUserWebForm.getUsername());
				ps.setString(3, insertUserWebForm.getPassword());
				ps.setInt(4, insertUserWebForm.getSex());
				ps.setInt(5, insertUserWebForm.getAge());
				Date birthOfDate = new Date(insertUserWebForm.getTransBirthOfDate().getTime());
				ps.setDate(6, birthOfDate);
				ps.setString(7, insertUserWebForm.getMobilePhoneNumber());
				ps.setString(8, insertUserWebForm.getAddress());
				ps.setString(9, insertUserWebForm.getEmail());
				ps.setInt(10, insertUserWebForm.getUserType());
				succeed = ps.executeUpdate();
			}catch (SQLException e) {
				e.getMessage();
			}finally {
				JDBCUtils.close(conn);
			}
		}
		return succeed;
	}

	@Override
	public int modifyUserPassword(String id, String newPassword) {
		String sql = "  UPDATE USER SET password = ? where id = ?";
		int succeed = 0;
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, newPassword);
				ps.setString(2, id);
				succeed = ps.executeUpdate();
			}catch (SQLException e) {
				e.getMessage();
			}finally {
				JDBCUtils.close(conn);
			}
		}
		return succeed;
	}

	@Override
	public int updateUser(UpdateUserWebForm updateUserWebForm) {
		int succeed = 0;
		String sql = " update user SET username = ?, sex = ?, age = ?, birthOfDate = ?, mobilePhoneNumber = ?, address = ?, email = ?, userType = ? WHERE id = ?";
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, updateUserWebForm.getUsername());
				ps.setInt(2, updateUserWebForm.getSex());
				ps.setInt(3, updateUserWebForm.getAge());
				Date d = new Date(updateUserWebForm.getTransBirthOfDate().getTime());
				ps.setDate(4, d);
				ps.setString(5, updateUserWebForm.getMobilePhoneNumber());
				ps.setString(6, updateUserWebForm.getAddress());
				ps.setString(7, updateUserWebForm.getEmail());
				ps.setInt(8, updateUserWebForm.getUserType());
				ps.setString(9, updateUserWebForm.getId());
				succeed = ps.executeUpdate();
			}catch (SQLException e) {
				e.getMessage();
			}finally {
				JDBCUtils.close(conn);
			}
		}
		return succeed;
	}

	@Override
	public int deleteUser(String id) {
		String sql = " DELETE FROM user WHERE id = ?";
		int succeed = 0;
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, id);
				succeed = ps.executeUpdate();
			}catch (SQLException e) {
				e.getMessage();
			}finally {
				JDBCUtils.close(conn);
			}
		}
		return succeed;
	}

	@Override
	public List<User> searchUser(String name) {
		name = name + "%";
		String sql = " SELECT id, username, sex, age, mobilePhoneNumber, email, userType FROM User WHERE username LIKE ? ";
		List<User> userList = new ArrayList<>();
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			try (PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, name);
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						String id = rs.getString("id");
						String username = rs.getString("username");
						int sex = rs.getInt("sex");
						int age = rs.getInt("age");
						String mobilePhoneNumber = rs.getString("mobilePhoneNumber");
						String email = rs.getString("email");
						int userType = rs.getInt("userType");
						User user = new User(id, username, sex, age, mobilePhoneNumber, email, userType);
						userList.add(user);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.close(conn);
			}
		}
		return userList;
	}
	
}
