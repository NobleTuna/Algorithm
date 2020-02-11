package bj2517_runner; // 머지소트로 못품, 세그먼트 트리 문제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main {

	static int N;
	static int runner[] = new int[500001];
	static int position[] = new int[500001]; // 선수의 인덱스
	static int tmpPosition[] = new int[500001]; // 머지중 임시저장할 선수의 인덱스
	static int answer[] = new int[500001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(TC1));
		N = Integer.parseInt(br.readLine());
		position = new int[N];
		tmpPosition = new int[N];
		answer = new int[N];

		for (int n = 0; n < N; n++) {
			answer[n] = n + 1;
			position[n] = n;
			runner[n] = Integer.parseInt(br.readLine());
		}
		mergeSort(runner, 0, N - 1);

		for (int i = 0; i < N; i++)
			System.out.println(answer[i]);
	}

	static void mergeSort(int arr[], int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, r);
			merge(arr, l, mid, r);
		}
	}

	static void merge(int[] arr, int l, int mid, int r) {
		int i = l;
		int j = mid + 1;
		int k = l;
		int temp[] = new int[arr.length];

		while (i <= mid && j <= r) {
			if (arr[i] > arr[j]) {
				tmpPosition[k] = position[i];
				temp[k++] = arr[i++];
			} else {
				tmpPosition[k] = position[j];
				answer[position[j]] -= (mid + 1 - i);
				temp[k++] = arr[j++];
			}
		}

		while (i <= mid) {
			tmpPosition[k] = position[i];
			temp[k++] = arr[i++];
		}

		while (j <= r) {
			tmpPosition[k] = position[j];
			temp[k++] = arr[j++];
		}

		for (int idx = l; idx < k; idx++) {
			arr[idx] = temp[idx];
			position[idx] = tmpPosition[idx];
		}
	}

	static String TC1 = "8\r\n" + "2\r\n" + "8\r\n" + "10\r\n" + "7\r\n" + "1\r\n" + "9\r\n" + "4\r\n" + "15";

}
