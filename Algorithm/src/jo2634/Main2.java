package jo2634;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
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

		int result = 0;
		for (int i = 0; i < N; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if (y > L)
				continue;

			int min = 0;
			int max = M - 1;
			int mid;
			while (true) {
				mid = (min + max) / 2;
				if (Math.abs(x - gun[mid]) + y <= L) {
					result++;
					break;
				}
				if (min >= max)
					break;

				if (x < gun[mid]) {
					max = mid - 1;
				} else if (x > gun[mid]) {
					min = mid + 1;
				}
			}

		}
		System.out.println(result);
	}

}
