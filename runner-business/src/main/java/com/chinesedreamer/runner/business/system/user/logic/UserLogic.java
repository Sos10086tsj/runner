package com.chinesedreamer.runner.business.system.user.logic;

import com.chinesedreamer.runner.business.system.user.model.User;
import com.chinesedreamer.runner.common.base.jpa.logic.BaseLogic;

/**  
* Description:
* @author Paris    
* @date Jul 28, 2015
* @version 1.0
*/
public interface UserLogic extends BaseLogic<User, Long>{
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);
}
