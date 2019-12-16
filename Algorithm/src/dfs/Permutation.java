package dfs;

import java.util.Arrays;

public class Permutation {
	public static int N;
	public static int R;
	public static int cnt;

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		N = arr.length;
		R = 5;
		Permu(arr, 0);
		
		System.out.println(cnt);

	}

	public static void Permu(int[] arr, int idx) {
		if (idx == R) {
			System.out.println(Arrays.toString(arr));
			cnt++;
			return;
		}

		for (int i = idx; i < N; i++) {
			swap(arr, idx, i);
			Permu(arr, idx + 1);
			swap(arr, idx, i);
		}
	}

	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

}
