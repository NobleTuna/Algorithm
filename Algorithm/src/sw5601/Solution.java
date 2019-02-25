package sw5601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<N; i++) {
				System.out.print("1/"+N+" ");
			}System.out.println();

		}
	}

}
