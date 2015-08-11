package com.chinesedreamer.runner.demo.designpattern.abstractfactory;

/**  
* Description:
* @author Paris    
* @date Aug 10, 2015
* @version 1.0
*/
public class DotaFactoryMethod implements FactoryMethod{

	@Override
	public void produce() {
		System.out.println("This is produce of DOTA!");
	}

}
