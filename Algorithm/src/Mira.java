import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Mira {

	static int[][] map;
	static int a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new StringReader(TC));
		StringTokenizer st = new StringTokenizer(br.readLine());
		answer = 11;
		blank = 0;
		b = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		map = new int[a][b];

		for (int i = 0; i < a; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < b; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					blank++;
			}
		}

		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				go(i, j, 0, 0, 0, new boolean[a][b]);
				go(i, j, 0, 1, 0, new boolean[a][b]);
				go(i, j, 0, 2, 0, new boolean[a][b]);
			}
		}
		System.out.println("answer : " + ((answer == 11) ? -1 : answer - 1));
	}

	/**
	 * 
	 * @param y
	 * @param x
	 * @param D
	 * @param form 0 : 한칸, 1 : 가로, 2 : 세로
	 */
	static int answer;
	static int blank;

	public static void go(int y, int x, int D, int form, int cnt, boolean[][] visited) {
		if (D >= answer) {
			return;
		}

		if (cnt == blank) {
			answer = Math.min(answer, D);
			return;
		}

		// 한칸
		if (form == 0) {

			// 상
			int ny = y - 1;
			int ny2 = y - 2;
			int nx = x;
			int nx2 = x;
			if (outRange(ny, nx) && outRange(ny2, nx2) && map[ny][nx] == 1 && map[ny2][nx2] == 1) {
				boolean v1 = false;
				boolean v2 = false;

				int nCnt = cnt;

				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					nCnt++;
					v1 = true;
				}
				if (!visited[ny2][nx2]) {
					visited[ny2][nx2] = true;
					nCnt++;
					v2 = true;
				}
				go(ny2, nx, D + 1, 2, nCnt, visited);
				if (v1)
					visited[ny][nx] = false;
				if (v2)
					visited[ny2][nx2] = false;
			}

			// 하
			ny = y + 1;
			ny2 = y + 2;
			nx = x;
			nx2 = x;
			if (outRange(ny, nx) && outRange(ny2, nx2) && map[ny][nx] == 1 && map[ny2][nx2] == 1) {
				boolean v1 = false;
				boolean v2 = false;

				int nCnt = cnt;

				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					nCnt++;
					v1 = true;
				}
				if (!visited[ny2][nx2]) {
					visited[ny2][nx2] = true;
					nCnt++;
					v2 = true;
				}
				go(ny2, nx, D + 1, 2, nCnt, visited);
				if (v1)
					visited[ny][nx] = false;
				if (v2)
					visited[ny2][nx2] = false;
			}
			// 좌
			ny = y;
			ny2 = y;
			nx = x - 1;
			nx2 = x - 2;
			if (outRange(ny, nx) && outRange(ny2, nx2) && map[ny][nx] == 1 && map[ny2][nx2] == 1) {
				boolean v1 = false;
				boolean v2 = false;

				int nCnt = cnt;

				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					nCnt++;
					v1 = true;
				}
				if (!visited[ny2][nx2]) {
					visited[ny2][nx2] = true;
					nCnt++;
					v2 = true;
				}
				go(ny2, nx, D + 1, form, nCnt, visited);
				if (v1)
					visited[ny][nx] = false;
				if (v2)
					visited[ny2][nx2] = false;
			}
			// 우
			ny = y;
			ny2 = y;
			nx = x - 1;
			nx2 = x - 2;
			if (outRange(ny, nx) && outRange(ny2, nx2) && map[ny][nx] == 1 && map[ny2][nx2] == 1) {
				boolean v1 = false;
				boolean v2 = false;

				int nCnt = cnt;

				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					nCnt++;
					v1 = true;
				}
				if (!visited[ny2][nx2]) {
					visited[ny2][nx2] = true;
					nCnt++;
					v2 = true;
				}
				go(ny2, nx, D + 1, form, nCnt, visited);
				if (v1)
					visited[ny][nx] = false;
				if (v2)
					visited[ny2][nx2] = false;
			}

			///////////////////// 가로
		} else if (form == 1) {

			// 상
			int ny = y - 1;
			int ny2 = y - 1;
			int nx = x;
			int nx2 = x + 1;

			if (outRange(ny, nx) && outRange(ny2, nx2) && map[ny][nx] == 1 && map[ny2][nx2] == 1) {
				boolean v1 = false;
				boolean v2 = false;
				int nCnt = cnt;

				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					nCnt++;
					v1 = true;
				}
				if (!visited[ny2][nx2]) {
					visited[ny2][nx2] = true;
					nCnt++;
					v2 = true;
				}

				go(Math.min(ny, ny2), Math.min(nx, nx2), D + 1, 1, nCnt, visited);
				if (v1)
					visited[ny][nx] = false;
				if (v2)
					visited[ny2][nx2] = false;
			}

			// 하
			ny = y + 1;
			ny2 = y + 1;
			nx = x;
			nx2 = x + 1;

			if (outRange(ny, nx) && outRange(ny2, nx2) && map[ny][nx] == 1 && map[ny2][nx2] == 1) {
				boolean v1 = false;
				boolean v2 = false;
				int nCnt = cnt;

				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					nCnt++;
					v1 = true;
				}
				if (!visited[ny2][nx2]) {
					visited[ny2][nx2] = true;
					nCnt++;
					v2 = true;
				}

				go(Math.min(ny, ny2), Math.min(nx, nx2), D + 1, 1, nCnt, visited);
				if (v1)
					visited[ny][nx] = false;
				if (v2)
					visited[ny2][nx2] = false;
			}

			// 좌
			ny = y;
			nx = x - 1;
			if (outRange(ny, nx) && map[ny][nx] == 1) {
				boolean v1 = false;
				int nCnt = cnt;

				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					nCnt++;
					v1 = true;
				}
				go(ny, nx, D + 1, 0, nCnt, visited);
				if (v1)
					visited[ny][nx] = false;
			}

			// 우
			ny = y;
			nx = x + 1;
			if (outRange(ny, nx) && map[ny][nx] == 1) {
				boolean v1 = false;
				int nCnt = cnt;

				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					nCnt++;
					v1 = true;
				}
				go(ny, nx, D + 1, 0, nCnt, visited);
				if (v1)
					visited[ny][nx] = false;
			}

			////////////////// 세로
		} else if (form == 2) {
			// 상
			int ny = y - 1;
			int nx = x;
			if (outRange(ny, nx) && map[ny][nx] == 1) {
				boolean v1 = false;
				int nCnt = cnt;

				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					nCnt++;
					v1 = true;
				}
				go(ny, nx, D + 1, 0, nCnt, visited);
				if (v1)
					visited[ny][nx] = false;
			}

			// 하

			ny = y + 1;
			nx = x;
			if (outRange(ny, nx) && map[ny][nx] == 0) {
				boolean v1 = false;
				int nCnt = cnt;

				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					nCnt++;
					v1 = true;
				}
				go(ny, nx, D + 1, 0, nCnt, visited);
				if (v1)
					visited[ny][nx] = false;
			}

			// 좌
			ny = y;
			int ny2 = y + 1;
			nx = x + 1;
			int nx2 = x + 1;

			if (outRange(ny, nx) && outRange(ny2, nx2) && map[ny][nx] == 1 && map[ny2][nx2] == 1) {
				boolean v1 = false;
				boolean v2 = false;
				int nCnt = cnt;

				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					nCnt++;
					v1 = true;
				}
				if (!visited[ny2][nx2]) {
					visited[ny2][nx2] = true;
					nCnt++;
					v2 = true;
				}

				go(Math.min(ny, ny2), Math.min(nx, nx2), D + 1, 2, nCnt, visited);
				if (v1)
					visited[ny][nx] = false;
				if (v2)
					visited[ny2][nx2] = false;
			}

			// 우

			if (outRange(ny, nx) && outRange(ny2, nx2) && map[ny][nx] == 1 && map[ny2][nx2] == 1) {
				boolean v1 = false;
				boolean v2 = false;
				int nCnt = cnt;

				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					nCnt++;
					v1 = true;
				}
				if (!visited[ny2][nx2]) {
					visited[ny2][nx2] = true;
					nCnt++;
					v2 = true;
				}

				go(Math.min(ny, ny2), Math.min(nx, nx2), D + 1, 2, nCnt, visited);
				if (v1)
					visited[ny][nx] = false;
				if (v2)
					visited[ny2][nx2] = false;
			}

		}

	}

	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static boolean outRange(int y, int x) {
		return y >= 0 && x >= 0 && y < a && x < b;
	}

	static String TC = "6 7\r\n" + "0 0 0 0 0 0\r\n" + "0 0 0 1 1 0\r\n" + "0 0 0 1 1 0\r\n" + "0 1 1 1 1 0\r\n"
			+ "0 0 1 1 0 0\r\n" + "0 0 1 1 0 0\r\n" + "0 0 0 0 0 0";
}
