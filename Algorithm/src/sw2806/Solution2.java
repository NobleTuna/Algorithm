package sw2806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			result = 0;
			boolean[][] map = new boolean[N][N];
			go(map, 0);
			System.out.println("#" + tc + " " + result);

		}
	}

	static int result;
	static int N;

	static void go(boolean map[][], int line) {
		if (line == N) {
			result++;
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					System.out.print(map[i][j]+" ");
//				}System.out.println();
//			}
			return;
		}

		for (int i = 0; i < N; i++) {

			boolean flag = true;
			for (int j = 0; j < line; j++) {
				if (map[j][i]) {
					flag = false;
					break;
				}
			}
			for (int j = 1; j <= N; j++) {
				if (0 > line - j || i - j < 0) {
					break;
				}
				if (map[line - j][i - j]) {
					flag = false;
					break;
				}
			}
			for (int j = 1; j <= N; j++) {
				if (0 > line - j || N <= i + j) {
					break;
				}
				if (map[line - j][i + j]) {
					flag = false;
					break;
				}
			}
			if (!flag)
				continue;

			map[line][i] = true;
			go(map, line + 1);
			map[line][i] = false;

		}

	}
}
