package se2001;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int result = 0;
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					int curMax = 0;
					for (int a = i; a < i + M; a++) {
						for (int b = j; b < j + M; b++) {
							curMax += map[a][b];
						}
					}
					if(curMax >result ) {
						result = curMax;
					}
				}
			}
			System.out.println("#"+tc+" "+result);

		}
	}

}
