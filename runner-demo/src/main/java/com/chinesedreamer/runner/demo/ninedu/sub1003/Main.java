package com.chinesedreamer.runner.demo.ninedu.sub1003;

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
		while (cin.hasNext()) {
			String aX = cin.next();
			String bX = cin.next();
			long a = format(aX);
			long b = format(bX);
			if (a <= -1000000000 || a >= 1000000000 || b >= 1000000000 || b <= -1000000000) {
				continue;
			}
			System.out.println(a + b);
		}
		cin.close();
	}

	private static long format(String x) {
		String value = x.replace(",", "");
		return Long.valueOf(value);
	}
}
