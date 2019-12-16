package sw1208;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int T = 1; T <= 10; T++) { // 테스트케이스 10번
			int[] box = new int[100];
			int max; // 제일 높은 인덱스
			int min; // 제일낮은 인덱스
			int N = sc.nextInt(); // 돌릴값 N
			max = 0;
			min = 0;
			int Ans = 99;
			for (int i = 0; i < 100; i++) { // 박스 입력
				box[i] = sc.nextInt();
				if (box[max] < box[i]) {
					max = i;
				}
				if (box[min] > box[i]) {
					min = i;
				}
			}
			int[] Answer = new int[box.length];
			int MAX = box[0];
			int MIN = box[0];
			for (int i = 1; i < box.length; i++) {
				if (MAX < box[i])
					MAX = box[i];
				if (MIN > box[i])
					MIN = box[i];
			}
			int Z = MAX - MIN;

			int[] count = new int[Z + 1];

			for (int i = 0; i < box.length; i++) {
				count[box[i] - MIN]++;
			}
			for (int i = 1; i < count.length; i++) {
				count[i] = count[i] + count[i - 1];
			} // 위치 정렬

			for (int i = 0; i < box.length; i++) {
				Answer[--count[box[i] - MIN]] = box[i];
			}
			for (int i = 0; i < N; i++) {
				Answer[max]--;
				Answer[min]++;
				for (int j = 0; j < 50; j++) {
					if (Answer[max] < Answer[99 - j]) {
						max = 99 - j;
					}
					if (Answer[min] > Answer[j]) {
						min = j;
					}
				}
				Ans = Answer[max] - Answer[min];
				if (Ans <= 1) {
					break;
				}
			}
			System.out.println("#" + T + " " + Ans);

		}
	}
}
