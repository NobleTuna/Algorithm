package sw1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int result = 0;
			int v = 0;
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {

				
				String input = br.readLine();
				StringTokenizer st = new StringTokenizer(input);
				int C = Integer.parseInt(st.nextToken());

				if (C == 0) { //
					result += v;
					continue;
				} else if (C == 1) {
					int a = Integer.parseInt(st.nextToken());
					v += a;
					result += v;
				} else if (C == 2) {
					int a = Integer.parseInt(st.nextToken());

					v -= a;
					if (v < 0)
						v = 0;

					result += v;
				}
			}
			System.out.println("#" + tc + " " + result);

		}
	}

}
