package dfs;

import java.util.Arrays;

public class Ez_perm {

	static int N;
	static int R;
	static int cnt;

	public static void main(String[] args) {
		cnt = 0;
		int[] arr = { 1, 2, 3, 4, 5 };
		N = arr.length;
		R = 5;
		Permu(arr, new int[N], 0, new boolean[N]);

		System.out.println(cnt);
	}

	static void Permu(int[] arr, int[] result, int idx, boolean[] visited) {
		if (idx == R) {
			System.out.println(Arrays.toString(result));
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {

			if (!visited[i]) {
				result[idx] = arr[i];
				visited[idx] = true;
				Permu(arr, result, idx + 1, visited);
				visited[idx] = false;
			}
		}
	}
}
