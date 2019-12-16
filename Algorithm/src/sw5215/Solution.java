package sw5215; // 햄버거 다이어트

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static class Mat {
		int score;
		int cal;

		public Mat(int score, int cal) {
			this.score = score;
			this.cal = cal;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			N = Integer.parseInt(st.nextToken());
			maxCal = Integer.parseInt(st.nextToken());

			Mat[] arr = new Mat[N];

			for (int i = 0; i < N; i++) {
				input = br.readLine();
				st = new StringTokenizer(input);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[i] = new Mat(a, b);
			}
			result = 0;
			go(arr, 0, 0, 0);

			System.out.println("#" + tc + " " + result);

		}
	}

	static int result;
	static int maxCal;
	static int N;

	static void go(Mat[] arr, int idx, int calSum, int scoreSum) {
		if (idx == N) {
			if (result < scoreSum)
				result = scoreSum;

			return;
		}

		if (calSum + arr[idx].cal <= maxCal)
			go(arr, idx + 1, calSum + arr[idx].cal, scoreSum + arr[idx].score);

		go(arr, idx + 1, calSum, scoreSum);

	}

}
