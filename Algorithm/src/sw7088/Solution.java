package sw7088;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int N = Integer.parseInt(st.nextToken()); // 송아지수
			int Q = Integer.parseInt(st.nextToken()); // 질문수

			int arr[][] = new int[N + 1][3]; // 1,2,3

			for (int i = 1; i <= N; i++) {
				int a = Integer.parseInt(br.readLine());
				arr[i] = arr[i - 1].clone();
				arr[i][a - 1]++;
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append("\n");
			for (int i = 0; i < Q; i++) {
				input = br.readLine();
				st = new StringTokenizer(input);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int ans1 = arr[b][0] - arr[a - 1][0];
				int ans2 = arr[b][1] - arr[a - 1][1];
				int ans3 = arr[b][2] - arr[a - 1][2];
				sb.append(ans1).append(" ").append(ans2).append(" ").append(ans3).append("\n");
			}
			System.out.print(sb);
		}
	}

}
