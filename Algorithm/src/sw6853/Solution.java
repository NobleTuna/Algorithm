package sw6853;

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
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int result1 = 0;
			int result2 = 0; // ( X1, Y1 ), ( X1, Y2 ), ( X2, Y2 ), ( X2, Y1 )
			int result3 = 0;

			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				input = br.readLine();
				st = new StringTokenizer(input);

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (x1 < a && a < x2 && y1 < b && b < y2) {
					result1++;
				} else if (((a == x1 || a == x2) && y1 <= b && b <= y2)
						|| (x1 <= a && a <= x2 && (b == y2 || b == y1))) {
					result2++;

				} else
					result3++;
			}
			System.out.println("#"+tc+" "+result1+" "+result2+" "+result3);

		}
	}

}
