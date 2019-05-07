package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner("7 8\r\n" + "1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7");
		List<String> list = new ArrayList<String>(){{add("aaa");}};
		int V = sc.nextInt();// 정점
		int E = sc.nextInt(); // 간선
		int[][] adj = new int[V + 1][V + 1]; // 정점의 번호가 1번부터 7번.
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a][b] = 1;
			adj[b][a] = 1;
		}

		Queue<Integer> Q = new LinkedList<Integer>();
		boolean visited[] = new boolean[E];
		Q.add(1);
		visited[1] = true;

		while (!Q.isEmpty()) {

			int v = Q.poll();
			System.out.println(v);
			
			for (int i = 0; i < adj.length; i++) {
				if (adj[v][i] == 1 && !visited[i]) {
					Q.add(i);
					visited[i] = true;
				}
			}

		}
	}

}
