package com.chinesedreamer.runner.web.security.service;

import com.chinesedreamer.runner.web.security.entity.UserSession;
import com.chinesedreamer.runner.web.security.exception.SessionOverdueException;

/**
 * Description: 
 * @author Paris
 * @date Jul 23, 20151:32:49 PM
 * @version beta
 */
public interface UserSessionService {
	public void validateSession() throws SessionOverdueException;
	public UserSession getCurrentUserSession();
}
