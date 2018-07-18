package cn.benzfungus.supermarket.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.benzfungus.supermarket.web.form.user.LoginUserWebForm;
import cn.benzfungus.supermarket.web.util.WebUtils;

/**
 * 登录servlet
 * @author benzfungus
 *
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 封装用户登录表单数据
		LoginUserWebForm wf = WebUtils.toWebForm(req, LoginUserWebForm.class);
		// 判断是否存在该用户
		if (wf.validate()) {
			// 将用户对象设置到session中保存
			req.getSession().setAttribute("user", wf.getUser());
			// 转发到index.jsp页面
			req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, res);
		}else {
			// 将错误信息提交给request对象
			req.setAttribute("errorAlertMessageMap", wf.getErrorAlertMessageMap());
			// 重定向到登录页面
			res.sendRedirect("login");
		}
		
	}
}
