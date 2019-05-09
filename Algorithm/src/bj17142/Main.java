package bj17142;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	static int N;
	static int M;
	static int map[][];
	static int cnt;

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static List<Node> list = new ArrayList<>();
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		cnt = 0;
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					list.add(new Node(i, j));
				} else if (map[i][j] == 0)
					cnt++;
			}
		}

		ans = Integer.MAX_VALUE;

		combi(new boolean[list.size()], 0, 0);

		System.out.println((ans == Integer.MAX_VALUE) ? -1 : ans);
	}

	static void combi(boolean[] check, int idx, int count) {

		if (count == M) {

			int arr[] = new int[M];
			int id = 0;
			for (int i = 0; i < check.length; i++) {
				if (check[i])
					arr[id++] = i;
			}
//			System.out.println(Arrays.toString(arr));
			search(arr);

			return;
		}

		if (idx == check.length) {

			return;
		}

		check[idx] = true;
		combi(check, idx + 1, count + 1);
		check[idx] = false;
		combi(check, idx + 1, count);

	}

	static public void search(int[] arr) {

		int[][] newMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			newMap[i] = map[i].clone();
		}

		Queue<Node> q = new LinkedList<>();

		for (int i = 0; i < arr.length; i++) {
			Node node = list.get(arr[i]);
			newMap[node.y][node.x] = 9;
			q.add(node);
		}

//		for(int i=0; i<N; i++)
//			System.out.println(Arrays.toString(newMap[i]));

//		System.out.println("cnt : "+ cnt);
//		System.out.println();
		int thisCnt = 0;
		int result = 0;

		while (!q.isEmpty()) {

			if (cnt == thisCnt) {
//				System.out.println("resutl :" + result);
//				for (int k : arr) {
//					System.out.println(list.get(k).y + " " + list.get(k).x);
//				}
				ans = Math.min(result, ans);
				return;
			}

			result++;
			if (result >= ans)
				return;

			int T = q.size();

			for (int t = 0; t < T; t++) {
				Node node = q.poll();
				int y = node.y;
				int x = node.x;
				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];

					if (outRange(ny, nx) || newMap[ny][nx] == 1)
						continue;

					if (newMap[ny][nx] == 0)
						thisCnt++;

					newMap[ny][nx] = 1;

					q.add(new Node(ny, nx));
				}
			}
		}

//		if (cnt == thisCnt) {
//
//			System.out.println();
//			ans = Math.min(result, ans);
//		}
//
//		return;
	}

	static boolean outRange(int i, int j) {
		return i < 0 || j < 0 || i >= N || j >= N;
	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
}
