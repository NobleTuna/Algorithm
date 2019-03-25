package bj2839;

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

		for (int i = 5; i < arr.length; i++) {
			arr[i] = Math.min(arr[i], arr[i - 5] + 1);
		}
	}

}
