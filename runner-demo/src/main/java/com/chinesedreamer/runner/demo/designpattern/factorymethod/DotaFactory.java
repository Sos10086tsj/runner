package com.chinesedreamer.runner.demo.designpattern.factorymethod;

/**  
* Description:
* @author Paris    
* @date Aug 10, 2015
* @version 1.0
*/
public class DotaFactory implements FactoryMethod{

	@Override
	public void produce() {
		System.out.println("This is produce of DOTA!");
	}

}
