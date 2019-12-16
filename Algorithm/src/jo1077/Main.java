package jo1077; // 배낭채우기1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br= new BufferedReader(new StringReader(inputString));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][2];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int[] bag = new int[W+1];
			
			int[] memo = new int [W+1];
			
			int sw = arr[0][0]; // 무게
			int sv = arr[0][1]; // 가치
			
			for(int i=sw; i<W+1; i++) {
				bag[i]=bag[i-sw]+sv;
			}
			
			for(int i=1; i<N; i++) {
				int w = arr[i][0];
				int v = arr[i][1];
				
				memo = bag.clone();
				for(int j=w; j<W+1; j++) {
					bag[j] = Math.max(memo[j], memo[j-w]+v);
				}
//				System.out.println(Arrays.toString(bag));
			}
			
			System.out.println(bag[W]);
	}
	static String inputString = "4 14\r\n" + 
			"2 40\r\n" + 
			"5 110\r\n" + 
			"10 200\r\n" + 
			"3 50";
}
