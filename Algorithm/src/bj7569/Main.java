package bj7569;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class P {
		int r;
		int c;
		int cnt;

		public P(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); // 가로 행
		int N = sc.nextInt(); // 세로 열
		int[][] map = new int[N][M];
		Queue<P> q = new LinkedList<Main.P>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					q.add(new P(i, j, 0));
				}
			}
		}
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(map[i][j] + " ");
//			}System.out.println();
//		}

		int[] dc = { 0, 0, 1, -1 };
		int[] dr = { 1, -1, 0, 0 };

		int max = 0;
		while (!q.isEmpty()) {

			P now = q.poll();
			if (max < now.cnt) {
				max = now.cnt;
			}
			int c = now.c;
			int r = now.r;

			for (int i = 0; i < 4; i++) {
				int nc = c + dc[i];
				int nr = r + dr[i];
				if (nc < 0 || nr < 0 || nr >= map.length || nc >= map[nr].length) {
					continue;
				}
				if (map[nr][nc] == 0) {
					map[nr][nc] = 1;
					q.add(new P(nr, nc, now.cnt + 1));
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					max = -1;
					break;
				}
			}
		}
		System.out.println(max);
	}
}
