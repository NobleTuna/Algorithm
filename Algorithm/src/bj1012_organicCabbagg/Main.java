package bj1012_organicCabbagg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int M, N, K;
	static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(TC1));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int TC = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			ans = 0;

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[y][x] = 1;

//			q.add(new Point(y, x));
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						ans++;
						search(i, j);
					}
				}
			}

			System.out.println(ans);
		}

	}

	static int ans;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	static public void search(int y, int x) {

		Queue<Point> q = new LinkedList<Main.Point>();
		q.add(new Point(y, x));

		map[y][x] = 2;

		while (!q.isEmpty()) {
			Point curPoint = q.poll();

			int cy = curPoint.y;
			int cx = curPoint.x;

			map[cy][cx] = 2;

			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];

				if (outRange(ny, nx) || map[ny][nx] != 1)
					continue;

				map[ny][nx] = 2;
				q.add(new Point(ny, nx));
			}

		}
	}

	static boolean outRange(int y, int x) {
		return y < 0 || x < 0 || y >= N || x >= M;
	}

	static String TC1 = "2\r\n" + "10 8 17\r\n" + "0 0\r\n" + "1 0\r\n" + "1 1\r\n" + "4 2\r\n" + "4 3\r\n" + "4 5\r\n"
			+ "2 4\r\n" + "3 4\r\n" + "7 4\r\n" + "8 4\r\n" + "9 4\r\n" + "7 5\r\n" + "8 5\r\n" + "9 5\r\n" + "7 6\r\n"
			+ "8 6\r\n" + "9 6\r\n" + "10 10 1\r\n" + "5 5";

}
