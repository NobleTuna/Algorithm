package sw1945;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			int a = calc(N, 2, 0);
			int b = calc(N, 3, 0);
			int c = calc(N, 5, 0);
			int d = calc(N, 7, 0);
			int e = calc(N, 11, 0);
			System.out.println("#" + tc + " " + a + " " + b + " " + c + " " + d + " " + e);

		}
	}

	public static int calc(int a, int b, int cnt) {
		if (a % b != 0) {
			return cnt;
		} else {
			N = a / b;
			return calc(a / b, b, cnt + 1);
		}
	}

}
