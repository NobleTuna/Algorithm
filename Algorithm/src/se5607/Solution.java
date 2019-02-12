package se5607;

import java.util.Scanner;

public class Solution {
	static int P = 1234567891;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] fact = new long[1000000 + 1];
		fact[0] = 1;
		for (int i = 1; i < fact.length; i++) {
			fact[i] = fact[i - 1] * i % P;
		}
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			// 1000000! mod p 를 구하시오
			long result = fact[N] * divisionPow(fact[N - R] * fact[R] % P, P - 2) % P;
			System.out.println("#" + tc + " " + result);
		}
	}

	static long divisionPow(long a, int n) {
		if (n == 1)
			return a;
		long result = divisionPow(a, n / 2) % P;
		if (n % 2 == 0)
			return result * result % P;
		else
			return result * result % P * a % P;
	}
}
