package bj2042_구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;

	static int tree[] = new int[1000001 * 4];
	static int input[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		input = new int[N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			input[i] = Integer.parseInt(st.nextToken());
		}

		init(1, N, 1);
	}

	static int init(int left, int right, int node) {
		if (left == right)
			tree[node] = input[left];

		int mid = (left + right) / 2;

		return tree[node] = init(left, mid, node * 2) + init(mid, right, node * 2 + 1);
	}
}
