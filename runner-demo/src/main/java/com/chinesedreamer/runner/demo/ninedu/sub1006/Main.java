package com.chinesedreamer.runner.demo.ninedu.sub1006;

import java.util.Scanner;

/**  
* Description:
* @author Paris    
* @date Aug 11, 2015
* @version 1.0
* 题目描述：
对给定的字符串(只包含'z','o','j'三种字符),判断他是否能AC。

是否AC的规则如下：
1. zoj能AC；
2. 若字符串形式为xzojx，则也能AC，其中x可以是N个'o' 或者为空；
3. 若azbjc 能AC，则azbojac也能AC，其中a,b,c为N个'o'或者为空；
输入：
输入包含多组测试用例，每行有一个只包含'z','o','j'三种字符的字符串，字符串长度小于等于1000。
输出：
对于给定的字符串，如果能AC则请输出字符串“Accepted”，否则请输出“Wrong Answer”。
样例输入：
zoj
ozojo
ozoojoo
oozoojoooo
zooj
ozojo
oooozojo
zojoooo
样例输出：
Accepted
Accepted
Accepted
Accepted
Accepted
Accepted
Wrong Answer
Wrong Answer
*/
public class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			String zoj = cin.nextLine();
			if (zoj.length() > 1000) {
				continue;
			}
			isAc(zoj);
		}
		cin.close();
	}

	private static void isAc(String zoj) {
		//0. over more than one 'z' or 'j'
		int c1 = zoj.indexOf("z");
		int c2 = zoj.lastIndexOf("z");
		int c3 = zoj.indexOf("j");
		int c4 = zoj.lastIndexOf("j");
		if (c1 == -1 || c2 != c1 || c3 == -1 || c3 != c4) {
			System.out.println("Wrong Answer");
			return;
		}
		//1. =zoj
		if (zoj.equals("zoj")) {
			print();
			return;
		}
		//2. xzojx
		if (isXzojx(zoj)) {
			print();
			return;
		}
		//3. azbojac
		if (isAzbojac(zoj)) {
			print();
			return;
		}
		System.out.println("Wrong Answer");
	}
	
	private static void print() {
		System.out.println("Accepted");
	}
	
	private static boolean isXzojx(String zoj) {
		boolean isZoj = true;
		int zojIndex = zoj.indexOf("zoj");
		if (zojIndex != -1) {
			if (zojIndex != zoj.length() - zojIndex - 3) {
				isZoj = false;
			}
		}else {
			isZoj = false;
		}
		return isZoj;
	}
	
	private static boolean isAzbojac(String zoj) {
		if (zoj.length() < 3) {
			return false;
		}
		//1. zoo...ooj
		if (zoj.startsWith("z") && zoj.endsWith("j")) {
			return true;
		}
		//2. xzooojxxx
		int zIndex = zoj.indexOf("z");
		int preXLenght = zIndex;
		
		if (preXLenght == 0) {
			return false;
		}
		
		int jIndex = zoj.indexOf("j");
		int oLength = jIndex - zIndex - 1;
		
		if (oLength == 0) {
			return false;
		}
		
		if (jIndex < zIndex) {
			return false;
		}
		
		int suffXLength = zoj.length() - jIndex - 1;
		
		if (suffXLength == 0) {
			return false;
		}
		
		if (suffXLength == preXLenght * oLength) {
			return true;
		}
		
		return false;
	}
}
