package cn.benzfungus.supermarket.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.benzfungus.supermarket.entity.User;
import cn.benzfungus.supermarket.web.form.user.ModifyUserPasswordWebForm;
import cn.benzfungus.supermarket.web.util.WebUtils;

/**
 * 修改用户密码servlet
 */
@WebServlet("/modifyPassword")
public class ModifyPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 获取修改密码表单数据
		ModifyUserPasswordWebForm wf = WebUtils.toWebForm(req, ModifyUserPasswordWebForm.class);
		// 验证是否合法
		if (!wf.validate()) {
			// 提交错误信息
			req.setAttribute("errorAlertMessageMap", wf.getErrorAlertMessageMap());
			// 返回修改页面
			req.getRequestDispatcher("password").forward(req, res);
		}else {
			// 获取修改的用户对象
			User user = (User)req.getSession().getAttribute("user");
			// 是否修改成功
			if(wf.modifyPassword(user.getId())) {
				// 成功则将当前保存在session中的用户信息更新
				user.setPassword(wf.getNewPassword());
				req.getSession().setAttribute("user", user);
				req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, res);
			}else {
			req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, res);
			}
		}
	}

}
