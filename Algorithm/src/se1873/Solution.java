package se1873;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];
			for (int i = 0; i < H; i++) {

				input = br.readLine();
				char[] mapInput = input.toCharArray();
				for (int j = 0; j < W; j++) {
					map[i][j] = mapInput[j];
				}
			}
			int x = 0;
			int y = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
						y = i;
						x = j;
					}
				}
			}
			input = br.readLine();
//			int N = Integer.parseInt(input);
			input = br.readLine();
			char[] p = input.toCharArray();
			for (int i = 0; i < p.length; i++) {
//				System.out.println("P : " + p[i]);
//				System.out.println("map[y][x] : " + map[y][x]);
				if (p[i] == 'U') {
					map[y][x] = '^';
					if (y == 0) {
					} else if (map[y - 1][x] == '.') {
						map[y][x] = '.';
						map[y - 1][x] = '^';
						y = y - 1;
					}

				} else if (p[i] == 'D') {
					map[y][x] = 'v';
					if (y == H - 1) {

					} else if (map[y + 1][x] == '.') {
						map[y][x] = '.';
						map[y + 1][x] = 'v';
						y = y + 1;
					}

				} else if (p[i] == 'L') {
					map[y][x] = '<';
					if (x == 0) {

					} else if (map[y][x - 1] == '.') {
						map[y][x] = '.';
						map[y][x - 1] = '<';
						x = x - 1;
					}

				} else if (p[i] == 'R') {
					map[y][x] = '>';
					if (x == W - 1) {
					} else if (map[y][x + 1] == '.') {
						map[y][x] = '.';
						map[y][x + 1] = '>';
						x = x + 1;
					}

				} else if (p[i] == 'S') {
					if (map[y][x] == '^') {
						if (y == 0) {

						} else {
							for (int k = y - 1; k >= 0; k--) {
								if (map[k][x] == '#') {
									break;
								} else if (map[k][x] == '*') {
									map[k][x] = '.';
									break;
								}
							}
						}
					} else if (map[y][x] == 'v') {
						if (y == H - 1) {

						} else {
							for (int k = y + 1; k <= H - 1; k++) {
								if (map[k][x] == '#') {
									break;
								} else if (map[k][x] == '*') {
									map[k][x] = '.';
									break;
								}
							}
						}
					} else if (map[y][x] == '<') {
						if (x == 0) {

						} else {
							for (int k = x - 1; k >= 0; k--) {
								if (map[y][k] == '#') {
									break;
								} else if (map[y][k] == '*') {
									map[y][k] = '.';
									break;
								}
							}
						}
					} else if (map[y][x] == '>') {
						if (x == W - 1) {

						} else {
							for (int k = x + 1; k <= W - 1; k++) {
								if (map[y][k] == '#') {
									break;
								} else if (map[y][k] == '*') {
									map[y][k] = '.';
									break;
								}
							}
						}

					}

				}

			}
			System.out.print("#" + tc+" ");
			for (int a = 0; a < H; a++) {
				for (int b = 0; b < W; b++) {
					System.out.print(map[a][b]);
				}
				System.out.println();
			}

		}
	}

}
