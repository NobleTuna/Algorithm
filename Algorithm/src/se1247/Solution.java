package se1247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int cus[][];
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= T; TC++) {
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);

			// cus[0] = 회사
			// cus[1] = 집
			// 고객 집정보, cus[n][0] = x, cus[n][1] = y;
			cus = new int[N + 2][2];

			for (int i = 0; i < N + 2; i++) {
				cus[i][0] = Integer.parseInt(st.nextToken());
				cus[i][1] = Integer.parseInt(st.nextToken());
			}
			int len[][] = new int[N + 2][N + 2];
			boolean visit[] = new boolean[N + 2];
			makeSheet(len);

			go(len, visit, 0, 0, 0, 0, N + 2);

			System.out.println("#" + TC + " " + result);

		}
	}

/// 0 회사, 1 집
	static void go(int[][] len, boolean[] visit, int current, int next, int sum, int cnt, int N) {
		if (cnt == N) { // 순회 다했으면 합 비교
			if (sum < result) {
				result = sum;
				return;
			}
		}
		if (current == N || next == N) {
			return;
		}
		if (visit[1]) { // 집에 도착해버렸으면 리턴
			return;
		}
		if (visit[current]) { // 지금 위치에 들린적이 있으면 리턴
			return;
		}
		sum = sum + len[current][next];
		visit[current] = true;
		for (int i = 0; i < N; i++) {
			go(len, visit, next, i, sum, cnt + 1, N);
		}

		visit[current] = false;
		go(len, visit, current, next + 1, sum, cnt, N);
	}

	static void makeSheet(int[][] len) { // 거리표 작성
		for (int i = 0; i < len.length; i++) {
			for (int j = 0; j < len.length; j++) {
				len[i][j] = road(i, j);
			}
		}
	}

	static int road(int a, int b) { // 거리계산
		return Math.abs(cus[a][0] - cus[b][0]) + Math.abs(cus[a][1] - cus[b][1]);
	}

}
