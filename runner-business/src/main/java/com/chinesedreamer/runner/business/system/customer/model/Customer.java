package com.chinesedreamer.runner.business.system.customer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.springframework.format.annotation.DateTimeFormat;

import com.chinesedreamer.runner.business.system.customer.util.CustomerUtil;
import com.chinesedreamer.runner.common.base.jpa.model.BaseEntity;

/**
 * Description: 
 * @author Paris
 * @date Jul 23, 20153:42:08 PM
 * @version beta
 */
@Entity
@Table(name = "sys_customer")
public @Getter @Setter class Customer extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7830885993789155992L;

	@Column
	private String code = CustomerUtil.generateCustomerCode();//客户唯一ID
	
	@Column
	private String name;//客户名称
	
	@Column(name = "create_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate = new Date();//创建时间
}
