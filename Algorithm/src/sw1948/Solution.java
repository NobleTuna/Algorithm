package sw1948;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] month = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int m1 = sc.nextInt();
			int d1 = sc.nextInt();
			int m2 = sc.nextInt();
			int d2 = sc.nextInt();

			int resultM = 0;
			int resultD = 0;

			int result = 0;

			if (m1 != m2) {
				for (int i = m1 + 1; i < m2; i++) {
					resultM += month[i];
				}
			}
			if (m1 == m2) {
				resultD = d2 - d1 + 1;
			} else
				resultD = (month[m1] - d1) + d2 + 1;

			result = resultM + resultD;

			System.out.println("#" + tc + " " + result);

		}
	}

}
