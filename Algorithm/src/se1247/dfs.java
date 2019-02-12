package se1247;

import java.util.Scanner;

public class dfs {
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		boolean[] visited = new boolean[3];
		dfs(arr,visited, 0 , "");
		
	}
	static void dfs(int[] arr, boolean[] visited,  int cnt, String msg) {
		if(cnt == arr.length) {
			System.out.println(msg);
			return;
		}
		
		for(int i = 0; i < arr.length; i++)
		{
			if( ! visited[i])
			{
				visited[i] = true;
				dfs(arr,visited, cnt+1, arr[i] + msg);
				visited[i] = false;
			}
		}
	}
	
}












