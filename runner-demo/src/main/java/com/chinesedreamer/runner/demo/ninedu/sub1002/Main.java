package com.chinesedreamer.runner.demo.ninedu.sub1002;

import java.text.DecimalFormat;
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
			int p = cin.nextInt();
			int t = cin.nextInt();
			int g1 = cin.nextInt();
			int g2 = cin.nextInt();
			int g3 = cin.nextInt();
			int gj = cin.nextInt();
			if (t < 0 || t >= p || g1 >p || g1<0 || g2 > p ||g2<0 || g3 > p||g3<0 || gj > p|| gj<0) {
				continue;
			}
			printGrad(t, g1, g2, g3, gj);
		}
		cin.close();
	}
	
	private static void printGrad(int t,int g1,int g2,int g3,int gj) {
		//1
		int diff1_2 = Math.abs((g1 - g2));
		if (diff1_2 <= t) {
			print((g1 + g2) /2.0);
			return;
		}
		//2
		int diff1_3 = Math.abs((g1 - g3));
		int diff2_3 = Math.abs((g2 - g3));
		//2.1
		if (diff1_3 <= t && diff2_3 > t) {
			print((g1 + g3) /2.0);
			return;
		}
		//2.2
		if (diff2_3 <= t && diff1_3 > t) {
			print((g2 + g3) /2.0);
			return;
		}
		//3
		if (diff2_3 <= t && diff1_3 <= t) {
			int tmp =  g1 > g2 ? g1 : g2;
			tmp = tmp > g3 ? tmp : g3;
			print((double)tmp);
			return;
		}
		//4
		print((double)gj);
	}
	
	private static void print(double result) {
		DecimalFormat myformat1 = new DecimalFormat("###.0");
	    System.out.println(myformat1.format(result));
	}
}
