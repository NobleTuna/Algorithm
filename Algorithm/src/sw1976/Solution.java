package sw1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int t1_h = Integer.parseInt(st.nextToken());
			int t1_m = Integer.parseInt(st.nextToken());
			int t2_h = Integer.parseInt(st.nextToken());
			int t2_m = Integer.parseInt(st.nextToken());
			
			
			int m = (t1_m+t2_m)%60;
			int h = t1_h + t2_h + (t1_m+t2_m)/60;
			
			if(h==24) {
				h = 12;
			}else {
				h = h%12;
			}
			
			System.out.println("#"+tc+" "+h+" "+m);
		}
	}

}
