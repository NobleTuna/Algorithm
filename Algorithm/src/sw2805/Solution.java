package sw2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				char[] msg = input.toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(msg[j]+"");
				}
			}

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j] + " ");
//				}System.out.println();
//			}
			int result = 0;
			int blank = N / 2; // 빈칸
			int value = 1; // 칸
			for (int i = 0; i < N / 2 + 1; i++) {
				for (int j = blank; j < N - blank; j++) {
					result += map[i][j];
				}
				blank--;
			}
			blank = 1;
			for (int i = N / 2 + 1; i < N; i++) {
				for (int j = blank; j < N - blank; j++) {
					result += map[i][j];
				}	
				blank++;
			}
			System.out.println("#"+tc+" "+result);

		}
	}

}
