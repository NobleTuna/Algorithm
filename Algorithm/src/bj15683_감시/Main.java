package bj15683_감시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static int[][] map;

	static class Position {
		int y;
		int x;
		int state;

		public Position(int y, int x, int state) {
			this.y = y;
			this.x = x;
			this.state = state;
		}
	}

	static List<Position> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(TC2));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		list = new ArrayList<Position>();
		map = new int[R][C];
		zero = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					zero++;
				else if (map[i][j] != 0 && map[i][j] != 6) {
					list.add(new Position(i, j, map[i][j]));
				}
			}
		}
//		System.out.println(zero);
		camera = list.size();
		ans = Integer.MAX_VALUE;
		go(0, 0, new boolean[R][C]);
		System.out.println(ans);

	}

	static int camera;
	static int zero; // 전체 사각지대
	static int ans;

	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };

	static int[][] type2 = { { 0, 1 }, { 2, 3 } };
	static int[][] type3 = { { 0, 3 }, { 3, 1 }, { 1, 2 }, { 2, 0 } };
	static int[][] type4 = { { 2, 0, 3 }, { 0, 3, 1 }, { 3, 1, 2 }, { 1, 2, 0 } };

	static int chk(int y, int x, int dir, boolean[][] isCnt, Queue<Position> recover) {
		int cnt = 0;

		while (true) {
			y += dy[dir];
			x += dx[dir];
			if (outRange(y, x) || map[y][x] == 6)
				break;
			if (map[y][x] == 0 && !isCnt[y][x]) {
				cnt++;
				recover.add(new Position(y, x, 0));
				isCnt[y][x] = true;
			}
		}

		return cnt;
	}

	static void go(int idx, int cnt, boolean[][] isCnt) {
		// 리스트에서 카메라 하나씩 꺼내서 그 카메라의 경우의 수대로 체크하고 다음카메라로.
		if (idx == camera) {
//			System.out.println("cnt : " + cnt);
			ans = Math.min(ans, zero - cnt);
			return;
		}

		Position c = list.get(idx);

		int y = c.y;
		int x = c.x;
		int type = c.state;
//		System.out.println(y + " " + x + " state : " + type);

		switch (type) {
		case 1:
			for (int i = 0; i < 4; i++) {
				Queue<Position> recover = new LinkedList<Position>();
				int sum = chk(y, x, i, isCnt, recover);
//				System.out.println("type : "+type);
//				for (int k = 0; k < isCnt.length; k++) {
//					System.out.println(Arrays.toString(isCnt[k]));
//				}
//				System.out.println();
				go(idx + 1, cnt + sum, isCnt);
				while (!recover.isEmpty()) {
					Position p = recover.poll();
					isCnt[p.y][p.x] = false;
				}
			}
			break;
		case 2:
			for (int i = 0; i < type2.length; i++) {
				Queue<Position> recover = new LinkedList<Position>();
				int sum = 0;
				for (int j = 0; j < type2[i].length; j++) {
					sum += chk(y, x, type2[i][j], isCnt, recover);
//					System.out.println("type : "+type);
//					for (int k = 0; k < isCnt.length; k++) {
//						System.out.println(Arrays.toString(isCnt[k]));
//					}
//					System.out.println();
				}
				go(idx + 1, cnt + sum, isCnt);
				while (!recover.isEmpty()) {
					Position p = recover.poll();
					isCnt[p.y][p.x] = false;
				}
			}

			break;
		case 3:

			for (int i = 0; i < type3.length; i++) {
				Queue<Position> recover = new LinkedList<Position>();
				int sum = 0;
				for (int j = 0; j < type3[i].length; j++) {
					sum += chk(y, x, type3[i][j], isCnt, recover);
//					System.out.println("type : "+type);
//					for (int k = 0; k < isCnt.length; k++) {
//						System.out.println(Arrays.toString(isCnt[k]));
//					}
//					System.out.println();
				}
				go(idx + 1, cnt + sum, isCnt);

				while (!recover.isEmpty()) {
					Position p = recover.poll();
					isCnt[p.y][p.x] = false;
				}
			}

			break;
		case 4:

			for (int i = 0; i < type4.length; i++) {
				Queue<Position> recover = new LinkedList<Position>();
				int sum = 0;
				for (int j = 0; j < type4[i].length; j++) {
					sum += chk(y, x, type4[i][j], isCnt, recover);
//					System.out.println("type : "+type);
//					for(int k=0; k<isCnt.length; k++) {
//						System.out.println(Arrays.toString(isCnt[k]));
//					}
//					System.out.println();
				}
				go(idx + 1, cnt + sum, isCnt);

				while (!recover.isEmpty()) {
					Position p = recover.poll();
					isCnt[p.y][p.x] = false;
				}
			}

			break;
		case 5:
			Queue<Position> recover = new LinkedList<Position>();
			int sum = 0;
			for (int i = 0; i < 4; i++) {
				sum += chk(y, x, i, isCnt, recover);
//				System.out.println("type : "+type);
//				for (int k = 0; k < isCnt.length; k++) {
//					System.out.println(Arrays.toString(isCnt[k]));
//				}
//				System.out.println();
			}
			go(idx + 1, cnt + sum, isCnt);
			while (!recover.isEmpty()) {
				Position p = recover.poll();
				isCnt[p.y][p.x] = false;
			}

			break;
		}

	}

	static boolean outRange(int y, int x) {
		return y < 0 || x < 0 || y >= R || x >= C;
	}

	static String TC1 = "4 6\r\n" + "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0\r\n" + "0 0 1 0 6 0\r\n" + "0 0 0 0 0 0";
	static String TC2 = "6 6\r\n" + "0 0 0 0 0 0\r\n" + "0 2 0 0 0 0\r\n" + "0 0 0 0 6 0\r\n" + "0 6 0 0 2 0\r\n"
			+ "0 0 0 0 0 0\r\n" + "0 0 0 0 0 5";
}
