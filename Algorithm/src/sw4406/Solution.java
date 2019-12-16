package sw4406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			char[] msg = input.toCharArray();
			System.out.print("#" + tc + " ");
			for (int i = 0; i < msg.length; i++) {
				if (msg[i] != 'a' && msg[i] != 'e' && msg[i] != 'i' && msg[i] != 'o' && msg[i] != 'u') {
					System.out.print(msg[i]);
				}
			}
			System.out.println();

		}
	}

}
