package cn.benzfungus.supermarket.servlet.ui.user;

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
 * 请求用户显示页面servlet
 */
@WebServlet("/userList")
public class UIUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 获取用户DAO
    private UserDAO udao = new UserDAOImpl();
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 获取所有用户
		List<User> users = udao.getAllUsers();
		// 交给request
		req.setAttribute("users", users);
		// 跳转到用户显示页面
		req.getRequestDispatcher("/WEB-INF/jsp/userList.jsp").forward(req, res);
	}

}
