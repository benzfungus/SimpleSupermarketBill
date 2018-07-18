package cn.benzfungus.supermarket.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC工具类
 * @author benzfungus
 *
 */
public class JDBCUtils {
	/**
	 * 数据库连接地址
	 */
	private static final String URL = "jdbc:mysql:///supermarket";
	
	/**
	 * 数据库连接用户名
	 */
	private static final String USER = "root";
	
	/**
	 * 数据库密码
	 */
	private static final String PWD = "123456";
	
	/**
	 * 获取数据库连接
	 * @return 数据库连接对象 conn
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接对象
			conn = DriverManager.getConnection(URL, USER, PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭JDBC对象
	 * @param conn 数据库连接对象
	 */
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
