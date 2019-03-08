package ssafy_03_08_algoTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test3 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int W = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());

			int number[] = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}

			int[] dp = new int[W + 1];

			Arrays.fill(dp, -1);

			for (int i = 0; i < N; i++) {
				dp[number[i]] = 1;
			}

			for (int i = 0; i < N; i++) { // number

				int curN = number[i];

				int[] beforeDp = dp.clone();

				for (int j = curN + 1; j <= W; j++) {
					if (dp[j - curN] == -1) {
						continue; // 그대로 내려옴
					} else {
						if (beforeDp[j] == -1)
							dp[j] = dp[j - curN] + 1;
						else
							Math.min(beforeDp[j], dp[j - curN] + 1);
					}
				}
			}

			System.out.println("#" + tc + " " + dp[W]);

		}
	}

}
