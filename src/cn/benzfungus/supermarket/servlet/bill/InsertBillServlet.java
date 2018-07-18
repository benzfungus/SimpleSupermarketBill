package cn.benzfungus.supermarket.servlet.bill;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.benzfungus.supermarket.web.form.bill.InsertBillWebForm;
import cn.benzfungus.supermarket.web.util.WebUtils;

/**
 * 添加账单servlet
 */
@WebServlet("/insertBill")
public class InsertBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取添加账单的表单内容
		InsertBillWebForm wf = WebUtils.toWebForm(request, InsertBillWebForm.class);
		// 判断提交内容是否合法
		if(!wf.validate()) {
			// 将错误信息交给request对象返回
			System.out.println("信息不合法");
			request.setAttribute("errorAlertMessageMap", wf.getErrorAlertMessageMap());
			request.getRequestDispatcher("billAdd").forward(request, response);
		}else {
			// 判断是否添加成功
			if(wf.insertBill() > 0) {
				System.out.println("添加成功");
			}else {
				System.out.println("添加失败");
			}
			// 转发回账单显示页面
			request.getRequestDispatcher("billList").forward(request, response);
		}
	}

}
