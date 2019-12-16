package sw4301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int dy[] = { -2, 2, 0, 0 };
	static int dx[] = { 0, 0, -2, 2 };
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			boolean[][] map = new boolean[N][M];

			int cnt = N * M;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!map[i][j]) {

						for (int d = 0; d < 4; d++) {
							int y = i + dy[d];
							int x = j + dx[d];
							
							if (outRange(y, x)||map[y][x])
								continue;
							map[y][x] = true;
							cnt--;
						}

					}
				}
			}
			System.out.println("#"+tc+" "+cnt);

		}

	}

	static boolean outRange(int y, int x) {
		return y < 0 || x < 0 || y >= N || x >= M;
	}

}
