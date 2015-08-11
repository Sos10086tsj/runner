package com.chinesedreamer.runner.demo.ninedu.sub1517;

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
			int n = cin.nextInt();
			int k = cin.nextInt();
			int[] numbers = new int[n];
			for (int i = 0; i < n; i++) {
				numbers[i] = cin.nextInt();
			}
			if (k == 0 || k > n) {
				System.out.println("NULL");
			}else {
				System.out.println(numbers[n - k ]);
			}
		}
		cin.close();
	}

	
}
