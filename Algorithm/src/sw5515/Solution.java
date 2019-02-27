package sw5515; // 달력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] mont = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int M = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int sum = 0;
			for (int i = 0; i < M; i++) {
				sum += mont[i];
			}
			sum += D+3;
			System.out.println("#"+tc+" "+(sum % 7));

		}

	}

}
