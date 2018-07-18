package cn.benzfungus.supermarket.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.benzfungus.supermarket.web.form.user.UpdateUserWebForm;
import cn.benzfungus.supermarket.web.util.WebUtils;

/**
 * 更新用户servlet
 */
@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 封装更新表单数据
		UpdateUserWebForm wf = WebUtils.toWebForm(request, UpdateUserWebForm.class);
		// 验证是否合法
		if(!wf.validate()) {
			// 提交错误信息
			request.setAttribute("errorAlertMessageMap", wf.getErrorAlertMessageMap());
			// 返回更新页面
			request.getRequestDispatcher("userUpdate").forward(request, response);
		}else {
			// 判断是否更新成功
			if(wf.updateUser() > 0) {
				System.out.println("修改成功");
			}
			// 返回用户显示页面
			request.getRequestDispatcher("userList").forward(request, response);
		}
	}

}
