package jo1462;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_dfs {
	static class Node { // 큐에넣을 좌표
		int y;
		int x;
		int d;

		public Node(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}

	}

	public static void main(String[] args) throws IOException {

		// 1. 입력받고 간선맵을 만들고
		// 2. bfs 로 도착한 맵을 바꾸면서 진행해야됨?

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		R = Integer.parseInt(st.nextToken()); // 세로
		W = Integer.parseInt(st.nextToken()); // 가로
		char map[][] = new char[R][W];

		for (int i = 0; i < R; i++) {
			input = br.readLine();
			char[] msg = input.toCharArray();
			for (int j = 0; j < W; j++) {
				map[i][j] = msg[j];
			}
		}

		result = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'L') {
//					System.out.println("start : " + i + " " + j);
					cnt = new int[R][W];
					go(map, new boolean[R][W], i, j, 0);

					for (int a = 0; a < R; a++) {
						for (int b = 0; b < R; b++) {
							if (result < cnt[a][b]) {
								result = cnt[a][b];
								
//								for(int c=0; c<R; c++) {
//									for(int d = 0; d<W; d++) {
//										System.out.print(cnt[c][d]+" ");
//										
//									}System.out.println();
//								}System.out.println();
//								
								
								
							}
						}
					}
				}
			}
		}

		System.out.println(result);
	}

	static int cnt[][];
	static int result;
	static int R;
	static int W;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void go(char[][] map, boolean[][] visited, int y, int x, int value) {

		for (int i = 0; i < 4; i++) {
			int cy = y + dy[i];
			int cx = x + dx[i];

			if (cx < 0 || cy < 0 || cx >= W || cy >= R || map[cy][cx] == 'W' || visited[cy][cx]) {
				if (cnt[y][x] == 0)
					cnt[y][x] = value;
				else if (cnt[y][x] > value)
					cnt[y][x] = value;
				continue;
			}

			visited[cy][cx] = true;
			go(map, visited, cy, cx, value + 1);
			visited[cy][cx] = false;
		}
	}

}
