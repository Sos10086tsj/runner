package com.chinesedreamer.runner.web.filter;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.chinesedreamer.runner.web.security.exception.SessionOverdueException;
import com.chinesedreamer.runner.web.security.service.UserSessionService;

/**
 * Description: 
 * @author Paris
 * @date Jul 23, 201510:51:28 AM
 * @version beta
 */
public class SessionFilter implements Filter{
	private Logger logger = LoggerFactory.getLogger(SessionFilter.class);
	private static final String[] ignoreUri = new String[]{".css",".js",".jpg",".png",".gif",".json",".ico"};
	@Autowired
	private UserSessionService userSessionService;
	private String sessionOverduePage = "login";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpSession session = httpServletRequest.getSession();
		String ctx = httpServletRequest.getContextPath();
		session.setAttribute("ctx", (null == ctx  ? "" : ctx) );
		String uri = httpServletRequest.getServletPath();
		SessionContext.setContext(request);
		if (StringUtils.isNotEmpty(uri) 
				&& !(uri.equals("/index") 
						|| uri.equals("/logout") 
						|| uri.equals("/login")) 
						&& !isStaticResourceRequest(uri)) {
			try {
				this.userSessionService.validateSession();
			} catch (Exception e) {
				logger.error("{}",e);
				request.getRequestDispatcher(sessionOverduePage).forward(request, response);
				return;
			}
			
		}
		chain.doFilter(request, response);
	}
	
	private boolean isStaticResourceRequest(String uri) {
		boolean isStaticResourceRequest = false;
		for (String ignore : ignoreUri) {
			if (uri.endsWith(ignore)) {
				isStaticResourceRequest = true;
				break;
			}
		}
		return isStaticResourceRequest;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public static class SessionContext implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 3192265765376636916L;
		
		public static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();
		
		public static HttpServletRequest getContext(){  
			if (null == threadLocal.get()) {
				throw new SessionOverdueException("Session invalid, please re-login.");
			}
			return (HttpServletRequest)threadLocal.get();
		}
		
		public static void setContext(Object request){   
			threadLocal.set(request);
		}   
		
		public static void cleanContext(){   
			threadLocal.set(null);   
		}
	}
}
