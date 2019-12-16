package sw1247;

import java.util.Scanner;

public class SolutionT {
    static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            ans = Integer.MAX_VALUE;
			int N = sc.nextInt();
			int cx = sc.nextInt();
			int cy = sc.nextInt();
			int hx = sc.nextInt();
			int hy = sc.nextInt();
			int[][] customers = new int[N][2];
			for(int i = 0; i < N; i++) {
				customers[i][0] = sc.nextInt();
				customers[i][1] = sc.nextInt();
			}
			boolean[] visited = new boolean[N];
			dfs(customers, visited, 0, 0, cx, cy, hx, hy);
			System.out.println("#" + tc + " " + ans);
		}
	}

	
	static void dfs(int[][] customers, boolean[] visited, int cnt, int dist, int lastx, int lasty, int hx, int hy) {
		if(cnt == customers.length) {
			//끝
			//지금까지의 누적거리 + 마지막 방문점으로부터 집까지의 거리
			int ndist = dist + (Math.abs(lastx-hx) + Math.abs(lasty-hy));
			if( ans > ndist)
				ans = ndist;
			return;
		}
		for(int i = 0; i < customers.length; i++) {
			int cx = customers[i][0];
			int cy = customers[i][1];
			int ndist = dist + ( Math.abs(cx-lastx) + Math.abs(cy-lasty) );
			if(!visited[i] && ans > ndist) {
				visited[i] = true;
				dfs(customers, visited, cnt+1,ndist, cx, cy, hx, hy);
				visited[i] = false;
			}
		}
		
		
	}
	
	
	
//	static void dfs(int[] arr, boolean[] visited,  int cnt, String msg) {
//		if(cnt == arr.length) {
//			System.out.println(msg);
//			return;
//		}
//		
//		for(int i = 0; i < arr.length; i++)
//		{
//			if( ! visited[i])
//			{
//				visited[i] = true;
//				dfs(arr,visited, cnt+1, arr[i] + msg);
//				visited[i] = false;
//			}
//		}
//	}
	
}












