package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj2178_dfs_bfs {
	static int R;
	static int C;

	public static void main(String[] args) {
		String input = "4 6\r\n" + "101111\r\n" + "101010\r\n" + "101011\r\n" + "111011\r\n";
		Scanner sc = new Scanner(input);
		// 첫줄은 행과 열의 정보입니다. 4행 6열
		// 그 다음부터 행의 갯수만큼 미로 길 정보가 들어옵니다.
		// 2차원 배열에 위 입력을 담아보세요
		R = sc.nextInt();
		C = sc.nextInt();
		int[][] map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String s = sc.next();
			for (int j = 0; j < C; j++)
				map[i][j] = s.charAt(j) - '0';
		}
		min = 987654321;
//		dfs(map, new boolean[R][C], 0, 0, 1);
		bfs(map, new boolean[R][C]);
		System.out.println(min);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int min;

	static void bfs(int[][] map, boolean[][] visited) {
		Queue<Status> q = new LinkedList<Status>();
		q.add(new Status(0, 0, 1));
		visited[0][0] = true;
		while (!q.isEmpty()) {
			Status top = q.poll();
			if (top.r == map.length-1 && top.c == map[top.r].length-1) {
				min = top.cnt;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int r = top.r + dr[i];
				int c = top.c + dc[i];
				if (r < 0 || c < 0 || r >= map.length || c >= map[r].length)
					continue;
				if (map[r][c] == 1 && !visited[r][c]) {
					visited[r][c] = true;
					q.add(new Status(r, c, top.cnt + 1));
					visited[r][c] = false;
				}
			}
		}
	}

	static class Status {
		int r, c, cnt;

		public Status(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static void dfs(int[][] map, boolean[][] visited, int r, int c, int cnt) {
		if (r == map.length - 1 && c == map[r].length - 1) {
			min = Math.min(min, cnt);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[nr].length) {
				continue;
			}
			if (!visited[nr][nc] && map[nr][nc] == 1) {
				visited[nr][nc] = true;
				dfs(map, visited, nr, nc, cnt + 1);
				visited[nr][nc] = false;
			}
		}
	}
}
