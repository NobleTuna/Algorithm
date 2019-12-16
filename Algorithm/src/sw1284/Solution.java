package sw1284;

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
			int A = Integer.parseInt(st.nextToken());
			int B_Q = Integer.parseInt(st.nextToken()); // 기본요금
			int B_R = Integer.parseInt(st.nextToken()); // 월간사용량 커트
			int B_S = Integer.parseInt(st.nextToken()); // 초과사용료
			int W = Integer.parseInt(st.nextToken());

			int resut = 0;

			int AR = A * W;
			int BR = 0;
			if (W <= B_R)
				BR = B_Q;
			else {
				BR = B_Q  + (B_S * (W - B_R));
			}
			System.out.println("#" + tc + " " + ((AR <= BR) ? AR : BR));

		}
	}

}
