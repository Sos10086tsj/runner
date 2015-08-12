package com.chinesedreamer.runner.demo.ninedu.sub1007;

import java.util.Scanner;

/**  
* Description:
* @author Paris    
* @date Aug 11, 2015
* @version 1.0
时间限制：1 秒内存限制：32 兆特殊判题：否提交：7167解决：1530
题目描述：
按要求，给国家进行排名。
输入：
有多组数据。
第一行给出国家数N，要求排名的国家数M，国家号从0到N-1。
第二行开始的N行给定国家或地区的奥运金牌数，奖牌数，人口数（百万）。
接下来一行给出M个国家号。
输出：
排序有4种方式: 金牌总数 奖牌总数 金牌人口比例 奖牌人口比例 
对每个国家给出最佳排名排名方式 和 最终排名
格式为: 排名:排名方式
如果有相同的最终排名，则输出排名方式最小的那种排名，对于排名方式，金牌总数 < 奖牌总数 < 金牌人口比例 < 奖牌人口比例 
如果有并列排名的情况，即如果出现金牌总数为 100,90,90,80.则排名为1,2,2,4.
每组数据后加一个空行。
样例输入：
4 4
4 8 1
6 6 2
4 8 2
2 12 4
0 1 2 3
4 2
8 10 1
8 11 2
8 12 3
8 13 4
0 3
样例输出：
1:3
1:1
2:1
1:2

1:1
1:1
*/
public class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int n = cin.nextInt();
			int m = cin.nextInt();
			double[][] scores = new double[n][3];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 3; j++) {
					scores[i][j] = cin.nextDouble();
				}
			}
			int[] countries = new int[m];
			for (int i = 0; i < m; i++) {
				countries[i] = cin.nextInt();
			}
			print(n, m, scores, countries);
			System.out.println();
		}
		cin.close();
	}

	private static void print(int n,int m,double[][] scores,int[] countries) {
		int[][] ranks = new int[n][4];
		//1. gold
		for (int i = 0; i < n; i++) {
			int rankNum = 1;
			double gold = scores[i][0];
			for (int j = 0; j < n; j++) {
				if (j != i) {
					if (scores[j][0] > gold) {
						rankNum ++;
					}
				}
			}
			ranks[i][0] = rankNum;
		}
		//2. medal
		for (int i = 0; i < n; i++) {
			int rankNum = 1;
			double medal = scores[i][1];
			for (int j = 0; j < n; j++) {
				if (j != i) {
					if (scores[j][1] > medal) {
						rankNum ++;
					}
				}
			}
			ranks[i][1] = rankNum;
		}
		//3. gold / population
		for (int i = 0; i < n; i++) {
			int rankNum = 1;
			for (int j = 0; j < n; j++) {
				if (j != i) {
					if (Math.abs(scores[j][0] / scores[j][2] - scores[i][0]  / scores[i][2]) > 0.00000001){
							//scores[j][0] / scores[j][2] > gold_population) {
						rankNum ++;
					}
				}
			}
			ranks[i][2] = rankNum;
		}
		//3. medal / population
		for (int i = 0; i < n; i++) {
			int rankNum = 1;
			for (int j = 0; j < n; j++) {
				if (j != i) {
					if (Math.abs(scores[j][1] / scores[j][2] - scores[i][1]  / scores[i][2]) > 0.00000001){
							//scores[j][1]  / scores[j][2] > medal_population) {
						rankNum ++;
					}
				}
			}
			ranks[i][3] = rankNum;
		}
		for (int i = 0; i < m; i++) {
			int countryId = countries[i];
			int[] countryRank = ranks[countryId];
			int finalRank = countryRank[0];
			int method = 1;
			for (int j = 1; j < countryRank.length; j++) {
				int compareRank = countryRank[j];
				if (compareRank < finalRank) {
					finalRank = compareRank;
					method = j + 1;
				}
			}
			System.out.println(finalRank + ":" + method);
		}
	}
}
