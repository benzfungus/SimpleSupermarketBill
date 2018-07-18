package cn.benzfungus.supermarket.servlet.ui.bill;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.benzfungus.supermarket.entity.Provider;
import cn.benzfungus.supermarket.provider.dao.ProviderDAO;
import cn.benzfungus.supermarket.provider.dao.impl.ProviderDAOImpl;

/**
 * 请求账单添加页面servlet
 */
@WebServlet("/billAdd")
public class UIBillAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 获取供应商数据访问对象
	private ProviderDAO pdao = new ProviderDAOImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 得到所有供应商的集合
		List<Provider> providers = pdao.getAllProvider();
		// 交给request对象
		req.setAttribute("providers", providers);
		// 转发到账单添加页面
		req.getRequestDispatcher("/WEB-INF/jsp/billAdd.jsp").forward(req, res);
	}

}
