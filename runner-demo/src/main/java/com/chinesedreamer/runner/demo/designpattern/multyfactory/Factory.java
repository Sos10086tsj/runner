package com.chinesedreamer.runner.demo.designpattern.multyfactory;

/**  
* Description:
* @author Paris    
* @date Aug 10, 2015
* @version 1.0
*/
public class Factory {
	
	public static FactoryMethod produceDota(){
		return new DotaFactory();
	}
	
	public static FactoryMethod produceDota2(){
		return new Dota2Factory();
	}
}
