package sw7102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int cnt[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			cnt = new int[N + M + 2];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					cnt[i + j]++;
				}
			}
			
			int max = 0;
			for (int i = 0; i < cnt.length; i++) {
				max = Math.max(max, cnt[i]);
			}
			int cc = 0;
			for (int i = 0; i < cnt.length; i++) {
				if (max == cnt[i])
					cc++;
			}

			int[] ans = new int[cc];
			int idx = 0;
			for (int i = 0; i < cnt.length; i++) {
				if (max == cnt[i])
					ans[idx++] = i;
			}
			Arrays.sort(ans);
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<ans.length; i++) {
				sb.append(ans[i]+" ");
			}

			System.out.println("#" + tc + " " + sb.toString());

		}
	}

}
