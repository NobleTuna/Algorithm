package sw1225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			Queue<Integer> q = new LinkedList<Integer>();

			for (int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			boolean flag = false;
			while (true) {
				for (int i = 1; i <= 5; i++) {
					int top = q.poll() - i;
					if (top <= 0) {
						q.add(0);
						flag = true;
						break;
					}
					q.add(top);
					if (top <= 0) {
						flag = true;
						break;
					}
				}
				if (flag)
					break;
			}
			System.out.print("#"+tc+" ");
			while(!q.isEmpty()) {
				System.out.print(q.poll()+" ");
			}System.out.println();

		}
	}
}
