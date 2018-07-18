package cn.benzfungus.supermarket.bill.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cn.benzfungus.supermarket.bill.dao.BillDAO;
import cn.benzfungus.supermarket.dao.utils.JDBCUtils;
import cn.benzfungus.supermarket.entity.Bill;
import cn.benzfungus.supermarket.web.form.bill.InsertBillWebForm;
import cn.benzfungus.supermarket.web.form.bill.UpdateBillWebForm;

/**
 * 账单数据访问对象实现类
 * @author benzfungus
 *
 */
public class BillDAOImpl implements BillDAO {

	@Override
	public int deleteBill(String id) {
		// 构造基础SQL语句
		String sql = " DELETE FROM Bill WHERE id = ?";
		// 记录影响的条目数量
		int succeed = 0;
		// 获取数据库连接
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			// 准备SQL语句
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, id);
				// 执行SQL语句
				succeed = ps.executeUpdate();
			} catch (SQLException e) {
			 	e.getMessage();
			} finally {
				// 关闭数据库连接
				JDBCUtils.close(conn);
			}
		}
		return succeed;
	}

	@Override
	public List<Bill> searchBill(String name, String providerId, int paid) {
		name = name + "%";
		String sql = null;
		int flag = 0; 
		if ((providerId == null || providerId.equals("")) && paid < 0) {
			flag = 0;
			sql = " SELECT id, billCode, goodsName, price, quantity, amount, providerId, paid, createDate FROM Bill WHERE goodsName LIKE ? ";
		}
		if (providerId == null || providerId.equals("") && paid > 0) {
			flag = 1;
			sql = " SELECT id, billCode, goodsName, price, quantity, amount, providerId, paid, createDate FROM Bill WHERE goodsName LIKE ? AND paid = ? ";
		}else if(paid > 0) {
			flag = 2;
			sql = " SELECT id, billCode, goodsName, price, quantity, amount, providerId, paid, createDate FROM Bill WHERE goodsName LIKE ?, paid = ? AND providerID = ?";
		}else if(paid < 0) {
			flag = 3;
			sql = " SELECT id, billCode, goodsName, price, quantity, amount, providerId, paid, createDate FROM Bill WHERE goodsName LIKE ? AND providerId = ? ";
		}
		
		List<Bill> billList = new ArrayList<>();
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				if (flag == 0) {
					ps.setString(1, name);					
				}
				if (flag == 1) {
					ps.setString(1, name);
					ps.setInt(2, paid);
				}
				if (flag == 2) {
					ps.setString(1, name);
					ps.setInt(2, paid);
					ps.setString(3, providerId);
				}
				if (flag == 3) {
					ps.setString(1, name);
					ps.setString(2, providerId);
				}
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						String id = rs.getString("id");
						String billCode = rs.getString("billCode");
						String goodsName = rs.getString("goodsName");
						double price = rs.getDouble("price");
						int quantity = rs.getInt("quantity");
						double amount = rs.getDouble("amount");
						String providerId1 = rs.getString("providerId");
						int paid1 = rs.getInt("paid");
						String createDate = rs.getString("createDate").toString();
						Bill bill = new Bill(id, billCode, goodsName, price, quantity, amount, providerId1, paid1, createDate);
						billList.add(bill);
					}
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.close(conn);
			}
		}
		return billList;
	}

	@Override
	public List<Bill> getAllBill() {
		// 创建表单对象集合
		List<Bill> billList = new ArrayList<>();
		// 构建SQL语句
		String sql = " SELECT id, billCode, goodsName, price, quantity, amount, providerId, paid, createDate FROM Bill ";
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			try(PreparedStatement ps = conn.prepareStatement(sql)) {
				// 获取结果集
				try (ResultSet rs = ps.executeQuery()) {
					// 获取结果集中的数据
					while(rs.next()) {
						String id = rs.getString("id");
						String billCode = rs.getString("billCode");
						String goodsName = rs.getString("goodsName");
						double price = rs.getDouble("price");
						int quantity = rs.getInt("quantity");
						double amount = rs.getDouble("amount");
						String providerId = rs.getString("providerId");
						int paid = rs.getInt("paid");
						String createDate = rs.getString("createDate").toString();
						// 构建Bill对象
						Bill bill = new Bill(id, billCode, goodsName, price, quantity, amount, providerId, paid, createDate);
						// 将Bill对象添加到集合中
						billList.add(bill);
					}
				}
			}catch (SQLException e) {
				e.getMessage();
			}finally {
				// 关闭数据库连接
				JDBCUtils.close(conn);
			}
		}
		return billList;
	}

	@Override
	public Bill getBillByBillId(String billId) {
		// 构建Bill变量
		Bill bill = null;
		String sql = " SELECT id, billCode, goodsName, price, quantity, amount, providerId, paid, createDate FROM Bill WHERE id=? ";
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			try(PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, billId);
				// 获取结果集
				try (ResultSet rs = ps.executeQuery()) {
					if(rs.next()) {
						String id = rs.getString("id");
						String billCode = rs.getString("billCode");
						String goodsName = rs.getString("goodsName");
						double price = rs.getDouble("price");
						int quantity = rs.getInt("quantity");
						double amount = rs.getDouble("amount");
						String providerId = rs.getString("providerId");
						int paid = rs.getInt("paid");
						String createDate = rs.getString("createDate").toString();
						// 创建Bill对象
						bill = new Bill(id, billCode, goodsName, price, quantity, amount, providerId, paid, createDate);
					}
				}
			} catch (SQLException e) {
				e.getMessage();
			} finally {
				JDBCUtils.close(conn);
			}
		}
		return bill;
	}

	@Override
	public int updateBill(UpdateBillWebForm updateBillWebForm) {
		// 记录影响的条目数量
		int succeed = 0;
		// 更新账单SQL语句
		String sql = " UPDATE Bill SET billCode = ?, goodsName = ?, price = ?, quantity = ?, amount = ?, providerId = ?, paid = ? WHERE id = ? ";
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			try(PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, updateBillWebForm.getBillCode());
				ps.setString(2, updateBillWebForm.getGoodsName());
				ps.setDouble(3, updateBillWebForm.getPrice());
				ps.setInt(4, updateBillWebForm.getQuantity());
				ps.setDouble(5, updateBillWebForm.getAmount());
				ps.setString(6, updateBillWebForm.getProviderId());
				ps.setInt(7, updateBillWebForm.getPaid());
				ps.setString(8, updateBillWebForm.getId());
				succeed = ps.executeUpdate();
			} catch (SQLException e) {
				e.getMessage();
			} finally {
				JDBCUtils.close(conn);
			}
		}
		return succeed;
	}

	@Override
	public int insertBill(InsertBillWebForm insertBillWebForm) {
		// 记录影响的条目数量
		int succeed = 0;
		// 构建UUID作为Bill的ID
		String id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		String sql = " INSERT INTO Bill(id, billCode, goodsName, price, quantity, amount, providerId, paid, createDate) VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		Connection conn = JDBCUtils.getConnection();
		if (conn != null) {
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, id);
				ps.setString(2, insertBillWebForm.getBillCode());
				ps.setString(3, insertBillWebForm.getGoodsName());
				ps.setDouble(4, insertBillWebForm.getPrice());
				ps.setInt(5, insertBillWebForm.getQuantity());
				ps.setDouble(6, insertBillWebForm.getAmount());
				ps.setString(7, insertBillWebForm.getProviderId());
				ps.setInt(8, insertBillWebForm.getPaid());
				Date createDate = new Date(insertBillWebForm.generateCreateDate().getTime());
				ps.setDate(9, createDate);
				System.out.println(ps);
				succeed = ps.executeUpdate();
			}catch (SQLException e) {
				e.getMessage();
			}finally {
				JDBCUtils.close(conn);
			}
		}
		return succeed;
	}

}
