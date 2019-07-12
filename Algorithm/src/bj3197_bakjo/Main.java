package bj3197_bakjo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int R, C;
	static int map[][];
	// 0 빈칸, 1 얼음, 2, 백조

	static Point[] bakjo;
	static Queue<Point> water;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(TC1));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		water = new LinkedList<Point>();
		map = new int[R][C];
		bakjo = new Point[2];
		answer = 0;
		int index = 0;

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				char input = line.charAt(j);

				if (input == 'X') {
					map[i][j] = 1;
				} else if (input == '.') {
					water.add(new Point(i, j));
				} else if (input == 'L') {
					bakjo[index++] = new Point(i, j);
				}
			}
		}

//		for (int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println(bakjo[0].y + " " + bakjo[0].x);
//		System.out.println(bakjo[1].y + " " + bakjo[1].x);
		while (!water.isEmpty()) {

			if (searchBakjo()) {
				break;
			}
			answer++;

			int size = water.size();
			/// 한바퀴
			for (int s = 0; s < size; s++) {

				Point curPoint = water.poll();
				int y = curPoint.y;
				int x = curPoint.x;

				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if (outRange(ny, nx) || map[ny][nx] != 1) {
						continue;
					}
					map[ny][nx] = 0;
					water.add(new Point(ny, nx));
				}
			}
//			for (int i = 0; i < R; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
		}
		System.out.println(answer);
	}

	public static boolean searchBakjo() {
		Queue<Point> bk = new LinkedList<Main.Point>();
		bk.add(bakjo[0]);

		int fy = bakjo[1].y;
		int fx = bakjo[1].x;

		boolean[][] visited = new boolean[R][C];

		while (!bk.isEmpty()) {
			Point bj = bk.poll();

			if (bj.y == fy && bj.x == fx) {
				return true;
			}

			for (int i = 0; i < 4; i++) {
				int ny = bj.y + dy[i];
				int nx = bj.x + dx[i];

				if (outRange(ny, nx) || map[ny][nx] == 1 || visited[ny][nx])
					continue;

				visited[ny][nx] = true;
				bk.add(new Point(ny, nx));

			}
		}

		return false;
	}

	static int dy[] = { 1, -1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };

	static boolean outRange(int y, int x) {
		return y < 0 || x < 0 || y >= R || x >= C;
	}

	static String TC1 = "8 17\r\n" + "...XXXXXX..XX.XXX\r\n" + "....XXXXXXXXX.XXX\r\n" + "...XXXXXXXXXXXX..\r\n"
			+ "..XXXXX.LXXXXXX..\r\n" + ".XXXXXX..XXXXXX..\r\n" + "XXXXXXX...XXXX...\r\n" + "..XXXXX...XXX....\r\n"
			+ "....XXXXX.XXXL...";

}
