package sw5644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	static class BC {
		int x;
		int y;
		int C;
		int P;

		public BC(int x, int y, int C, int P) {
			this.x = x;
			this.y = y;
			this.C = C;
			this.P = P;
		}

	}

	static int ax, ay;
	static int bx, by;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(inputSrc));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int AP = Integer.parseInt(st.nextToken());

			int[] A = new int[M];
			int[] B = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			BC[] list = new BC[AP];

			for (int i = 0; i < AP; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				list[i] = new BC(x, y, C, P);
			}

			Arrays.sort(list, new Comparator<BC>() {

				@Override
				public int compare(BC o1, BC o2) {
					// TODO Auto-generated method stub
					return o2.P - o1.P;
				}
			});

			ax = 1;
			ay = 1;

			bx = 10;
			by = 10;

			int sum = 0;
			int cnt = 0;

			while (true) {

				BC[] arrA = new BC[2];
				BC[] arrB = new BC[2];

				arrA[0] = new BC(0, 0, 0, 0);
				arrA[1] = new BC(0, 0, 0, 0);
				arrB[0] = new BC(0, 0, 0, 0);
				arrB[1] = new BC(0, 0, 0, 0);
				int idxA = 0;
				int idxB = 0;

				for (int i = 0; i < list.length; i++) {
					if (Math.abs(list[i].x - ax) + Math.abs(list[i].y - ay) <= list[i].C) {
						arrA[idxA++] = list[i];
						if (idxA == 2)
							break;
					}
				}

				for (int i = 0; i < list.length; i++) {
					if (Math.abs(list[i].x - bx) + Math.abs(list[i].y - by) <= list[i].C) {
						arrB[idxB++] = list[i];
						if (idxB == 2)
							break;
					}
				}

				if (arrA[0] == arrB[0]) {
//					System.out.println(ax+" "+ay+"       "+bx+" "+by+"  합 : "+(arrA[0].P + Math.max(arrA[1].P, arrB[1].P)) );
					sum += (arrA[0].P + Math.max(arrA[1].P, arrB[1].P));
				} else {
					sum += (arrA[0].P + arrB[0].P);
				}
				if (cnt == M)
					break;
				moveA(A[cnt]);
				moveB(B[cnt]);
				cnt++;
			}
			System.out.println("#" + tc + " " + sum);

		}
	}

	static void moveA(int dir) {
		if (dir == 0) {
			return;

		} else if (dir == 1) {
			ay--;
			return;

		} else if (dir == 2) {
			ax++;
			return;
		} else if (dir == 3) {
			ay++;
			return;
		} else if (dir == 4) {
			ax--;
			return;
		}

	}

	static void moveB(int dir) {
		if (dir == 0) {
			return;

		} else if (dir == 1) {
			by--;
			return;

		} else if (dir == 2) {
			bx++;
			return;
		} else if (dir == 3) {
			by++;
			return;
		} else if (dir == 4) {
			bx--;
			return;
		}

	}

	static String inputSrc = "5\r\n" + "20 3\r\n" + "2 2 3 2 2 2 2 3 3 4 4 3 2 2 3 3 3 2 2 3\r\n"
			+ "4 4 1 4 4 1 4 4 1 1 1 4 1 4 3 3 3 3 3 3\r\n" + "4 4 1 100\r\n" + "7 10 3 40\r\n" + "6 3 2 70\r\n"
			+ "40 2\r\n" + "0 3 0 3 3 2 2 1 0 4 1 3 3 3 0 3 4 1 1 3 2 2 2 2 2 0 2 3 2 2 3 4 4 3 3 3 2 0 4 4 \r\n"
			+ "0 1 0 3 4 0 4 0 0 1 1 1 0 1 4 4 4 4 4 3 3 3 0 1 0 4 3 2 1 4 4 3 2 3 2 2 0 4 2 1 \r\n" + "5 2 4 140\r\n"
			+ "8 3 3 490\r\n" + "60 4\r\n"
			+ "0 3 3 3 0 1 2 2 2 1 2 2 3 3 4 4 0 3 0 1 1 2 2 3 2 2 3 2 2 0 3 0 1 1 1 4 1 2 3 3 3 3 3 1 1 4 3 2 0 4 4 4 3 4 0 3 3 0 3 4 \r\n"
			+ "1 1 4 1 1 1 1 1 1 4 4 1 2 2 3 2 4 0 0 0 4 3 3 4 3 3 0 1 0 4 3 0 4 3 2 3 2 1 2 2 3 4 0 2 2 1 0 0 1 3 3 1 4 4 3 0 1 1 1 1 \r\n"
			+ "6 9 1 180\r\n" + "9 3 4 260\r\n" + "1 4 1 500\r\n" + "1 3 1 230\r\n" + "80 7\r\n"
			+ "2 2 2 2 2 2 0 2 2 0 4 0 2 3 3 2 3 3 0 3 3 3 4 3 3 2 1 1 1 0 4 4 4 1 0 2 2 2 1 1 4 1 2 3 4 4 3 0 1 1 0 3 4 0 1 2 2 2 1 1 3 4 4 4 4 4 4 3 2 1 4 4 4 4 3 3 3 0 3 3 \r\n"
			+ "4 4 1 1 2 1 2 3 3 3 4 4 4 4 4 1 1 1 1 1 1 1 1 0 3 3 2 0 4 0 1 3 3 3 2 2 1 0 3 2 3 4 1 0 1 2 2 3 2 0 4 0 3 4 1 1 0 0 3 2 0 0 4 3 3 4 0 4 4 4 4 0 3 0 1 1 4 4 3 0 \r\n"
			+ "4 3 1 170\r\n" + "10 1 3 240\r\n" + "10 5 3 360\r\n" + "10 9 3 350\r\n" + "9 6 2 10\r\n"
			+ "5 1 4 350\r\n" + "1 8 2 450\r\n" + "100 8\r\n"
			+ "2 2 3 2 0 2 0 3 3 1 2 2 2 2 3 3 0 4 4 3 2 3 4 3 3 2 3 4 4 4 2 2 2 0 2 2 4 4 4 4 1 1 1 2 2 2 4 3 0 2 3 3 4 0 0 1 1 4 1 1 1 1 2 2 1 1 3 3 3 0 3 2 3 3 0 1 3 3 0 1 1 3 3 4 0 4 1 1 2 2 4 0 4 1 1 2 2 1 1 1 \r\n"
			+ "4 4 4 0 4 1 1 4 1 1 1 1 3 2 1 2 1 1 4 4 1 0 2 3 4 4 4 4 4 0 1 0 2 2 2 0 2 2 2 2 2 2 3 0 0 1 4 3 3 2 0 0 4 4 4 0 2 0 4 1 1 2 2 0 4 4 0 0 2 0 2 3 3 0 2 3 0 3 4 0 4 3 4 4 3 4 1 1 2 2 2 0 0 1 0 4 1 1 1 4 \r\n"
			+ "3 4 2 340\r\n" + "10 1 1 430\r\n" + "3 10 4 10\r\n" + "6 3 4 400\r\n" + "7 4 1 80\r\n" + "4 5 1 420\r\n"
			+ "4 1 2 350\r\n" + "8 4 4 300\r\n" + "";

}
