package sw7338;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(TC));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Long Y = Long.parseLong(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

//			if (Y == 2016 && M == 12) {
//				System.out.println("#" + tc + " " + Y + " " + M);
//				continue;
//			}

			Long a = ((Y - 2016) * 12) + M;

			Long ansY = ((a-1) / 13) + 2016;
			Long ansM = (a % 13 == 0) ? 13 : a % 13;

			System.out.println("#" + tc + " " + ansY + " " + ansM);
		}
	}

	static String TC = "4\r\n" + "2016 12\r\n" + "2017 1\r\n" + "2017 2\r\n" + "111111111111 11";

}
