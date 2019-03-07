package bj15684_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Position {
		int y;
		int x;

		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		N = Integer.parseInt(st.nextToken()); // 세로선 숫자
		M = Integer.parseInt(st.nextToken()); // 가로선 숫자
		H = Integer.parseInt(st.nextToken()); // 체크해야될 숫자

		line = new Position[H][2];
		for (int i = 0; i < H; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			line[i][0] = new Position(a, b); // a높이의 b;
			line[i][1] = new Position(a, b + 1); // a높이의 b+1;
		}
		ans = 4;

		// if ans == 4 ....
		System.out.println("p1");
		go(new boolean [H], 0, 0);
		System.out.println("p2");
		System.out.println(ans);
	}

	static Position[][] line;
	static int N; // 세로선 숫자(시작점들)
	static int M; // 가로선 숫자 (점선, 높이)
	static int H; // 체크할 숫자
	static int ans;

	static void go(boolean[] chk, int cnt, int idx) {

		if (cnt > ans) {
			return;
		}
		if (idx == H) {
			boolean[][] map = new boolean[M + 1][N + 1];

			for (int i = 0; i < H; i++) { // 맵 true 체크
				if (chk[i]) {
					map[line[i][0].y][line[i][0].x] = true;
					map[line[i][1].y][line[i][1].x] = true;
				}
			}
			// 사다리 내려가며 실패하면 그때그때 리턴하자

			boolean isSuccess = true;
			for (int i = 1; i <= N; i++) {
				int x = i;
				int y = 0;
				while (true) {
					if (y == M) {
						break;
					}
					if (map[y][i]) {
						if (i != 0 && map[y][i - 1]) {
							i = i - 1;
						} else if (i != N && map[y][i + 1])
							i = i + 1;
					}
					y++;
				}

				if (i != x) {
					isSuccess = false;
					break;
				}
			}
			if(isSuccess) {
				ans = Math.min(ans, cnt);
			}

			// 다돌고 리턴전에 체크해야됨
			return;
		}

		chk[idx] = true;
		go(chk, cnt + 1, idx + 1);
		chk[idx] = false;
		go(chk, cnt, idx + 1);

	}

}
