package sw1258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int ry;
	static int rx;

	static class result implements Comparable<result> {
		int y;
		int x;

		public result(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(result o) {
			// TODO Auto-generated method stub
			if (this.x * this.y == o.x * o.y) {
				return Integer.compare(this.y, o.y);
			}
			return Integer.compare(this.x * this.y, o.x * o.y);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				StringTokenizer st = new StringTokenizer(input);

				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			PriorityQueue<result> pq = new PriorityQueue<result>();
			ry = 0;
			rx = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0 && map[i][j] != -1) {
						find(i, j, map);
						pq.add(new result(ry - i + 1, rx - j + 1));
						j=rx;
//						for(int a=0; a<N; a++) {
//							for(int b=0; b<N; b++) {
//								System.out.print(map[a][b]+" ");
//							}System.out.println();
//						}
					}
				}
			}
			System.out.print("#" + tc + " " + pq.size() + " ");
			while (!pq.isEmpty()) {
				result r = pq.poll();
				System.out.print(r.y + " " + r.x + " ");
			}

			System.out.println();

		}
	}

	public static void find(int y, int x, int[][] map) {
		ry = y;
		rx = x;

		for (int i = y; i < N; i++) {
			if (map[i][x] == 0) {
				ry = i - 1;
				break;
			}
			for (int j = x; j < N; j++) {
				if (map[i][j] == 0) {
					rx = j - 1;
					break;
				}
				map[i][j] = -1;
			}
		}
	}

}
