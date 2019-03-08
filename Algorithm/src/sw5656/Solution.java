package sw5656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			allBoom = 0;
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0)
						allBoom++;

				}
			}
			ans = Integer.MAX_VALUE;

			combi(0, new int[N]);

			/// 중복조합 W, N;
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int ans;
	static int N, W, H;
	static int[][] map;
	static int allBoom;

	static void combi(int idx, int[] ball) { // N크기 배열
		if (idx == N) {
			/// 발사

			shot(ball);

			return;
		}

		for (int i = 0; i < W; i++) {

			ball[idx] = i;
			combi(idx + 1, ball);

		}
	}

	static class boom {
		int y;
		int x;
		int value;

		public boom(int y, int x, int value) {
			this.y = y;
			this.x = x;
			this.value = value;
		}
	}

	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	static boolean outRange(int y, int x) {
		return y < 0 || x < 0 || y >= H || x >= W;
	}

	static void shot(int[] ball) {
		
		
		int boomCnt = allBoom;
		int[][] thisMap = new int[H][W];
		for(int i=0; i<H; i++) {
			thisMap[i] = map[i].clone();
		}
		
		for (int i = 0; i < ball.length; i++) {
			int sx = ball[i];
			int sy = 0;
			for (int h = 0; h < H; h++) {
				if (thisMap[h][sx] != 0) {
					sy = h;
					break;
				}
			}
			/// 큐에 넣자
			Queue<boom> q = new LinkedList<>();
			q.add(new boom(sy, sx, thisMap[sy][sx]));
//			thisMap[sy][sx] = 0;
//			boomCnt--;

			while (!q.isEmpty()) {

				boom B = q.poll();
				int y = B.y;
				int x = B.x;
				int power = B.value;

				for (int d = 0; d < 4; d++) {

					for (int p = 0; p < power; p++) {

						int ny = y + (dy[d] * p);
						int nx = x + (dx[d] * p);

						if (outRange(ny, nx))
							continue;

						if (thisMap[ny][nx] != 0) {
							q.add(new boom(ny, nx, thisMap[ny][nx]));
							thisMap[ny][nx] = 0;
							boomCnt--;
						}
					}
				}
			}
			downer(thisMap);
		}
		ans = Math.min(ans, boomCnt);

	}

	static void downer(int[][] mapt) {

		for (int x = 0; x < W; x++) {

			for (int y = H - 1; y >= 0; y--) {

				if (mapt[y][x] != 0) {

					for (int ny = H - 1; ny > y; ny--) {
						if (mapt[ny][x] == 0) {
							mapt[ny][x] = mapt[y][x];
							mapt[y][x] = 0;
						}
					}
				}
			}
		}
	}
}
