package com.chinesedreamer.runner.business.system.user.exception;

import com.chinesedreamer.runner.common.base.exception.entity.BizException;

/**  
* Description:
* @author Paris    
* @date Jul 29, 2015
* @version 1.0
*/
public class UserNotExistException extends BizException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5851470981596675678L;

	public UserNotExistException(String message, Throwable cause){
		super(message, cause);
	}
	
	public UserNotExistException(String message){
		super(message);
	}
}
