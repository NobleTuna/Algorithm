package sw1251_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static double E;
	static double result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int map[][] = new int[N][2]; // a, b, cost

			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);

			for (int i = 0; i < N; i++) {
				map[i][0] = Integer.parseInt(st.nextToken());
			}
			input = br.readLine();
			st = new StringTokenizer(input);
			for (int i = 0; i < N; i++) {
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			result = 0;
			
			
			
			

		}

	}

}
