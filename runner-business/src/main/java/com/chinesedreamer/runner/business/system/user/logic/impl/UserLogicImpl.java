package com.chinesedreamer.runner.business.system.user.logic.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.runner.business.system.user.logic.UserLogic;
import com.chinesedreamer.runner.business.system.user.model.User;
import com.chinesedreamer.runner.business.system.user.repository.UserRepository;
import com.chinesedreamer.runner.common.base.jpa.logic.BaseLogicImpl;

/**  
* Description:
* @author Paris    
* @date Jul 28, 2015
* @version 1.0
*/
@Service
public class UserLogicImpl extends BaseLogicImpl<User, Long> implements UserLogic{
	@Resource
	private UserRepository repository;
	@Override
	public User findByUsername(String username) {
		return this.repository.findByUsername(username);
	}

}
