package com.chinesedreamer.runner.business.system.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.chinesedreamer.runner.business.system.user.constant.UserStatus;
import com.chinesedreamer.runner.common.base.jpa.model.BaseVersionEntity;

import lombok.Getter;
import lombok.Setter;

/**  
* Description:
* @author Paris    
* @date Jul 28, 2015
* @version 1.0
*/

@Entity
@Table(name = "sys_user")
public @Getter @Setter class User extends BaseVersionEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8375672365606481731L;

	@Column
	private String username;//用户名
	
	@Column
	private String password;//密码
	
	@Column
	private String salt;//盐
	
	@Column
	private String name;//名字
	
	@Column(name = "status")
	@Enumerated(EnumType.ORDINAL)
	private UserStatus status;//状态
}
