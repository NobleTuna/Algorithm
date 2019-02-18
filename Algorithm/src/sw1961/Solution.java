package sw1961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<=T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int map[][] = new int[N][N];
			for(int i=0; i<N; i++) {
				String input = br.readLine();
				StringTokenizer st = new StringTokenizer(input);
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int [][]res1 = new int[N][N];
			int [][]res2 = new int[N][N];
			int [][]res3 = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					res1[i][j] = map[j][2-i]; 
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(res1[i][j]+" ");
				}System.out.println();
			}
		}
		
		
	}

}
