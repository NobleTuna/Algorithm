package sw2806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			boolean[][] map = new boolean[N][N];
			ans = 0;
			go(map, 0);
			
			System.out.println("#"+tc+" "+ans);
		}
		
	}

	static int ans;

	static void go(boolean[][] map, int y) {
		if (y == N) {
			ans++;
			return;
		}

		// 위 , 대각선 체크하고 보냄

		for (int i = 0; i < N; i++) {
			boolean isOk = true;

			for (int j = 0; j < y; j++) { // 위쪽탐색
				if (map[j][i]) {
					isOk = false;
					break;
				}
			}

			int right = i;
			int left = i;

			for (int r = y; r >= 0; r--) {
				if (right < N && map[r][right++]) {
					isOk = false;
					break;
				}
				if (left >= 0 && map[r][left--]) {
					isOk = false;
					break;
				}
			}

			if (isOk) {
				map[y][i] = true;
				go(map, y + 1);
				map[y][i] = false;
			}

		}

	}

}
