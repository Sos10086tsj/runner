package com.chinesedreamer.runner.common.base.exception.entity;
/**
 * Description: 
 * @author Paris
 * @date Jun 19, 20154:59:17 PM
 * @version beta
 */
public class SysException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3355113620854658771L;

	public SysException(String message, Throwable cause){
		super(message, cause);
	}
	
	public SysException(String message){
		super(message);
	}
}
