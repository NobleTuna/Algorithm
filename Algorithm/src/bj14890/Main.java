package bj14890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, L;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(TC3));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 가로로 한번
		int ans = 0;
		for (int i = 0; i < N; i++) {
			boolean isUsed[] = new boolean[N]; // 체크할필요있나?-> 있음
			boolean isOk = true;
			for (int j = 1; j < N; j++) {
				if (map[i][j - 1] < map[i][j]) { // 커질때
					for (int k = j - L; k < j; k++) {
						if (outRange(i, k) || map[i][k] != map[i][j] - 1 || isUsed[k]) {
							isOk = false;
							break;
						}
					}
					if (!isOk)
						break;
					else {
						for (int k = j - L; k < j; k++) { // 경사로 트루로
							isUsed[k] = true;
						}
					}

				} else if (map[i][j - 1] > map[i][j]) { // 작아질때
					for (int k = j; k < j + L; k++) {
						if (outRange(i, k) || map[i][k] != map[i][j - 1] - 1 || isUsed[k]) {
							isOk = false;
							break;
						}
					}
					if (!isOk)
						break;
					else {
						for (int k = j; k < j + L; k++) { // 경사로 트루로
							isUsed[k] = true;
						}
					}
					j += L - 1;
				}
			}
			if (isOk) {
				ans++;
			}
		}

		// 세로로 한번
		for (int i = 0; i < N; i++) {
			boolean isUsed[] = new boolean[N]; // 체크할필요있나?-> 있음
			boolean isOk = true;
			for (int j = 1; j < N; j++) {
				if (map[j-1][i] < map[j][i]) { // 커질때
					for (int k = j - L; k < j; k++) {
						if (outRange(i, k) || map[k][i] != map[j][i] - 1 || isUsed[k]) {
							isOk = false;
							break;
						}
					}
					if (!isOk)
						break;
					else {
						for (int k = j - L; k < j; k++) { // 경사로 트루로
							isUsed[k] = true;
						}
					}

				} else if (map[j-1][i] > map[j][i]) { // 작아질때
					for (int k = j; k < j + L; k++) {
						if (outRange(i, k) || map[k][i] != map[j-1][i] - 1 || isUsed[k]) {
							isOk = false;
							break;
						}
					}
					if (!isOk)
						break;
					else {
						for (int k = j; k < j + L; k++) { // 경사로 트루로
							isUsed[k] = true;
						}
					}
					j += L - 1;
				}
			}
			if (isOk) {
				ans++;
			}

		}

		System.out.println(ans);
	}

	static boolean outRange(int y, int x) {
		return y < 0 || x < 0 || y >= N || x >= N;
	}

	static String TC1 = "6 2\r\n" + "3 3 3 3 3 3\r\n" + "2 3 3 3 3 3\r\n" + "2 2 2 3 2 3\r\n" + "1 1 1 2 2 2\r\n"
			+ "1 1 1 3 3 1\r\n" + "1 1 2 3 3 2";

	static String TC3 = "6 3\r\n" + "3 2 1 1 2 3\r\n" + "3 2 2 1 2 3\r\n" + "3 2 2 2 3 3\r\n" + "3 3 3 3 3 3\r\n"
			+ "3 3 3 3 2 2\r\n" + "3 3 3 3 2 2";
}
