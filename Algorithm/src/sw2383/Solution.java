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
						stair[sIdx] = new Position(i, j, 0, map[i][j]);
				}
			}
			ans = Integer.MAX_VALUE;
			dfs(new int[people.size()], 0);

			System.out.println("#" + tc + " " + ans);
		}
	}

	static class ready {
		int depth;
		int target;

		public ready(int depth, int target) {
			this.depth = depth;
			this.target = target;
		}

	}

	static int ans;
	static List<Position> people;

	static void go(int[] result) { // 목적지도 알아야함.
		ready K[] = new ready[result.length];
		for (int i = 0; i < result.length; i++) {
			K[i] = new ready(
					Math.abs(people.get(i).y - stair[result[i]].y) + Math.abs(people.get(i).x - stair[result[i]].x),
					result[i]);
		}

		List<Integer> stairA = new LinkedList<>();
		List<Integer> stairB = new LinkedList<>();

		Queue<Integer> qA = new LinkedList<>();
		Queue<Integer> qB = new LinkedList<>();
		int cnt = 0;
		while (true) {

			boolean finishChk = true;
			for (int i = 0; i < K.length; i++) {
				if (K[i] != null) {
					finishChk = false;
					break;
				}
			}
			if (finishChk && stairA.size()!=0 && stairB.size()!=0 && qA.isEmpty() && qB.isEmpty()) {
				ans = Math.min(ans, cnt);
				break;
			}
			cnt++;
			
			
			if (!stairA.isEmpty()) {
				for (int p : stairA) {
					
					System.out.println(p);
					p-=1;
					if (p == 0) {
						stairA.remove(p);
					}
				}
			}
			if (stairB.size()!=0) {
				for (Iterator<Integer> it = stairB.iterator() ; it.hasNext() ;) {
					int p = it.next();
					p--;
					if (p == 0) {
						stairB.remove(p);
					}
				}
			}
			//// 계단위 사람 체크하고 계단으로 보냄

			if (stairA.size() < 3 && !qA.isEmpty()) {

				while (stairA.size() < 3) {
					stairA.add(qA.poll());
				}
			}

			if (stairB.size() < 3 && !qB.isEmpty()) {

				while (stairB.size() < 3) {
					stairB.add(qB.poll());
				}
			}

			// 대기큐

			for (int i = 0; i < result.length; i++) {
				if (K[i] == null) // 계단 도착한놈이면컨티뉴
					continue;
				ready curK = K[i];
				int targetPosition = curK.depth;
				if (curK.depth == 0) {
					K[i] = null; // 맵에서 지우고

					if (curK.target == 0)
						qA.add(stair[targetPosition].depth);
					else if (curK.target == 1)
						qB.add(stair[targetPosition].depth);

					/// 계단부분
				} else
					K[i] = new ready(curK.depth - 1, curK.target);
			}

		}
	}

	static Position stair[];

	static void dfs(int[] result, int idx) {

		if (idx == result.length) {
			go(result);

			return;
		}

		result[idx] = 0;
		dfs(result, idx + 1);
		result[idx] = 1;
		dfs(result, idx + 1);

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
