package com.cnipr.open.ms.test.pd.learn;

/**
 * 打印图形
 *
 * @author Bi Yunfei
 * @date 2019/8/6 13:43
 */
public class TriangleOut {
	/**
	 * 打印出n层的等腰三角形
	 *
	 * @param n 层数
	 */
	public static void out(int n) {
		for (int i = 0; i < n; i++) {
			//先打印一个直角三角形
			for (int j = 0; j < n - i - 1; j++) {
				System.out.print(" ");
			}
			//再打印等腰三角形
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	/**
	 * 杨辉三角
	 */
	public static void print() {
		int[][] a = new int[6][6];
		for (int i = 0; i < a.length; i++) {
			a[i] = new int[i + 1];
		}
		for (int i = 0; i < a.length; i++) {
			a[i][0] = 1;
			a[i][i] = 1;
			for (int j = 1; j < i; j++) {
				a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		out(5);
		print();
	}


}
