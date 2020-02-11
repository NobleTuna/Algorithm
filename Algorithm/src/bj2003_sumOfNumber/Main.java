package bj2003_sumOfNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(TC2));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		long sum = arr[0];
		long count = 0;

		while (true) {

//			System.out.println("start : " + start + " end : " + end);
			if (end == N)
				break;

			if (sum == M) {
				count++;
				end++;
				if (end != N)
					sum += arr[end];
				continue;
			}

			if (start == end || sum < M) {
				end++;
				if (end != N)
					sum += arr[end];
				continue;
			}

			if (sum > M) {
				sum -= arr[start];
				start++;
			}
		}
		System.out.println(count);

	}

	static String TC1 = "4 2\r\n" + "1 1 1 1";
	
	static String TC2 = "10 5\r\n" + 
			"1 2 3 4 2 5 3 1 1 2";

}
