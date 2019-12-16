package jo1053;

import java.util.Scanner;

public class SolutionT {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n==-1)
				break;
			else if(n==0)
				System.out.println(0);
			else {
				int[][]res = fibo(n);
				System.out.println(res[0][1]); //or[1][0]
			}
		}
		

	}

	static final int[][] base = { { 1, 1 }, { 1, 0 } };

	static int[][] fibo(int n) {
		if (n == 1) {
			return base;
		} else {
			// 짝수면 n/2*n/2
			// 홀수면 n/2 *n/2 *1
			int[][] res = fibo(n / 2);
			if (n % 2 == 0) {
				return cal(res, res);
			} else {
				return cal(cal(res, res), base);
			}
		}
	}

	static int[][] cal(int[][] a, int[][] b) {
		int[][] result = new int[2][2];
		result[0][0] = ((a[0][0] * b[0][0]) + (a[0][1] * b[1][0])) % 10000;
		result[0][1] = ((a[0][0] * b[0][1]) + (a[0][1] * b[1][1])) % 10000;
		result[1][0] = ((a[1][0] * b[0][0]) + (a[1][1] * b[1][0])) % 10000;
		result[1][1] = ((a[1][0] * b[0][1]) + (a[1][1] * b[1][1])) % 10000;
		return result;
	}

}
