package com.chinesedreamer.runner.business.system.user.service;

import com.chinesedreamer.runner.business.system.user.exception.UserExistException;
import com.chinesedreamer.runner.business.system.user.exception.UserNotExistException;
import com.chinesedreamer.runner.business.system.user.exception.UsernamePasswordIncorrectException;
import com.chinesedreamer.runner.business.system.user.vo.UserVo;

/**
 * Description: 
 * @author Paris
 * @date Jul 23, 20151:49:44 PM
 * @version beta
 */
public interface UserService {
	
	/**
	 * 注册用户
	 * @param vo
	 * @throws UserExistException
	 */
	public void register(UserVo vo) throws UserExistException;
	
	/**
	 * 用户登陆
	 * @param vo
	 * @throws UserNotExistException
	 * @throws UsernamePasswordIncorrectException
	 */
	public void login(UserVo vo) throws UserNotExistException, UsernamePasswordIncorrectException;
}
