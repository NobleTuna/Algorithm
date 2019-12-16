package sw5356;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			char map[][] = new char[5][15];
			for(int i=0; i<5; i++) {
				String input = br.readLine();
				char msg[] = input.toCharArray();
				for(int j=0; j<msg.length; j++) {
					map[i][j] = msg[j];
				}
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<15; i++) {
				for(int j=0; j<5; j++) {
					if(map[j][i]!='\u0000') {
						System.out.print(map[j][i]);
					}
				}
			}System.out.println();
		}
	}

}
