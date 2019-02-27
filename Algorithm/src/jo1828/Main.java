package jo1828;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		boolean[] check = new boolean[N];
		int minRange;
		int idx;
		int result = 0;
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		while (true) {
			minRange = Integer.MAX_VALUE;
			idx = 0;
			for (int i = 0; i < N; i++) {
				if (!check[i] && minRange > (arr[i][1] - arr[i][0])) {
					minRange = (arr[i][1] - arr[i][0]);
					idx = i;
				}
			}

			boolean flag = false;
			for (int i = 0; i < N; i++) {
				if (!check[i]) {
					if (arr[i][0] <= arr[idx][0] & arr[i][1] >= arr[idx][0]
							|| arr[i][0] <= arr[idx][1] & arr[i][1] >= arr[idx][1]) {
						arr[idx][1] = Math.min(arr[idx][1], arr[i][1]);
						check[i] = true;
						flag = true;
					}
				}
			}
			if (flag) {
				result++;
			} else {
				break;
			}
		}
		System.out.println(result);

		sc.close();
	}
}