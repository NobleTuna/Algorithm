package sw1861;

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
			int map[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				StringTokenizer st = new StringTokenizer(input);
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					System.out.print(map[i][j]+" ");
//				}System.out.println();
//			}
			resultLen = 0;
			resultRoom = N * N;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					curLen = 1;
					go(map, i, j);
					if (curLen > resultLen) {
						resultLen = curLen;
						resultRoom = map[i][j];
					} else if (curLen == resultLen && resultRoom > map[i][j]) {
						resultRoom = map[i][j];
					}
				}
			}

			System.out.println("#" + tc + " " + resultRoom + " " + resultLen);

		}
	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int resultLen;
	static int resultRoom;
	static int curLen;

	public static void go(int[][] map, int y, int x) {
		for (int i = 0; i < 4; i++) {
			int cy = y + dy[i];
			int cx = x + dx[i];

			if (cy < 0 || cx < 0 || cy >= map.length || cx >= map.length || map[cy][cx] - map[y][x] != 1)
				continue;

			
			curLen++;
			go(map, cy, cx);
		}

	}

}
