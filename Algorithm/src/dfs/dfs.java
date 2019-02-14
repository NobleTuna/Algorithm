package dfs;

import java.util.Arrays;

public class dfs {
	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1};
		
		boolean[] visited = new boolean[arr.length];
		
		int[] result = new int[arr.length];
		go(arr, visited, result, 0);
	}
	
	public static void go(int[] arr, boolean [] visited, int[] result , int cnt) {
		if(cnt == result.length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[cnt] = arr[i];
				go(arr, visited, result, cnt+1);
				visited[i] = false;
			}
		}
	}
}
