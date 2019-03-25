package bj2458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<Integer>[] low = new Set[N + 1];
		Set<Integer>[] high = new Set[N + 1];

		for (int i = 0; i < N + 1; i++) {
			low[i] = new HashSet<>();
			high[i] = new HashSet<>();
		}
		int arr[][] = new int[M][2];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[i][0] = a;
			arr[i][1] = b;

			low[b].add(a);
//			low[b].addAll(low[a]);
			high[a].add(b);
//			high[a].addAll(high[b]);
		}
		
		for(int i=M-1; i>=0 ;i--) {
			int a = arr[i][0];
			int b = arr[i][1];
			
			low[b].addAll(low[a]);
			high[a].addAll(high[b]);
			
		}
		
		int result = 0;
		
		for(int i=0; i<N+1; i++) {
//			System.out.println(i);
//			System.out.println(low[i].toString());
//			System.out.println(high[i].toString());
//			System.out.println();
			if(low[i].size()+high[i].size()==N-1)
				result++;
		}
		
		System.out.println(result);
	}

}
