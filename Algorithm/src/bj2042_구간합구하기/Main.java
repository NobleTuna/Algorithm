package bj2042_구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

	static long[] tree = new long[4000001];

	static int N, startNode, endNode;
	static int M, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(TC1));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N * 4; i++)
			tree[i] = 0;

		startNode = 1;
		while (true) {
			if (startNode > N)
				break;
			startNode *= 2;
		}
		endNode = startNode + N - 1;
//		System.out.println(startNode);

		for (int i = startNode; i < startNode + N; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}

		for (int i = startNode - 1; i > 0; i--)
			tree[i] = tree[i * 2] + tree[i * 2 + 1];

//		System.out.println(search(1, 5));

		for (int i = 0; i < M + K; i++) {

			st = new StringTokenizer(br.readLine());

			int Q = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			switch (Q) {
			case 1:
				long c = Long.parseLong(st.nextToken());
				update(b, c);

				break;
			case 2:
				int cc = Integer.parseInt(st.nextToken());
				System.out.println(search(b, cc));

				break;
			default:
				break;
			}

		}
	}

	static public long search(int a, int b) {
		a += startNode - 1;
		b += startNode - 1;

		long sum = 0;

		while (a < b) {
			if (a % 2 == 1) {
				sum += tree[a];
				a++;
			}
			if (b % 2 == 0) {
				sum += tree[b];
				b--;
			}
			a /= 2;
			b /= 2;
		}
		if (a == b)
			sum += tree[a];

		return sum;
	}

	static public void update(int idx, long c) {

		idx = idx + startNode - 1;

		tree[idx] = c;

		idx /= 2;
		while (true) {
			if (idx <= 0)
				break;

			tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
			idx /= 2;
		}

	}

	static String TC1 = "5 2 2\r\n" + "1\r\n" + "2\r\n" + "3\r\n" + "4\r\n" + "5\r\n" + "1 3 6\r\n" + "2 2 5\r\n"
			+ "1 5 2\r\n" + "2 3 5";

}
