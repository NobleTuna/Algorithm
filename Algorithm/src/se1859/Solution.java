package se1859;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			String input = br.readLine();
			
			
			StringTokenizer st = new StringTokenizer(input);
			int[]arr = new int[N];
			for(int i=N-1; i>=0; i--) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			long result = 0;
			int max = arr[0];
			for(int i=1; i<N; i++) {
				int current = arr[i];
				if(max>current) {
					result+=max-current;
				}else if(max<current){
//					result+=current-max;
					max = current;
				}
			}
			System.out.println("#"+tc+" "+result);
			
		}
		
		
	}


}
