package bj2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[][] dp = new long[N][2];

		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		dp[0][1] = input[0];
		dp[1][0] = input[1];
		dp[1][1] = input[1] + dp[0][1];
		
		for(int i=2; i<N; i++) {
			dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1])+input[i];
			dp[i][1] = dp[i-1][0]+input[i];
		}
		for(int i=0; i<N; i++) {
			System.out.print(dp[i][0]+" ");
		}
		System.out.println();
		for(int i=0; i<N; i++) {
			System.out.print(dp[i][1]+" ");
		}
		
		long ans = Math.max(Math.max(dp[N-1][0], dp[N-1][1]),Math.max(dp[N-2][0], dp[N-2][1]));
		System.out.println(ans);

	}

}
