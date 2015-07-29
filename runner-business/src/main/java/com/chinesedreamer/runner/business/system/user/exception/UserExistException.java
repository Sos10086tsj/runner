package com.chinesedreamer.runner.business.system.user.exception;

import com.chinesedreamer.runner.common.base.exception.entity.BizException;

/**  
* Description:
* @author Paris    
* @date Jul 29, 2015
* @version 1.0
*/
public class UserExistException extends BizException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6692483871507224612L;

	public UserExistException(String message, Throwable cause){
		super(message, cause);
	}
	
	public UserExistException(String message){
		super(message);
	}
}
