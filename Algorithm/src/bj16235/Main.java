package bj16235; // 나무재태크

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int dy[] = { 1, 1, 1, 0, 0, -1, -1, -1 };
	static int dx[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken()); // 맵크기
		int M = Integer.parseInt(st.nextToken()); // 나무개수
		int K = Integer.parseInt(st.nextToken()); // 출력 연도

		int map[][] = new int[N][N];
		int biryu[][] = new int[N][N]; // 겨울에 뿌리는 비료의양

		for (int i = 0; i < N; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			for (int j = 0; j < N; j++) {
				biryu[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][][] wood = new int[N][N][1000];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(wood[i][j], 3000);
			}
		}
		int[][] woodIdx = new int[N][N];
		for (int i = 0; i < M; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			woodIdx[a - 1][b - 1]++;
			wood[a - 1][b - 1][0] = c;
		}

		int ans = 0;

		for (int i = 0; i < N; i++)
			Arrays.fill(map[i], 5); // 비료맵 5로 초기화

		for (int Y = 0; Y < K; Y++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int idx = woodIdx[i][j];
					if (idx == 0) // 나무 없으면 컨티뉴
						continue;
					Arrays.sort(wood[i][j]);
					int BP = 0;
					for (int k = 0; k < idx; k++) {
						if (map[i][j] >= wood[i][j][k]) {
							map[i][j] -= wood[i][j][k]; // 비료에서 나이만큼 뺌
							wood[i][j][k]++; // 한살증가
						} else if (wood[i][j][k] != 3000 && map[i][j] < wood[i][j][k]) { // 3천이 아니고 비료를 못먹으면 죽음
							BP += (wood[i][j][k] / 2); // 비료에 추가해줄 양;
							wood[i][j][k] = 3000; // 죽임
							woodIdx[i][j]--; // 인덱스 --;
						}
					}
					map[i][j] += BP; // 여름, 맵에 비료더해줌
				}
			} // 봄, 여름 끝
//			System.out.println(Y+"년    나무 숫자");
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(woodIdx[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			
//			System.out.println("양분");
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			int tmpIdx[][] = new int[N][N]; // 모판

			int[][][] tmpWood = new int[N][N][1000];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Arrays.fill(tmpWood[i][j], 3000);
				}
			}
			////////// 가을 시작

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int idx = woodIdx[i][j];
					if (idx == 0) // 나무 없으면 컨티뉴
						continue;
					for (int k = 0; k < idx; k++) {
						if (wood[i][j][k] % 5 == 0) {
							for (int d = 0; d < 8; d++) {
								int cy = i + dy[d];
								int cx = j + dx[d];

								if (cy < 0 || cx < 0 || cy >= N || cx >= N) // 범위컷
									continue;

								int cIdx = tmpIdx[cy][cx];
								tmpWood[cy][cx][cIdx] = 1; // 나무 심어줌
								tmpIdx[cy][cx]++;
							}
						}
					}

				}
			} // 가을 모판에심음

//			for (int i = 0; i < N; i++) { // 모판출력실험
//				for (int j = 0; j < N; j++) {
//					System.out.print(tmpIdx[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int idx = woodIdx[i][j];// 기존 인덱스(시작점)
					int tidx = tmpIdx[i][j]; // 더해질 인덱스

					for (int k = idx; k < idx + tidx; k++) {
						wood[i][j][k] = tmpWood[i][j][k - idx];
					}
					woodIdx[i][j] += tidx;
				}
			} // 모판 이식

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] += biryu[i][j];
				}
			}

		} // 해넘이
		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans += woodIdx[i][j];
			}
		}

		System.out.println(ans);
	}
}
