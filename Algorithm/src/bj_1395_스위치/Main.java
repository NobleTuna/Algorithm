package bj_1395_스위치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

	static int[] tree;
	static int[] propa;

	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(TC1));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new int[N * 4];
		propa = new int[N * 4];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 0) {
				update(1, N, 1, b, c);
			} else {
				System.out.println(query(1, N, 1, b, c));
			}
		}

	}

	static int query(int left, int right, int idx, int start, int end) {
		propa(idx, left, right);
		if (end < left || right < start)
			return 0;

		if (start <= left && right <= end)
			return tree[idx];

		int mid = (left + right) / 2;

		return query(left, mid, idx * 2, start, end) + query(mid + 1, right, idx * 2 + 1, start, end);
	}

	static void update(int left, int right, int idx, int start, int end) {
		propa(idx, left, right);
		if (end < left || right < start)
			return;

		if (start <= left && right <= end) {
			propa[idx] += 1;
			propa(idx, left, right);
			return;
		}

		int mid = (left + right) / 2;

		update(left, mid, idx * 2, start, end);
		update(mid + 1, right, idx * 2 + 1, start, end);
		tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];

	}

	static void propa(int idx, int left, int right) {

		if (propa[idx] == 0)
			return;

		if (propa[idx] % 2 == 1)
			tree[idx] = right - left + 1 - tree[idx];

		if (left != right) {
			propa[idx * 2] += propa[idx];
			propa[idx * 2 + 1] += propa[idx];
		}
		propa[idx] = 0;

	}

	static String TC1 = "4 5\r\n" + "0 1 2\r\n" + "0 2 4\r\n" + "1 2 3\r\n" + "0 2 4\r\n" + "1 1 4";

}
