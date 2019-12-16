package sw1215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());

			if (N == 1) {
				System.out.println("#" + tc + " " + 64);
				continue;
			}

			char[][] map = new char[8][8];
			StringTokenizer st;
			for (int i = 0; i < 8; i++) {
				String input = br.readLine();
				char[] tmp = input.toCharArray();
				for (int j = 0; j < 8; j++) {
					map[i][j] = tmp[j];
				}
			}
			int result = 0;
			int len; // 뒤쪽 시작부분
			if (N % 2 == 0) // 짝수이면 +1부터
				len = N / 2;
			else // 홀수이면 +2부터
				len = N / 2 + 1;

			// 가로, 세로탐색 따로, 길이 짝수개 홀수개 따로, 서브스트링 리버스

			// 가로 탐색
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - N + 1; j++) { // 시작점
					// 두개의 문자열 합치는 포문
					StringBuilder a = new StringBuilder();
					StringBuilder b = new StringBuilder();
					for (int k = 0; k < (N / 2); k++) {
						a.append(map[i][j + k]);
						b.append(map[i][j + len + k]);
					}
					b.reverse();
					if ((a.toString()).equals(b.toString()))
						result++;
				}
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - N + 1; j++) { // 시작점
					// 두개의 문자열 합치는 포문
					StringBuilder a = new StringBuilder();
					StringBuilder b = new StringBuilder();
					for (int k = 0; k < N / 2; k++) {
						a.append(map[j + k][i]);
						b.append(map[j + len + k][i]);
					}
					b.reverse();
					if ((a.toString()).equals(b.toString()))
						result++;
				}
			}
			System.out.println("#" + tc + " " + result);

		}
	}

}
