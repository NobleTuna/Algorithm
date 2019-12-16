package bj16236; // 아기상어

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

	static int N;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sX = j;
					sY = i;
				}
			}
		}
		ans = 0;
		size = 2;
		map[sY][sX] = 0; // 상어위치 초기화
		while (true) { // 시작

			tD = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) { // 먹이탐색후 먹을 수 있으면 거리탐색
					if (map[i][j] != 0 && map[i][j] < size) {
						// serchFood 최단거리탐색
						searchFood(i, j);
					}
				}
			}
			if (tD == Integer.MAX_VALUE)
				break;

			ans += tD;
			map[sY][sX] = 0; // 상어위치 초기화
			map[targetY][targetX] = 0;
			sX = targetX;
			sY = targetY;
			amountEat++;
			if (amountEat == size) {
				size++;
				amountEat = 0;
			}

//			System.out.println(targetY + " " + targetX + " " + tD);
		}
		System.out.println(ans);
	}

	static int ans;
	static int size; // 상어사이즈
	static int amountEat; // 현재 먹은양
	static int sX, sY; // 현재상어위치
	static int targetX, targetY; // 현재까지 목표로한 타겟위치
	static int tD; // 현재까지의 타겟과의 거리

	static int[] dx = { 0, -1, 1, 0 };
	static int[] dy = { 1, 0, 0, -1 };

	static class M {
		int y;
		int x;
		int distance;

		public M(int y, int x, int distance) {
			this.y = y;
			this.x = x;
			this.distance = distance;
		}
	}

	static void searchFood(int y, int x) { // 목표로 할 먹이좌표

		boolean vistied[][] = new boolean[N][N];

		Queue<M> q = new LinkedList<>();

		vistied[sY][sX] = true;
		q.add(new M(sY, sX, 0)); // 상어위치넣고 출발

		while (!q.isEmpty()) {

			M curM = q.poll();

			int mx = curM.x;
			int my = curM.y;

			if (mx == x && my == y) {
				tD = curM.distance;
				targetX = x;
				targetY = y;
				return;
			}
			for (int d = 0; d < 4; d++) {

				int nx = mx + dx[d];
				int ny = my + dy[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N || vistied[ny][nx] || map[ny][nx] > size)
					continue;

				vistied[ny][nx] = true;
				q.add(new M(ny, nx, curM.distance + 1));
			}
		}
	}
}
