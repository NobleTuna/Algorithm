package bj2458;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 키순서_박성하 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		boolean[][] flags = new boolean[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {
			boolean flag = false;
			for (int j = 1; j < N + 1; j++) {
				if(i==j)
					continue;
				if (arr[i][j] == 1) {
					for (int l = 1; l <= N; l++) {
						if(j==l)
							continue;
						if (arr[j][l] == 1 && !flags[i][l]) {
							flag = true;
							flags[i][l] = true;
							arr[i][l] = 1;
						}
					}
				}
			}
			if (flag)
				i--;
		}

		int total = 0;
		for (int i = 1; i <= N; i++) {
			total += i;
		}

		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			int sum = i;

			for (int j = 1; j <= N; j++) {
				if (arr[i][j] == 1) {
					sum += j;
				}

				if (arr[j][i] == 1) {
					sum += j;
				}
			}

			if (sum == total) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
