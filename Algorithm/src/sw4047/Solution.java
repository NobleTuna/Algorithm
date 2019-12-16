package sw4047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			char msg[] = input.toCharArray();

			boolean[] S = new boolean[14];
			boolean[] D = new boolean[14];
			boolean[] H = new boolean[14];
			boolean[] C = new boolean[14];
			boolean isError = false;

			for (int i = 0; i < msg.length; i = i + 3) {
				char key = msg[i];

				StringBuilder sb = new StringBuilder();
				sb.append(msg[i + 1]).append(msg[i + 2]);

				int num = Integer.parseInt(sb.toString());

				if (key == 'S') {
					if (S[num]) {
						System.out.println("#" + tc + " " + "ERROR");
						isError = true;
						break;
					}
					S[num] = true;
				} else if (key == 'D') {
					if (D[num]) {
						System.out.println("#" + tc + " " + "ERROR");
						isError = true;
						break;
					}
					D[num] = true;
				} else if (key == 'H') {
					if (H[num]) {
						System.out.println("#" + tc + " " + "ERROR");
						isError = true;
						break;
					}
					H[num] = true;
				} else if (key == 'C') {
					if (C[num]) {
						System.out.println("#" + tc + " " + "ERROR");
						isError = true;
						break;
					}
					C[num] = true;
				}
			}
			if (isError)
				continue;

			int Scnt = 0;
			int Dcnt = 0;
			int Hcnt = 0;
			int Ccnt = 0;
			for (int i = 1; i < 14; i++) {
				if (!S[i])
					Scnt++;
				if (!D[i])
					Dcnt++;
				if (!H[i])
					Hcnt++;
				if (!C[i])
					Ccnt++;
			}
			System.out.println("#" + tc + " "+Scnt+" "+Dcnt+" "+Hcnt+" "+Ccnt);

		}
	}
}
