package sw5603;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int arr[] = new int[N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				int tmp = sc.nextInt();
				arr[i] = tmp;
				sum += tmp;
			}

			int av = sum / N;
			int result = 0;
			for (int i = 0; i < N; i++) {
				result += Math.abs(av - arr[i]);
			}
			System.out.println("#"+tc+" "+result/2);

		}

	}

}
