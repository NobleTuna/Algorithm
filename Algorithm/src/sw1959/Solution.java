package sw1959;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N1 = sc.nextInt();
			int N2 = sc.nextInt();

			int[] arr1 = new int[N1];
			int[] arr2 = new int[N2];
			for (int i = 0; i < N1; i++) {
				arr1[i] = sc.nextInt();
			}
			for (int i = 0; i < N2; i++) {
				arr2[i] = sc.nextInt();
			}
			if(N1>N2) {
				int tmp = N1;
				N1 = N2;
				N2 = tmp;
				int []t = arr1;
				arr1 = arr2;
				arr2 = t;
			}

			int max = 0;
			for (int i = 0; i < N2 - N1 + 1; i++) {
				int sum = 0;
				for (int j = 0; j < N1; j++) {

					sum += arr1[j] * arr2[i + j];
				}
				if (max < sum)
					max = sum;
			}
			System.out.println("#"+tc+" "+max);
		}
	}

}
