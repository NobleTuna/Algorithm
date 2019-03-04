package sw6900;

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
			int N = Integer.parseInt(st.nextToken());
			String[] lotto = new String[N];
			int[] money = new int[N];

			int M = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				input = br.readLine();
				st = new StringTokenizer(input);
				lotto[i] = st.nextToken();
				money[i] = Integer.parseInt(st.nextToken());
			}

			int result = 0;

			for (int i = 0; i < M; i++) {
				input = br.readLine();
				char[] msg1 = input.toCharArray();

				for (int j = 0; j < N; j++) {
					char[] msg2 = lotto[j].toCharArray();
					boolean isDebak = true;
					
					for (int k = 0; k < msg1.length; k++) {
						if (msg2[k] != '*' && msg1[k] != msg2[k]) {
							isDebak = false;
							break;
						}
					}
					if (isDebak)
						result += money[j];
				}

			}
			System.out.println("#"+tc+" "+result);

		}
	}

}
