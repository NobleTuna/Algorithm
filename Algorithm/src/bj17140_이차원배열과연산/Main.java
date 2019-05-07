package bj17140_이차원배열과연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c, k;
	static int map[][];
	static int curR, curC;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[100][100];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		curR = 3;
		curC = 3;

		int ans = -1;
		//클래스형배열 해야함
		for (int t = 0; t < 100; t++) {
			if (curR >= curC) {
				for(int i=0; i<map.length; i++) {
					int cnt[] = new int[101];
					for(int j=0; j<map[i].length; j++) {
						cnt[map[i][j]]++;
					}
				}
				
				
			} else {

			}

			if (map[r - 1][c - 1] == k) {
				ans = t;
				break;
			}
		}
	}
}
