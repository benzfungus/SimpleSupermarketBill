package cn.benzfungus.supermarket.servlet.provider;

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
 * Servlet implementation class SearchUserServlet
 */
@WebServlet("/searchProvider")
public class SearchProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 获取供应商数据访问对象
	private ProviderDAO pdao = new ProviderDAOImpl();
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取查询的供应商名称
		String providerName = request.getParameter("providerName");
		// 得到查询结果->供应商集合
		List<Provider> providers = pdao.searchProvider(providerName);
		// 将供应商集合交给request返回
		request.setAttribute("providers", providers);
		// 返回到显示页面
		request.getRequestDispatcher("/WEB-INF/jsp/providerList.jsp").forward(request, response);
	}

}
