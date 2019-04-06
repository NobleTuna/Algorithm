package sw1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int ans = 0;
			for (int i = 2; i < N - 2; i++) {
				int left = Math.max(arr[i - 1], arr[i - 2]);
				int right = Math.max(arr[i + 1], arr[i + 2]);

				int max = Math.max(left, right);

				ans += (max < arr[i]) ? arr[i] - max : 0;

			}
			
			System.out.println("#"+tc+" "+ans);

		}
	}

}
