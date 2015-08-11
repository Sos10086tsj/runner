package com.chinesedreamer.runner.demo.designpattern.decorator;
/**  
* Description:
* @author Paris    
* @date Aug 11, 2015
* @version 1.0
*/
public class PrintImpl implements Printer{

	@Override
	public void print() {
		System.out.println("I'm working to print the order.");
	}

}
