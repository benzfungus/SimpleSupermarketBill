package cn.benzfungus.supermarket.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.benzfungus.supermarket.web.form.user.InsertUserWebForm;
import cn.benzfungus.supermarket.web.util.WebUtils;

/**
 * 添加用户servlet
 */
@WebServlet("/insertUser")
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 封装用户添加表单数据
		InsertUserWebForm wf = WebUtils.toWebForm(request, InsertUserWebForm.class);
		// 验证数据是否合法
		if(!wf.validate()) {
			System.out.println("信息不合法");
			// 提交错误信息
			request.setAttribute("errorAlertMessageMap", wf.getErrorAlertMessageMap());
			// 返回添加页面
			request.getRequestDispatcher("userAdd").forward(request, response);
		}else {
			// 判断是否添加成功
			System.out.println("信息合法");
			if(wf.insertUser() > 0) {
				System.out.println("添加成功");
			}
			// 返回显示页面
			request.getRequestDispatcher("userList").forward(request, response);
		}
	}

}
