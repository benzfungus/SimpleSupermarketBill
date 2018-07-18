package cn.benzfungus.supermarket.servlet.provider;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.benzfungus.supermarket.provider.dao.ProviderDAO;
import cn.benzfungus.supermarket.provider.dao.impl.ProviderDAOImpl;

/**
 * 删除供应商servlet
 */
@WebServlet("/deleteProvider")
public class DeleteProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 持有一个供应商数据访问对象
	private ProviderDAO pdao = new ProviderDAOImpl();
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取要删除的对象ID
		String id = request.getParameter("id");
		// 判断是否删除成功
		if (pdao.deleteProvider(id) > 0) {
			System.out.println("删除成功");
		}
		// 返回供应商显示页面
		request.getRequestDispatcher("providerList").forward(request, response);
	}

}
