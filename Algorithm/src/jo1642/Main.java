package jo1642;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
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
					go(map, new boolean[R][W], i, j);
				}
			}
		}

		System.out.println(result);
	}

	static int result;
	static int R;
	static int W;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void go(char[][] map, boolean[][] visited, int startY, int startX) {

		Queue<Node> q = new LinkedList<Node>();

		q.add(new Node(startY, startX, 0));
		visited[startY][startX] = true; // 지나옴 체크

		while (!q.isEmpty()) {

			Node v = q.poll();

			int y = v.y;
			int x = v.x;

			for (int i = 0; i < 4; i++) {
				int cy = y + dy[i];
				int cx = x + dx[i];

				if (cy < 0 || cx < 0 || cy >= R || cx >= W || map[cy][cx] != 'L' || visited[cy][cx]) { // 가로막히면 결과값 갱신시도
					if (result < v.d) {
						result = v.d;
//						System.out.println(result);
//						for (int a = 0; a < R; a++) {
//							for (int j = 0; j < W; j++) {
//								System.out.print(visited[a][j] + " ");
//							}
//							System.out.println();
//						}
//						System.out.println();
					}
					continue;
				}

				visited[cy][cx] = true;
				q.add(new Node(cy, cx, v.d + 1));
			}
		}
	}

//	public static void go(char[][] map, boolean[][] visited, int y, int x, int value) {
//
//		for (int i = 0; i < 4; i++) {
//			int cy = y + dy[i];
//			int cx = x + dx[i];
//
//			if (cx < 0 || cy < 0 || cx >= W || cy >= R || map[cy][cx] == 'W' || visited[cy][cx]) {
//				if (value > result) {
//					for (int k = 0; k < R; k++) {
//						for (int j = 0; j < W; j++) {
//							System.out.print(visited[k][j]+" ");
//						}System.out.println();
//					}System.out.println();
//					result = value;
//				}
//				continue;
//			}
//
//			visited[cy][cx] = true;
//			go(map, visited, cy, cx, value + 1);
//		}
//	}

}
