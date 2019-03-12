package bj17070; // 파이프 옮기기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int[][][] memo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		memo = new int[N][N][4];
//		tracking = new int[N][N];
		go(0, 1, 1);
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(tracking[i]));
//		}
		System.out.println(ans);
	}

	static int[][] tracking;
	static int ans;

	// dir = 1, 2, 3 오른쪽, 대각선, 아래
	static void go(int y, int x, int dir) {

		if ((dir == 1 || dir == 3)) {
			if (outRange(y, x))
				return;
		}
		if (dir == 2) {
			if (outRange(y - 1, x) || outRange(y, x - 1) || outRange(y, x))
				return;
		}
//		System.out.println(y+" "+x+" "+dir);
//		tracking[y][x] = 5;
		if (y == N - 1 && x == N - 1) {
			ans++;
		}

		if (dir == 1) { // 오른쪽
			go(y, x + 1, 1);
			go(y + 1, x + 1, 2);
		} else if (dir == 2) { // 대각선
			go(y, x + 1, 1);
			go(y + 1, x + 1, 2);
			go(y + 1, x, 3);
		} else if (dir == 3) { // 아래
			go(y + 1, x, 3);
			go(y + 1, x + 1, 2);
		}
	}

	static boolean outRange(int y, int x) {
		return y < 0 || x < 0 || y >= N || x >= N || map[y][x] != 0;
	}

}
