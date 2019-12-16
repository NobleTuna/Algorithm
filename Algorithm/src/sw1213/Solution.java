package sw1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			String s = br.readLine();
			String input = br.readLine();
			int result = 0;
			int sLen = s.length();
			for (int i = 0; i < input.length() - sLen+1; i++) {
				if (input.substring(i, i + sLen).equals(s)) {
					result++;
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}

}
