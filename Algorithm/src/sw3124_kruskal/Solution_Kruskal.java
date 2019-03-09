package sw3124_kruskal; // 트리셋으로 해보자

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_Kruskal {
	static int[] parents;
	static int[] rank;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int V = sc.nextInt();
			int E = sc.nextInt();
			int[][] edges = new int[E][3];
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				edges[i][0] = a;
				edges[i][1] = b;
				edges[i][2] = c;
			}
			parents = new int[V + 1];
			rank = new int[V + 1];
			// 간선 배열 정렬
//			for (int i = 0; i < E; i++) {
//				int minIdx = i;
//				for (int j = i; j < E; j++) {
//					if (edges[j][2] < edges[minIdx][2])
//						minIdx = j;
//				}
//				int[] tmp = edges[minIdx];
//				edges[minIdx] = edges[i];
//				edges[i] = tmp;
//			}

			Arrays.sort(edges, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[2] < o2[2] ? -1 : 1;
				}
			});

			for (int i = 1; i < V + 1; i++)
				make_set(i);

			long result = 0;
			int cnt = 0;
			for (int i = 0; i < E; i++) {

				if (cnt == V - 1) { // 정점 숫자 -1
					break;
				}
				// 간선배열정보를 탐색하면서, 시작-끝 정점이 속한 집합을 얻어와서
				int a = findSet(edges[i][0]);
				int b = findSet(edges[i][1]);

				if (a == b)
					continue;
				// 서로 다른 집합(아직 연결되지 않은 정점) 이라면
				if (a != b) {
					// union
					union(a, b);
					// 가중치 누적
					result += edges[i][2];
					cnt++;
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}

	static void make_set(int x) {
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

	static void union(int x, int y) {
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
