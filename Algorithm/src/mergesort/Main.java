package mergesort;

import java.io.IOException;
import java.util.Arrays;

public class Main {
	static int N;
	static int arr[] = { -10, 4, 5, 20, -7, -94, 24, 99, 10, 3, 48, 1, -48, 34, 777, -194, 0, 17, 2, 100 };
	static int sorted[];

	public static void main(String[] args) throws IOException {
		N = 20;
		sorted = new int[N];
		mergeSort(arr, 0, N - 1);
		System.out.println(Arrays.toString(arr));
	}

	static void mergeSort(int[] arr, int left, int right) {

		int mid = (left + right) / 2;
		if (left < right) {
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	static void merge(int[] arr, int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int k = left;

		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				sorted[k] = arr[i];
				i++;
			} else {
				sorted[k] = arr[j];
				j++;
			}
			k++;
		}
		if (i > mid) {
			while (j <= right) {
				sorted[k] = arr[j];
				j++;
				k++;
			}
		} else if (j > right) {
			while (i <= mid) {
				sorted[k] = arr[i];
				i++;
				k++;
			}
		}
		for (int t = left; t <= right; t++)
			arr[t] = sorted[t];
	}

}
