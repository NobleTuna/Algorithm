package sw1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int arr[];
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[100];

			StringTokenizer st = new StringTokenizer(br.readLine());

			int maxIdx = 0;
			int minIdx = 0;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[99]--;
			}
			Arrays.sort(arr);
			System.out.println("#" + tc + " " + (arr[99] - arr[0]));

		}
	}

}
