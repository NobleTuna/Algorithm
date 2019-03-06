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
//		String input = br.readLine();
//		StringTokenizer st = new StringTokenizer(input);
		M = sc.nextInt(); // 가로
		N = sc.nextInt(); // 세로
		H = sc.nextInt(); // 높이

		Queue<Position> q = new LinkedList<>();

		int box[][][] = new int[H][N][M];
		boolean visited[][][] = new boolean[H][N][M];

		boolean isFull = true;

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
//				input = br.readLine();
//				st = new StringTokenizer(input);
				for (int j = 0; j < M; j++) {
					box[h][i][j] = sc.nextInt();
					if (box[h][i][j] == 0)
						isFull = false;

					if (box[h][i][j] == 1) {
						visited[h][i][j] = true;
						q.add(new Position(h, i, j, 0));
					}
				}
			}
		}
		System.out.println("1ck");

		if (isFull) {
			System.out.println(0);
			return;
		}

		ans = 0;
		bfs(q, box, visited);

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (box[i][j][k] == 0) {
						System.out.print(-1);
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

	}

	static int dx[] = { 0, 0, 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 0, 0, 1, -1 };
	static int dz[] = { 1, -1, 0, 0, 0, 0 };
	static int ans;

	static boolean outRange(int z, int y, int x) {
		return (z < 0 || y < 0 || x < 0 || z >= H || y >= N || x >= M);
	}

	static int H, N, M; // 높이 H, 세로 N, 가로 M

	static void bfs(Queue<Position> q, int[][][] map, boolean[][][] visited) {

		while (!q.isEmpty()) {

			Position P = q.poll();

			int z = P.i;
			int y = P.j;
			int x = P.k;
			ans = P.value;

			for (int d = 0; d < 6; d++) {

				int cz = dz[d] + z;
				int cy = dy[d] + y;
				int cx = dx[d] + x;

				if (outRange(cz, cy, cx) || visited[cz][cy][cx] || map[cz][cy][cx] != 0)
					continue;

				visited[cz][cy][cx] = true;
				map[cz][cy][cx] = 1;

				q.add(new Position(cz, cy, cx, P.value + 1));
			}
		}
	}

}
