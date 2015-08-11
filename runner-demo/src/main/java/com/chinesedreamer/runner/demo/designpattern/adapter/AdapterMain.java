package com.chinesedreamer.runner.demo.designpattern.adapter;
/**  
* Description: 适配器的目标是从多方已存在接口中，获取需要的接口拼装成新的方法类或者接口
* @author Paris    
* @date Aug 11, 2015
* @version 1.0
*/
public class AdapterMain {
	public static void main(String[] args){
		TargetA a = new TargetA();
		TargetB b = new TargetB();
		
		a.source1();
		a.source2();
		b.source1();
		b.source2();
	}
}
