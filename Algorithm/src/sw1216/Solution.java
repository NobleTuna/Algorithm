package sw1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			char map[][] = new char[100][100];

			for (int i = 0; i < 100; i++) {
				String input = br.readLine();
				char[] msg = input.toCharArray();
				for (int j = 0; j < 100; j++) {
					map[i][j] = msg[j];
				}
			}

			// 가로탐색
			int len = 1;

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 99; j++) {
					StringBuilder sb = new StringBuilder();
					sb.append(map[i][j]);
					for (int k = j + 1; k < 100; k++) {
						sb.append(map[i][k]);
						if (sb.length() > len && map[i][j] == map[i][k]) {
							if (sb.length() % 2 == 0) { // 짝수일때
								StringBuilder after = new StringBuilder();
								String before = sb.toString().substring(0, sb.length() / 2);
								after.append(sb.toString().substring(sb.length() / 2, sb.length()));
								if (before.equals(after.reverse().toString())) {
									len = sb.length();
								}

							} else { // 홀수일떄
								StringBuilder after = new StringBuilder();
								String before = sb.toString().substring(0, sb.length() / 2);
								after.append(sb.toString().substring((sb.length() / 2) + 1, sb.length()));
								if (before.equals(after.reverse().toString())) {
									len = sb.length();
								}
							}
						}
					}
				}
			}

			// 세로탐색

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 99; j++) {
					StringBuilder sb = new StringBuilder();
					sb.append(map[j][i]);
					for (int k = j + 1; k < 100; k++) {
						sb.append(map[k][i]);
						if (sb.length() > len && map[j][i] == map[k][i]) {
							if (sb.length() % 2 == 0) { // 짝수일때
								StringBuilder after = new StringBuilder();
								String before = sb.toString().substring(0, sb.length() / 2);
								after.append(sb.toString().substring(sb.length() / 2, sb.length()));
								if (before.equals(after.reverse().toString())) {
									len = sb.length();
								}

							} else { // 홀수일떄
								StringBuilder after = new StringBuilder();
								String before = sb.toString().substring(0, sb.length() / 2);
								after.append(sb.toString().substring((sb.length() / 2) + 1, sb.length()));
								if (before.equals(after.reverse().toString())) {
									len = sb.length();
								}
							}
						}
					}
				}
			}

			System.out.println("#" + tc + " " + len);
		}
	}

}
