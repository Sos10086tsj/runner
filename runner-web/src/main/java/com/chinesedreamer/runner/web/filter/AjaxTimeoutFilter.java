package com.chinesedreamer.runner.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxTimeoutFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		// if (httpServletRequest.getSession().getAttribute("user") == null) {
		// 判断session里是否有用户信息
					if (httpServletRequest.getHeader("x-requested-with") != null
							&& httpServletRequest.getHeader("x-requested-with")
									.equalsIgnoreCase("XMLHttpRequest")) {
						// 如果是ajax请求响应头会有，x-requested-with
						httpServletResponse.setHeader("sessionstatus", "timeout");// 在响应头设置session状态
						return;
					}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
