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
 * 请求用户更新页面servlet
 */
@WebServlet("/userUpdate")
public class UIUserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 获取用户DAO
    private UserDAO udao = new UserDAOImpl();
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 获取要更新的用户ID
		String id = req.getParameter("id");
		// 获取该用户对象
		User user = udao.getUserByUserId(id);
		// 交给REQUSET
		req.setAttribute("user", user);
		// 跳转到更新页面
		req.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp").forward(req, res);
	}

}
