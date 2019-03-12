package sw1952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int[] money = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 4; i++) {
				money[i] = Integer.parseInt(st.nextToken());
			}

			int[] month = new int[12];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < 12; i++) {
				if (month[i] == 0)
					continue;
				month[i] = Math.min(money[1], month[i] * money[0]);
			}
			

		}
	}

}
