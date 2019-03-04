package sw3282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static class M {
		int v;
		int c;

		public M(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

	static int N;
	static int V;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			N = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());

			int arr[] = new int[V + 1];

			for (int i = 0; i < N; i++) {
				input = br.readLine();
				st = new StringTokenizer(input);

				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				int[] original = arr.clone();
				go(arr, v, v, c, original);
			}

			System.out.println("#" + tc + " " + arr[V]);

		}
	}

	// v = 무게, c= 가치
	public static void go(int[] arr, int idx ,int v, int c, int[] original) {
		if (idx == V + 1)
			return;

		arr[idx] = Math.max(original[idx -v ] + c, original[idx]);

		go(arr, idx+1, v, c, original);
	}
}
