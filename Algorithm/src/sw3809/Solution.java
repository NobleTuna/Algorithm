package sw3809;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(msg);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			StringBuilder input = new StringBuilder();

			for (int i = 0; i < N; i++) {
				input.append(sc.next());
			}
			
			String result = null;
			for(int i=0; i<Integer.MAX_VALUE; i++) {
				String k = i+"";
				if(!input.toString().contains(k)) {
					result = k;
					break;
				}
			}
			
			System.out.println("#"+tc+" "+result);

		}
	}
	
//	static String msg = "6\r\n" + 
//			"3\r\n" + 
//			"3 0 1\r\n" + 
//			"11\r\n" + 
//			"9 8 7 6 5 4 3 2 1 1 0\r\n" + 
//			"10\r\n" + 
//			"9 0 8 7 6 5 4 3 2 1\r\n" + 
//			"100\r\n" + 
//			"3 6 7 5 3 5 6 2 9 1 2 7 0 9 3 6 0 6 2 6\r\n" + 
//			"1 8 7 9 2 0 2 3 7 5 9 2 2 8 9 7 3 6 1 2\r\n" + 
//			"9 3 1 9 4 7 8 4 5 0 3 6 1 0 6 3 2 0 6 1\r\n" + 
//			"5 5 4 7 6 5 6 9 3 7 4 5 2 5 4 7 4 4 3 0\r\n" + 
//			"7 8 6 8 8 4 3 1 4 9 2 0 6 8 9 2 6 6 4 9\r\n" + 
//			"100\r\n" + 
//			"7 2 7 5 4 7 4 4 5 8 1 5 7 7 0 5 6 2 0 4\r\n" + 
//			"3 4 1 1 0 6 1 6 6 2 1 7 9 2 4 6 9 3 6 2\r\n" + 
//			"8 0 5 9 7 6 3 1 4 9 1 9 1 2 6 4 2 9 7 8\r\n" + 
//			"3 9 5 5 2 3 3 8 4 0 6 8 2 5 5 0 6 7 1 8\r\n" + 
//			"5 1 4 8 1 3 7 3 3 5 3 0 6 0 6 5 3 2 2 2\r\n" + 
//			"1\r\n" + 
//			"3";

}
