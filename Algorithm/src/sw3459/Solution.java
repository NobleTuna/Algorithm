package sw3459;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		long[] stor = new long[60];
		stor[0] = 1;
		stor[1] = 1;
		long k = 1;
		for (int i = 2; i < stor.length; i++) {
			if (i % 2 == 0) {
				k = k * 4;
				stor[i] = stor[i - 1] + k;
			} else
				stor[i] = stor[i - 1] + k;

//			if (stor[i] > Math.pow(10, 18))
//				System.out.println(i);

		}
//		System.out.println(Arrays.toString(stor));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			Long N = Long.parseLong(br.readLine());
			if (N == 1) {
				System.out.println("#" + tc + " " + "Bob");
				continue;
			}

			int idx = 0;
			for (int i = 0; i < stor.length; i++) {
				if (stor[i] >= N) {
					idx = i;
					break;
				}
			}
//			System.out.println(idx);

			if (idx % 2 == 1) {
				System.out.println("#" + tc + " " + "Bob");
			} else
				System.out.println("#" + tc + " " + "Alice");
		}

	}
}
