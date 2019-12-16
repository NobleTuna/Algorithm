package sw4008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int numArr[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			numArr = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());

			char arr[] = new char[N - 1];
			int idx = 0;
			int k = Integer.parseInt(st.nextToken());
			for (int i = 0; i < k; i++) {
				arr[idx++] = '+';
			}
			k = Integer.parseInt(st.nextToken());
			for (int i = 0; i < k; i++) {
				arr[idx++] = '-';
			}
			k = Integer.parseInt(st.nextToken());
			for (int i = 0; i < k; i++) {
				arr[idx++] = '*';
			}
			k = Integer.parseInt(st.nextToken());
			for (int i = 0; i < k; i++) {
				arr[idx++] = '/';
			}

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				numArr[i] = Integer.parseInt(st.nextToken());
			}

			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			go(arr, 0);
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

	static void go(char[] arr, int idx) {
		if (idx == arr.length) {

			int a = numArr[0];
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '+')
					a = a + numArr[i + 1];
				else if (arr[i] == '-')
					a = a - numArr[i + 1];
				else if (arr[i] == '*')
					a = a * numArr[i + 1];
				else if (arr[i] == '/')
					a = a / numArr[i + 1];
			}

			max = Math.max(max, a);
			min = Math.min(min, a);
			return;
		}

		for (int i = idx; i < arr.length; i++) {

			char tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
			go(arr, idx + 1);
			tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
	}

//	static void swap(int a, int b, char[] arr) {
//		char tmp = arr[a];
//		arr[a] = arr[b];
//		arr[b] = tmp;
//	}
}
