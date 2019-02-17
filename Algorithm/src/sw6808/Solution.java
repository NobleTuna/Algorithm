package sw6808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int xWin;
	static int fact[] = { 1, 2, 6, 24, 120 ,720, 5040};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int x[] = new int[9];
			for (int i = 0; i < 9; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			int[] y = new int[9];
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				boolean token = true;
				for (int j = 0; j < 9; j++) {
					if (i == x[j]) {
						token = false;
						break;
					}
				}
				if (token) {
					y[idx] = i;
					idx++;
				}
			}
			xWin = 0;
			boolean[] visited = new boolean[9];

			go(x, y, visited, 0, 0, 0, 0);
			System.out.println("#" + tc + " " + xWin + " " + (362880 - xWin));

		}
	}

	public static void go(int[] x, int[] y, boolean[] visited, int idx, int cnt, int xSum, int ySum) {
		if (cnt == 9) {
			if (xSum > ySum) {
				xWin++;
			}
			return;
		}
		if (xSum >= 86) {
			xWin += fact[8-cnt];
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int goXSum = xSum;
				int goYSum = ySum;

				if (x[cnt] > y[i]) {
					goXSum += y[i] + x[cnt];
				} else {
					goYSum += x[cnt] + y[i];
				}

				go(x, y, visited, i, cnt + 1, goXSum, goYSum);

				visited[i] = false;
			}
		}
	}

}
