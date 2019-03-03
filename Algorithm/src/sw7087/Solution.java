package sw7087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine()); // A = 65
			String list[] = new String[N];
			for(int i=0; i<N; i++) {
				list[i] = br.readLine();
			}
			
			int result = 0;
			for(int i=0; i<27; i++) {
				char k = (char) ('A'+i);
				boolean isPass = false;
				
				for(int j=0; j<list.length; j++){
					if(list[j].charAt(0) == k) {
						isPass = true;
						break;
					}
				}
				if(isPass)
					continue;
				else {
					result = i;
					break;
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}

}
