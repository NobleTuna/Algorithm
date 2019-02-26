package sw6730;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			
			int arr[] = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int upMax = 0;
			int downMax = 0;
			for(int i=1; i<N; i++) {
				int curState = arr[i]-arr[i-1];
				if(upMax<curState) 
					upMax = curState;
				
				if(downMax>curState)
					downMax = curState;
			}
			System.out.println("#"+tc+" "+upMax+" "+Math.abs(downMax));
			
			
			
		}
	}
}
