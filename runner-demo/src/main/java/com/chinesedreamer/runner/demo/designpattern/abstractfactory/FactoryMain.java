package com.chinesedreamer.runner.demo.designpattern.abstractfactory;
/**  
* Description:
* @author Paris    
* @date Aug 10, 2015
* @version 1.0
*/
public class FactoryMain {
	public static void main(String args[]){
		Factory fac = null;
		for(int i = 0 ; i < 20; i++){
			System.out.println("i:" + i);
			if (i % 2 == 0) {
				fac = new DotaFactory();
			}else {
				fac = new Dota2Factory();
			}
			fac.getInstance().produce();
		}
	}
}
