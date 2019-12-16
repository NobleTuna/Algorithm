package sw1868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];

			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j);
				}
			}

			ans = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (map[i][j] != '.')
						continue;
					
					boolean isClear = true;

					for (int d = 0; d < 8; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];

						if (ny < 0 || nx < 0 || ny >= N || nx >= N)
							continue;

						if (map[ny][nx] == '*') {
							isClear = false;
							break;
						}
					}
					if (isClear) {

						map[i][j] = 'X';
						click(map, new boolean[N][N], i, j);
						ans++;
					}

				}
			}

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.')
						ans++;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int ans;
	static int N;
	static int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int[] dy = { 1, 1, 1, 0, 0, -1, -1, -1 };

	static class Position {
		int x;
		int y;

		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static void click(char[][] map, boolean[][] visited, int sy, int sx) {

		Queue<Position> q = new LinkedList<>();
		visited[sy][sx] = true;
		q.add(new Position(sy, sx));

		while (!q.isEmpty()) {

			Position curP = q.poll();
			int cy = curP.y;
			int cx = curP.x;

			for (int d = 0; d < 8; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || map[ny][nx] != '.')
					continue;

				map[ny][nx] = 'X';
				visited[ny][nx] = true;

				boolean isBoom = false;
				for (int dd = 0; dd < 8; dd++) {

					int yy = dy[dd] + ny;
					int xx = dx[dd] + nx;

					if (yy < 0 || xx < 0 || yy >= N || xx >= N)
						continue;

					if (map[yy][xx] == '*') {
						isBoom = true;
						break;
					}
				}
				if (!isBoom) {
					q.add(new Position(ny, nx));
				}
			}
		}
	}
}
