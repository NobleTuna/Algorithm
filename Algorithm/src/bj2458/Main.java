package bj2458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		rank = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

		}
	}

	static int[] parent;
	static int[] rank;

	static int findParent(int x) {
		if (parent[x] == x)
			return x;
		else
			return findParent(parent[x]);
	}

	static void union(int x, int y) {
		int px = findParent(x);
		int py = findParent(y);

		if (rank[px] > rank[py])
			parent[py] = px;
		else {
			if (rank[px] == rank[py])
				rank[py]++;
			parent[px] = py;
		}
	}

}
