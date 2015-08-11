package com.chinesedreamer.runner.demo.designpattern.factorymethod;
/**  
* Description:
* @author Paris    
* @date Aug 10, 2015
* @version 1.0
*/
public class FactoryMain {
	public static void main(String args[]){
		Factory factory = new Factory();
		for(int i = 0 ; i < 20; i++){
			System.out.println("i:" + i);
			if (i % 2 == 0) {
				factory.getInstance(FactoryType.DOTA).produce();;
			}else {
				factory.getInstance(FactoryType.DOTA2).produce();;
			}
		}
	}
}
