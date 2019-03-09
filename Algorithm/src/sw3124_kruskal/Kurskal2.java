package sw3124_kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Kurskal2 {

	static class Edge implements Comparable<Edge> {
		int a;
		int b;
		int value;

		public Edge(int a, int b, int value) {
			this.a = a;
			this.b = b;
			this.value = value;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
	}

	static int V;
	static int E;
	static int[] parent;
	static int[] ranks;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			PriorityQueue<Edge> q = new PriorityQueue<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken()); // 간선정보

			parent = new int[V + 1];
			ranks = new int[V + 1];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				q.add(new Edge(a, b, c));

			}

			for (int i = 0; i < V + 1; i++) { // 초기화
				make(i);
			}
//			while(!q.isEmpty()) {
//				System.out.println(q.poll().value);
//			}

			int cnt = 0;
			long result = 0;

			while (!q.isEmpty()) {
				if (cnt == V - 1)
					break;

				Edge e = q.poll();

				int pa = findP(e.a);
				int pb = findP(e.b);

				if (pa != pb) {
					union(pa, pb);
					result += e.value;
					cnt++;
				}
			}
			
			System.out.println("#"+tc+" "+result);

		}

	}

	static void make(int i) {
		parent[i] = i;
		ranks[i] = 0;
	}

	static int findP(int a) {
		if (parent[a] == a)
			return a;
		else {
			parent[a] = findP(parent[a]);
			return parent[a];
		}
	}

	static void union(int a, int b) {
		int pa = findP(a);
		int pb = findP(b);
		if (ranks[pa] > ranks[pb]) {
			parent[pb] = pa;
		} else {
			parent[pa] = pb;
			if (ranks[pa] == ranks[pb])
				ranks[pb]++;
		}
	}
}
