package com.chinesedreamer.runner.web.security.logic;

import com.chinesedreamer.runner.web.security.entity.UserSession;
import com.chinesedreamer.runner.web.security.exception.SessionOverdueException;

/**
 * Description: 
 * @author Paris
 * @date Jul 23, 20151:41:18 PM
 * @version beta
 */
public interface UserSessionLogic {
	/**
	 * 检查session是否存在
	 */
	public void validateSession() throws SessionOverdueException;
	
	/**
	 * 获取当前用户
	 * @return
	 */
	public UserSession getCurrentUserSession() throws SessionOverdueException;
	
	/**
	 * 保存用户session
	 */
	public void saveUserSessionCache(UserSession userSession);
	
	/**
	 * 清楚session
	 * @param userSession
	 */
	public void clear(UserSession userSession);
}
