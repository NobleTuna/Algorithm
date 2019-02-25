package sw1287;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			String input = br.readLine();
			char[] num = input.toCharArray();
			int result = 0;
			if(num[0]=='1') {
				result++;
			}
			
			for(int i=1; i<num.length; i++) {
				if(num[i-1]!=num[i]) {
					result++;
				}
			}
			System.out.println("#"+tc+" "+result);
			
			
		}
	}

}
