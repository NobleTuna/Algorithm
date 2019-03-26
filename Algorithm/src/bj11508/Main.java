package bj11508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer arr[] = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr,Collections.reverseOrder());
//		System.out.println(Arrays.toString(arr));
		int k = N % 3;

		int ans = 0;
		for (int i = 0; i < arr.length - k; i += 3) {
			ans += arr[i];
			ans += arr[i + 1];
		}
		for (int i = arr.length - k; i < arr.length; i++) {
			ans += arr[i];
		}
		System.out.println(ans);
	}
}
