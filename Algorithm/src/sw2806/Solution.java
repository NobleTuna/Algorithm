package sw2806;

import java.util.Scanner;

public class Solution {
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			boolean map[][] = new boolean[N][N];
			result = 0;
			queen(map, N, 0, 0);
			System.out.println("#" + tc + " " + result);
		}
	}

	public static void queen(boolean[][] map, int N, int y, int x) {
		if (y == N) {
			result += 1;
			return;
		}

		for (int i = 0; i < N; i++) { // i = x좌표

			boolean token = true;
			for (int j = 0; j < y; j++) {
				if (map[j][i]) {
					token = false;
					break;
				}
			}
			int left = i;
			int right = i;
			for (int j = y; j >= 0; j--) {
				if (left >= 0 && map[j][left] == true) {
					token = false;

					break;
				}
				if (right <= N - 1 && map[j][right] == true) {
					token = false;
					break;
				}
				left--;
				right++;
			}

			if (token) {
				map[y][i] = true;
				queen(map, N, y + 1, x);
				map[y][i] = false;
			}
		}
	}

}
