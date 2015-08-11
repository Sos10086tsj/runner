package com.chinesedreamer.runner.demo.ninedu.sub1000;

import java.util.Scanner;

/**  
* Description:
* @author Paris    
* @date Aug 11, 2015
* @version 1.0
*/
public class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int a, b;
		while (cin.hasNext()) {
			a = cin.nextInt(); 
			b = cin.nextInt();
			System.out.println(a + b);
		}
	}
}
