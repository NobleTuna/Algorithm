package bj11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			for (int j = 1; j <= M; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		for(int i=0; i<N+1; i++) {
//			for(int j=0; j<M+1; j++) {
//				System.out.print(dp[i][j]+" ");
//			}System.out.println();
//		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				dp[i][j] += Math.max(Math.max(dp[i][j - 1], dp[i - 1][j]),dp[i-1][j-1]);
			}
		}
		
		System.out.println(dp[N][M]);

	}

}
