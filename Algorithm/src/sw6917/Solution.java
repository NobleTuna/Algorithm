package sw6917;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int arr[] = new int[N];
			double max = 0; // 공부한값
			double result = 0; // 최대값
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < (1 << N); i++) {
				int cnt = 0;
				max = 0;
				for (int j = 0; j < N; j++) {
					if (((1 << j) & i) != 0) {
						System.out.print(arr[j] + " ");
						max = (max + arr[j]) / 2;
						cnt++;
					}
				}System.out.println();
				System.out.println("cnt : "+ cnt);
				
				if (cnt == K)
					if (cnt == K && result < max) {
						result = max;
					}
			}
			System.out.println("#" + t + " " + result);

		}
	}

}
