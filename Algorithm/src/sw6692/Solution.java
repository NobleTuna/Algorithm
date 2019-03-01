package sw6692;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			Double sum = (double) 0;
			for (int n = 0; n < N; n++) {
				String input = br.readLine();
				StringTokenizer st = new StringTokenizer(input);

				Double a = Double.parseDouble(st.nextToken());
				Double b = Double.parseDouble(st.nextToken());

				sum = sum + a*b;
			}
			System.out.println("#"+tc+" "+sum);

		}

	}
}
