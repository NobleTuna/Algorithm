package bj17144_미세먼지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T;
	static int map[][];

	static int[] py;
	static int[] px;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		py = new int[2];
		px = new int[2];

		int idx = 0;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					py[idx] = i;
					px[idx] = j;
					idx++;
				}
			}
		}
//		for (int i = 0; i < R; i++)
//			System.out.println(Arrays.toString(map[i]));
//		System.out.println();

		for (int t = 0; t < T; t++) {

			int[][] newMap = new int[R][C];
			newMap[py[0]][px[0]] = -1;
			newMap[py[1]][px[1]] = -1;

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != 0 && map[i][j] != -1) {

						int mise = map[i][j];
						int dMise = mise / 5;
						int aMise = 0;

						if (dMise < 1) {
							newMap[i][j] += map[i][j];
							continue;
						}

						for (int d = 0; d < 4; d++) {
							int ny = i + dy[d];
							int nx = j + dx[d];

							if (outRange(ny, nx) || map[ny][nx] == -1)
								continue;

							newMap[ny][nx] += dMise;
							aMise += dMise;
						}

						newMap[i][j] += mise - aMise;
					}
				}
			}

//			for (int i = 0; i < R; i++)
//				System.out.println(Arrays.toString(newMap[i]));
//			System.out.println();

			int Py = py[0];
			newMap[Py - 1][0] = 0;

			for (int i = Py - 2; i >= 0; i--) {
				newMap[i + 1][0] = newMap[i][0];
			}

			for (int j = 1; j < C; j++) {
				newMap[0][j - 1] = newMap[0][j];
			}

			for (int i = 1; i <= Py; i++) {
				newMap[i - 1][C - 1] = newMap[i][C - 1];
			}

			for (int j = C - 1; j >= 2; j--) {
				newMap[Py][j] = newMap[Py][j - 1];
			}
			newMap[Py][1] = 0;

			Py = py[1];
			for (int i = Py + 2; i < R; i++) {
				newMap[i - 1][0] = newMap[i][0];
			}

			for (int j = 1; j < C; j++) {
				newMap[R - 1][j - 1] = newMap[R - 1][j];
			}

			for (int i = R - 2; i >= Py; i--) {
				newMap[i + 1][C - 1] = newMap[i][C - 1];
			}

			for (int j = C - 1; j >= 2; j--) {
				newMap[Py][j] = newMap[Py][j - 1];
			}
			newMap[Py][1] = 0;

			map = newMap;

//			for (int i = 0; i < R; i++)
//				System.out.println(Arrays.toString(newMap[i]));
		}

		int ans = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0 && map[i][j] != -1)
					ans += map[i][j];
			}
		}

		System.out.println(ans);
	}

	static boolean outRange(int i, int j) {
		return i < 0 || j < 0 || i >= R || j >= C;
	}
}
