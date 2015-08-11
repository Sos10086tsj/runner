package com.chinesedreamer.runner.demo.designpattern.abstractfactory;
/**  
* Description:
* @author Paris    
* @date Aug 10, 2015
* @version 1.0
*/
public class Dota2Factory implements Factory{

	@Override
	public FactoryMethod getInstance() {
		return new Dota2FactoryMethod();
	}

}
