package sw7272;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static String D = "DIFF";
	static String S = "SAME";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();

			if (a.length() != b.length()) {
				System.out.println("#" + tc + " " + D);
				continue;
			}

			boolean isFail = false;

			for (int i = 0; i < a.length(); i++) {
				if (comppare(a.charAt(i)) != comppare(b.charAt(i))) {
					isFail = true;
					break;
				}

			}
			if(isFail) {
				System.out.println("#" + tc + " " + D);
			}else
				System.out.println("#" + tc + " " + S);

		}

	}

	static int comppare(char C) {
		switch (C) {
		case 'A':
			return 1;
		case 'D':
			return 1;
		case 'O':
			return 1;
		case 'P':
			return 1;
		case 'Q':
			return 1;
		case 'R':
			return 1;
		case 'B':
			return 2;
		default:
			return 3;
		}

	}

}
