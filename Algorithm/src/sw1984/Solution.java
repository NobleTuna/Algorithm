package sw1984;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int arr[] = new int[10];
			for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
			}
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < 10; i++) {
				if (arr[i] < min)
					min = arr[i];
				if (arr[i] > max)
					max = arr[i];
			}
			double sum = 0;
			for (int i = 0; i < 10; i++) {
				if (arr[i] == min || arr[i] == max) {
					continue;
				}
				sum += arr[i];
			}
			double result = sum/8;
			
			System.out.println("#"+tc+" "+Math.round(result));

		}

	}

}