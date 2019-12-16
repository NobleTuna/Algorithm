package sw5650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int map[][];
	static int N;
	static int wormHole[][]; // 웜홀은 12,13/14,15/16,17/18,19/20,21

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			wormHole = new int[22][2];

			int W1 = 12;
			int W2 = 14;
			int W3 = 16;
			int W4 = 18;
			int W5 = 20;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 6) {
						wormHole[W1][0] = i;
						wormHole[W1][1] = j;
						map[i][j] = W1;
						W1++;
					} else if (map[i][j] == 7) {
						wormHole[W2][0] = i;
						wormHole[W2][1] = j;
						map[i][j] = W2;
						W2++;
					} else if (map[i][j] == 8) {
						wormHole[W3][0] = i;
						wormHole[W3][1] = j;
						map[i][j] = W3;
						W3++;
					} else if (map[i][j] == 9) {
						wormHole[W4][0] = i;
						wormHole[W4][1] = j;
						map[i][j] = W4;
						W4++;
					} else if (map[i][j] == 10) {
						wormHole[W5][0] = i;
						wormHole[W5][1] = j;
						map[i][j] = W5;
						W5++;
					}
				}
			}
			maxScore = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						go(i, j, i, j, 0, 0, true);
						go(i, j, i, j, 1, 0, true);
						go(i, j, i, j, 2, 0, true);
						go(i, j, i, j, 3, 0, true);
					}
				}
			}
//			go(0, 2, 0, 2, 2, 0, true);

			/// 방향 0,1,2,3 // 상 하 좌 우
			System.out.println("#" + tc + " " + maxScore);
		}

	}

	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };

	static int maxScore;
	
	

	static void go(int sy, int sx, int y, int x, int dir, int score, boolean isStart) {
		
		
		
		if (map[y][x] == -1 || (!isStart && sy == y && sx == x)) {
			maxScore = Math.max(maxScore, score);
			return;
		}

		isStart = false;

		int ny = y + dy[dir];
		int nx = x + dx[dir];
		
		if(boundRange(ny, nx)) {
			ny = y;
			nx = x;
			score++;
			dir = mirrorDir(dir);
		}

		if (map[ny][nx] == 5) { // 방향만 바꿔 제자리, 점수 +1
			go(sy, sx, ny, nx, mirrorDir(dir), score + 1, isStart);
			return;
		} else if (map[ny][nx] == 6 || map[ny][nx] == 7 || map[ny][nx] == 8 || map[ny][nx] == 9 || map[ny][nx] == 10) {
			int WN = map[ny][nx]; // 웜홀넘버
			// 웜홀은 12,13/14,15/16,17/18,19/20,21
			if (WN % 2 == 0) {
				ny = wormHole[WN + 1][0];
				nx = wormHole[WN + 1][1];
			} else {
				ny = wormHole[WN - 1][0];
				nx = wormHole[WN - 1][1];
			}
			go(sy, sx, ny, nx, dir, score, isStart);
			return;
		} else if (map[ny][nx] == 0) { /////////// 직진
			go(sy, sx, ny, nx, dir, score, isStart);
			return;
		} else if (map[ny][nx] == 1) { // ㄴ 1,2,3,4 // 0 1 2 3 상 하 좌 우
			if (dir == 0 || dir == 3) {
				go(sy, sx, ny, nx, mirrorDir(dir), score + 1, isStart);
			} else if (dir == 1) {
				go(sy, sx, ny, nx, 3, score + 1, isStart);
			} else if (dir == 2) {
				go(sy, sx, ny, nx, 0, score + 1, isStart);
			}
			return;
		} else if (map[ny][nx] == 2) {// r
			if (dir == 3 || dir == 1) {
				go(sy, sx, ny, nx, mirrorDir(dir), score + 1, isStart);
			} else if (dir == 0) {
				go(sy, sx, ny, nx, 3, score + 1, isStart);
			} else if (dir == 2) {
				go(sy, sx, ny, nx, 1, score + 1, isStart);
			}
			return;
		} else if (map[ny][nx] == 3) {// ㄱ
			if (dir == 1 || dir == 2) {
				go(sy, sx, ny, nx, mirrorDir(dir), score + 1, isStart);
			} else if (dir == 0) {
				go(sy, sx, ny, nx, 2, score + 1, isStart);
			} else if (dir == 3) {
				go(sy, sx, ny, nx, 1, score + 1, isStart);
			}
			return;
		} else if (map[ny][nx] == 4) {/// J
			if (dir == 0 || dir == 2) {
				go(sy, sx, ny, nx, mirrorDir(dir), score + 1, isStart);
			} else if (dir == 1) {
				go(sy, sx, ny, nx, 2, score + 1, isStart);
			} else if (dir == 3) {
				go(sy, sx, ny, nx, 0, score + 1, isStart);
			}
			return;
		} else {
			go(sy, sx, ny, nx, dir, score, isStart);
			return;
		}

	}

	static boolean boundRange(int y, int x) {
		return y < 0 || x < 0 || y >= N || x >= N;
	}

	static int mirrorDir(int dir) {// 0 1 2 3 상 하 좌 우
		if (dir == 0)
			return 1;
		else if (dir == 1)
			return 0;
		else if (dir == 2)
			return 3;
		else
			return 2;
	}

}
