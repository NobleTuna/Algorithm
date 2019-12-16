package dfs;

import java.util.Arrays;

public class Pratice_perm {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		cnt = 0;
		perm(arr, 0);
		System.out.println(cnt);
	}
static int cnt;
	static void perm(int[] arr, int idx) {

		if (idx == arr.length) {
			System.out.println(Arrays.toString(arr));
			cnt++;
			return;
		}

		for (int i = idx; i < arr.length; i++) {

			swap(arr, i, idx);
			perm(arr, idx + 1);
			swap(arr, i, idx);

		}

	}

	static void swap(int[] arr, int a, int b) {

		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;

	}

}
