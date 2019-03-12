package sw4008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2 {
	static int N;
	static int numArr[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			numArr = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());

			int calc[] = new int[4];
			for (int i = 0; i < 4; i++) {
				calc[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				numArr[i] = Integer.parseInt(st.nextToken());
			}

			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			go(calc[0], calc[1], calc[2], calc[3], 1, numArr[0]);
			int ans = max - min;
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(ans);
			System.out.println(sb);
		}

	}

//	static int calc(char n, int a, int b) {
//
//		if (n == '+')
//			return a + b;
//		else if (n == '-')
//			return a - b;
//		else if (n == '*')
//			return a * b;
//		else
//			return a / b;
//	}

	static int max;
	static int min;

	static void go(int plus, int minus, int multiple, int division, int idx, int sum) {
		if (plus == 0 && minus == 0 && multiple == 0 && division == 0) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		if (plus > 0) {
			go(plus - 1, minus, multiple, division, idx + 1, sum + numArr[idx]);
		}
		if (minus > 0) {
			go(plus, minus - 1, multiple, division, idx + 1, sum - numArr[idx]);
		}
		if (multiple > 0) {
			go(plus, minus, multiple - 1, division, idx + 1, sum * numArr[idx]);
		}
		if (division > 0) {
			go(plus, minus, multiple, division - 1, idx + 1, sum / numArr[idx]);
		}

	}

//	static void swap(int a, int b, char[] arr) {
//		char tmp = arr[a];
//		arr[a] = arr[b];
//		arr[b] = tmp;
//	}
}
