package sw2382;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_2 {

	static class Item implements Comparable<Item> {
		int size;
		int dir;
		int y;
		int x;

		public Item(int size, int dir, int y, int x) {
			this.size = size;
			this.dir = dir;
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(Item o) {
			// TODO Auto-generated method stub
			return this.size - o.size;
		}
	}

	static Item[][] map;
	static int ans;
	static int N, M, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 맵크기
			M = Integer.parseInt(st.nextToken()); // 시간
			K = Integer.parseInt(st.nextToken()); // 미생물 수
			map = new Item[N][N];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int size = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				map[y][x] = new Item(size, dir, y, x);
			}

			ans = 0;

			for (int i = 0; i < M; i++) { // 하루

				nextMap = new Item[N][N];
				list = new ArrayList<>();
				for (int y = 0; y < N; y++) {
					for (int x = 0; x < N; x++) {

						if (map[y][x] != null) {
							go(y, x);
						}
					}
					// 세방향이상에서 오는거 체크해줘야함
				}
				list.sort(null);
				
				move();

				map = nextMap.clone();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != null) {
						ans += map[i][j].size;
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
//			for (int i = 0; i < N; i++)
//				System.out.println(Arrays.toString(mapNum[i]));
		}
	}

	/// sumchk 에 고유넘버를 부여하고
	// 해당 넘버에서 중복이 일어나면
	// 해당 넘버의 리스트형 배열에 넣는다.
	// 다돌고 끝나고 리스트가 비어있지 않으면 비교하며 처리
	static List<Item> list;
	static Item[][] nextMap;
	static int dx[] = { 0, 0, 0, -1, 1 };
	static int dy[] = { 0, -1, 1, 0, 0 };

	static boolean ChkBound(int y, int x) {
		return y == 0 || x == 0 || y == N - 1 || x == N - 1;
	}

	static void go(int y, int x) { // 상: 1, 하: 2, 좌: 3, 우: 4;

		Item item = map[y][x];
		int dir = item.dir;
		int size = item.size;

		int nextY = y + dy[dir];
		int nextX = x + dx[dir];

		if (ChkBound(nextY, nextX)) { // 다음 좌표가 경계일때는 겹치는거 생각할필요 없음
			if (dir == 1) {
				dir = 2;
			} else if (dir == 2) {
				dir = 1;
			} else if (dir == 3) {
				dir = 4;
			} else if (dir == 4) {
				dir = 3;
			}
			size = Math.round(size / 2);

//			if (size == 0) // 사이즈 0되면 죽음
//				return;

			nextMap[nextY][nextX] = new Item(size, dir, nextY, nextX);
			return;
		}

		list.add(new Item(size, dir, nextY, nextX));
		/// 이동
		return;
	}

	static void move() {

		for (Item item : list) {

			int y = item.y;
			int x = item.x;

			if (nextMap[y][x] != null) {
				int size = nextMap[y][x].size + item.size;
				nextMap[y][x] = new Item(size, item.dir, y, x);
			} else
				nextMap[y][x] = item;
		}
	}
}
