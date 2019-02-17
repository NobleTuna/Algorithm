package sw1974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int[][] map = new int[9][9];
			for (int i = 0; i < 9; i++) {
				String input = br.readLine();
				StringTokenizer st = new StringTokenizer(input);
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean token = true;
			for (int i = 0; i < 6; i = i + 3) {
				for (int j = 0; j < 6; j = j + 3) {
					token = nine(map, i, j);
					if (!token) {
						break;
					}
				}
				if (!token) {
					break;
				}
			}

			if (token&& line(map)) {
				System.out.println("#"+tc+" "+1);
			}
			else {
				System.out.println("#"+tc+" "+0);
			}
		}
	}

	public static boolean line(int[][] map) {
		boolean token = true;
		for (int a = 0; a < 9; a++) {
			for (int i = 0; i < 8; i++) {
				for (int j = i + 1; j < 9; j++) {
					if (map[a][i] == map[a][j]) {
						token = false;
						break;
					}
					if (map[i][a] == map[j][a]) {
						token = false;
						break;
					}
				}
				if (!token)
					break;
			}
			if (!token)
				break;
		}
		return token;
	}

	public static boolean nine(int[][] map, int y, int x) {

		boolean token = true;
		int arr[] = new int[9];
		int idx = 0;
		for (int i = y; i < y + 3; i++) {
			for (int j = x; j < x + 3; j++) {
				arr[idx] = map[i][j];
				idx++;
			}
		}
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (arr[i] == arr[j]) {
					token = false;
					break;
				}
				if (!token)
					break;
			}
		}
		return token;
	}

}
