package com.chinesedreamer.runner.demo.ninedu.sub1001;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**  
* Description:
* @author Paris    
* @date Aug 11, 2015
* @version 1.0
*/
public class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int m, n;
		String[] lines = new String[1024];
		while (cin.hasNext()) {
			String flag = cin.nextLine();
			if (flag.equals("0")) {
				break;
			}
			String[] flags = flag.split(" ");
			m = Integer.valueOf(flags[0]);
			n = Integer.valueOf(flags[1]);
			for (int i = 0; i < m * 2; i++) {
				lines[i] = cin.nextLine();
			}
			printMatrices(lines, m, n);
		}
	}
	
	private static void printMatrices(String[] lines,int m , int n) {
		int[][] tmp = new int[m][n];
		for (int i = 0; i < m; i++) {
			String[] pre = lines[i].split(" ");
			String[] suf = lines[i + m].split(" ");
			for (int j = 0; j < n; j++) {
				tmp[i][j] = Integer.parseInt(pre[j]) + Integer.parseInt(suf[j]);
			}
		}
		Set<Integer> rows = new HashSet<Integer>();
		for (int i = 0; i < m; i++) {
			boolean zero = true;
			for (int j = 0; j < n; j++) {
				if (tmp[i][j] != 0) {
					zero = false;
					break;
				}
			}
			if (zero) {
				rows.add(i);
			}
		}
		Set<Integer> columns = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			boolean zero = true;
			for (int j = 0; j < m; j++) {
				if (tmp[j][i] != 0) {
					zero = false;
					break;
				}
			}
			if (zero) {
				columns.add(i);
			}
		}
		System.out.println(rows.size() + columns.size());
	}
}
