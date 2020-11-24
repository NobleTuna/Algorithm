package bj1517_버블소트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int idx;
		int num;
		int order;

		public Node(int idx, int num, int order) {
			this.idx = idx;
			this.num = num;
			this.order = order;
		}
	}

	static int N;
	static Node[] arr;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(TC1));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new Node[N + 1];
		tree = new int[N * 4];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			arr[i] = new Node(i, Integer.parseInt(st.nextToken()), 0);

		Arrays.sort(arr, 1, N + 1, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.num - o2.num;
			}
		});

		arr[0] = new Node(0, 0, 0);

		int idx = 0;
		for (int i = 1; i <= N; i++) {
			if (arr[i].num != arr[i - 1].num)
				idx++;
			arr[i].order = idx;
		}

		Arrays.sort(arr, 1, N + 1, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.idx - o2.idx;
			}
		});

		long ANS = 0;
		for (int i = 1; i <= N; i++) {
			ANS += query(1, N, 1, arr[i].order + 1, N);
//			System.out.println(Arrays.toString(tree));
//			System.out.println(arr[i].order);
			update(1, N, 1, arr[i].order, 1);
		}
		System.out.println(ANS);

	}

	static void update(int left, int right, int idx, int target, int val) {

		if (left > target || right < target)
			return;

		if (left == right) {
			tree[idx] = val;
			return;
		}
		int mid = (left + right) / 2;

		if (target <= mid)
			update(left, mid, idx * 2, target, val);
		else
			update(mid + 1, right, idx * 2 + 1, target, val);

		tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
	}

	static int query(int left, int right, int idx, int start, int end) {

		if (left > end || right < start)
			return 0;

		if (start <= left && right <= end)
			return tree[idx];

		int mid = (left + right) / 2;

		return query(left, mid, idx * 2, start, end) + query(mid + 1, right, idx * 2 + 1, start, end);
	}

	static String TC1 = "3\r\n" + "3 2 1";
}
