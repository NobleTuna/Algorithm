package sw6057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			boolean[][] node = new boolean[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				input = br.readLine();
				st = new StringTokenizer(input);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				node[a][b] = true;
				node[b][a] = true;
			}
			
			int result = 0;
			
			for(int i=1; i<=N; i++) {
				for(int j=i+1; j<=N; j++) {
					if(!node[i][j])
						continue;
					
					for(int k=j; k<=N; k++) {
						if(!node[k][j])
							continue;
						if(!node[k][i])
							continue;
						
						result++;
					}
				}
			}
			
			System.out.println("#"+tc+" "+result);
			
			
			
		}
	}


}
