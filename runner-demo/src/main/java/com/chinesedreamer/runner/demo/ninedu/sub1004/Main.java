package com.chinesedreamer.runner.demo.ninedu.sub1004;

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
			int first = cin.nextInt();
			long[] f = new long[first];
			for (int i = 0; i < first; i++) {
				f[i] = cin.nextLong();
			}
			
			int second = cin.nextInt();
			long[] s = new long[second];
			for (int i = 0; i < second; i++) {
				s[i] = cin.nextLong();
			}
			
			long[] merge = merge(f, s);
			int mid = (merge.length - 1 ) / 2;
			System.out.println(merge[mid]);
		}
		cin.close();
	}

	private static long[] merge(long[] f,long[] s) {
		int length1 = f.length;
		int length2 = s.length;
		long[] merge = new long[length1 + length2];

		int index1 = 0;
		int index2 = 0;
		int index = 0;
		for (; index < length1 + length2; index++) {
			
			if (index1 == length1) {
				for (; index2 < length2; index2++) {
					merge[index] = s[index2];
					index++;
				}
				continue;
			}else if (index2 == length2) {
				for (; index1 < length1; index1++) {
					merge[index] = f[index1];
					index++;
				}
				continue;
			}
			long fi = f[index1];
			long si = s[index2];
			if (fi >= si) {
				merge[index] = si;
				index2 ++;
			}else {
				merge[index] = fi;
				index1 ++;
			}
		}
		
		return merge;
	}
}
