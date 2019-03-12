package sw7250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, K;
	static int finishY, finishX;
	static char map[][];

	static class FP {
		int y;
		int x;

		public FP(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			int sy = 0;
			int sx = 0;
			int vy = 0;
			int vx = 0;
			List<FP> list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = input.charAt(j);
					if (map[i][j] == 'S') {
						sy = i;
						sx = j;
						map[i][j] = 'A';
					} else if (map[i][j] == 'V') {
						vy = i;
						vx = j;
						map[i][j] = 'A';
					} else if (map[i][j] == 'F') {
						list.add(new FP(i, j));
					} else if (map[i][j] == 'E') {
						map[i][j] = 'A';
						finishY = i;
						finishX = j;
					}
				}
			}
			visitedV = new boolean[N][M];
			visitedS = new boolean[N][M];
			visitedF = new boolean[N][M];
			Queue<Position> q = new LinkedList<>();
			visitedV[vy][vx] = true;
			q.add(new Position(vy, vx, 'V', 0, 0));
			visitedS[sy][sx] = true;
			q.add(new Position(sy, sx, 'S', K, 0));
			for (FP f : list) {
				visitedF[f.y][f.x] = true;
				q.add(new Position(f.y, f.x, 'F', 0, 0));
			}
			ans = -1;
			go(q);
			System.out.println("#" + tc + " " + ans);

		}
	}

	static int ans;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean[][] visitedV;
	static boolean[][] visitedS;
	static boolean[][] visitedF;

	static void go(Queue<Position> q) {

		while (!q.isEmpty()) {

			Position cur = q.poll();
			int cy = cur.y;
			int cx = cur.x;

			int time = cur.time;

			if (cy == finishY && cx == finishX) {
				if (cur.who == 'V') {
					ans = -1;
					return;
				} else if (cur.who == 'S') {
					ans = time;
					return;
				}
			}
			if(cur.who == 'F') 
				map[cy][cx] ='F'; 
			
			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];

				if (cur.who == 'V') { // 악당
					if (!outRange(ny, nx) && (map[ny][nx] == 'F' || map[ny][nx] == 'A') && !visitedV[ny][nx]) { // A, F
																												// 통과가능
						visitedV[ny][nx] = true;
						q.add(new Position(ny, nx, 'V', 0, 0));
					}
				} else if (cur.who == 'S') { // 스캇
					if (!outRange(ny, nx) && map[ny][nx] == 'W') { // 통과하는 벽이면
						if (cur.k > 0) {
//							visitedS[ny][nx] = true;
							q.add(new Position(ny, nx, 'S', cur.k - 1, time + 1));
						}
					} else if (!outRange(ny, nx) && map[ny][nx] == 'A' && !visitedS[ny][nx]) {
						visitedS[ny][nx] = true;
						q.add(new Position(ny, nx, 'S', K, time + 1));
					}

				} else if (cur.who == 'F') {
					if (!outRange(ny, nx) && map[ny][nx] == 'A' && !visitedF[ny][nx]) {
						visitedF[ny][nx] = true;
						q.add(new Position(ny, nx, 'F', 0, 0));
					}
				}
			}
		}
	}

	

	static class Position { // 1 = 스캇, 2 = 악당, 3 = 불
		int y;
		int x;
		char who;
		int k;
		int time;

		public Position(int y, int x, char who, int k, int time) {
			this.y = y;
			this.x = x;
			this.who = who;
			this.k = k;
			this.time = time;
		}
	}

	static boolean outRange(int y, int x) {
		return 0 > y || 0 > x || y >= N || x >= M || map[y][x] == 'X';
	}

}
