package com.chinesedreamer.runner.demo.ninedu.sub1004;

import java.util.ArrayList;
import java.util.Collections;
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
			int[] first = initList(cin.nextLine());
			int[] second = initList(cin.nextLine());
			int n1 = first[0];
			int n2 = second[0];
			if (n1 > 1000000 || n2 > 1000000) {
				continue;
			}
			int median1 = median(first);
			int median2 = median(second);
			int medianValue1 = first[median1];
			int medianValue2 = second[median2];
			int min = 0;
			int max = 0;
			boolean bigger = true;
			if (medianValue1 > medianValue2) {
				min = medianValue2;
				max = medianValue1;
				bigger =false;
			}else {
				min = medianValue1;
				max = medianValue2;
			}
			List<Integer> s = new ArrayList<Integer>();
			if (bigger) {
				for (int i = median1; i < first.length; i++) {
					if (first[i] <= max) {
						s.add(first[i]);
					}else {
						break;
					}
				}
				for (int i = 0; i <= median2; i++) {
					if (second[i] >= min) {
						s.add(second[i]);
					}
				}
			}else {
				for (int i = 0; i < median1; i++) {
					if (first[i] >= min) {
						s.add(first[i]);
					}
				}
				for (int i = median2; i < second.length; i++) {
					if (second[i] <= max) {
						s.add(second[i]);
					}else {
						break;
					}
				}
			}
			Collections.sort(s);
			if (s.size() % 2 == 0) {
				System.out.println(s.get(s.size() / 2 - 1));
			}else {
				System.out.println(s.get(s.size() / 2));
			}
		}
		cin.close();
	}

	private static int[] initList(String line) {
		String[] values = line.split(" ");
		int[] list = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			list[i] = Integer.valueOf(values[i]);
		}
		return list;
	}
	
	private static int median(int[] values) {
		int median = 0;
		if ( (values.length - 1) % 2 == 0 ) {
			median = (values.length - 1) / 2;
		}else {
			median = (values.length - 1) / 2 + 1;
		}
		return median;
	}
}
