package com.chinesedreamer.runner.business.system.user.exception;

import com.chinesedreamer.runner.common.base.exception.entity.BizException;

/**  
* Description:
* @author Paris    
* @date Jul 29, 2015
* @version 1.0
*/
public class UsernamePasswordIncorrectException extends BizException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2080151638684777714L;

	public UsernamePasswordIncorrectException(String message, Throwable cause){
		super(message, cause);
	}
	
	public UsernamePasswordIncorrectException(String message){
		super(message);
	}
}
