package jo1863;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	static int[] rank;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		rank = new int[n+1];
		set();
		for (int i = 0; i < m; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		Set<Integer> h = new HashSet<>();
		for(int i=1; i<n+1; i++) {
			h.add(find(i));
		}
		System.out.println(h.size());
	}

	static void set() {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	static int find(int a) {
		if (parent[a] == a) {
			return a;
		} else {
			parent[a] = find(parent[a]);
			return parent[a];
		}

	}

	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (rank[pa] > rank[pb]) {
			parent[pb] = pa;
		} else {

			parent[pa] = pb;

			if (rank[pa] == rank[pb]) {
				rank[pb]++;
			}
		}

	}
}
