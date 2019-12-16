package sw3421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int result;
	static List<Integer>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			N = Integer.parseInt(st.nextToken());

			int M = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = i;
			}

			boolean[] chk = new boolean[N];

			list = new List[N];
			for (int i = 0; i < N; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				input = br.readLine();
				st = new StringTokenizer(input);
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				list[a].add(b);
			}
			result = 0;
			go(arr, chk, 0);
			System.out.println("#" + tc + " " + result);
		}
	}

	public static void go(int[] arr, boolean[] chk, int idx) {
		if (idx == N) {
			for (int i = 0; i < chk.length; i++) {
				if (chk[i]) {
					for (int k : list[i]) {
						if (chk[k]) {
							return;
						}
					}
				}
			}
			result++;
			return;
		}
		chk[idx] = true;

		go(arr, chk, idx + 1);
		chk[idx] = false;
		go(arr, chk, idx + 1);

	}

}
