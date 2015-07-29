package com.chinesedreamer.runner.business.system.user.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.chinesedreamer.runner.business.system.customer.model.Customer;
import com.chinesedreamer.runner.business.system.user.constant.UserStatus;
import com.chinesedreamer.runner.common.base.jpa.model.BaseVersionEntity;
import com.chinesedreamer.runner.common.security.EncryptionUtil;

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
	private String salt = EncryptionUtil.generateSalt(8);//盐
	
	@Column
	private String name;//名字
	
	@Column(name = "status")
	@Enumerated(EnumType.ORDINAL)
	private UserStatus status;//状态
	
	@Column(name = "cust_code")
	private String custCode;//客户外键
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_code", referencedColumnName = "code", insertable = false, updatable = false)
	private Customer customer;
	
	@Column(name = "register_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date registerDate = new Date();
}
