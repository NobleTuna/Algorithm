package sw1234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int N = Integer.parseInt(st.nextToken());
			char[] msg = st.nextToken().toCharArray();
			List<Character> list = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				list.add(msg[i]);
			}
			boolean token;
			while (true) {
				token = false;
				for (int i = 1; i < list.size(); i++) {
					if (list.get(i)==list.get(i-1)) {
						list.remove(i);
						list.remove(i-1);
						token = true;
						break;
					}
				}
				if (!token)
					break;
			}
			System.out.print("#"+tc+" ");
			for(char c :list) {
				System.out.print(c);
			}System.out.println();
		}
		
	}

}
