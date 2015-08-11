package com.chinesedreamer.runner.demo.designpattern.factorymethod;

/**  
* Description:
* @author Paris    
* @date Aug 10, 2015
* @version 1.0
*/
public class Factory {
	
	public FactoryMethod getInstance(FactoryType type){
		FactoryMethod fm = null;
		switch (type) {
		case DOTA:
			fm = new DotaFactory();;
			break;
		case DOTA2:
			fm = new Dota2Factory();
			break;
		default:
			break;
		}
		return fm;
	}
	
}
