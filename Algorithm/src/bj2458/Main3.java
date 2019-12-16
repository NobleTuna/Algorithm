package bj2458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		chk = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			chk[a][b] = true;
		}
		high = new int[N + 1];
		low = new int[N + 1];

		Arrays.fill(high, 0);
		Arrays.fill(low, 0);

		int ans = 0;

		for (int i = 1; i < N + 1; i++) {
			sum = 0;
			visited = new boolean[N + 1];
			goHigh(i);
			high[i] = sum;

			sum = 0;
			visited = new boolean[N + 1];
			goLow(i);
			low[i] = sum;

			int tmp = high[i] + low[i];
			if (tmp == N - 1)
				ans++;

//			System.out.println(i + " high : " + high[i]);
//			System.out.println(i + " low : " + low[i]);
//			System.out.println();

		}

		System.out.println(ans);

	}

	static int N;
	static boolean[] visited;
	static boolean[][] chk;
	static int[] high;
	static int[] low;

	static int sum;

	static void goHigh(int x) {

		for (int i = 0; i < N + 1; i++) {
			if (chk[x][i] && !visited[i]) {
				visited[i] = true;
//				System.out.println(i);

//				if (high[x] != 0) {
//					sum += high[x];
//					return;
//				}
				sum++;
//				System.out.println("sum : "+sum);
				goHigh(i);
			}
		}
	}

	static void goLow(int x) {

		for (int i = 0; i < N + 1; i++) {
			if (chk[i][x] && !visited[i]) {
				visited[i] = true;
//				if (low[i] != 0) {
//					sum += low[i];
//					return;
//				}
				sum++;
				goLow(i);
			}
		}
	}

}
