package sw1949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static class Position {
		int y;
		int x;

		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int N, K;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(inputString));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];

			int maxMountain = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxMountain = Math.max(map[i][j], maxMountain);
				}
			}

			List<Position> start = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxMountain) {
						start.add(new Position(i, j));
					}
				}
			}
			ans = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int t = 0; t <= K; t++) {
						map[i][j] -= t;
						for (Position P : start) {
							memo = new int[N][N];
							boolean[][] gobo = new boolean[N][N];
							gobo[P.y][P.x] = true;
							go(map, gobo, P.y, P.x, 1);

						}
						map[i][j] += t;
					}
				}
			}

			System.out.println("#" + tc + " " + ans);

		}

	}

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };

	static boolean outRange(int y, int x) {
		return y < 0 || x < 0 || N <= y || N <= x;
	}

	static int[][] memo;
	static int ans;

	static void go(int map[][], boolean[][] visited, int y, int x, int deep) {
		if (memo[y][x] > deep)
			return;
		else if (memo[y][x] < deep)
			memo[y][x] = deep;

		ans = Math.max(deep, ans);

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (outRange(ny, nx) || map[y][x] <= map[ny][nx] || visited[ny][nx])
				continue;
			visited[ny][nx] = true;
			go(map, visited, ny, nx, deep + 1);
			visited[ny][nx] = false;

		}

	}

	static String inputString = "10\r\n" + "5 1\r\n" + "9 3 2 3 2\r\n" + "6 3 1 7 5\r\n" + "3 4 8 9 9\r\n"
			+ "2 3 7 7 7\r\n" + "7 6 5 5 8\r\n" + "3 2\r\n" + "1 2 1\r\n" + "2 1 2\r\n" + "1 2 1\r\n" + "5 2\r\n"
			+ "9 3 2 3 2\r\n" + "6 3 1 7 5\r\n" + "3 4 8 9 9\r\n" + "2 3 7 7 7\r\n" + "7 6 5 5 8\r\n" + "4 4\r\n"
			+ "8 3 9 5\r\n" + "4 6 8 5\r\n" + "8 1 5 1\r\n" + "4 9 5 5\r\n" + "4 1\r\n" + "6 6 1 7\r\n" + "3 6 6 1\r\n"
			+ "2 4 2 4\r\n" + "7 1 3 4\r\n" + "5 5\r\n" + "18 18 1 8 18\r\n" + "17 7 2 7 2\r\n" + "17 8 7 4 3\r\n"
			+ "17 9 6 5 16\r\n" + "18 10 17 13 18\r\n" + "6 4\r\n" + "12 3 12 10 2 2\r\n" + "13 7 13 3 11 6\r\n"
			+ "2 2 6 5 13 9\r\n" + "1 12 5 4 10 5\r\n" + "11 10 12 8 2 6\r\n" + "13 13 7 4 11 7\r\n" + "7 3\r\n"
			+ "16 10 14 14 15 14 14\r\n" + "15 7 12 2 6 4 9\r\n" + "10 4 11 4 6 1 1\r\n" + "16 4 1 1 13 9 14\r\n"
			+ "3 12 16 14 8 13 9\r\n" + "3 4 17 15 12 15 1\r\n" + "6 6 13 6 6 17 12\r\n" + "8 5\r\n"
			+ "2 3 4 5 4 3 2 1\r\n" + "3 4 5 6 5 4 3 2\r\n" + "4 5 6 7 6 5 4 3\r\n" + "5 6 7 8 7 6 5 4\r\n"
			+ "6 7 8 9 8 7 6 5\r\n" + "5 6 7 8 7 6 5 4\r\n" + "4 5 6 7 6 5 4 3\r\n" + "3 4 5 6 5 4 3 2\r\n" + "8 2\r\n"
			+ "5 20 15 11 1 17 10 14\r\n" + "1 1 11 16 1 14 7 5\r\n" + "17 2 3 4 5 13 19 20\r\n"
			+ "6 18 5 16 6 7 8 5\r\n" + "10 4 5 4 9 2 10 16\r\n" + "2 7 16 5 8 9 10 11\r\n"
			+ "12 19 18 8 7 11 15 12\r\n" + "1 20 18 17 16 15 14 13\r\n" + "";

}
