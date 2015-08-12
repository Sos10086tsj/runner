package com.chinesedreamer.runner.demo.ninedu.sub1005;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
		while (cin.hasNext()) {
			int n = cin.nextInt();
			int m = cin.nextInt();
			int k = cin.nextInt();
			int[] quota = new int[m];
			for (int i = 0; i < m; i++) {
				quota[i] = cin.nextInt();
			}
			int[][] scoes = new int[n][2+k];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 2+k; j++) {
					scoes[i][j] = cin.nextInt();
				}
			}
			
			Map<Integer, Set<Integer>> orders = reorderStudents(scoes, n);
			
			
			Map<Integer, Set<Integer>> admitted = new HashMap<Integer, Set<Integer>>();
			for (Integer key: orders.keySet()) {
				Set<Integer> students = orders.get(key);
				for (Integer student : students) {
					int[] applies = scoes[student];
					for (int j = 0; j < k; j++) {
						int apply = applies[2 + j];
						if (quota[apply] != 0) {
							Set<Integer> admittedStd = null;
							if (admitted.containsKey(apply)) {
								admittedStd = admitted.get(apply);
							}else {
								admittedStd = new HashSet<Integer>();
							}
							admittedStd.add(student);
							admitted.put(apply, admittedStd);
							quota[apply] --;
							break;
						}else {
							Set<Integer> admittedStd = admitted.get(apply);
							for (Integer admittedStdudent : admittedStd) {
								if (students.contains(admittedStdudent) && scoes[admittedStdudent][2 + j] == apply) {
									admittedStd.add(student);
									admitted.put(apply, admittedStd);
//									quota[apply] --;
									break;
								}
							}
						}
					}
				}
				
			}
			for (int i = 0; i < m; i++) {
				if (admitted.containsKey(i)) {
					Set<Integer> admittedStd = admitted.get(i);
					List<Integer> tmp = new ArrayList<Integer>(admittedStd);
					for (int j = 0; j < tmp.size(); j++) {
						System.out.print(tmp.get(j));
						if (j != tmp.size() - 1) {
							System.out.print(" ");
						}
					}
				}
				System.out.println();
			}
		}
		cin.close();
	}

	private static Map<Integer, Set<Integer>> reorderStudents(int[][] scoes, int n) {
		Map<Integer, Set<Integer>> order = new HashMap<Integer, Set<Integer>>();
		float[] average = new float[n];
		for (int i = 0; i < average.length; i++) {
			float av = (scoes[i][0] + scoes[i][1]) / 2.0f;
			average[i] = av;
		}
		for (int i = 0; i < average.length; i++) {
			int rank = 1;
			for (int j = 0; j < average.length; j++) {
				if (j == i) {
					continue;
				}
				if (average[j] > average[i] || 
						(average[j] == average[i] && scoes[j][0] > scoes[i][0])
					) {
					rank ++;
				}
			}
			Set<Integer> students = null;
			if (order.containsKey(rank)) {
				students = order.get(rank);
			}else {
				students = new HashSet<Integer>();
			}
			students.add(i);
			order.put(rank, students);
		}
		return order;
	}
}
