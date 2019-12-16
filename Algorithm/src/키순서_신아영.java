
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 키순서_신아영 {

	static Set<Integer>[] nodeSet;
	public static int bfs(int v, boolean[] visit, int n, boolean[][] arr) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		int count = 0;
		while (!q.isEmpty()) {
			int temp = q.poll();

			for (int i = 1; i <= n; i++) {
				if (!visit[i] && arr[temp][i]) {
					nodeSet[i].add(v);
					q.add(i);
					visit[i] = true;
					count++;
				}
			}
		}

		return count;
	}

	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = true;
		}
		int result = 0; 
		nodeSet = new Set[n+1];
		int[] count = new int[n+1];
		for(int i=1;i<=n;i++) {
			nodeSet[i] = new HashSet<>();
		}
		for (int i = 1; i <= n; i++) {
			boolean[] visit = new boolean[n + 1];
			count[i] = bfs(i, visit, n, arr);
		}
		
		for(int i=1;i<=n;i++) {
			if(count[i] + nodeSet[i].size() == n-1) 
				result++;
		}

		System.out.println(result);
	}

}
