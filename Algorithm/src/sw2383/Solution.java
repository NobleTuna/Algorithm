package sw2383;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static class Position {
		int y;
		int x;
		int target;
		int depth;

		public Position(int y, int x, int target, int depth) {
			this.y = y;
			this.x = x;
			this.target = target;
			this.depth = depth;
		}

	}

	static int map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(source));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			people = new ArrayList<>();
			stair = new Position[2];
			int sIdx = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						people.add(new Position(i, j, 0, 0));
					else if (map[i][j] != 0)
						stair[sIdx++] = new Position(i, j, 0, map[i][j]);
				}
			}
			ans = Integer.MAX_VALUE;
			///
			dfs(new boolean[people.size()], 0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static class PP {
		int len;
		int target;

		public PP(int len, int target) {
			this.len = len;
			this.target = target;
		}
	}

	static int ans;
	static List<Position> people;

	static Position stair[];

	static void go(PP[] run) {

		Queue<Integer> stairA = new LinkedList<>();
		Queue<Integer> stairB = new LinkedList<>();
		int depthA = stair[0].depth;
		int depthB = stair[1].depth;

		Queue<Integer> waitA = new LinkedList<>();
		Queue<Integer> waitB = new LinkedList<>();
		int cnt = 0;
		int fieldPeople = run.length;

		// 먼저 내려가는놈들을 체크
		while (true) {

			if (fieldPeople == 0 && stairA.isEmpty() && stairB.isEmpty() && waitA.isEmpty() && waitB.isEmpty()) {
				ans = Math.min(ans, cnt);
				return;
			}

			cnt++;
			if (!stairA.isEmpty()) {
				int tmp = stairA.size();
				for (int i = 0; i < tmp; i++) {
					int q = stairA.poll();
					q--;
					if (q == 0)
						continue;
					else
						stairA.add(q);
				}
			}
			if (!stairB.isEmpty()) {
				int tmp = stairB.size();
				for (int i = 0; i < tmp; i++) {
					int q = stairB.poll();
					q--;
					if (q == 0)
						continue;
					else
						stairB.add(q);
				}
			}

			/// 그담 대기중인놈들을 내려보냄
			if (!waitA.isEmpty()) {
				while (stairA.size() < 3 && !waitA.isEmpty()) {
					stairA.add(waitA.poll());
				}
			}
			if (!waitB.isEmpty()) {
				while (stairB.size() < 3 && !waitB.isEmpty()) {
					stairB.add(waitB.poll());
				}
			}

			// 다음 나머지얘들을 움직이고 웨이트에 넣음
			if (fieldPeople == 0)
				continue;
			for (int i = 0; i < run.length; i++) {
				if (run[i] == null)
					continue;
				else {
					if (run[i].len - 1 == 0) {

						if (run[i].target == 0) {
							waitA.add(depthA);
						} else if (run[i].target == 1) {
							waitB.add(depthB);
						}
						run[i] = null;
						fieldPeople--;
					} else {
						run[i] = new PP(run[i].len - 1, run[i].target);
					}
				}
			}
		}
	}

	static void dfs(boolean[] chk, int idx) {

		PP[] run = new PP[chk.length];

		if (idx == chk.length) {
			for (int i = 0; i < chk.length; i++) {

				Position P = people.get(i);
				int y = P.y;
				int x = P.x;

				if (chk[i]) // 0번계단
				{
					run[i] = new PP(Math.abs(P.y - stair[0].y) + Math.abs(P.x - stair[0].x), 0);

				} else { // 1번계단
					run[i] = new PP(Math.abs(P.y - stair[1].y) + Math.abs(P.x - stair[1].x), 1);
				}
			}
			// 거리랑 타겟을 보내야함? 넹
			go(run);
			return;
		}

		chk[idx] = true;
		dfs(chk, idx + 1);
		chk[idx] = false;
		dfs(chk, idx + 1);

	}

	static String source = "10\r\n" + "5\r\n" + "0 1 1 0 0\r\n" + "0 0 1 0 3\r\n" + "0 1 0 1 0\r\n" + "0 0 0 0 0\r\n"
			+ "1 0 5 0 0\r\n" + "5\r\n" + "0 0 1 1 0\r\n" + "0 0 1 0 2\r\n" + "0 0 0 1 0\r\n" + "0 1 0 0 0\r\n"
			+ "1 0 5 0 0\r\n" + "6\r\n" + "0 0 0 1 0 0\r\n" + "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0\r\n" + "0 1 0 0 0 0\r\n"
			+ "2 0 1 0 0 0\r\n" + "0 0 2 0 0 0\r\n" + "6\r\n" + "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0\r\n" + "1 0 0 0 0 0\r\n" + "0 0 0 2 0 4\r\n" + "7\r\n"
			+ "0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 4\r\n" + "0 0 0 0 1 0 0\r\n" + "1 0 0 1 0 0 0\r\n"
			+ "0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0\r\n" + "0 2 0 0 0 0 0\r\n" + "7\r\n" + "0 0 0 0 0 0 0\r\n"
			+ "7 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0\r\n"
			+ "2 0 0 0 0 1 0\r\n" + "0 0 0 0 0 0 0\r\n" + "8\r\n" + "0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 2\r\n"
			+ "0 0 0 0 0 0 0 0\r\n" + "2 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 1 0 0\r\n" + "0 0 0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0 1 0\r\n" + "0 0 0 0 1 0 0 0\r\n" + "8\r\n" + "3 0 0 0 0 0 5 0\r\n" + "0 0 0 0 0 0 0 0\r\n"
			+ "1 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0\r\n" + "1 0 1 1 0 0 0 0\r\n" + "0 0 0 0 0 0 1 0\r\n"
			+ "0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0\r\n" + "9\r\n" + "0 0 0 1 0 0 0 0 0\r\n"
			+ "0 1 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 8\r\n" + "7 0 0 0 0 1 0 0 0\r\n" + "0 0 0 0 0 1 1 0 0\r\n"
			+ "0 0 0 0 0 0 0 0 0\r\n" + "1 0 0 0 0 1 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0\r\n"
			+ "10\r\n" + "0 0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 1 0 0 0 0 0\r\n" + "0 0 1 0 0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0\r\n" + "3 0 1 0 1 0 0 0 0 2\r\n"
			+ "1 1 0 0 1 0 1 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0";

}
