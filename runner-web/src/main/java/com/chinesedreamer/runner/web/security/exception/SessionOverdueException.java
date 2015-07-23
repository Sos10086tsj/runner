package com.chinesedreamer.runner.web.security.exception;

import com.chinesedreamer.runner.common.base.exception.entity.BizException;


/**
 * Description: 
 * @author Paris
 * @date Feb 11, 201510:17:22 AM
 * @version beta
 */
public class SessionOverdueException extends BizException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4423641251918769005L;

	public SessionOverdueException(String message) {
		super(message);
	}

}
