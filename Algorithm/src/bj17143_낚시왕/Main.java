package bj17143_낚시왕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static int R;
	static int C;
	static int M;

	static class Shark {
		int s; // 속력
		int d; // 방향
		int z; // 크기

		public Shark(int s, int d, int z) {
			this.s = s;
			this.d = d;
			this.z = z;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new StringReader(TC1));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Shark[][] map = new Shark[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			map[r][c] = new Shark(s, d, z);
		}

		int ans = 0;

//		for (int i = 1; i < R + 1; i++) {
//			for (int j = 1; j < C + 1; j++) {
//				if (map[i][j] != null) {
//					System.out.print(map[i][j].z + " ");
//				} else
//					System.out.print(0 + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		for (int c = 1; c <= C; c++) {

			// 낚아
			for (int r = 1; r <= R; r++) {
				if (map[r][c] != null) {
					ans += map[r][c].z;
					map[r][c] = null;
					break;
				}
			}

			Shark[][] newMap = new Shark[R + 1][C + 1];

			// 이동
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (map[i][j] != null) {
						Shark shark = map[i][j];
						newMap = move(newMap, shark, i, j);
					}
				}
			}
			map = newMap;

//			for (int i = 1; i < R + 1; i++) {
//				for (int j = 1; j < C + 1; j++) {
//					if (map[i][j] != null) {
//						System.out.print(map[i][j].z + " ");
//					} else
//						System.out.print(0 + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			
		}
		System.out.println(ans);
	}
	
	// 상 하 우 좌
	static int[] dx = { 0, 0, 0, 1, -1 };
	static int[] dy = { 0, -1, 1, 0, 0 };

	static boolean dirChk(int i, int j) {
		return i == 0 || j == 0 || i == R + 1 || j == C + 1;

	}

	static Shark[][] move(Shark[][] newMap, Shark shark, int i, int j) {

		int s = shark.s;
		int d = shark.d;
		
//		System.out.println("상어 방향 : "+ d);

		for (int a = 0; a < s; a++) {
			i += dy[d];
			j += dx[d];
			if (dirChk(i, j)) {
				i += (dy[d] * -2);
				j += (dx[d] * -2);

				if (d == 1)
					d = 2;
				else if (d == 2)
					d = 1;
				else if (d == 3)
					d = 4;
				else if (d == 4)
					d = 3;
			}
		}

		if (newMap[i][j] != null) {
			if (newMap[i][j].z < shark.z) {
				newMap[i][j] = new Shark(s, d, shark.z);
			}
		} else {
			newMap[i][j] = new Shark(s, d, shark.z);
		}


//		for (int a = 1; a < R + 1; a++) {
//			for (int b = 1; b < C + 1; b++) {
//				if (newMap[a][b] != null) {
//					System.out.print(newMap[a][b].z + " ");
//				} else
//					System.out.print(0 + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		return newMap;
	}

	static String TC1 = "4 6 8\r\n" + "4 1 3 3 8\r\n" + "1 3 5 2 9\r\n" + "2 4 8 4 1\r\n" + "4 5 0 1 4\r\n"
			+ "3 3 1 2 7\r\n" + "1 5 8 4 3\r\n" + "3 6 2 1 2\r\n" + "2 2 2 3 5";
}
