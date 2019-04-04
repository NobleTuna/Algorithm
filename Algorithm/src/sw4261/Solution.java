package sw4261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		char[] alphabet = new char[26]; // a == 97
		alphabet[0] = '2';
		alphabet[1] = '2';
		alphabet[2] = '2';

		alphabet[3] = '3';
		alphabet[4] = '3';
		alphabet[5] = '3';

		alphabet[6] = '4';
		alphabet[7] = '4';
		alphabet[8] = '4';

		alphabet[9] = '5';
		alphabet[10] = '5';
		alphabet[11] = '5';

		alphabet[12] = '6';
		alphabet[13] = '6';
		alphabet[14] = '6';

		alphabet[15] = '7';
		alphabet[16] = '7';
		alphabet[17] = '7';
		alphabet[18] = '7';

		alphabet[19] = '8';
		alphabet[20] = '8';
		alphabet[21] = '8';

		alphabet[22] = '9';
		alphabet[23] = '9';
		alphabet[24] = '9';
		alphabet[25] = '9';

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] S = st.nextToken().toCharArray();
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				char[] word = st.nextToken().toCharArray();

				if (word.length != S.length) // 길이가 안맞으면 먼저 패스
					continue;
				
				boolean isOk = true;
				
				for (int j = 0; j < word.length; j++) {
					int k = word[j] - 97;
					if(alphabet[k]!=S[j]) {
						isOk = false;
						break;
					}
				}
				
				if(isOk)
					ans++;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}

}
