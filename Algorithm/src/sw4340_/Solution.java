package sw4340_;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static class Position {
		int y;
		int x;
		int value;
		int dir;

		public Position(int y, int x, int dir, int value) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.value = value;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}

				q = new LinkedList<>();

				visited = new boolean[N][N];
				visited[0][0] = true;
				q.add(new Position(0, 0, 2, 4));
				// go

			}

			/// go

		}

	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean[][] visited;
	static Queue<Position> q;
	static int N;
	static int[][] map;

	// 1=상 >> 3=좌, 4=우 // 진행방향 dir
	// 2=하 >> 3=좌, 4=우
	// 3=좌 >> 1=상, 2=하
	// 4=우 >> 1=상, 2=하
	// dir 1 2 3 4 // 상 하 좌 우
	static boolean outRange(int y, int x) {
		return y < 0 || x < 0 || y >= N || x >= N;
	}

	static void go() {

		while (!q.isEmpty()) {

			Position P = q.poll();

			int cy = P.y;
			int cx = P.x;
			int dir = P.dir;

			int curState = map[cy][cx];

			for (int d = 0; d < 4; d++) {

				int ny = cy + dy[d];
				int nx = cx + dx[d];

				if (outRange(cy, cx) || visited[cy][cx] || map[cy][cx] == 0)
					continue;

				visited[ny][cx] = true;
				// 현재 좌표의 상태 확인하고 보낼 수 있는 방향 확인후 보냄

			}

		}

	}

}
