package sw2115; // 벌꿀채취

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int C, N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(inputString));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 맵크기
			M = Integer.parseInt(st.nextToken()); // 조사 범위
			C = Integer.parseInt(st.nextToken()); // 총 용량

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = 0;
			int[] A = new int[M];

			chkA = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - M+1; j++) {
					int aIdx = 0;
					for (int k = j; k < j + M; k++) {
						A[aIdx++] = map[i][k];
						chkA[i][k] = true;
					}

					findB(A);

				}
			}

			System.out.println("#" + tc + " " + Math.round(ans));
		}

	}

	static int[][] map;
	static boolean[][] chkA;

	static void findB(int[] A) {

		int B[] = new int[M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - M+1; j++) {
				if (chkA[i][j] || j + M > N)
					continue;
				
				int bIdx = 0;
				for (int k = j; k < j + M; k++) {
					B[bIdx++] = map[i][k];
				}

				go(A, B);

			}
		}
	}

	static double ans;

	static void go(int[] A, int[] B) {

		maxHoney = 0;
		honey(A, 0, 0, 0);
		double honeyA = maxHoney;
		maxHoney = 0;
		honey(B, 0, 0, 0);
		double honeyB = maxHoney;

		ans = Math.max(ans, honeyA + honeyB);
	}

	static double maxHoney;

	static void honey(int[] arr, int idx, int sum, double lastHoney) { // C == 한계치
		if (sum > C)
			return;
		if (idx == M) {
			maxHoney = Math.max(maxHoney, lastHoney);
			return;
		}

		honey(arr, idx + 1, sum + arr[idx], lastHoney + Math.pow(arr[idx], 2));
		honey(arr, idx + 1, sum, lastHoney);

	}

	static boolean outRange(int i, int j) {
		return i < 0 || j < 0 || i >= N || j >= N;
	}

	static String inputString = "10\r\n" + "4 2 13\r\n" + "6 1 9 7\r\n" + "9 8 5 8\r\n" + "3 4 5 3\r\n" + "8 2 6 7\r\n"
			+ "3 3 10\r\n" + "7 2 9\r\n" + "6 6 6\r\n" + "5 5 7\r\n" + "4 1 10\r\n" + "8 1 8 2\r\n" + "4 6 1 6\r\n"
			+ "4 9 6 3\r\n" + "7 4 1 3\r\n" + "4 3 12\r\n" + "8 8 6 5\r\n" + "5 2 7 4\r\n" + "8 5 1 7\r\n"
			+ "7 8 9 4\r\n" + "5 2 11\r\n" + "7 5 9 9 6\r\n" + "7 3 7 9 3\r\n" + "1 7 1 4 5\r\n" + "1 7 9 2 6\r\n"
			+ "6 6 8 3 8\r\n" + "6 3 20\r\n" + "8 5 2 4 3 1\r\n" + "4 3 6 1 1 8\r\n" + "4 4 1 2 3 1\r\n"
			+ "1 7 4 9 6 1\r\n" + "6 5 1 2 8 4\r\n" + "3 1 4 5 1 3\r\n" + "7 2 11\r\n" + "2 8 2 5 2 8 6\r\n"
			+ "2 3 7 4 6 4 8\r\n" + "3 7 8 3 9 4 4\r\n" + "8 8 5 9 3 6 9\r\n" + "9 7 6 2 4 1 3\r\n"
			+ "2 9 2 8 9 7 3\r\n" + "2 1 7 2 7 8 3\r\n" + "8 3 12\r\n" + "9 1 6 7 5 4 6 7\r\n" + "9 5 1 8 8 3 5 8\r\n"
			+ "5 2 6 8 6 9 2 1\r\n" + "9 2 1 8 7 5 2 3\r\n" + "6 5 5 1 4 5 7 2\r\n" + "1 7 1 8 1 9 5 5\r\n"
			+ "6 2 2 9 2 5 1 4\r\n" + "7 1 1 2 5 9 5 7\r\n" + "9 4 20\r\n" + "5 2 4 8 3 7 6 2 1\r\n"
			+ "7 9 8 5 8 2 6 3 6\r\n" + "1 9 4 6 7 5 3 1 1\r\n" + "4 4 7 6 2 2 8 1 7\r\n" + "9 6 8 5 7 3 7 9 5\r\n"
			+ "7 3 1 4 1 1 8 5 3\r\n" + "4 6 8 9 4 5 3 8 8\r\n" + "1 3 4 2 4 1 1 3 6\r\n" + "5 9 2 3 5 2 4 8 5\r\n"
			+ "10 5 30\r\n" + "7 4 7 5 9 3 6 4 6 7\r\n" + "8 9 8 4 5 7 8 9 2 9\r\n" + "6 5 3 4 6 4 7 6 3 2\r\n"
			+ "4 7 4 3 4 7 3 3 4 3\r\n" + "3 5 6 4 8 8 2 1 8 6\r\n" + "3 7 9 7 1 7 6 2 8 9\r\n"
			+ "3 6 1 6 8 9 7 7 5 1\r\n" + "4 3 5 6 2 1 2 6 3 6\r\n" + "3 4 9 2 1 5 9 9 6 3\r\n"
			+ "9 9 7 3 7 5 5 5 8 4\r\n" + "";
}
