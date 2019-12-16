package sw4013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[] M1;
	static int[] M2;
	static int[] M3;
	static int[] M4;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			M1 = new int[8];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				M1[i] = Integer.parseInt(st.nextToken());
			}
			M2 = new int[8];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				M2[i] = Integer.parseInt(st.nextToken());
			}
			M3 = new int[8];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				M3[i] = Integer.parseInt(st.nextToken());
			}
			M4 = new int[8];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				M4[i] = Integer.parseInt(st.nextToken());
			}
			
			int command[][] = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				command[i][0] = Integer.parseInt(st.nextToken());
				command[i][1] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; i++) { // 2,6 // 2,6// 2,6
				int C = command[i][0];
				int dir = command[i][1];
				if (C == 1) {
					turn1(dir);
				} else if (C == 2) {
					turn2(dir);
				} else if (C == 3) {
					turn3(dir);
				} else if (C == 4) {
					turn4(dir);
				}
				
//				System.out.println(Arrays.toString(M1));
//				System.out.println(Arrays.toString(M2));
//				System.out.println(Arrays.toString(M3));
//				System.out.println(Arrays.toString(M4));
//				System.out.println();
			}

			int ans = M1[0] + (M2[0] * 2) + (M3[0] * 4) + (M4[0] * 8);

			System.out.println("#" + tc + " " + ans);

		}
	}

	static void turn1(int C) {// M1 2/6 M2 2/6 M3 2/6 M4 6
		int C1 = C;
		int C2 = 0;
		int C3 = 0;
		int C4 = 0;

		if (M1[2] != M2[6]) {
			C2 = C1 * -1;
			if (M2[2] != M3[6]) {
				C3 = C2 * -1;
				if (M3[2] != M4[6]) {
					C4 = C3 * -1;
				}
			}
		}
		turn(M1, C1);
		turn(M2, C2);
		turn(M3, C3);
		turn(M4, C4);
	}

	static void turn2(int C) {// M1 2/6 M2 2/6 M3 2/6 M4 6
		int C1 = 0;
		int C2 = C;
		int C3 = 0;
		int C4 = 0;

		if (M2[2] != M3[6]) {
			C3 = C2 * -1;
			if (M3[2] != M4[6]) {
				C4 = C3 * -1;
			}
		}

		if (M1[2] != M2[6]) {
			C1 = C2 * -1;
		}

		turn(M1, C1);
		turn(M2, C2);
		turn(M3, C3);
		turn(M4, C4);
	}

	static void turn3(int C) {// M1 2/6 M2 2/6 M3 2/6 M4 6
		int C1 = 0;
		int C2 = 0;
		int C3 = C;
		int C4 = 0;

		if (M3[2] != M4[6]) {
			C4 = C3 * -1;
		}
		if (M2[2] != M3[6]) {
			C2 = C3 * -1;
			if (M1[2] != M2[6]) {
				C1 = C2 * -1;
			}
		}

		turn(M1, C1);
		turn(M2, C2);
		turn(M3, C3);
		turn(M4, C4);
	}

	static void turn4(int C) {// M1 2/6 M2 2/6 M3 2/6 M4 6
		int C1 = 0;
		int C2 = 0;
		int C3 = 0;
		int C4 = C;

		if (M3[2] != M4[6]) {
			C3 = C4 * -1;
			if (M2[2] != M3[6]) {
				C2 = C3 * -1;
				if (M1[2] != M2[6]) {
					C1 = C2 * -1;
				}
			}
		}
		turn(M1, C1);
		turn(M2, C2);
		turn(M3, C3);
		turn(M4, C4);
	}

	static void turn(int arr[], int C) {

//		System.out.println("입력   "+Arrays.toString(arr));
		if (C == -1) { // 반시계
			int tmp = arr[0];
			for (int i = 0; i < arr.length - 1; i++) {
				arr[i] = arr[i + 1];
			}
			arr[arr.length - 1] = tmp;

		} else if (C == 1) { // 시계방향
			int tmp = arr[arr.length - 1];
			for (int i = arr.length-1; i >0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = tmp;
		} else
			return;

//		System.out.println("바꿈    : "+Arrays.toString(arr));
//		System.out.println();

	}

}
