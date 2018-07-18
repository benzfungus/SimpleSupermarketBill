package cn.benzfungus.supermarket.servlet.provider;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.benzfungus.supermarket.web.form.provider.InsertProviderWebForm;
import cn.benzfungus.supermarket.web.util.WebUtils;

/**
 * 添加供应商servlet
 */
@WebServlet("/insertProvider")
public class InsertProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取添加的表单内容
		InsertProviderWebForm wf = WebUtils.toWebForm(request, InsertProviderWebForm.class);
		// 判断提交内容是否合法
		if(!wf.validate()) {
			// 将错误信息交给request对象返回
			request.setAttribute("errorAlertMessageMap", wf.getErrorAlertMessageMap());
			request.getRequestDispatcher("providerAdd").forward(request, response);
		}else {
			// 判断是否添加成功
			if(wf.insertProvider() > 0) {
				System.out.println("添加成功");
			}
			// 返回显示页面
			request.getRequestDispatcher("providerList").forward(request, response);
		}
	}

}
