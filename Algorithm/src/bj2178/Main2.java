package bj2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	static int N, M;
	static int map[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}
		
		ans = 0;
		go();
		System.out.println(ans);

	}

	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static class Position {
		int y;
		int x;
		int value;

		public Position(int y, int x, int value) {
			this.y = y;
			this.x = x;
			this.value = value;
		}
	}

	static int ans;

	static void go() {

		Queue<Position> q = new LinkedList<Position>();

		q.add(new Position(0, 0, 1));
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;

		while (!q.isEmpty()) {

			Position curP = q.poll();

			int y = curP.y;
			int x = curP.x;

			if (y == N - 1 && x == M - 1) {
				ans = curP.value;
				break;
			}

			for (int d = 0; d < 4; d++) {

				int ny = y + dy[d];
				int nx = x + dx[d];

				if (outRange(ny, nx) || map[ny][nx] != 1 || visited[ny][nx])
					continue;

				visited[ny][nx] = true;
				q.add(new Position(ny, nx, curP.value + 1));

			}
		}
	}

	static boolean outRange(int y, int x) {
		return y < 0 || x < 0 || y >= N || x >= M;
	}

}
