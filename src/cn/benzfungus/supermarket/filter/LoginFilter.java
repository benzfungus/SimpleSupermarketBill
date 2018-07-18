package cn.benzfungus.supermarket.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 判断用户是否登录
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/*" })
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		// 获取用户Session
		HttpSession session = req.getSession();	
		
		// 禁止缓存, 防止退出后点击后退键还能看到网页缓存内容
		res.setHeader("Cache-Control","no-cache");
		res.setHeader("Cache-Control","no-store");
		res.setHeader("Pragma","no-cache");
		res.setDateHeader("Expires", 0);
		
		// 获取用户请求地址
		String uri = req.getRequestURI();
		// 放行CSS, JS和图片文件
		if(uri.contains(".css") || uri.contains(".js") || uri.contains(".png") || uri.contains(".jpg")) {
			chain.doFilter(req, res);
		}else {
			// 如果请求不是登录页面并且用户没有登录, 则重定向到登录页面
			if(!uri.contains("login")) {
				if (session.getAttribute("user") == null) {
					res.sendRedirect("login");
				}else {
					chain.doFilter(req, res);
				}
			// 如果请求登录页面, 则直接放行
			}else {
				chain.doFilter(req, res);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
