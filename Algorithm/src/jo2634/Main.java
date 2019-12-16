package jo2634;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class animal implements Comparable<animal> {
		int x;
		int y;

		public animal(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(animal o) {
			// TODO Auto-generated method stub
			return this.x - o.x;
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
		Arrays.sort(gun);

		PriorityQueue<animal> q = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (y > L || x < gun[0] - L || gun[M - 1] + L < x)
				continue;

			q.add(new animal(x, y));
		}

//		for(int i=0; i<M; i++) {
//			System.out.print(gun[i]+" " );
//		}

//		for (int i = 0; i < N; i++) {
//			System.out.print(animalArray[i].x + " ");
//		}
		int result = 0;

		int idx = 0;

		while (!q.isEmpty()) {

			animal A = q.poll();

			if (idx < M && gun[idx] < A.x) {
				while (idx < M && gun[idx] < A.x) {
					idx++;
				}
			}
			boolean isDead = false;

			if (idx > 0 && A.x - gun[idx - 1] + A.y <= L)
				isDead = true;

			if (idx < M && gun[idx] - A.x + A.y <= L)
				isDead = true;

			if (isDead)
				result++;

		}

		System.out.println(result);
	}
}
