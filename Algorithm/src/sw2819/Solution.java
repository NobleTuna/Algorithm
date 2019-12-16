package sw2819;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static Set<String> S;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			S = new HashSet<String>();
			String[][] map = new String[4][4];
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++) {
					map[i][j] = sc.next();
				}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					String arr[] = new String[7];
					arr[0] = map[i][j];
					go(map, 1, i, j, arr);
				}
			}
			System.out.println("#" + tc + " " + S.size());

		}
	}

	public static void go(String[][] map, int cnt, int y, int x, String[] arr) {
		if (cnt == 7) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<arr.length; i++) {
				sb.append(arr[i]);
			}
			S.add(sb.toString());
			return;
		}

		if (y != 0) { // 위로
			arr[cnt]=map[y - 1][x];
			go(map, cnt + 1, y - 1, x, arr);
		}

		if (y != 3) {
			arr[cnt]=map[y + 1][x];
			go(map, cnt + 1, y + 1, x, arr);
		}

		if (x != 0) {
			arr[cnt]=map[y][x - 1];
			go(map, cnt + 1, y, x - 1, arr);
		}

		if (x != 3) {
			arr[cnt]=map[y][x + 1];
			go(map, cnt + 1, y, x + 1, arr);

		}

	}

}
