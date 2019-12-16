package sw1288;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());

			boolean[] chk = new boolean[10];
			int result = 0;
			int N = 1;
			while (true) {
				int current = N * K;
				result = current;

				String sCurrent = Integer.toString(current);
				char[] msg = sCurrent.toCharArray();
				for (int i = 0; i < msg.length; i++) {
					chk[msg[i] - '0'] = true;
				}
				boolean flag = true;
				for (int i = 0; i < chk.length; i++) {
					if (!chk[i]) {
						flag = false;
						break;
					}
				}
				if (flag)
					break;

				N++;
			}
			System.out.println("#" + tc + " " + result);
		}
	}

}
