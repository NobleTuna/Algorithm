package sw4672;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			char[] input = br.readLine().toCharArray();
			
			Arrays.sort(input);


			
			
			
			int cnt = 0;
			String toString = String.valueOf(input);
//			System.out.println("result : "+toString);
			for (int l = 1; l < input.length + 1; l++) { // 길이
				for (int n = 0; n < input.length - l + 1; n++) {
					String sub = toString.substring(n, n + l);
//					System.out.println(sub);
					if (fel(sub))
						cnt++;
				}
			}

			
//			go(input, 0);
			System.out.println("#" + tc + " " + cnt);

		}
	}


	static boolean fel(String msg) {

		int mid = msg.length() / 2;
		String a = msg.substring(0, mid);
		StringBuilder b;

		if (msg.length() % 2 == 0) { // 짝수
			b = new StringBuilder(msg.substring(mid, msg.length()));
		} else { // 홀수
			b = new StringBuilder(msg.substring(mid + 1, msg.length()));
		}
		b.reverse();
		if (a.equals(b.toString()))
			return true;
		else
			return false;

	}

}
