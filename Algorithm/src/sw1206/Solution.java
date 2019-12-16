package sw1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int result = 0;

			for (int i = 2; i < N - 2; i++) {
				int l1 = arr[i - 1];
				int l2 = arr[i - 2];
				int r1 = arr[i + 1];
				int r2 = arr[i + 2];

				int l = Math.max(l1, l2);
				int r = Math.max(r1, r2);

				int value = Math.min(arr[i] - l, arr[i] - r);
				if (value > 0)
					result += value;
			}
			System.out.println("#"+tc+" "+result);

		}
	}

}
