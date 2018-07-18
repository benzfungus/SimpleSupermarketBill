package cn.benzfungus.supermarket.servlet.bill;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.benzfungus.supermarket.web.form.bill.UpdateBillWebForm;
import cn.benzfungus.supermarket.web.util.WebUtils;

/**
 * 更新账单servlet
 */
@WebServlet("/updateBill")
public class UpdateBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取更新账单表单对象
		UpdateBillWebForm wf = WebUtils.toWebForm(request, UpdateBillWebForm.class);
		// 验证是否合法
		if(!wf.validate()) {
			// 返回错误提示信息
			request.setAttribute("errorAlertMessageMap", wf.getErrorAlertMessageMap());
			// 返回更新页面
			request.getRequestDispatcher("billUpdate").forward(request, response);
		}else {
			// 判断是否修改成功
			if(wf.updateBill() > 0) {
				System.out.println("修改成功");
			}
			request.getRequestDispatcher("billList").forward(request, response);
		}
	}

}
