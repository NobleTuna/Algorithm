package sw5644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

			int ax = 1;
			int ay = 1;

			int bx = 10;
			int by = 10;

			int sum = 0;

			for (int cnt = 0; cnt < M; cnt++) {
				
				


				move(ax, ay, A[cnt]);
				move(bx, by, B[cnt]);
			}

		}
	}

	static void move(int x, int y, int dir) {
		if (dir == 0) {
			return;

		} else if (dir == 1) {
			y--;
			return;

		} else if (dir == 2) {
			x++;
			return;
		} else if (dir == 3) {
			y++;
			return;
		} else if (dir == 4) {
			x--;
			return;
		}

	}

}
