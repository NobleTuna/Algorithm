package bj2839; //설탕 // 계단오르기 // 포도주시식

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int arr[] = new int[N + 1];
		int result[] = new int[N + 1];

		for (int i = 3; i < arr.length; i++) {
			arr[i] = i / 3;
			result[i] = 3 * arr[i];
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(result));

		for (int i = 5; i < arr.length; i++) {
			if ((result[i - 5] + 5) % i == 0) {
				arr[i] = Math.min(arr[i], arr[i - 5] + 1);
				result[i] = result[i - 5] + 5;
			}
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(result));

		if (result[N] == N)
			System.out.println(arr[N]);
		else
			System.out.println(-1);
	}

}
