package se1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2 { // 그리드
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			String cards = st.nextToken();
			char arc[] = cards.toCharArray(); // 카드 배열
			int arr[] = new int[arc.length];
			int len = arr.length; // 길이

			for (int i = 0; i < len; i++) { // int형 arr 배열
				arr[i] = arc[i] - '0';
			}
			boolean select[] = new boolean[len]; // 선택체크 배열
			int d[] = new int[len]; // 중복있던 자리 체크
			for (int i = 0; i < len; i++) {
				d[i] = -1;
			}

			int n = Integer.parseInt(st.nextToken()); // 회전수
			

			// 중복값 있는지 확인
			boolean dd = false;
			for (int i = 0; i < len - 1; i++) {
				for (int j = i + 1; j < len; j++) {
					if (arr[i] == arr[j]) {
						dd = true;
						d[i] = arr[i];
						d[j] = arr[j];
					}
				}
			}

			for (int i = 0; i < n; i++) { // 돌려

				boolean rota = false; // 회전유무 판단용

				int maxIdx = len - 1;
				for (int j = len - 1; j >= 0; j--) {
					if (arr[maxIdx] < arr[j] && select[j] != true) { // 바꾸지않은 최대값
						maxIdx = j;
					}
				} // maxIdx 가 최대값

				for (int j = 0; j < len; j++) {
					if (select[j] != true) { //
						if (maxIdx == j) {
							select[j] = true;
							rota = true;
							i--;
							break;
						}
						select[j] = true;

						int tmp = arr[maxIdx]; // 스왑
						arr[maxIdx] = arr[j];
						arr[j] = tmp;
						rota = true;
						break;
					}
				}
				if (rota == true) {
					continue;
				} else { // 아직 로테안했으면 select가 전부 true
							// 중복 있으면 중복된거 스왑 ( 그냥 컨티뉴)
					if (dd)
						continue;
					// 중복 없으면 맨뒤에 두개만 스왑
					int tmp = arr[len - 1];
					arr[len - 1] = arr[len - 2];
					arr[len - 2] = tmp;
				}

			}
			// 같은 숫자가 있던 자리의 숫자들끼리 정렬
			if (dd) {
				for (int i = 0; i < len - 1; i++) {
					if (d[i] != -1 && arr[i] != d[i]) {
						for (int j = i + 1; j < len; j++) {
							if (d[i] == d[j] && d[j] != arr[j]) {
								if (arr[j] > arr[i]) {
									int tmp = arr[j];
									arr[j] = arr[i];
									arr[i] = tmp;
								}
							}
						}
					}
				}

			}

			System.out.print("#" + TC + " ");
			for (int j = 0; j < len; j++) {
				System.out.print(arr[j]);
			}
			System.out.println();

		}

	}

}
