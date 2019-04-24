package bj17135_캐슬디펜스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static List<Node> originList;
	static int N, M;

	static int D;
	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(TC3));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		D = Integer.parseInt(st.nextToken());

		originList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int k = Integer.parseInt(st.nextToken());
				map[i][j] = k;
				if (k == 1) {
					originList.add(new Node(i, j));
				}
			}
		}
		answer = 0;
		combi(new int[3], 0, 0);
		System.out.println(answer);

	}

	static int answer;

	static void combi(int[] arr, int idx, int x) {
		if (idx == 3) {
//			System.out.println(Arrays.toString(arr));
			answer = Math.max(go(arr), answer);
			return;
		}

		if (x == M) {
			return;
		}

		arr[idx] = x;
		combi(arr, idx + 1, x + 1);
		combi(arr, idx, x + 1);
	}

	static int go(int[] x) {

		int[][] tmpMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			tmpMap[i] = map[i].clone();
		}

		List<Node> list = new ArrayList<>();
		list.addAll(originList);
		int result = 0;

		Node[] targetList = new Node[3];

		for (int y = N; y > 0; y--) {
			for (int i = 0; i < 3; i++) {
//				System.out.println("사수위치 : " + y+" "+x[i]);
				int curD = D;
				int curX = M;

				for (Node p : list) {
					int pD = (Math.abs(x[i] - p.x) + Math.abs(y - p.y));
					if (y > p.y && pD <= curD) {
						if (pD == curD && p.x >= curX) {
							continue;
						}
						curD = pD;
						curX = p.x;
						targetList[i] = p;
					}

				}
			}


			for (int i = 0; i < 3; i++) {
				if (targetList[i] != null) {
					int targetY = targetList[i].y;
					int targetX = targetList[i].x;

					for (Node target : list) {
						if (target.y == targetY && target.x == targetX) {
							result++;
							list.remove(target);
							tmpMap[targetY][targetX] = 0;

							if (list.size() == 0)
								return result;
							break;
						}
					}
				}
			}
//			System.out.println();
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(tmpMap[i]));
//			}
		}

		return result;
	}

	static String TC1 = "5 5 1\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n"
			+ "1 1 1 1 1";
	static String TC2 = "5 5 1\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "1 1 1 1 1\r\n"
			+ "0 0 0 0 0";
	static String TC3 = "5 5 5\r\n" + "1 1 1 1 1\r\n" + "1 1 1 1 1\r\n" + "1 1 1 1 1\r\n" + "1 1 1 1 1\r\n"
			+ "1 1 1 1 1";

}
