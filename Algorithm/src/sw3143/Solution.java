package sw3143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(inputString));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String A = st.nextToken();
			String B = st.nextToken();

			int ans = 0;

			for (int i = 0; i < A.length(); i++) {

				if (A.length() - i < B.length()) {
					ans++;
					continue;
				}
				String tmp = A.substring(i, i + B.length());
//				System.out.println(tmp);
				if (tmp.equals(B)) {
					ans++;
					i = i + B.length() - 1;
				} else {
//					System.out.println(tmp);
					ans++;
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	static String inputString = "2\r\n" + "abcabababcabababcdeab abc\r\n" + "asakusa sa";

}
