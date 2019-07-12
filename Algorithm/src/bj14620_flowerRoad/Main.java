package bj14620_flowerRoad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
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

	static int N;
	static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(TC1));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		plant(0, new Point[3], new boolean[N][N]);
		System.out.println(ans);

	}

	static int ans;

	public static void plant(int cnt, Point[] points, boolean[][] visited) {
		if (cnt == 3) {
			chkCost(points);
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					points[cnt] = new Point(i, j);
					plant(cnt + 1, points, visited);
					visited[i][j] = false;
				}
			}
		}
	}

	public static void chkCost(Point[] points) {
		int cost = 0;
		boolean[][] flowers = new boolean[N][N];

		for (int i = 0; i < 3; i++) {
			int y = points[i].y;
			int x = points[i].x;
			cost += map[y][x];
			flowers[y][x] = true;

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (outRange(ny, nx) || flowers[ny][nx])
					return;

				cost += map[ny][nx];
				flowers[ny][nx] = true;
			}
		}
		ans = Math.min(ans, cost);
	}

	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };

	public static boolean outRange(int y, int x) {
		return y < 0 || x < 0 || y >= N || x >= N;
	}

	static String TC1 = "6\r\n" + "1 0 2 3 3 4\r\n" + "1 1 1 1 1 1\r\n" + "0 0 1 1 1 1\r\n" + "3 9 9 0 1 99\r\n"
			+ "9 11 3 1 0 3\r\n" + "12 3 0 0 0 1";
}
