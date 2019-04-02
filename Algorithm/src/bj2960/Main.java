package bj2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		boolean[] arr = new boolean[N + 1];
		int cnt = 0;
		for (int i = 2; i < N + 1; i++) {
			if (!arr[i]) {
				for (int j = 1; j * i < arr.length; j++) {
					if (!arr[j * i]) {
						arr[j * i] = true;
						cnt++;
						if (cnt == K) {
							System.out.println(j * i);
							return;
						}
					}
				}

			}
		}
	}

}
