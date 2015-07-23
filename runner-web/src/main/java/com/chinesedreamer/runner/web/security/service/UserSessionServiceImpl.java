package com.chinesedreamer.runner.web.security.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.runner.web.security.entity.UserSession;
import com.chinesedreamer.runner.web.security.exception.SessionOverdueException;
import com.chinesedreamer.runner.web.security.logic.UserSessionLogic;

/**
 * Description: 
 * @author Paris
 * @date Jul 23, 20151:32:59 PM
 * @version beta
 */
@Service
public class UserSessionServiceImpl implements UserSessionService{
	@Resource
	private UserSessionLogic logic;
	@Override
	public void validateSession() throws SessionOverdueException{
		this.logic.validateSession();
	}

	@Override
	public UserSession getCurrentUserSession() {
		return this.logic.getCurrentUserSession();
	}

}
