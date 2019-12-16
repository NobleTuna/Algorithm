package jo1350;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] adj = new int[M][3];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int v = sc.nextInt();

			adj[i][0] = a;
			adj[i][1] = b;
			adj[i][2] = v;
		}

		Arrays.sort(adj, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[2] - o1[2];
			}
		});

		parents = new int[N + 1];

		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

		ranks = new int[N + 1];
		int ans = 0;

		for (int i = 0; i < M; i++) {
			int a = adj[i][0];
			int b = adj[i][1];

			if (findP(a) != findP(b)) {
				union(a, b);
				ans += adj[i][2];
			}
		}
		System.out.println(ans);
	}

	static int parents[];
	static int ranks[];

	static int findP(int a) {
		if (parents[a] == a)
			return a;
		else
			return findP(parents[a]);
	}

	static void union(int a, int b) {
		int pa = findP(a);
		int pb = findP(b);

		if (ranks[pa] > ranks[pb])
			parents[pb] = pa;
		else {
			if (ranks[pa] == ranks[pb])
				ranks[pb]++;
			parents[pa] = pb;
		}
	}

}
