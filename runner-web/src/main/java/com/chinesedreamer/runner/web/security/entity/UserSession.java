package com.chinesedreamer.runner.web.security.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
/**
 * Description: 
 * @author Paris
 * @date Jul 23, 20151:42:25 PM
 * @version beta
 */
public @Getter @Setter class UserSession {
	private String username;
	private String sessionId;
	private Date createDate;
}
