package bj2458;

import java.util.Arrays;
import java.util.Scanner;

public class 키순서_문은진 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 학생 수
		int m = sc.nextInt(); // 비교횟수
		int up[] = new int[501];
		int down[] = new int[501];
		int[][] arr = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				arr[i][j] =9999;
			}
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
		}
//		for(int a[] : arr) {
//			System.out.println(Arrays.toString(a));
//		}
//		System.out.println("**********************************");
		int cnt[] = new int[501];
		for (int k = 1; k < n + 1; k++) {
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					if (i == j || i == k || j == k)
						continue;
					if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
		for(int a[] : arr) {
			System.out.println(Arrays.toString(a));
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (i == j)
					continue;
				if (arr[i][j] != 9999 ) {
					up[i]++;
					down[j]++;
				}
			}
		}
		int result = 0;
		for (int i = 1; i < n+1; i++) {
			if (up[i]+down[i] == n-1) {
				result++;
			}
		}
		System.out.println(result);

	}

}
