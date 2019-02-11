package se1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			result = 0;
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			String cards = st.nextToken();
			char arc[] = cards.toCharArray(); // 카드 배열
			int arr[] = new int[arc.length];
			int len = arr.length; // 길이

			for (int i = 0; i < len; i++) { // int형 arr 배열
				arr[i] = arc[i] - '0';
			}

			N = Integer.parseInt(st.nextToken()); // 회전수
			go(arr, 0, 1, 0);
			System.out.println("#"+TC+" "+result);

		}
	}

	public static void go(int[] arr, int cnt, int current, int idx) {

		if (cnt == N) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]);
			}
			System.out.println(sb.toString());
			int sum = Integer.parseInt(sb.toString());
			if (sum > result) {
				result = sum;
			}
			return;
		}
		if (idx >= arr.length - 1) {
			return;
		}
		if (current >= arr.length - 1) {
			go(arr, 0, idx+1, idx+1);
			return;
		}

		int tmp = arr[current];
		arr[current] = arr[idx];
		arr[idx] = tmp;
		
		go(arr, cnt + 1, current, idx);
		
		tmp = arr[current];
		arr[current] = arr[idx];
		arr[idx] = tmp;
		
		go(arr, cnt, current + 1, idx);

	}
}
