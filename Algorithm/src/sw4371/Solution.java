package sw4371;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int arr[] = new int[N];

			br.readLine(); // 0 버림

			for (int i = 1; i < N; i++) {
				arr[i] = Integer.parseInt(br.readLine()) - 1;
			}

			for (int i = 1; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (arr[i] != 0 && arr[j] != 0 && arr[j] % arr[i] == 0) {
						arr[j] = 0;
					}
				}
			}
			int result = 0;
			for (int i = 1; i < N; i++) {
				if (arr[i] != 0)
					result++;
			}

			System.out.println("#" + tc + " " + result);

		}
	}

}
