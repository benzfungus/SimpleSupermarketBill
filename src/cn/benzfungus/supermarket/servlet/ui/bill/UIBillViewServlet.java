package cn.benzfungus.supermarket.servlet.ui.bill;

import java.io.IOException;

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
 * 请求账单详情页面servlet
 */
@WebServlet("/billView")
public class UIBillViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 获取账单和供应商的DAO
    private BillDAO bdao = new BillDAOImpl();
    private ProviderDAO pdao = new ProviderDAOImpl();
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 获取要显示的账单ID
		String billId = req.getParameter("id");
		// 获取该账单对象
		Bill bill = bdao.getBillByBillId(billId);
		// 获取该账单对应的供应商的信息
		String providerId = bill.getProviderId();
		Provider provider = pdao.getProviderByProviderId(providerId);
		// 交给request
		req.setAttribute("bill", bill);
		req.setAttribute("provider", provider);
		// 跳转到详情页面
		req.getRequestDispatcher("/WEB-INF/jsp/billView.jsp").forward(req, res);
	}

}
