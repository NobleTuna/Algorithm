package sw1225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		Queue<Integer> queue;
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		for (int TC = 1; TC <= 10; TC++) {
			queue = new LinkedList<Integer>();
			br.readLine();
			sb = new StringBuilder();
			st = new StringTokenizer((br.readLine()));
			for (int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			boolean token = true;
			while (token) {
				for (int i = 1; i <= 5; i++) {
					int pop = queue.poll() - i;
					if (pop <= 0) {
						queue.add(0);
						token = false;
						break;
					}
					queue.add(pop);
				}
			}
			sb.append("#").append(TC).append(" ");
			while (!queue.isEmpty()) {
				sb.append(queue.poll()).append(" ");
			}
			System.out.println(sb);
		}
	}
}