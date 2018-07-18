package cn.benzfungus.supermarket.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.benzfungus.supermarket.entity.User;
import cn.benzfungus.supermarket.user.dao.UserDAO;
import cn.benzfungus.supermarket.user.dao.impl.UserDAOImpl;

/**
 * 模糊查询用户servlet
 */
@WebServlet("/searchUser")
public class SearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 获取用户DAO
	private UserDAO udao = new UserDAOImpl();
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取查询的用户名
		String username = request.getParameter("username");
		// 获取用户的集合
		List<User> users = udao.searchUser(username);
		// 交给request
		request.setAttribute("users", users);
		// 返回用户显示页面
		request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp").forward(request, response);
	}

}
