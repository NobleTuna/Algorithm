package jo2634;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class animal {
		int x;
		int y;

		public animal(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		input = br.readLine();
		st = new StringTokenizer(input);

		int gun[] = new int[M];
		for (int i = 0; i < M; i++) {
			gun[i] = Integer.parseInt(st.nextToken());
		}
		Queue<animal> q = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (y > L)
				continue;
			q.add(new animal(x, y));
		}

		int result = 0;
		for (int i = 0; i < M; i++) {

			int loop = q.size();

			for (int j = 0; j < loop; j++) {
				animal k = q.poll();
				int aX = k.x;
				int aY = k.y;
				int sade = gun[i];
				if (Math.abs(aX - sade) + aY <= L) {
					result++;
				} else {
					q.add(k);
				}
			}
		}
		System.out.println(result);
	}
}
