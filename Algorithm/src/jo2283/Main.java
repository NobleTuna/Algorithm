package jo2283; //RGB

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());

		}
		int[] dp = new int[3];
		int[] nextDp = new int[3];

		dp[0] = arr[0][0];
		dp[1] = arr[0][1];
		dp[2] = arr[0][2];

		for (int i = 1; i < N; i++) {
			nextDp[0] = arr[i][0] + Math.min(dp[1], dp[2]);
			nextDp[1] = arr[i][1] + Math.min(dp[0], dp[2]);
			nextDp[2] = arr[i][2] + Math.min(dp[0], dp[1]);
			dp = nextDp.clone();
		}
		
		int ans = Math.min(nextDp[2], Math.min(nextDp[0], nextDp[1]));
		
		System.out.println(ans);

	}

}
