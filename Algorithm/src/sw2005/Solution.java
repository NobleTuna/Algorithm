package sw2005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int[] before = new int[10];
			before[0]=1;
			before[1]=1;
			int N = Integer.parseInt(br.readLine())+1;
			System.out.print("#"+tc);
			for(int i=0; i<N; i++) {
				for(int j=0; j<i; j++) {
					if(j ==0 ||j==i-1) {
						
						System.out.print(1+" ");
					}else {
						int k= before[j-1]+before[j];
						System.out.print(k+" ");
						before[j]=k;
					}
					
				}System.out.println();
			}
		}
	}

}
