package bj14503_로봇청소기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	static int map[][];
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(TC2));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		for(int i=0; i<R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		ans = 0;
		cleaning(r, c, d);
		System.out.println(ans);

	}

	// 0,1,2,3
	// 북, 동, 남, 서
	static int dy[] = { -1, 0, 1, 0 };
	static int dx[] = { 0, 1, 0, -1 };
	static int ans;

	static void cleaning(int r, int c, int d) {

		while (true) {
			
			if (map[r][c] == 0) {
				ans++;
				map[r][c] = 2;
			}
			boolean isOk = false;

			// 청소할수있는 칸 사방탐색
			for (int i = 0; i < 4; i++) {
				d = turn(d);

				int nr = r + dy[d];
				int nc = c + dx[d];

//				System.out.println(nr+" "+nc+" "+d+" "+map[nr][nc]);
//				
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}

				if (!rangeOut(nr, nc) && map[nr][nc] == 0) {
					isOk = true;
					r = nr;
					c = nc;
					break;
				}
			}
			// 4방탐색 끝, 못찾았을 시
			if (!isOk) {
				int b = back(d);

				int br = r + dy[b];
				int bc = c + dx[b];

				// 청소 끝
				if (rangeOut(br, bc) || map[br][bc] == 1)
					break;

				r = br;
				c = bc;
			}
		}
	}

	static int turn(int d) {
		if (d == 0)
			return 3;
		else
			return d - 1;
	}

	static int back(int d) {
		if (d == 0) {
			return 2;
		} else if (d == 1) {
			return 3;
		} else if (d == 2) {
			return 0;
		} else if (d == 3) {
			return 1;
		}
		System.out.println("back error");
		return 0;
	}

	static boolean rangeOut(int y, int x) {
		return y < 0 || x < 0 || y >= R || x >= C;
	}

	static String TC1 = "3 3\r\n" + "1 1 0\r\n" + "1 1 1\r\n" + "1 0 1\r\n" + "1 1 1";
	static String TC2 = "11 10\r\n" + "7 4 0\r\n" + "1 1 1 1 1 1 1 1 1 1\r\n" + "1 0 0 0 0 0 0 0 0 1\r\n"
			+ "1 0 0 0 1 1 1 1 0 1\r\n" + "1 0 0 1 1 0 0 0 0 1\r\n" + "1 0 1 1 0 0 0 0 0 1\r\n"
			+ "1 0 0 0 0 0 0 0 0 1\r\n" + "1 0 0 0 0 0 0 1 0 1\r\n" + "1 0 0 0 0 0 1 1 0 1\r\n"
			+ "1 0 0 0 0 0 1 1 0 1\r\n" + "1 0 0 0 0 0 0 0 0 1\r\n" + "1 1 1 1 1 1 1 1 1 1";

}
