package com.chinesedreamer.runner.web.security.logic;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.chinesedreamer.runner.common.base.cache.BaseCacheAspect;
import com.chinesedreamer.runner.web.filter.SessionFilter;
import com.chinesedreamer.runner.web.security.entity.UserSession;
import com.chinesedreamer.runner.web.security.exception.SessionOverdueException;

/**
 * Description: 
 * @author Paris
 * @date Jul 23, 20151:41:25 PM
 * @version beta
 */
@Service
public class UserSessionLogicImpl extends BaseCacheAspect implements UserSessionLogic{
	
	private final Logger logger = LoggerFactory
			.getLogger(UserSessionLogicImpl.class);

	private final String userSessionCacheName = "sessionCache";
	private final String userSessionPrefix = "user-session-";

	@Override
	public void validateSession() throws SessionOverdueException {
		HttpServletRequest request = SessionFilter.SessionContext.getContext();
		String sessionId = request.getSession().getId();
		UserSession userSession = this.get(userSessionPrefix + sessionId);
		if (null == userSession) {
			throw new SessionOverdueException("Session invalid, please re-login.");
		}
	}

	@Override
	public UserSession getCurrentUserSession() throws SessionOverdueException{
		HttpServletRequest request = SessionFilter.SessionContext.getContext();
		String sessionId = request.getSession().getId();
		UserSession userSession = this.get(userSessionPrefix + sessionId);
		if (null == userSession) {
			throw new SessionOverdueException("Session invalid, please re-login.");
		}
		return userSession;
	}

	@Override
	public void saveUserSessionCache(UserSession userSession) {
		this.logger.info("Save user session cache:{}" , userSession);
		if (null == userSession) {
			this.logger.debug("session is null, return.");
			return;
		}
		setCacheName(userSessionCacheName);
		this.put(userSessionPrefix + userSession.getSessionId(), userSession);
	}

	@Override
	public void clear(UserSession userSession) {
		this.evict(userSessionPrefix + userSession.getSessionId());
	}

}
