package se1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			String cards = st.nextToken();
			char arc[] = cards.toCharArray(); // 카드 배열
			int arr[] = new int[arc.length];

			for (int i = 0; i < arr.length; i++) { // int형 arr 배열
				arr[i] = arc[i]-'0';
			}
			boolean select[] = new boolean[arr.length]; // 선택체크 배열
			int n = Integer.parseInt(st.nextToken()); // 회전수
			int len = arr.length; // 길이

			for (int i = 0; i < n; i++) { // 돌려

				boolean rota = false; // 회전유무 판단용

				int maxIdx = len-1;
				for (int j = arr.length-1; j >=0; j--) {
					if (arr[maxIdx] < arr[j] && select[j] != true) { // 바꾸지않은 최대값
						maxIdx = j;
					}
				} // maxIdx 가 최대값

				for (int j = 0; j < arr.length; j++) {
					if (select[j] != true) { //
						if(maxIdx == j) {
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
				System.out.println(Arrays.toString(arr));
				System.out.println(Arrays.toString(select));
				if (rota == true) {
					continue;
				} else { // 아직 로테안했으면 맨뒤에 두개만 스왑
					int tmp = arr[len - 1];
					arr[len - 1] = arr[len - 2];
					arr[len - 2] = tmp;
				}

			}
			System.out.print("#" + TC + " ");
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j]);
			}
			System.out.println();

		}

	}

}
