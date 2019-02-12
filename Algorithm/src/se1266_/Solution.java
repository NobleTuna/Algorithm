package se1266_;

import java.util.Scanner;

public class Solution {
	static int R[] = { 2, 3, 5, 7, 11, 13, 17 }; // 소수
	static int N = 18;
	static long[] fact = new long[19];

	public static void main(String[] args) {
		fact();

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {
			boolean[] chk = new boolean[18];
			int sA = sc.nextInt();
			int sB = sc.nextInt();

			for (int i = 0; i < R.length; i++) { // 일단 솟수만큼 구하는 확률
			}

		}
	}

	public static long com(int n, int r) {
		if (n == 0 || r == n) {
			return 1;
		}
		return fact[n] / (fact[n - r] * fact[r]);
	}

	public static void fact() {
		fact[0] = 1;
		fact[1] = 1;
		for (int i = 1; i < 19; i++) {
			fact[i] = fact[i - 1] * i;
		}
	}

}
