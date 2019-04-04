package sw3234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[] arr;
	static int allSum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(TC));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			ans = 0;

			go(0, 0, new boolean[N], arr, 0);

			System.out.println("#" + tc + " " + ans);

		}
	}

	static int ans;

	static void go(int right, int left, boolean[] chk, int[] arr, int idx) {
		if (idx == arr.length) {
			ans++;
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!chk[i]) {

				if (left + arr[i] >= right) {
					chk[i] = true;
					go(right, left + arr[i], chk, arr, idx + 1);
					chk[i] = false;
				}

				if (left >= right + arr[i]) {
					chk[i] = true;
					go(right + arr[i], left, chk, arr, idx + 1);
					chk[i] = false;
				}

			}

		}

	}

	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	static String TC1 = "1\r\n" + "3\r\n" + "1 2 4";
	static String TC = "3\r\n" + "3\r\n" + "1 2 4\r\n" + "3\r\n" + "1 2 3\r\n" + "9\r\n" + "1 2 3 5 6 4 7 8 9";

}
