package cn.benzfungus.supermarket.servlet.ui.provider;

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
 * 请求供应商显示页面servlet
 */
@WebServlet("/providerList")
public class UIProviderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 获取供应商DAO
    private ProviderDAO pdao = new ProviderDAOImpl();
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 获取所有供应商
		List<Provider> providers = pdao.getAllProvider();
		// 交给request
		req.setAttribute("providers", providers);
		// 跳转到供应商显示页面
		req.getRequestDispatcher("/WEB-INF/jsp/providerList.jsp").forward(req, res);
	}

}
