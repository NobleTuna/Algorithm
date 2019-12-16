package bj2804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();

		char[][] map = new char[b.length()][a.length()];

		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], '.');
		}

		int ay = 0;
		int bx = 0;

		out: for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i) == b.charAt(j)) {
					ay = j;
					bx = i;
					break out;
				}
			}
		}

		for (int i = 0; i < a.length(); i++) {
			map[ay][i] = a.charAt(i);
		}
		for (int i = 0; i < b.length(); i++) {
			map[i][bx] = b.charAt(i);
		}

		for (int i = 0; i < b.length(); i++) {
			for (int j = 0; j < a.length(); j++) {
				System.out.print(map[i][j]);
			}
			if (i == b.length() - 1)
				continue;
			System.out.println();
		}

	}
}
