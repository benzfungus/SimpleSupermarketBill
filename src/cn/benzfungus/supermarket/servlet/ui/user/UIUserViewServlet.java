package cn.benzfungus.supermarket.servlet.ui.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.benzfungus.supermarket.entity.User;
import cn.benzfungus.supermarket.user.dao.UserDAO;
import cn.benzfungus.supermarket.user.dao.impl.UserDAOImpl;

/**
 * 请求用户详情页面servlet
 */
@WebServlet("/userView")
public class UIUserViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 获取用户DAO
    private UserDAO udao = new UserDAOImpl();
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 获取要显示的用户ID
		String userId = req.getParameter("id");
		// 获取用户
		User user = udao.getUserByUserId(userId);
		// 交给request
		req.setAttribute("user", user);
		// 跳转到用户详情页面
		req.getRequestDispatcher("/WEB-INF/jsp/userView.jsp").forward(req, res);
	}

}
