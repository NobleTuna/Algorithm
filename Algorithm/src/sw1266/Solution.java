package sw1266;

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
			double sA = sc.nextDouble() / 100;
			double fA = 1 - sA;
			double sB = sc.nextDouble() / 100;
			double fB = 1 - sB;

			double result = 0;
			double sumA = 0;
			double sumB = 0;

			for (int i = 0; i < 7; i++) {

				long combi = com(18, R[i]); // 곱해줘야할 조합 경우의 수
				double resultA = pow(sA, R[i]) * pow(fA, 18 - R[i]) * combi;
				double resultB = pow(sB, R[i]) * pow(fB, 18 - R[i]) * combi;
				// 둘다 성공한 경우를 뺴야됨
				sumA += resultA;
				sumB += resultB;
//				result = result + resultA + resultB - (resultA * resultB); // 교집합 뺴줘야되는거같은데
			}
			result = sumA + sumB - (sumA*sumB);
			System.out.println("#" + TC + " " + String.format("%.6f", result));

		}
	}

	static double pow(double a, int n) { // 제곱
		int k = n;
		int cnt = 0;
		while (k != 1) {
			k /= 2;
			cnt++;
		}
		double[] powMap = new double[cnt + 1];
		powMap[0] = a;
		for (int i = 1; i < powMap.length; i++)
			powMap[i] = powMap[i - 1] * powMap[i - 1];
		double result = 1;
		for (int i = 0; i < cnt + 1; i++) {
			if ((n & (1 << i)) != 0) {
				result = powMap[i] * result;
			}
		}
		return result;
	}

	public static long com(int n, int r) { // 조합계산
		if (r == 0 || r == n) {
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
