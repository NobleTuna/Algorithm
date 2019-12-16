package sw3431;

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
			int B = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			if (X <= A)
				System.out.println("#" + tc + " " + (A - X));
			else if(A<=X && X<=B)
				System.out.println("#" + tc + " " +0);
			else {
				System.out.println("#" + tc + " " + -1);
			}
		}
	}

}
