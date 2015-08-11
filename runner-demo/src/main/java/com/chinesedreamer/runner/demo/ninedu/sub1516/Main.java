package com.chinesedreamer.runner.demo.ninedu.sub1516;

import java.util.ArrayList;
import java.util.List;
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
			int intN = cin.nextInt();
			if (intN <= 0 ) {
				break;
			}
			cin.nextLine();
			String lines = cin.nextLine();
			String[] lineList = lines.split(" ");
			if (lineList.length < intN) {
				break;
			}
			print(lineList, intN);
		}
		cin.close();
	}

	private static void print(String[] lineList,int intN) {
		List<Integer> odd = new ArrayList<Integer>();
		List<Integer> even = new ArrayList<Integer>();
		for (int i = 0; i < intN; i++) {
			Integer val = Integer.valueOf(lineList[i]);
			if (val % 2 == 0) {
				even.add(val);
			}else {
				odd.add(val);
			}
		}
		if (even.size() == 0) {
			for (int i = 0; i < odd.size(); i++) {
				if (i != odd.size() - 1) {
					System.out.print(odd.get(i) + " ");
				}else {
					System.out.print(odd.get(i));
				}
			}
		}else {
			for (Integer integer : odd) {
				System.out.print(integer + " ");
			}
			for (int i = 0; i < even.size(); i++) {
				if (i != even.size() - 1) {
					System.out.print(even.get(i) + " ");
				}else {
					System.out.print(even.get(i));
				}
			}
		}
		System.out.print("\n");
	}
}
