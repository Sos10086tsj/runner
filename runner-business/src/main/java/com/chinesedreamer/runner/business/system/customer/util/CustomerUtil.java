package com.chinesedreamer.runner.business.system.customer.util;
/**
 * Description: 
 * @author Paris
 * @date Jul 23, 20153:46:17 PM
 * @version beta
 */
public class CustomerUtil {
	public static String generateCustomerCode(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("CUST")
		.append(System.currentTimeMillis());
		return buffer.toString();
	}
}
