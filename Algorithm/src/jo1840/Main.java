package jo1840;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Position {
		int y;
		int x;

		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

	static int R, C;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] map;
	static Queue<Position> q;

	static boolean isStart(int i, int j) {
		return (i == 0 || i == R - 1 || j == 0 || j == C - 1) && map[i][j] == 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		q = new LinkedList<>();

		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (isStart(i, j)) {
					q.add(new Position(i, j));
				}
			}
		}
		time = 0;
		lastCheese = 0;
		go();

		System.out.println(time);
		System.out.println(lastCheese);
	}

	static int time;
	static int lastCheese;

	static void go() {

		while (!q.isEmpty()) {

			int oneTime = q.size();
			Boolean[][] vistied = new Boolean[R][C];

			for (int t = 0; t < oneTime; t++) { // 한번

				Position P = q.poll();
				int y = P.y;
				int x = P.x;

				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if (outRange(ny, nx) || vistied[ny][nx]) {
						continue;
					}

					vistied[ny][nx] = true;

					if (map[ny][nx] == 1) {
						map[ny][nx] = -1;
						continue;
					}

					q.add(new Position(ny, nx));
				}
			}

			time++;
			boolean isLast = true;

			lastCheese = 0;

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != 0) {
						lastCheese++;
						if (map[i][j] == 1)
							isLast = false;
					}
				}
			}

			if (isLast) {
				break;
			}

		}
	}

	static boolean outRange(int y, int x) {
		return y < 0 || x < 0 || y >= R || x >= C;
	}
}
