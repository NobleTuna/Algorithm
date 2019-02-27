package sw5986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	static int arr[];
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 소수를 구하자.
		List<Integer> list = new ArrayList<>();
		arr = new int[169];
		list.add(2);
		for (int i = 3; i <= 999; i++) {
			boolean token = false;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					token = true;
					break;
				}
			}
			if (!token) {
				list.add(i);
			}
		}
		int idx = 0;
		for (int k : list) {
			arr[idx++] = k;
		}
		arr[168] = 1001;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			result = 0;
			go(new int[3], 0, 0, 0, N);
			System.out.println("#" + tc + " " + result);

		}
	}

	public static void go(int[] value, int v, int idx, int cnt, int N) {
		if (value[0] + value[1] + value[2] > N)
			return;

		if (arr[idx] >= N)
			return;

		if (cnt == 3) {
			if (value[0] + value[1] + value[2] == N)
				result++;
			return;
		}

		value[v] = arr[idx];
		go(value, v + 1, idx, cnt + 1, N);

		value[v] = 0;
		go(value, v, idx + 1, cnt, N);
	}

}
