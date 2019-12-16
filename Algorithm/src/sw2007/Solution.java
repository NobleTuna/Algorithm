package sw2007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String input = br.readLine();
			char S = input.charAt(0); //k
			int result = 0;
			for(int i=1; i<input.length(); i++) { // korea koreakor
				if(S==input.charAt(i)) {
					int cur = i; 
					boolean chk = true;
					for(int j=0; j<i; j++) {
						if(input.charAt(j)==input.charAt(cur)) {
							cur++;
						}else
						{
							chk = false;
							break;
						}
					}
					if(chk) {
						result = i;
						break;
					}
				}
			}
			System.out.println("#"+tc+" "+result);
		}
		
	}

}
