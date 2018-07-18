package cn.benzfungus.supermarket.servlet.provider;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.benzfungus.supermarket.web.form.provider.UpdateProviderWebForm;
import cn.benzfungus.supermarket.web.util.WebUtils;

/**
 * 更新供应商servlet
 */
@WebServlet("/updateProvider")
public class UpdateProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取更新表单对象
		UpdateProviderWebForm wf = WebUtils.toWebForm(request, UpdateProviderWebForm.class);
		// 验证是否合法
		if(!wf.validate()) {
			// 返回错误提示信息
			request.setAttribute("errorAlertMessageMap", wf.getErrorAlertMessageMap());
			// 返回更新页面
			request.getRequestDispatcher("providerUpdate").forward(request, response);
		}else {
			// 判断是否修改成功
			if(wf.updateProvider() > 0) {
				System.out.println("修改成功");
			}
			request.getRequestDispatcher("providerList").forward(request, response);
		}
	}

}
