package sw3304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			String a = st.nextToken();
			String b = st.nextToken();

			// 문자열이 없을때 ~한글자만 두글자까지 세글자까지.. n글자까지..
			// 를 a에 대해서 행으로, b에 대해서 열로 모든 경우를 매칭
			int[][] dp = new int[a.length() + 1][b.length() + 1];
			for (int i = 1; i <= a.length(); i++) {
				for (int j = 1; j <= b.length(); j++) {
					// 현재 서로 문자가 같다면, 해당 문자들을 양쪽 다 뻇을때의 LSC+1;
					if (a.charAt(i - 1) == b.charAt(j - 1))
						dp[i][j] = dp[i - 1][j - 1] + 1;
					// 다를 때는 a쪽 현재 글자를 뻇을때와 b쪽 현재 글자를 뻇을 때 중 LCS의 최대값
					else
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
			System.out.println("#"+tc+" "+dp[a.length()][b.length()]);
		}
	}
}
