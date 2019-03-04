package sw2817;

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
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			input = br.readLine();
			st = new StringTokenizer(input);

			int arr[] = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			result = 0;
			go(arr, 0, 0);
			System.out.println("#"+tc+" "+result);

		}
	}

	static int result;
	static int N;
	static int K;

	static void go(int[] arr, int idx, int sum) {
		if (sum == K) {
			result++;
			return;
		}
		if (idx == N) {
			return;
		}
		
		go(arr, idx+1, sum+arr[idx]);
		go(arr, idx+1, sum);
		
	}

}
