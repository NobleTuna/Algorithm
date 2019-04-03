package sw4796;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

//			System.out.println(Arrays.toString(arr));
			int cnt = 0;
			for (int i = 1; i < N - 1; i++) {
				if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
//					System.out.println("센터 : " + arr[i]);
					int a = 0;
					int b = 0;
					for (int j = i; j > 0; j--) {
						if (arr[j - 1] < arr[j]) {
//							System.out.println(arr[j - 1] + " " + arr[j]);
							a++;
						} else
							break;
					}

					for (int j = i; j < N - 1; j++) {
						if (arr[j] > arr[j + 1]) {
//							System.out.println(arr[j] + " " + arr[j + 1]);
							b++;
						} else
							break;
					}
					cnt += (a * b);
//					System.out.println("cnt : " + cnt);
				}
			}
			System.out.println("#" + tc + " " + cnt);

		}
	}

	static String TC = "3\r\n" + "3\r\n" + "1 3 2\r\n" + "3\r\n" + "3 2 1\r\n" + "9\r\n" + "1 4 6 5 3 7 9 2 8";

}
