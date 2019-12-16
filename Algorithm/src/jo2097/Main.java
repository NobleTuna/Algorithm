package jo2097;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Item {
		int n;
		String node;
		int size;

		public Item(int n, String next, int size) {
			this.n = n;
			this.node = next;
			this.size = size;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int map[][] = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] chk = new int[N + 1];

		for (int i = 2; i < chk.length; i++) {
			chk[i] = Integer.MAX_VALUE;
		}
		String result2 = null;
		Queue<Item> q = new LinkedList<>();

		q.add(new Item(1, "1", 0));

		while (!q.isEmpty()) {

			Item item = q.poll();

			int size = item.size;
			int S = item.n;
			String before = item.node;
			
//			System.out.println(before);
			if (S == M) {
				if (chk[M] >= size)
					result2 = before;
				continue;
			}

			for (int i = 1; i < map[S].length; i++) {
				if (i == S)
					continue;
				if (chk[i] > size + map[S][i]) {
					chk[i] = size + map[S][i];
					String nodeString = before + " " + i;
					q.add(new Item(i, nodeString, chk[i]));
				}
			}
		}
		
		System.out.println(chk[M]);
		System.out.println(result2);
	}
}
