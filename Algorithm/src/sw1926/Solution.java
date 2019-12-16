package sw1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			String sign = String.valueOf(i);
			int cnt = 0;
			for (int j = 0; j < sign.length(); j++) {
				if (sign.charAt(j) == '3' || sign.charAt(j) == '6' || sign.charAt(j) == '9') {
					cnt++;
				}
			}
			if (cnt == 0) {
				System.out.print(sign + " ");
			} else {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < cnt; j++) {
					sb.append("-");
				}
				System.out.print(sb.toString() + " ");
			}
		}
	}
}
