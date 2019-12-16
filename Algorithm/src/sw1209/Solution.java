package sw1209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int result = 0;

			br.readLine();
			int[][] map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				String input = br.readLine();
				StringTokenizer st = new StringTokenizer(input);
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					sum += tmp;
					map[i][j] = tmp;
				}
				if (sum > result)
					result = sum;
			}

			for (int i = 0; i < 100; i++) {
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += map[j][i];
				}
				if (sum > result)
					result = sum;
			}
			int sum = 0;
			for (int i = 0; i < 100; i++) {
				sum += map[i][i];
			}
			if (sum > result)
				result = sum;
			
			sum = 0;
			for (int i = 0; i < 100; i++) {
				sum += map[i][99-i];
			}
			if (sum > result)
				result = sum;
			
			System.out.println("#"+tc+" "+result);

		}
	}

}
