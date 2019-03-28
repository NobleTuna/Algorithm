package bj2698;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(inputString));
		int[][][] dp = new int[101][101][2];

		dp[1][0][0] = 1;
		dp[1][0][1] = 1;

		for (int i = 2; i < 101; i++) {
			for (int j = 0; j < i; j++) {
				dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
				dp[i][j][1] = dp[i - 1][j][0] + ((j > 0) ? dp[i - 1][j - 1][1] : 0);
			}
		}

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			System.out.println(dp[n][r][0] + dp[n][r][1]);

		}
	}

	static String inputString = "10\r\n" + "5 2\r\n" + "20 8\r\n" + "30 17\r\n" + "40 24\r\n" + "50 37\r\n"
			+ "60 52\r\n" + "70 59\r\n" + "80 73\r\n" + "90 84\r\n" + "100 90";

}
