package com.chinesedreamer.runner.demo.designpattern.abstractfactory;
/**  
* Description:
* @author Paris    
* @date Aug 10, 2015
* @version 1.0
*/
public class DotaFactory implements Factory{

	@Override
	public FactoryMethod getInstance() {
		return new DotaFactoryMethod();
	}

}
