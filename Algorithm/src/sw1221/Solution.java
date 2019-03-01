package sw1221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static String[] num = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());

			input = br.readLine();
			int arr[] = new int[N];
			st = new StringTokenizer(input);
			for (int i = 0; i < N; i++) {
				String C = st.nextToken();
				for (int j = 0; j < num.length; j++) {
					if (C.equals(num[j])) {
						arr[i] = j;
						break;
					}
				}
			}

			Arrays.sort(arr);
			System.out.println("#" + tc);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(num[arr[i]] + " ");
			}
			System.out.println();
		}
	}

}
