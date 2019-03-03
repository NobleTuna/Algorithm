package sw4789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			char[] msg = input.toCharArray();
			int[] people = new int[msg.length];
			for (int i = 0; i < msg.length; i++) {
				people[i] = msg[i] - '0';
			}

			int result = 0;

			int sumP = people[0];

			for (int i = 1; i < people.length; i++) {
				int p = people[i];
				if (p != 0 && i > sumP) {
					result += i - sumP;
					sumP += i-sumP+p;
				} else
					sumP += p;
			}

			System.out.println("#" + tc + " " + result);

		}

	}
}
