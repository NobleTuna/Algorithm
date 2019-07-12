package bj14620_flowerRoad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(TC1));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		ans = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

	}

	static int ans;

	public static void plant(int cnt, boolean[][] visited) {
		if (ans == 3) {
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
			}
		}
	}

	static String TC1 = "6\r\n" + "1 0 2 3 3 4\r\n" + "1 1 1 1 1 1\r\n" + "0 0 1 1 1 1\r\n" + "3 9 9 0 1 99\r\n"
			+ "9 11 3 1 0 3\r\n" + "12 3 0 0 0 1";
}
