package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo2_광주_2_위영웅 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		memo = new int[10001];

		for (int tc = 1; tc <= T; tc++) {
			W = Integer.parseInt(br.readLine());
			N = Integer.parseInt(br.readLine());

			int tmp[] = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				tmp[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(tmp);
			arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = tmp[N - i - 1];
			}
			ans = Integer.MAX_VALUE;
			go(0, 0);

			if (ans == Integer.MAX_VALUE)
				ans = -1;

			System.out.println("#" + tc + " " + ans);

		}
	}

	static int[] memo;
	static int arr[];
	static int N;
	static int W;
	static int ans;

	static void go(int cnt, int sum) {
		if (cnt >= ans || sum > W) {
			return;
		}

		if (sum == W) {
			ans = Math.min(cnt, ans);
			return;
		}

		for (int i = 0; i < N; i++) {

			if (memo[sum] == 0)
				memo[sum] = cnt;
			else if (memo[sum] < cnt) {
				continue;
			} else
				memo[sum] = cnt;

			go(cnt + 1, sum + arr[i]);

		}
	}

}
