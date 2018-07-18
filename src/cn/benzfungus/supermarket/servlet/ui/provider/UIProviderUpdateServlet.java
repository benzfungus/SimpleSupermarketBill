package cn.benzfungus.supermarket.servlet.ui.provider;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.benzfungus.supermarket.entity.Provider;
import cn.benzfungus.supermarket.provider.dao.ProviderDAO;
import cn.benzfungus.supermarket.provider.dao.impl.ProviderDAOImpl;

/**
 * 请求供应商更新页面servlet
 */
@WebServlet("/providerUpdate")
public class UIProviderUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 获取供应商DAO
    private ProviderDAO pdao = new ProviderDAOImpl();
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 获取要更新的供应商ID
		String providerId = req.getParameter("id");
		// 获取该供应商对象
		Provider provider = pdao.getProviderByProviderId(providerId);
		// 交给request
		req.setAttribute("provider", provider);
		// 跳转到供应商更新页面
		req.getRequestDispatcher("/WEB-INF/jsp/providerUpdate.jsp").forward(req, res);
	}

}
