package sw4408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int corrider[] = new int[200];
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

				if (sc < fc) {
					for (int j = sc; j <= fc; j++) {
						corrider[j]++;
					}
				} else {
					for (int j = fc; j <= sc; j++) {
						corrider[j]++;
					}
				}

			}
			int result = 0;
			for (int i = 0; i < corrider.length; i++) {
				if (corrider[i] > result)
					result = corrider[i];
			}
			System.out.println("#" + tc + " " + result);

		}
	}

}
