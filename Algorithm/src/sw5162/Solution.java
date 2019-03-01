package sw5162;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc= 1; tc<=T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			
			int A = Integer.parseInt(st.nextToken()); //현미빵
			int B = Integer.parseInt(st.nextToken()); //단호박빵
			int C = Integer.parseInt(st.nextToken()); //돈
			int result = 0;
			
			int bbang;
			if(A>B)
				bbang = B;
			else
				bbang = A;
			
			int sum;
			
			int cnt = 1;
			while(true) {
				sum = cnt*bbang;
				if(sum>C)
					break;
				
				cnt++;
			}
			
			cnt-=1;
			System.out.println("#"+tc+" "+cnt);
			
		}
		
	}
//	static int result;
//	
//	public static void go(int A, int B, int C, int sum, int cnt) {
//		if(sum>C)
//			return;
//		if(cnt>=result)
//			result = cnt;
//		
//		go(A, B, C, sum+A, cnt+1);
//		go(A, B, C, sum+B, cnt+1);
//		
//		
//	}

}
