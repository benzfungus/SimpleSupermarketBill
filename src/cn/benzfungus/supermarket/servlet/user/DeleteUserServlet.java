package cn.benzfungus.supermarket.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.benzfungus.supermarket.user.dao.UserDAO;
import cn.benzfungus.supermarket.user.dao.impl.UserDAOImpl;

/**
 * 删除用户servlet
 */
@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 获取用户DAO
	private UserDAO udao = new UserDAOImpl();
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取要删除的用户ID
		String id = request.getParameter("id");
		// 是否删除成功
		if (udao.deleteUser(id) > 0) {
			System.out.println("删除成功");
		}
		// 回到用户显示页面
		request.getRequestDispatcher("userList").forward(request, response);
	}

}
