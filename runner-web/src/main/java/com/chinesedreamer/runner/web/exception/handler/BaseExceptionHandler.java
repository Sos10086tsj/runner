package com.chinesedreamer.runner.web.exception.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/** 
 * Description: 统一处理异常
 * @author Paris Tao
 * @version 1.0beta
 * @date 2015年6月21日 上午8:37:30 
 * Copyright:   Copyright (c)2015
 */
@Component
public class BaseExceptionHandler implements HandlerExceptionResolver{
	private Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ModelAndView view = new ModelAndView("exception");
		logger.error("{}",ex);
		return view;
	}

}
