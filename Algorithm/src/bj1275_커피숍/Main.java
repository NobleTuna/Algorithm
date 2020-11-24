package bj1275_커피숍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

	static long[] tree = new long[100000 * 4];
	static long[] input;
	static int N, Q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(TC1));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		input = new long[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Long.parseLong(st.nextToken());
		}
		init(1, N, 1);

		int x, y, a, tmp;
		long b;
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Long.parseLong(st.nextToken());

			if (y < x) {
				tmp = x;
				x = y;
				y = tmp;
			}

			System.out.println(query(1, N, 1, x, y));
			update(1, N, 1, a, b);
		}

	}

	static long init(int left, int right, int idx) {
		if (left == right) {
			tree[idx] = input[left];
			return tree[idx];
		}
		int mid = (left + right) / 2;
		return tree[idx] = init(left, mid, idx * 2) + init(mid + 1, right, idx * 2 + 1);
	}

	static long query(int left, int right, int idx, int start, int end) {

		if (end < left || right < start)
			return 0;

		if (start <= left && right <= end)
			return tree[idx];

		int mid = (left + right) / 2;
		return query(left, mid, idx * 2, start, end) + query(mid + 1, right, idx * 2 + 1, start, end);
	}

	static void update(int left, int right, int idx, int target, long val) {

		if (target < left || right < target)
			return;

		if (left == right) {
			tree[idx] = val;
			return;
		}
		int mid = (left + right) / 2;

		update(left, mid, idx * 2, target, val);
		update(mid + 1, right, idx * 2 + 1, target, val);
		tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
	}

	static String TC1 = "5 2\r\n" + "1 2 3 4 5\r\n" + "2 3 3 1\r\n" + "3 5 4 1";

	static void printTree() {
		for (int i = 0; i <= 20; i++)
			System.out.print(tree[i] + " ");
		System.out.println();
	}
}
