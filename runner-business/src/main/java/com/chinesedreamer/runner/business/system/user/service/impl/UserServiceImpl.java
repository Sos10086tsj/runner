package com.chinesedreamer.runner.business.system.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.runner.business.system.user.constant.UserStatus;
import com.chinesedreamer.runner.business.system.user.exception.UserExistException;
import com.chinesedreamer.runner.business.system.user.logic.UserLogic;
import com.chinesedreamer.runner.business.system.user.model.User;
import com.chinesedreamer.runner.business.system.user.service.UserService;
import com.chinesedreamer.runner.business.system.user.vo.UserVo;
import com.chinesedreamer.runner.common.security.EncryptionUtil;

/**
 * Description: 
 * @author Paris
 * @date Jul 23, 20152:00:53 PM
 * @version beta
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserLogic logic;

	@Override
	public void register(UserVo vo) throws UserExistException{
		//1. 检查用户名是否存在
		User exist = this.logic.findByUsername(vo.getUsername());
		if (null != exist) {
			throw new UserExistException("User " + vo.getUsername() + " already exist, please try again.");
		}
		//2. 保存用户
		User user = new User();
		user.setUsername(vo.getUsername());
		user.setName(vo.getName());
		//密码 = MD5(密码 + 盐 + 时间）
		String password = EncryptionUtil.md5L32(vo.getPassword() + user.getSalt() + user.getRegisterDate());
		user.setPassword(password);
		user.setStatus(UserStatus.ACTIVE);
		this.logic.save(user);
	}

}
