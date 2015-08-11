package com.chinesedreamer.runner.demo.designpattern.decorator;
/**  
* Description:装饰模式的初衷是强化某个核心类，如果对原方法依赖性不强，完全没有必要做这种方式
* @author Paris    
* @date Aug 11, 2015
* @version 1.0
*/
public class PrinterMain {
	public static void main(String[] args){
		PrinterExtent pe = new PrinterExtent(new PrintImpl());
		pe.print();
	}
}
