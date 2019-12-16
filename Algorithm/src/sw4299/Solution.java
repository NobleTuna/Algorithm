package sw4299;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int D = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			if ((D == 11 && H < 11) || (D == 11 && H == 11 && M < 11))
				System.out.println("#" + tc + " " + -1);
			else {
				int a;
				int b;
				int c;
				if (M >= 11) {
					c = M-11;
				} else {
					H--;
					c = 60 - 11 +M;
				}

				if (H >= 11) {
					b = H-11;
				} else {
					D--;
					b = 24-11+H;
				}

				a = D - 11;
				

				int result = c + b * 60 + a * 60 * 24;
				System.out.println("#" + tc + " " + result);

			}
		}
	}
}
