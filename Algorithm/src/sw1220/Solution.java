package sw1220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			int map[][] = new int[100][100];

			for (int i = 0; i < 100; i++) {
				String input = br.readLine();
				StringTokenizer st = new StringTokenizer(input);
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(input);
				}
			}
			int result = 0;

			// NNNN
			// 2 = S
			// 1 = N
			// SSSS
			// 그릴필요없음 세로단위로 세고 
			for (int i = 0; i < 100; i++) {
				int nCnt = 0;
				int sCnt = 0;
				for (int j = 0; j < 100; j++) {
					if (map[j][i] == 1) {
						nCnt++;
						
					}
					if(map[j][i] == 2) {
						sCnt++;
					}
				}
			}

		}
	}

}
