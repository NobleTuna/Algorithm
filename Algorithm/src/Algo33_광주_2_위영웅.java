import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo33_광주_2_위영웅 {

	static int R, C;
	static char[][] map;
	static int sy, sx;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		br = new BufferedReader(new StringReader(TC));

//		System.out.println(T);
			// 시작첨 찾아줘야됨
			// BFS 한쪽에서 출발해서 길을 따라가다가 분기하면 다 보냄.
			// visted 체크안된거만
			// 길이 끊겨있으면 -> 해당좌표 리턴
			// 해당좌표에서 사방탐색으로 블록확인

			StringTokenizer st = new StringTokenizer(br.readLine());

			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new char[R][C];

			q = new LinkedList<>();
			for (int i = 0; i < R; i++) {
				String tmp = br.readLine();
				char[] input = tmp.toCharArray();
				for (int j = 0; j < C; j++) {
					map[i][j] = input[j];
					if (map[i][j] == 'M') {
						sy = i;
						sx = j;
					}
				}
			}
			visited = new boolean[R][C];

			for (int i = 1; i <= 4; i++) {

				int y = sy + dy[i];
				int x = sx + dx[i];

				if (outRange(y, x) || map[y][x] == '.')
					continue;

				addQ(y, x, i);
			}
//			System.out.println(tc+" 사이즈 : "+q.size());
//			Position tmpp = q.poll();
//			System.out.println(tmpp.y+" "+tmpp.x);

//			System.out.println();
//			for (int i = 0; i < R; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();

			int targetY = 0;
			int targetX = 0;

			while (!q.isEmpty()) {

				Position curP = q.poll();

				int y = curP.y;
				int x = curP.x;

				if (map[y][x] == 'Z')
					continue;

				if (map[y][x] == '.') {
					targetY = y;
					targetX = x;
					break;
				}

				// 길이 끊기면 더 bfs할 필요없음 그곳이 타겟
				if (map[y][x] == '|') {
					for (int d = 1; d <= 2; d++) {

						int ny = y + dy[d];
						int nx = x + dx[d];

						if (outRange(ny, nx) || visited[ny][nx])
							continue;

						addQ(ny, nx, d);

					}
				} else if (map[y][x] == '-') {
					for (int d = 3; d <= 4; d++) {

						int ny = y + dy[d];
						int nx = x + dx[d];

						if (outRange(ny, nx) || visited[ny][nx])
							continue;

						addQ(ny, nx, d);

					}
				} else if (map[y][x] == '+') {
					for (int d = 1; d <= 4; d++) {

						int ny = y + dy[d];
						int nx = x + dx[d];

						if (outRange(ny, nx) || visited[ny][nx])
							continue;

						addQ(ny, nx, d);
					}
				} else {
					int k = map[y][x] - '0';
//					System.out.println(k);

					for (int i = 0; i < 2; i++) {
						int d = dir[k][i];

						int ny = y + dy[d];
						int nx = x + dx[d];

						if (outRange(ny, nx) || visited[ny][nx]) {
//							System.out.println("d : "+d+" "+ny+" "+nx);
							continue;
						}

						addQ(ny, nx, d);
					}
				}
			}
//			for(int i=0; i<R; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
			

//			System.out.println("targetY: "+ targetY+" targetX: "+ targetX);

			boolean up = false;
			boolean down = false;
			boolean left = false;
			boolean right = false;

			for (int d = 1; d <= 4; d++) {

				int ny = targetY + dy[d];
				int nx = targetX + dx[d];

				if (outRange(ny, nx))
					continue;

				if (d == 1) {
					if (map[ny][nx] == '|' || map[ny][nx] == '+' || map[ny][nx] == '1' || map[ny][nx] == '4') {
						up = true;
					}

				} else if (d == 2) {
					if (map[ny][nx] == '|' || map[ny][nx] == '+' || map[ny][nx] == '2' || map[ny][nx] == '3') {
						down = true;
					}

				} else if (d == 3) {
					if (map[ny][nx] == '-' || map[ny][nx] == '+' || map[ny][nx] == '1' || map[ny][nx] == '2') {
						left = true;
					}

				} else if (d == 4) {
					if (map[ny][nx] == '-' || map[ny][nx] == '+' || map[ny][nx] == '3' || map[ny][nx] == '4') {
						right = true;
					}
				}
			}

			char ans = '0';

			if (up && down && left && right) {
				ans = '+';
			} else if (up && down && !left && !right) {
				ans = '|';
			} else if (!up && !down && left && right) {
				ans = '-';
			} else if (!up && down && !left && right) {
				ans = '1';
			} else if (up && !down && !left && right) {
				ans = '2';
			} else if (up && !down && left && !right) {
				ans = '3';
			} else if (!up && down && left && !right) {
				ans = '4';
			}
			
			System.out.println((targetY+1)+" "+(targetX+1)+" "+ans);

	}

	static int[][] dir = { { 0, 0 }, { 2, 4 }, { 1, 4 }, { 1, 3 }, { 2, 3 } };

	static void addQ(int y, int x, int d) {

		if (d == 1) {
			if (map[y][x] == '|' || map[y][x] == '+' || map[y][x] == '1' || map[y][x] == '4' || map[y][x] == '.') {
				visited[y][x] = true;
				q.add(new Position(y, x));
			}
		} else if (d == 2) {
			if (map[y][x] == '|' || map[y][x] == '+' || map[y][x] == '2' || map[y][x] == '3' || map[y][x] == '.') {
				visited[y][x] = true;
				q.add(new Position(y, x));
			}
		} else if (d == 3) {
			if (map[y][x] == '-' || map[y][x] == '+' || map[y][x] == '1' || map[y][x] == '2' || map[y][x] == '.') {
				visited[y][x] = true;
				q.add(new Position(y, x));
			}
		} else if (d == 4) {
			if (map[y][x] == '-' || map[y][x] == '+' || map[y][x] == '3' || map[y][x] == '4' || map[y][x] == '.') {
				visited[y][x] = true;
				q.add(new Position(y, x));
			}
		}

	}

	static class Position {
		int y;
		int x;

		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int[] dy = { 0, -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 0, -1, 1 };

	static Queue<Position> q;

	static boolean[][] visited;

	static boolean outRange(int y, int x) {
		return y < 0 || x < 0 || y >= R || x >= C;
	}

	static String TC = "3\r\n" + "3 7\r\n" + ".......\r\n" + ".M-.-Z.\r\n" + ".......\r\n" + "3 5\r\n" + "..1-M\r\n"
			+ "1-+..\r\n" + "Z.23.\r\n" + "6 10\r\n" + "Z.1----4..\r\n" + "|.|....|..\r\n" + "|..14..M..\r\n"
			+ "2-+++4....\r\n" + "..2323....\r\n" + "..........\r\n" + "";
}
