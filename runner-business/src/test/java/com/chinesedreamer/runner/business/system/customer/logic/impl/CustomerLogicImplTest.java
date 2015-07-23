package com.chinesedreamer.runner.business.system.customer.logic.impl;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.chinesedreamer.runner.business.system.customer.model.Customer;
import com.chinesedreamer.runner.common.base.test.BaseSpringTest;

/**
 * Description: 
 * @author Paris
 * @date Jul 23, 20153:54:32 PM
 * @version beta
 */
public class CustomerLogicImplTest extends BaseSpringTest{
	
	@Test
	@Rollback(value = false)
	public void testSave(){
		Customer customer = new Customer();
		customer.setName("Test测试");
	}
}
