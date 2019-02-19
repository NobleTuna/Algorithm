package sw3124_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static class info implements Comparable<info> {
		int cost;
		int next;

		public info(int cost, int next) {
			this.cost = cost;
			this.next = next;
		}

		public int compareTo(info o) {
			if (this.cost > o.cost)
				return 1;
			else if (this.cost < o.cost)
				return -1;
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			PriorityQueue<info> q = new PriorityQueue<info>();
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			PriorityQueue<info>[] arr = new PriorityQueue[V + 1];
			for (int i = 0; i < V + 1; i++) {
				arr[i] = new PriorityQueue<info>();
			}
			for (int i = 0; i < E; i++) {
				input = br.readLine();
				st = new StringTokenizer(input);
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				arr[r].add(new info(cost, c));
			}
			long result = 0;

			boolean[] visited = new boolean[V + 1];
			List<Integer> list = new ArrayList<Integer>();
			visited[1] = true;
			list.add(1);
			for (int i = 0; i < V - 1; i++) {
				int min = Integer.MAX_VALUE;
				int K = 0;
				for (int k : list) {
					if (!arr[k].isEmpty()) {
						while (!arr[k].isEmpty() && visited[arr[k].peek().next]) {
							arr[k].poll();
						}
						if (!arr[k].isEmpty() &&!visited[arr[k].peek().next] && min > arr[k].peek().cost) {
							K = k;
						}
					}
				}
				visited[arr[K].peek().next] = true;
				list.add(arr[K].peek().next);
				result += arr[K].peek().cost;
				arr[K].poll();

			}
			System.out.println("#" + tc + " " + result);

		}
	}
}
