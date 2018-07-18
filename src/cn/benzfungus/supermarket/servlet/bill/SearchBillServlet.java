package cn.benzfungus.supermarket.servlet.bill;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.benzfungus.supermarket.bill.dao.BillDAO;
import cn.benzfungus.supermarket.bill.dao.impl.BillDAOImpl;
import cn.benzfungus.supermarket.entity.Bill;

/**
 * 查询账单servlet
 */
@WebServlet("/searchBill")
public class SearchBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 获取账单数据访问对象
	private BillDAO bdao = new BillDAOImpl();
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取查询账单的商品名称
		String goodsName = request.getParameter("goodsName");
		// 获取供应商名称
		String providerId = request.getParameter("providerId");
		// 获取是否付款
		int paid = Integer.parseInt(request.getParameter("paid"));
		// 得到查询结果->账单集合
		List<Bill> bills = bdao.searchBill(goodsName, providerId, paid);
		// 将账单集合交给request返回
		request.setAttribute("bills", bills);
		// 返回到账单显示页面
		request.getRequestDispatcher("/WEB-INF/jsp/billList.jsp").forward(request, response);
	}

}
