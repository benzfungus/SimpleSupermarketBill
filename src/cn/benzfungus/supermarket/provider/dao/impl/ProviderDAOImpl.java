package cn.benzfungus.supermarket.provider.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cn.benzfungus.supermarket.dao.utils.JDBCUtils;
import cn.benzfungus.supermarket.entity.Provider;
import cn.benzfungus.supermarket.provider.dao.ProviderDAO;
import cn.benzfungus.supermarket.web.form.provider.InsertProviderWebForm;
import cn.benzfungus.supermarket.web.form.provider.UpdateProviderWebForm;
/**
 * 供应商数据访问对象实现
 * @author benzfungus
 *
 */
public class ProviderDAOImpl implements ProviderDAO {
	
	@Override
	public List<Provider> getAllProvider() {
		String sql = " SELECT id, providerCode, providerName, contact, contactNumber, address, fax, email, createDate, description FROM Provider ";
		// 创建供应商的集合
		List<Provider> providerList = new ArrayList<>();
		// 获取数据库连接
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			try (PreparedStatement ps = conn.prepareStatement(sql)){
				// 获取结果集
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						String id = rs.getString("id");
						String providerCode = rs.getString("providerCode");
						String providerName = rs.getString("providerName");
						String contact = rs.getString("contact");
						String contactNumber = rs.getString("contactNumber");
						String address = rs.getString("address");
						String fax = rs.getString("fax");
						String email = rs.getString("email");
						String createDate = rs.getString("createDate").toString();
						String description = rs.getString("description");
						// 创建供应商对象
						Provider provider = new Provider(id, providerCode, providerName, contact, contactNumber, address, fax, email, createDate, description);
						// 将供应商对象添加到供应商集合
						providerList.add(provider);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.close(conn);
			}
		}
		return providerList;
	}

	@Override
	public Provider getProviderByProviderId(String providerId) {
		Provider provider = null;
		String sql = " SELECT id, providerCode, providerName, contact, contactNumber, address, fax, email, createDate, description FROM Provider WHERE id = ?";
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, providerId);
				// 返回结果集
				try (ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
						String id = rs.getString("id");
						String providerCode = rs.getString("providerCode");
						String providerName = rs.getString("providerName");
						String contact = rs.getString("contact");
						String contactNumber = rs.getString("contactNumber");
						String address = rs.getString("address");
						String fax = rs.getString("fax");
						String email = rs.getString("email");
						String createDate = rs.getString("createDate").toString();
						String description = rs.getString("description");
						provider = new Provider(id, providerCode, providerName, contact, contactNumber, address, fax, email, createDate, description);
					}
				}
			}catch (SQLException e) {
				e.getMessage();
			}finally {
				JDBCUtils.close(conn);
			}
		}
		return provider;
	}

	@Override
	public int insertProvider(InsertProviderWebForm insertProviderWebForm) {
		int succeed = 0;
		// 通过UUID生成供应商ID 
		String id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		String sql = " INSERT INTO Provider(id, providerCode, providerName, contact, contactNumber, address, fax, email, createDate, description) VALUE(?, ?, ?, ?, ?, ?, ? ,?, ?, ?) ";
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, id);
				ps.setString(2, insertProviderWebForm.getProviderCode());
				ps.setString(3, insertProviderWebForm.getProviderName());
				ps.setString(4, insertProviderWebForm.getContact());
				ps.setString(5, insertProviderWebForm.getContactNumber());
				ps.setString(6, insertProviderWebForm.getAddress());
				ps.setString(7, insertProviderWebForm.getFax());
				ps.setString(8, insertProviderWebForm.getEmail());
				Date createDate = new Date(insertProviderWebForm.generateCreateDate().getTime());
				ps.setDate(9, createDate);
				ps.setString(10, insertProviderWebForm.getDescription());
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
	public int updateProvider(UpdateProviderWebForm updateProviderWebForm) {
		int succeed = 0;
		String sql = " UPDATE Provider SET providerCode = ?, providerName = ?, contact = ?, contactNumber = ?, address = ?, fax = ?, email = ?, description = ? WHERE id = ?";
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, updateProviderWebForm.getProviderCode());
				ps.setString(2, updateProviderWebForm.getProviderName());
				ps.setString(3, updateProviderWebForm.getContact());
				ps.setString(4, updateProviderWebForm.getContactNumber());
				ps.setString(5, updateProviderWebForm.getAddress());
				ps.setString(6, updateProviderWebForm.getFax());
				ps.setString(7, updateProviderWebForm.getEmail());
				ps.setString(8, updateProviderWebForm.getDescription());
				ps.setString(9, updateProviderWebForm.getId());
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
	public int deleteProvider(String id) {
		String sql = " DELETE FROM Provider WHERE id = ?";
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
	public List<Provider> searchProvider(String name) {
		// 模糊查询
		name = name + "%";
		String sql = " SELECT id, providerCode, providerName, contact, contactNumber, address, fax, email, createDate, description FROM Provider WHERE providerName LIKE ? ";
		List<Provider> providerList = new ArrayList<>();
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			try (PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, name);
				System.out.println(ps);
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						String id = rs.getString("id");
						String providerCode = rs.getString("providerCode");
						String providerName = rs.getString("providerName");
						String contact = rs.getString("contact");
						String contactNumber = rs.getString("contactNumber");
						String address = rs.getString("address");
						String fax = rs.getString("fax");
						String email = rs.getString("email");
						String createDate = rs.getString("createDate").toString();
						String description = rs.getString("description");
						Provider provider = new Provider(id, providerCode, providerName, contact, contactNumber, address, fax, email, createDate, description);
						providerList.add(provider);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.close(conn);
			}
		}
		return providerList;
	}
	
}
