package bj2458;

import java.util.Arrays;
import java.util.Scanner;

public class 키순서_류승환 {
	static int result;
	static final int INF = 9999;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner("6 6\r\n" + "1 5\r\n" + "3 4\r\n" + "5 4\r\n" + "4 2\r\n" + "4 6\r\n" + "5 2");
		result = 0;

		int n = sc.nextInt();
		int m = sc.nextInt();
		// n 명을 m번 비교

		int[][] dist = new int[n + 1][n + 1];
		for (int[] is : dist) {
			Arrays.fill(is, INF);
		}
		for (int i = 0; i < dist.length; i++) {
			dist[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			dist[start][end] = 1;
		}

		for (int z = 1; z < dist.length; z++) {
			for (int i = 1; i < dist.length; i++) {
				for (int j = 1; j < dist.length; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][z] + dist[z][j]);
				}
			}
		}

		for (int start = 1; start < dist.length; start++) {
//			System.out.println(Arrays.toString(dist[start]));
			boolean flag = true;
			for (int end = 1; end <= n; end++) {
				// i > j 로 길이 있던지 j > i 로 길이 있어야 된다.
				if (start == end) {
					continue;
				}
				if (dist[start][end] == INF && dist[end][start] == INF) {
					flag = false;
					break;
				}
			}
			if (flag) {
				result++;
			}
		}

		System.out.println(result);
	}
}
