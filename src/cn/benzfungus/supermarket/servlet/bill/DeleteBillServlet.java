package cn.benzfungus.supermarket.servlet.bill;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.benzfungus.supermarket.bill.dao.BillDAO;
import cn.benzfungus.supermarket.bill.dao.impl.BillDAOImpl;

/**
 * 删除账单servlet
 */
@WebServlet("/deleteBill")
public class DeleteBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 持有一个账单数据访问对象
	private BillDAO bdao = new BillDAOImpl();
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取要删除的对象ID
		String id = request.getParameter("id");
		// 判断是否删除成功
		if (bdao.deleteBill(id) > 0) {
			System.out.println("删除成功");
		}
		// 将页面转发到账单显示页面
		request.getRequestDispatcher("billList").forward(request, response);
	}

}
