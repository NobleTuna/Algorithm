package sw4408; // 큐로 짰는데 잘안댐

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static class student implements Comparable<student> {
		int sc;
		int fc;
		int tum;

		public student(int sc, int fc) {
			if (sc < fc) {

				this.sc = sc;
				this.fc = fc;
			} else if (sc > fc) {

				this.sc = fc;
				this.fc = sc;
			}
			this.tum = Math.abs(sc - fc);
		}

		@Override
		public int compareTo(student o) {
			return o.tum - this.tum;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			Queue<student> q = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				StringTokenizer st = new StringTokenizer(input);
				int s = Integer.parseInt(st.nextToken());
				int f = Integer.parseInt(st.nextToken());
				int sc; // 시작복도
				int fc; // 끝복도

				if (s % 2 == 0)
					sc = s / 2 - 1;
				else
					sc = s / 2;

				if (f % 2 == 0)
					fc = f / 2 - 1;
				else
					fc = f / 2;

				q.add(new student(sc, fc));
			}
			int result = 0;

			while (!q.isEmpty()) {

				int size = q.size();

				boolean[] corridor = new boolean[200];
				for (int i = 0; i < size; i++) {

					student s = q.poll();

					boolean isPass = true;
					for (int j = s.sc; j <= s.fc; j++) {
						if (corridor[j]) {
							isPass = false;
							break;
						}
					}
					if (isPass) {
						for (int j = s.sc; j <= s.fc; j++) {
							corridor[j] = true;
						}
					} else {
						q.add(s);
					}
				}
				result++;
			}
			System.out.println("#" + tc + " " + result);
		}
	}

}
