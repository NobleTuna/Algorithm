package sw4466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			input = br.readLine();
			st = new StringTokenizer(input);
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int[] arrR = new int[N];
			for (int i = 0; i < N; i++) {
				arrR[N - 1 - i] = arr[i];
			}
			int result = 0;
			for (int i = 0; i < K; i++) {
				result += arrR[i];
			}
			System.out.println("#"+tc+" "+result);

		}
	}
}
