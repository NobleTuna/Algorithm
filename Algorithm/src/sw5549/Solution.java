package sw5549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			String input = br.readLine();
			int N = Integer.parseInt(input.substring(input.length() - 1));

			System.out.print("#" + tc + " ");
			if (N % 2 == 0) {
				System.out.println("Even");
			} else
				System.out.println("Odd");

		}
	}

}
