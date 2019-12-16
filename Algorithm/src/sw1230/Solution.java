package sw1230;

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
			List<String> list = new LinkedList<String>();
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			for (int i = 0; i < N; i++) {
				list.add(st.nextToken().toString());
			}
			int C = Integer.parseInt(br.readLine());
			input = br.readLine();
			st = new StringTokenizer(input);
			for (int i = 0; i < C; i++) {
				char S = st.nextToken().charAt(0);
				int x, y, s;
				switch (S) {
				case 'I':
					x = Integer.parseInt(st.nextToken()); // idx
					y = Integer.parseInt(st.nextToken()); // 숫자
					for (int k = 0; k < y; k++) {
						list.add(x + k, st.nextToken().toString());
					}

					break;
				case 'D':
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for (int k = 0; k < y; k++) {
						list.remove(x + k);
					}

					break;
				case 'A':
					s = Integer.parseInt(st.nextToken());
					for (int k = 0; k < s; k++) {
						list.add(st.nextToken().toString());
					}

					break;
				}
			}
			System.out.print("#"+tc+" ");
			for(int i=0; i<10; i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
	}

}
