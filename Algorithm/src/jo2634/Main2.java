package jo2634;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		int result = 0;
		for (int i = 0; i < N; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (y > L)
				continue;
			for (int j = 0; j < M; j++) {
				if (Math.abs(x - gun[j]) + y <= L) {
					result++;
					break;
				}
			}
		}
		System.out.println(result);
	}

}
