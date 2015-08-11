package com.chinesedreamer.runner.demo.designpattern.multyfactory;
/**  
* Description:
* @author Paris    
* @date Aug 10, 2015
* @version 1.0
*/
public class FactoryMain {
	public static void main(String args[]){
		for(int i = 0 ; i < 20; i++){
			System.out.println("i:" + i);
			if (i % 2 == 0) {
				Factory.produceDota();
			}else {
				Factory.produceDota2();
			}
		}
	}
}
