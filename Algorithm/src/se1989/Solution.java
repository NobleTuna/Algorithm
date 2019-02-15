package se1989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			int c = input.length() / 2;
			String a = input.substring(0, c);
			
			if (input.length() % 2 == 0) {
				c = c - 1;
			}
			String b = input.substring(c+1, input.length());
			StringBuilder sb = new StringBuilder();
			sb.append(b);
			sb.reverse();
//			System.out.println(a);
//			System.out.println(b);
			if (a.equals(sb.toString())) {
				System.out.println("#" + tc + " " + 1);
			} else
				System.out.println("#" + tc + " " + 0);
		}

	}

}
