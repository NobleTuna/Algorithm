package sw1953_탈주범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution {

	static class Position {
		int y, x;

		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static Queue<Position> q;

	static int N, M, R, C, L;
	static int map[][];
	static int ans;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static int dir[][] = { {}, { 0, 1, 2, 3 }, { 0, 1 }, { 2, 3 }, { 0, 3 }, { 1, 3 }, { 1, 2 }, { 0, 2 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(TC));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];

			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			L = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			q = new LinkedList<>();
			q.add(new Position(R, C));

			boolean[][] visited = new boolean[N][M];
			visited[R][C] = true;
			ans = 1;

			for (int l = 1; l < L; l++) {
				if (q.isEmpty())
					break;
				int tum = q.size();
				for (int t = 0; t < tum; t++) {
//				System.out.println("l : "+l);
					Position p = q.poll();

					int y = p.y;
					int x = p.x;
					int state = map[y][x];
//					System.out.println("꺼낸놈   : "+ y+" "+x);

					for (int i = 0; i < dir[state].length; i++) {

						int dirY = dy[dir[state][i]];
						int dirX = dx[dir[state][i]];

						int ny = y + dirY;
						int nx = x + dirX;

//						System.out.println("dy[dir[state][i]] : "+ dy[dir[state][i]]+" dx[dir[state][i]] : "+ dx[dir[state][i]]);

//						System.out.println("확인전 : "+ny+" "+nx);

						if (outRange(ny, nx) || map[ny][nx] == 0 || visited[ny][nx]) {
							continue;
						}
						int nextState = map[ny][nx];

						if (dir[state][i] == 0) {
							if (nextState == 3 || nextState == 4 || nextState == 7) {
//								System.out.println("나가는놈 "+nextState);
								continue;
							}
						} else if (dir[state][i] == 1) {
							if (nextState == 3 || nextState == 5 || nextState == 6)
								continue;

						} else if (dir[state][i] == 2) {
							if (nextState == 2 || nextState == 6 || nextState == 7)
								continue;

						} else if (dir[state][i] == 3) {
							if (nextState == 2 || nextState == 4 || nextState == 5)
								continue;

						}
//						System.out.println(ny+" "+nx+" "+nextState+"방향 : "+dir[state][i]);
//					System.out.println("add : "+ny+" "+nx);
						ans++;
						visited[ny][nx] = true;
						q.add(new Position(ny, nx));
					}
				}
			}

//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	static boolean outRange(int y, int x) {
		return y < 0 || x < 0 || y >= N || x >= M;
	}

	static String TC = "5\r\n" + "5 6 2 1 3\r\n" + "0 0 5 3 6 0\r\n" + "0 0 2 0 2 0\r\n" + "3 3 1 3 7 0\r\n"
			+ "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0\r\n" + "5 6 2 2 6\r\n" + "3 0 0 0 0 3\r\n" + "2 0 0 0 0 6\r\n"
			+ "1 3 1 1 3 1\r\n" + "2 0 2 0 0 2\r\n" + "0 0 4 3 1 1\r\n" + "10 10 4 3 9\r\n" + "0 0 0 0 0 0 0 0 0 0\r\n"
			+ "0 0 0 7 5 0 5 0 0 0\r\n" + "0 0 3 2 2 6 0 0 0 0\r\n" + "0 4 7 2 2 2 7 0 0 4\r\n"
			+ "0 3 0 1 1 2 2 0 0 5\r\n" + "0 5 6 1 1 1 1 6 2 5\r\n" + "7 4 1 2 0 0 4 6 0 0\r\n"
			+ "5 3 1 7 0 2 2 6 5 7\r\n" + "7 3 2 1 1 7 1 0 2 7\r\n" + "3 4 0 0 4 0 5 1 0 1\r\n" + "20 20 13 11 13\r\n"
			+ "0 0 0 1 4 4 4 0 0 0 0 0 0 0 0 1 2 3 1 0\r\n" + "0 0 0 0 0 0 0 0 0 0 0 4 2 7 7 2 0 1 1 0\r\n"
			+ "0 0 0 0 0 0 0 0 0 6 2 4 4 2 0 4 7 0 6 0\r\n" + "0 0 0 7 5 5 3 0 0 7 5 0 5 6 4 2 6 3 1 5\r\n"
			+ "0 0 0 1 2 6 3 3 7 0 3 6 2 4 5 6 7 7 5 7\r\n" + "0 0 0 3 7 6 1 5 3 3 4 5 7 6 0 4 3 3 1 1\r\n"
			+ "0 1 2 1 5 6 1 6 1 6 5 1 6 0 0 3 4 1 7 6\r\n" + "0 2 3 2 2 7 3 0 0 3 2 5 2 1 0 6 5 1 6 5\r\n"
			+ "0 2 5 7 0 7 1 3 3 4 1 3 3 0 2 3 3 2 4 1\r\n" + "4 0 0 7 2 4 2 2 1 3 1 6 5 5 6 2 5 1 1 6\r\n"
			+ "5 6 4 0 3 6 5 2 2 6 1 2 0 1 7 5 7 2 2 2\r\n" + "1 6 3 1 4 4 1 0 3 0 4 2 7 2 0 2 3 6 2 5\r\n"
			+ "1 5 7 2 1 1 4 4 2 1 0 2 7 1 6 2 6 6 2 2\r\n" + "3 7 0 6 5 0 4 0 6 6 7 1 3 1 1 1 5 1 6 6\r\n"
			+ "0 4 0 1 6 2 1 0 7 0 4 2 5 2 7 0 2 7 1 6\r\n" + "0 7 3 0 1 7 6 2 0 0 4 2 4 1 3 3 7 0 1 3\r\n"
			+ "0 1 1 4 3 7 4 5 2 2 4 7 4 7 7 4 6 0 1 6\r\n" + "0 5 2 2 1 4 6 3 7 0 6 3 5 0 0 6 4 4 2 1\r\n"
			+ "0 1 2 4 5 6 0 2 0 0 5 6 2 4 6 4 7 6 3 7\r\n" + "7 7 4 2 3 0 0 4 0 0 7 2 7 5 6 1 4 5 5 4\r\n"
			+ "50 50 20 12 18\r\n"
			+ "0 0 0 0 0 0 0 0 0 0 0 0 4 5 0 0 0 0 0 4 2 0 5 2 1 5 3 3 0 0 4 0 5 1 7 2 6 0 7 0 0 0 2 0 0 0 0 0 0 0\r\n"
			+ "6 7 0 0 0 0 0 0 0 0 0 0 4 5 5 3 6 3 0 2 3 3 0 0 5 6 1 5 3 4 7 6 2 2 1 1 6 5 6 4 6 2 0 0 0 0 2 3 1 0\r\n"
			+ "0 2 6 5 7 6 0 0 0 0 0 0 6 2 0 5 6 2 0 4 1 5 0 0 2 0 7 7 0 6 0 6 2 2 4 1 2 2 1 6 6 6 0 2 2 5 0 6 5 0\r\n"
			+ "0 0 0 4 7 2 7 3 7 0 0 0 0 6 7 6 5 1 1 1 2 2 1 3 1 2 7 6 1 2 1 2 4 1 6 1 1 7 3 1 6 6 6 1 1 1 7 0 0 0\r\n"
			+ "0 0 0 5 4 0 6 3 3 7 0 0 0 6 4 3 2 5 3 1 6 1 0 4 1 0 5 7 6 3 1 1 3 6 1 1 6 3 6 7 3 3 6 5 0 7 2 2 4 6\r\n"
			+ "0 6 0 7 6 0 7 4 0 5 3 0 4 3 2 0 5 7 3 0 1 3 6 7 7 5 1 7 5 2 0 5 3 1 3 7 1 1 1 5 2 5 1 3 6 7 7 6 4 3\r\n"
			+ "5 2 0 2 6 5 0 5 6 1 6 5 5 1 7 1 2 3 6 5 1 6 7 7 6 4 1 7 5 2 0 1 3 4 6 4 5 7 2 6 5 6 2 5 6 5 6 5 1 6\r\n"
			+ "1 2 0 7 0 5 5 0 7 6 2 2 1 3 5 5 3 6 3 7 6 4 1 3 1 3 7 0 3 7 0 2 5 6 1 3 4 1 5 1 7 4 1 7 7 0 4 7 5 5\r\n"
			+ "7 6 0 3 5 1 4 0 5 2 5 0 1 3 5 5 4 4 6 1 6 5 7 6 2 1 6 5 5 3 0 5 7 1 1 3 6 2 2 2 4 5 7 4 5 1 1 0 7 3\r\n"
			+ "2 5 4 0 3 1 4 5 6 3 7 0 4 5 3 6 4 5 1 7 4 7 3 1 1 7 7 1 1 5 6 4 7 1 2 6 4 1 7 2 7 1 6 0 5 0 0 0 1 0\r\n"
			+ "3 0 2 5 1 7 1 1 1 6 5 1 3 1 3 1 1 7 1 3 6 5 5 3 1 3 1 6 2 3 2 6 6 1 1 7 5 7 5 7 1 6 0 3 5 1 5 3 0 0\r\n"
			+ "0 0 3 2 0 1 4 1 4 1 0 7 3 2 2 4 2 4 4 6 1 1 1 7 2 4 7 4 3 6 3 5 1 6 1 3 7 7 2 6 3 2 1 0 4 6 2 6 3 0\r\n"
			+ "0 0 5 4 7 2 4 6 4 1 6 7 2 2 1 6 2 1 5 4 7 2 2 1 0 7 6 1 7 2 5 7 0 4 1 6 4 0 3 0 0 5 5 0 7 7 0 3 0 0\r\n"
			+ "0 0 6 4 3 1 3 1 4 7 2 1 2 4 3 4 1 6 2 1 5 1 1 6 0 7 2 7 2 4 7 4 0 3 7 7 3 3 5 2 0 4 3 0 4 2 0 1 3 5\r\n"
			+ "0 1 0 5 6 4 4 6 5 7 0 6 1 4 5 6 2 1 2 4 4 1 1 2 6 1 6 2 0 3 7 3 0 0 5 1 7 6 6 6 1 3 4 2 1 0 7 0 5 5\r\n"
			+ "0 7 2 1 4 2 7 3 0 2 1 4 3 5 1 1 1 1 7 1 4 4 1 7 6 0 1 2 0 5 2 0 0 0 5 4 0 3 7 5 3 1 4 1 2 7 2 6 6 4\r\n"
			+ "0 1 3 0 3 4 6 3 4 2 4 0 7 5 1 1 2 7 1 6 4 2 2 0 5 6 3 3 1 1 0 0 0 3 0 4 5 4 3 1 1 6 1 6 2 0 1 4 7 7\r\n"
			+ "0 3 0 0 2 6 1 4 7 5 1 4 3 2 5 1 4 3 6 3 0 2 4 5 7 5 6 2 0 5 6 3 6 4 6 2 0 0 6 0 7 2 2 6 0 0 0 0 0 0\r\n"
			+ "0 6 7 1 6 4 3 6 0 2 6 7 6 2 1 6 6 6 2 0 0 7 3 0 1 1 2 0 0 0 3 1 6 7 5 6 4 1 7 5 2 0 2 6 0 0 0 0 4 0\r\n"
			+ "0 6 7 7 3 3 0 2 0 1 6 4 1 1 1 6 2 3 3 4 2 3 5 0 5 7 7 6 2 7 2 7 3 1 0 5 6 7 1 6 4 1 5 0 0 0 0 0 0 0\r\n"
			+ "0 7 3 0 4 3 0 0 6 6 0 5 1 1 1 1 1 6 0 0 7 0 0 0 2 4 3 2 3 3 6 0 0 1 0 2 6 7 3 4 0 3 2 4 0 0 0 0 0 7\r\n"
			+ "0 0 4 7 2 0 0 0 1 4 2 4 7 7 2 4 2 4 0 5 6 0 0 0 7 0 2 7 4 4 1 6 1 4 2 3 6 2 0 6 5 3 5 0 3 5 6 0 0 1\r\n"
			+ "0 0 7 4 7 0 3 0 4 4 6 2 4 7 0 5 7 1 3 6 5 6 6 7 3 3 6 6 4 2 0 0 3 0 4 7 2 6 4 0 6 2 4 6 7 1 7 2 7 1\r\n"
			+ "0 0 2 6 0 0 6 5 0 4 1 2 2 2 2 7 2 1 0 4 6 4 1 0 1 1 2 2 0 4 4 2 0 0 3 0 3 6 2 2 7 6 6 0 4 6 0 2 2 2\r\n"
			+ "0 0 4 4 7 1 1 1 7 3 7 6 2 3 3 0 5 0 0 6 1 2 6 3 1 7 0 4 7 4 3 6 1 5 1 0 3 7 4 0 3 0 5 6 2 0 0 3 0 5\r\n"
			+ "0 0 7 3 0 5 4 0 7 4 0 0 4 5 7 1 3 2 3 3 5 3 5 3 5 5 5 5 4 2 3 6 0 3 1 7 2 4 5 3 0 0 5 3 6 0 0 7 3 6\r\n"
			+ "0 0 3 5 0 0 1 1 1 0 0 0 5 3 5 5 1 2 7 0 4 3 1 6 7 1 5 7 4 4 5 7 0 3 6 3 3 7 7 4 1 3 5 2 0 0 0 7 7 4\r\n"
			+ "0 0 7 6 3 5 0 7 2 7 7 5 4 0 0 7 0 4 0 0 3 2 3 1 5 7 4 6 0 3 5 5 2 0 6 0 0 0 2 1 1 4 3 6 2 0 5 1 1 6\r\n"
			+ "0 0 1 0 4 1 0 2 5 0 0 0 6 7 3 7 0 0 0 0 4 3 3 3 0 1 0 0 0 1 5 1 5 4 5 1 7 0 0 5 0 5 6 0 3 2 5 0 3 4\r\n"
			+ "0 0 0 0 0 4 0 2 3 1 6 6 6 3 5 3 6 0 0 0 4 7 0 6 1 7 1 0 0 5 5 2 5 1 0 1 1 3 3 4 1 4 2 0 6 3 0 0 6 4\r\n"
			+ "6 4 2 2 0 0 0 3 3 0 0 1 4 0 5 0 2 0 7 0 1 7 7 1 5 7 0 0 0 3 1 5 5 6 0 6 2 6 4 0 7 6 5 1 3 3 7 0 2 5\r\n"
			+ "0 0 0 7 7 0 0 4 4 3 1 6 1 0 1 3 3 1 4 5 7 3 7 0 0 4 0 0 0 7 3 7 2 2 0 1 5 0 7 5 5 2 5 1 0 2 0 0 3 2\r\n"
			+ "0 0 0 3 0 0 0 0 1 2 6 7 1 6 7 0 3 5 2 7 3 0 4 5 2 0 0 0 0 2 5 7 3 7 5 6 0 0 2 2 5 4 7 6 4 5 1 4 4 6\r\n"
			+ "0 4 3 0 0 0 0 3 5 6 3 2 0 3 6 0 6 0 0 1 4 3 6 2 4 7 4 7 1 5 0 4 0 0 2 0 0 0 3 7 6 1 2 5 3 5 2 3 3 3\r\n"
			+ "0 0 0 1 4 0 0 2 1 0 2 0 0 1 7 3 4 3 3 4 7 0 6 7 4 7 3 1 6 1 7 3 4 4 7 5 2 1 3 7 2 5 2 3 3 2 3 0 1 2\r\n"
			+ "0 0 0 0 1 1 0 0 5 7 3 6 6 0 0 6 5 4 2 7 0 0 4 5 5 0 5 7 3 3 0 3 5 5 3 6 0 0 3 5 4 0 0 7 5 1 6 0 0 7\r\n"
			+ "0 0 0 0 5 6 3 1 5 2 0 7 7 7 0 0 1 0 3 6 4 1 6 7 2 1 6 5 2 0 0 7 4 5 0 0 0 0 0 6 6 0 0 5 6 0 2 3 4 5\r\n"
			+ "0 0 7 1 0 1 6 5 6 0 0 5 4 5 7 1 1 6 5 2 2 0 3 7 4 5 2 6 4 0 0 3 4 0 0 0 0 0 0 7 7 7 7 6 4 3 4 4 0 0\r\n"
			+ "0 0 0 1 3 0 0 3 7 1 1 0 4 1 4 4 2 6 1 6 2 2 7 4 2 4 1 7 1 6 4 3 3 1 3 4 0 0 3 2 0 2 0 1 3 3 4 7 1 5\r\n"
			+ "0 0 0 3 4 0 0 2 0 5 5 0 0 1 4 4 0 4 0 1 6 6 4 2 1 0 0 3 7 0 4 3 3 2 3 5 3 5 0 4 0 5 0 3 0 7 7 3 5 6\r\n"
			+ "0 0 0 7 2 0 0 4 2 2 6 2 2 5 0 5 0 3 4 3 5 5 2 0 4 0 0 5 0 0 4 1 6 4 4 3 4 0 0 5 0 1 1 2 0 7 3 4 0 4\r\n"
			+ "0 0 1 1 4 4 1 0 0 0 3 5 4 5 4 2 7 4 6 1 6 7 0 3 0 7 1 7 6 6 3 0 5 7 6 6 4 7 3 4 5 0 0 0 0 6 1 1 5 3\r\n"
			+ "0 0 4 2 5 7 4 4 2 1 2 1 3 4 7 2 7 2 1 6 3 3 0 7 5 6 6 4 5 5 3 3 2 7 5 3 1 4 7 0 0 0 0 0 0 3 1 5 6 5\r\n"
			+ "0 0 0 4 4 1 0 0 6 0 0 7 5 7 5 1 7 3 6 0 2 4 3 4 7 7 3 0 0 0 1 5 5 0 6 7 7 7 4 4 3 6 3 7 5 0 1 1 0 2\r\n"
			+ "0 0 0 1 3 4 7 2 5 0 0 4 4 0 5 2 2 0 1 7 0 1 1 3 6 5 2 6 2 7 7 3 6 7 1 3 4 6 7 5 3 7 4 6 0 0 0 4 3 1\r\n"
			+ "0 0 0 2 1 6 3 5 4 0 0 6 0 0 6 7 0 0 5 2 0 7 7 0 7 0 0 7 7 6 0 0 1 1 0 1 0 1 3 1 0 0 4 7 7 0 0 0 2 6\r\n"
			+ "0 0 0 2 4 0 6 7 2 4 1 5 6 3 0 0 0 0 4 2 7 1 1 5 2 0 0 7 2 2 3 1 3 5 5 7 7 4 0 3 4 2 3 0 0 4 6 6 0 1\r\n"
			+ "0 0 0 4 6 1 0 3 6 4 7 3 5 0 0 0 0 0 0 7 0 0 3 6 2 1 0 2 3 4 6 7 5 0 7 0 5 4 5 1 5 0 0 0 0 4 5 3 1 0\r\n"
			+ "1 3 6 5 5 2 3 7 6 1 0 6 7 3 2 5 6 7 6 6 0 0 7 1 0 5 5 0 3 0 2 0 7 4 5 3 2 5 1 5 3 0 0 0 1 2 0 1 0 0\r\n"
			+ "1 7 3 0 2 0 7 0 4 6 1 1 5 0 7 0 5 7 7 2 6 0 0 1 0 2 3 3 4 2 7 5 3 7 0 0 4 6 6 6 3 0 0 0 7 7 7 5 7 2\r\n"
			+ "";
	static String TC1 = "1\r\n" + "5 6 2 1 4\r\n" + "0 0 5 3 6 0\r\n" + "0 0 2 0 2 0\r\n" + "3 3 1 3 7 0\r\n"
			+ "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0";

	static String TC2 = "1\r\n" + "5 6 2 2 6\r\n" + "3 0 0 0 0 3\r\n" + "2 0 0 0 0 6\r\n" + "1 3 1 1 3 1\r\n"
			+ "2 0 2 0 0 2\r\n" + "0 0 4 3 1 1";

}
