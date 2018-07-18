package cn.benzfungus.supermarket.servlet.ui.bill;

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
import cn.benzfungus.supermarket.entity.Provider;
import cn.benzfungus.supermarket.provider.dao.ProviderDAO;
import cn.benzfungus.supermarket.provider.dao.impl.ProviderDAOImpl;

/**
 * 请求账单显示页面servlet
 */
@WebServlet("/billList")
public class UIBillListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 获取供应商DAO
	private ProviderDAO pdao = new ProviderDAOImpl();
	// 获取账单DAO
	private BillDAO bdao = new BillDAOImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 获取所有账单
		List<Bill> bills = bdao.getAllBill();
		System.out.println(bills.size());
		// 获取所有供应商
		List<Provider> providers = pdao.getAllProvider();
		System.out.println(providers.size());
		// 交给request
		req.setAttribute("bills", bills);
		req.setAttribute("providers", providers);
		// 跳转到账单显示页面
		req.getRequestDispatcher("/WEB-INF/jsp/billList.jsp").forward(req, res);
	}

}
