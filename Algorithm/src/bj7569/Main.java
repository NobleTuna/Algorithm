package bj7569;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Position {
		int i;
		int j;
		int k;
		int value;

		public Position(int i, int j, int k, int value) {
			this.i = i;
			this.j = j;
			this.k = k;
			this.value = value;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); // 가로
		N = sc.nextInt(); // 세로
		H = sc.nextInt(); // 높이

		q = new LinkedList<Position>();

		box = new int[H][N][M];

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					box[h][i][j] = sc.nextInt();
					if (box[h][i][j] == 1) {
						q.add(new Position(h, i, j, 0));
					}
				}
			}
		}
		if (q.isEmpty()) {
			System.out.println(0);
			sc.close();
			return;
		}

		ans = 0;
		
		bfs();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (box[i][j][k] == 0) {
						System.out.print(-1);
						sc.close();
						return;
					}
				}
			}
		}

		System.out.println(ans);
//		for(int i=0; i<H; i++) {
//			for(int j=0; j<N; j++) {
//				for(int k=0; k<M; k++) {
//					System.out.print(box[i][j][k]+" ");
//				}System.out.println();
//			}System.out.println();System.out.println();
//		}
		sc.close();
	}

	static int[][][] box;
	static Queue<Position> q;
	static int dx[] = { 0, 0, 0, 0, 1, -1 };
	static int dy[] = { 0, 0, 1, -1, 0, 0 };
	static int dz[] = { 1, -1, 0, 0, 0, 0 };
	static int ans;

	static boolean outRange(int z, int y, int x) {
		return (z < 0 || y < 0 || x < 0 || z >= H || y >= N || x >= M);
	}

	static int H, N, M; // 높이 H, 세로 N, 가로 M

	static void bfs() {

		while (!q.isEmpty()) {

			Position P = q.poll();

			int z = P.i;
			int y = P.j;
			int x = P.k;
			ans = Math.max(ans, P.value);

			for (int d = 0; d < 6; d++) {

				int cz = dz[d] + z;
				int cy = dy[d] + y;
				int cx = dx[d] + x;

				if (outRange(cz, cy, cx) || box[cz][cy][cx] != 0)
					continue;

				box[cz][cy][cx] = 1;

				q.add(new Position(cz, cy, cx, P.value + 1));
			}
		}
	}

}
