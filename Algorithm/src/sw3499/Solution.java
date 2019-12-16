package sw3499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			String msg[] = new String[N + 1];

			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);

			Queue<String> first = new LinkedList<String>();

			Queue<String> second = new LinkedList<String>();

			boolean flag = false;
			if (N % 2 == 0) { // 짝수라면
				flag = true;

				for (int i = 1; i <= N / 2; i++) {
					first.add(st.nextToken());
				}
				for (int i = N / 2 + 1; i <= N; i++) {
					second.add(st.nextToken());
				}

			} else {
				for (int i = 1; i <= N / 2 + 1; i++) {
					first.add(st.nextToken());
				}
				for (int i = N / 2 + 2; i <= N; i++) {
					second.add(st.nextToken());
				}
			}

			System.out.print("#" + tc + " ");

			while (!first.isEmpty()) {

				System.out.print(first.poll() + " ");
				if (second.isEmpty())
					break;
				System.out.print(second.poll() + " ");

			}
			
			System.out.println();

		}
	}

}
