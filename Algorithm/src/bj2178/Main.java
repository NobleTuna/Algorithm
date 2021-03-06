package bj2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int r;
		int c;
		int cnt;

		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int arr[][] = new int[R][C];
		for (int i = 0; i < R; i++) {
			input = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		int[] dc = { 0, 0, -1, 1 };
		int[] dr = { 1, -1, 0, 0 };
		boolean visited[][] = new boolean[R][C];
		Queue<Point> q = new LinkedList<Main.Point>();
		q.add(new Point(0, 0, 1));
		visited[0][0] = true;
		int result = 0;
		while (!q.isEmpty()) {
			Point now = q.poll();
			int c = now.c;
			int r = now.r;

			if (c == C - 1 && r == R - 1) {
				result = now.cnt;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nc = c + dc[i];
				int nr = r + dr[i];
				if (nc < 0 || nr < 0 || nc >= C || nr >= R) {
					continue;
				}
				if (arr[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new Point(nr, nc, now.cnt + 1));
				}
			}
		}
		System.out.println(result);
	}
}