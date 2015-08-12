package com.chinesedreamer.runner.demo.ninedu.sub1518;

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
		StringBuffer str = new StringBuffer();
		while (cin.hasNext()) {
			int n = cin.nextInt();
			if (n == 0) {
				System.out.println("NULL");
				continue;
			}
			if (n < 0 || n > 1000) {
				continue;
			}
			cin.nextLine();
			str.delete(0, str.length());
			str.append(cin.nextLine());
			System.out.println(str.reverse());
		}
		cin.close();
	}

	
}
