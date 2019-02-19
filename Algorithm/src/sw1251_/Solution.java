package sw1251_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	static class Edge implements Comparable<Edge> {
		int a; // 노드 a
		int b; // 노드 b
		double cost;

		public Edge(int a, int b, double cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.cost > o.cost)
				return 1;
			else if (this.cost < o.cost)
				return -1;

			return 0;
		}
	}

	static double E;
	static double result;
	static int parents[];
	static int rank[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int P[][] = new int[N][2]; // a, b, 좌표입력받
			parents = new int[N];
			rank = new int[N];

			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);

			for (int i = 0; i < N; i++) {
				P[i][0] = Integer.parseInt(st.nextToken());
			}
			input = br.readLine();
			st = new StringTokenizer(input);
			for (int i = 0; i < N; i++) {
				P[i][1] = Integer.parseInt(st.nextToken());
			}

			E = Double.parseDouble(br.readLine());
			result = 0;

			//// 간선개수만큼의 1과 2 사이의 거리 Node 트리셋에 넣어
			// 트리셋 중복처리떄문에 우선순위큐로 변경
			PriorityQueue<Edge> q = new PriorityQueue<Solution.Edge>();

			// P[i][0] = x1, P[i][1] = y2;
			// P[j][0] = x2, P[j][1] = y2;

			int cntEdge = 0; // 간선 숫자 체크
			for (int i = 0; i < N - 1; i++)
				for (int j = i + 1; j < N; j++) {
					double cost = (Math.pow(P[i][0] - P[j][0], 2) + Math.pow(P[i][1] - P[j][1], 2)) * E;
					q.add(new Edge(i, j, cost));
					cntEdge++;
				}
			
//			Iterator<Edge> t = tree.iterator(); // 트리셋 선형화

			for (int i = 0; i < N; i++) { // 노드 초기화
				makeSet(i);
			}

			double result = 0;
			int cnt = 0; // 현재 유니온한 간선 숫자 체크용

			while (!q.isEmpty()) {

				if (cnt == N - 1)
					break;

				Edge k = q.poll();
				int a = k.a; // 노드 a
				int b = k.b; // 노드 b

				int pa = findSet(a); // a의 그룹탐색
				int pb = findSet(b); // b의 그룹탐색

				if (pa != pb) {
					unionSet(pa, pb);
					result += k.cost;
					cnt++;
				}
			}

			System.out.println("#" + tc + " " + Math.round(result));

		}

	}

	static void makeSet(int x) {
		parents[x] = x;
		rank[x] = 0;
	}

	static int findSet(int x) {
		if (x == parents[x])
			return x;
		else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}

	static void unionSet(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (rank[px] > rank[py]) {
			parents[py] = px;
		} else {
			parents[px] = py;
			if (rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}
}
