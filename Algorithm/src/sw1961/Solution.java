package sw1961;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			
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
					res1[j][i] = map[N-1-j][i];  
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					res2[i][j] = map[N-1-j][N-1-i];  
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					res3[j][i] = map[j][N-1-i];  
				}
			}
			System.out.println("#"+tc);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(res1[j][i]);
				}
				System.out.print(" ");
				for(int j=0; j<N; j++) {
					System.out.print(res2[j][i]);
				}
				System.out.print(" ");
				for(int j=0; j<N; j++) {
					System.out.print(res3[j][i]);
				}System.out.println();
			}
		}
		
		
	}

}
