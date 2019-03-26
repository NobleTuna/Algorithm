package jo1545_bitmask_returnHandler;

import java.util.Scanner;

public class Main_memo {
	
	//TSP 전형적인 여행자경로문제. 출발점에서 모든 정점을 찍고 다시 출발점으로 돌아오는 문제
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] adj = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				adj[i][j] = sc.nextInt();
		}
		memo = new int[1 << N][N];
		System.out.println(dfs(adj, 0, 0, 0));
	}
	static int[][] memo;
	static int dfs(int[][] adj, int status, int idx, int current) {
		if( idx == adj.length- 1 ) {
			if( adj[current][0] == 0 )
				return 987654321;
			else
				return adj[current][0];
		}
		if(memo[status][current] != 0)
			return memo[status][current];
		int opt = 987654321;
		for(int i = 1; i < adj.length; i++) {
			int mask = 1 << i;
			if( (mask & status) == 0 && adj[current][i] != 0 ) {
				int tmp = dfs(adj, status | mask, idx+1, i) + adj[current][i];
				opt = Math.min(opt, tmp);
			}
		}
		memo[status][current] = opt;
		return opt;
	}
}










