package com.chinesedreamer.runner.demo.designpattern.decorator;

import lombok.Getter;
import lombok.Setter;

/**  
* Description:
* @author Paris    
* @date Aug 11, 2015
* @version 1.0
*/
public class PrinterExtent implements Printer{
	private @Getter @Setter Printer printer;
	public PrinterExtent(Printer printer){
		super();
		this.printer = printer;
	}
	
	@Override
	public void print() {
		System.out.println("首先打印订单信息");
		printer.print();
		System.out.println("然后打印签名时间：" + System.currentTimeMillis());
	}

}
