package sw3376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static Long[] list = new Long[9999];
	static {
		// 1 1 1 2 2 3 4 5 7 9 12 16
		list[0] = (long) 1;
		list[1] = (long) 1;
		list[2] = (long) 1;
	}

	static void makeList() {
		for (int i = 3; i < list.length; i++) {
			list[i] = list[i - 2] + list[i - 3];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		makeList();
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.println("#"+tc+" "+list[N-1]);
		
		}

	}

}
