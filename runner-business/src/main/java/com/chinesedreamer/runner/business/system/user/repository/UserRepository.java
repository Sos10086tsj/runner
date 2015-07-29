package com.chinesedreamer.runner.business.system.user.repository;

import com.chinesedreamer.runner.business.system.user.model.User;
import com.chinesedreamer.runner.common.base.jpa.repository.BaseRepository;

/**  
* Description:
* @author Paris    
* @date Jul 28, 2015
* @version 1.0
*/
public interface UserRepository extends BaseRepository<User, Long>{
	public User findByUsername(String username);
}
