package bj7469_k번째수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int num;
		int idx;
		int order;

		public Node(int num, int idx, int order) {
			this.num = num;
			this.idx = idx;
			this.order = order;
		}
	}

	static int[] tree = new int[100001 * 4];
	static int[] orderToNum;
	static Node[] nodes;

	static int N, M, startNode;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(TC1));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nodes = new Node[N + 1];
		orderToNum = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nodes[i] = new Node(Integer.parseInt(st.nextToken()), i, 0);
		}

		Arrays.sort(nodes, 1, N + 1, new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return o1.num - o2.num;
			}
		});

		for (int i = 1; i <= N; i++) {
			nodes[i].order = i;
			orderToNum[i] = nodes[i].num;
		}
		Arrays.sort(nodes, 1, N + 1, new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return o1.idx - o2.idx;
			}
		});

		startNode = 1;
		while (startNode < N)
			startNode *= 2;
		Arrays.fill(tree, 0);
		long ANS = 0;
		for (int q = 0; q < M; q++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for (int i = a; i <= b; i++)
				update(nodes[i].order);

//			for (int i = 0; i < startNode + N; i++)
//				System.out.print(tree[i] + " ");
//			System.out.println();

			System.out.println(orderToNum[query(c)]);
			Arrays.fill(tree, 0);
		}
//		System.out.println(ANS);
	}

	static void update(int pos) {
		pos += startNode - 1;
		tree[pos]++;
		pos /= 2;
		while (pos > 0) {
			tree[pos] = tree[pos * 2] + tree[pos * 2 + 1];
			pos /= 2;
		}
	}

	static int query(int k) {
		int node = 1;
		while (node < startNode) {
			if (tree[node * 2] >= k) {
//				System.out.println("left");
				node = node * 2;
			} else {
//				System.out.println("right");
				k -= tree[node * 2];
				node = node * 2 + 1;
			}
//			System.out.println("node : " + node + " k : " + k);
		}
//		System.out.println("query result : :" + node);
		return node - startNode +1;
	}

	static String TC1 = "7 3\r\n" + "1 5 2 6 3 7 4\r\n" + "2 5 3\r\n" + "4 4 1\r\n" + "1 7 3";

}
