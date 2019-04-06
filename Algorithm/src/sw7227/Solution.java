package sw7227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static long result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int arr[][] = new int[N][2];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				StringTokenizer st = new StringTokenizer(input);
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			result = Long.MAX_VALUE;

			go(new boolean[N], arr, 0, 0);
			System.out.println("#" + tc + " " + result);
		}
	}

	static void go(boolean[] selected, int[][] arr, int idx, int Cnt) { // true = 움직임 / false = 안움직임
		if (idx == N) {
			if (Cnt == N / 2) {
				int sumX = 0;
				int sumY = 0;
				for (int i = 0; i < N; i++) {
					if (selected[i]) {
						sumX += arr[i][0];
						sumY += arr[i][1];
					} else {
						sumX -= arr[i][0];
						sumY -= arr[i][1];
					}
				}
				if (result > Math.pow(sumX, 2) + Math.pow(sumY, 2)) {
					result = (long) (Math.pow(sumX, 2) + Math.pow(sumY, 2));
				}

			}
			return;
		}
		selected[idx] = true;
		go(selected, arr, idx + 1, Cnt + 1);
		selected[idx] = false;
		go(selected, arr, idx + 1, Cnt);

	}
}
