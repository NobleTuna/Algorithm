package sw3308;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_T {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			int[] c = new int[N];

			int len = 1;
			c[0] = arr[0];
			for (int i = 0; i < N; i++) {
				int idx = Arrays.binarySearch(c, 0, len, arr[i]);

				idx = idx < 0 ? -idx - 1 : idx;
				c[idx] = arr[i];
				if (len <= idx)
					len++;
			}
			System.out.println("#" + tc + " " + len);

		}
	}

}
