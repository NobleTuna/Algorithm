package sw6913_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int people[] = new int[N];
			int max = 0;

			for (int i = 0; i < N; i++) {
				input = br.readLine();
				st = new StringTokenizer(input);
				for (int j = 0; j < M; j++) {
					if (Integer.parseInt(st.nextToken()) == 1)
						people[i]++;
				}
				if (people[i] > max)
					max = people[i];
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (people[i] == max)
					cnt++;
			}
			
			System.out.println("#"+tc+" "+cnt+" "+max);

		}
	}

}
