package sw6109_;

// 문제낸사람 때려도 무죄

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int N = Integer.parseInt(st.nextToken());

			int map[][] = new int[N][N];

			String D = st.nextToken(); // 방향

			for (int i = 0; i < N; i++) {
				input = br.readLine();
				st = new StringTokenizer(input);
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int firstMap[][] = new int[N][N];
			int secondMap[][] = new int[N][N];

			if (D.equals("up")) {

				for (int i = 0; i < N; i++) { // 먼저 0을 뺴고 입력 받아
					int idx = 0;
					for (int j = 0; j < N; j++) {
						if (map[j][i] != 0) {
							firstMap[i][idx++] = map[j][i];
						}
					}
				}
				for (int i = 0; i < N; i++) { // 더하고 두번쨰 자리는 0으로만듬
					for (int j = 1; j < N; j++) {
						if (firstMap[i][j] == firstMap[i][j - 1]) {
							firstMap[i][j - 1] = firstMap[i][j] + firstMap[i][j - 1];
							firstMap[i][j] = 0;
						}
					}
				}
				for (int i = 0; i < N; i++) {
					int idx = 0;
					for (int j = 0; j < N; j++) {
						if (firstMap[i][j] != 0) {
							secondMap[idx++][i] = firstMap[i][j];
						}
					}
				}
				System.out.println("#" + tc);
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						System.out.print(secondMap[i][j] + " ");
					}
					System.out.println();
				}

			} else if (D.equals("down")) {

				for (int i = 0; i < N; i++) { // 먼저 0을 뺴고 입력 받아
					int idx = 0;
					for (int j = 0; j < N; j++) {
						if (map[j][i] != 0) {
							firstMap[i][idx++] = map[j][i];
						}
					}
				}

				for (int i = 0; i < N; i++) { // 더하고 두번쨰 자리는 0으로만듬
					for (int j = 1; j < N; j++) {
						if (firstMap[i][j] == firstMap[i][j - 1]) {
							firstMap[i][j - 1] = firstMap[i][j] + firstMap[i][j - 1];
							firstMap[i][j] = 0;
						}
					}
				}

				for (int i = 0; i < N; i++) {
					int start = 0;
					for(int j=0; j<N; j++) {
						if(firstMap[i][j] ==0) {
							start++;
						}
					}
					for (int j = 0; j < N; j++) {
						if (firstMap[i][j] != 0) {
							secondMap[start++][i] = firstMap[i][j];
						}
					}
				}
				System.out.println("#" + tc);
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						System.out.print(secondMap[i][j] + " ");
					}
					System.out.println();
				}

			} else if (D.equals("left")) {

				for (int i = 0; i < N; i++) {
					int idx = 0;
					for (int j = 0; j < N; j++) {
						if (map[i][j] != 0) {
							firstMap[i][idx++] = map[i][j];
						}
					}
				}
				for (int i = 0; i < N; i++) {
					for (int j = 1; j < N; j++) {
						if (firstMap[i][j] == firstMap[i][j - 1]) {
							firstMap[i][j - 1] = firstMap[i][j - 1] + firstMap[i][j];
							firstMap[i][j] = 0;
						}
					}
				}

				for (int i = 0; i < N; i++) {
					int idx = 0;
					for (int j = 0; j < N; j++) {
						if (firstMap[i][j] != 0) {
							secondMap[i][idx++] = firstMap[i][j];
						}
					}
				}

				System.out.println("#" + tc);
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						System.out.print(secondMap[i][j] + " ");
					}
					System.out.println();
				}
			}else {

				for (int i = 0; i < N; i++) {
					int idx = 0;
					for (int j = 0; j < N; j++) {
						if (map[i][j] != 0) {
							firstMap[i][idx++] = map[i][j];
						}
					}
				}
				
				for (int i = 0; i < N; i++) {
					for (int j = 1; j < N; j++) {
						if (firstMap[i][j] == firstMap[i][j - 1]) {
							firstMap[i][j - 1] = firstMap[i][j - 1] + firstMap[i][j];
							firstMap[i][j] = 0;
						}
					}
				}

				for (int i = 0; i < N; i++) {
					int start = 0;
					for (int j = 0; j < N; j++) {
						if (firstMap[i][j] == 0) {
							start++;
						}
					}
					for(int j=0; j<N; j++) {
						if(firstMap[i][j]!=0) {
							secondMap[i][start++] = firstMap[i][j];
						}
					}
				}

				System.out.println("#" + tc);
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						System.out.print(secondMap[i][j] + " ");
					}
					System.out.println();
				}
			}
		}
	}
}
