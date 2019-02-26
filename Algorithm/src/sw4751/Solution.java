package sw4751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			char[] output = input.toCharArray();
			
			///
			System.out.print("..");
			for (int i = 0; i < output.length - 1; i++) {
				System.out.print("#...");
			}
			System.out.print("#..");
			System.out.println();
			
			/////
			
			System.out.print(".");
			for(int i=0; i<output.length; i++) {
				System.out.print("#.#.");
			}
			System.out.println();
			
			///
			
			
			for(int i=0; i<output.length; i++) {
				System.out.print("#."+output[i]+".");
			}System.out.println("#");
			
			
			System.out.print(".");
			for(int i=0; i<output.length; i++) {
				System.out.print("#.#.");
			}
			System.out.println();
			
			System.out.print("..");
			for (int i = 0; i < output.length - 1; i++) {
				System.out.print("#...");
			}
			System.out.print("#..");
			System.out.println();
			
			/////
			

		}
		
		
	}

}
