package sw3074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2 {
	static long[] pass;
	static int M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			pass = new long[N];
			for (int i = 0; i < N; i++) {
				pass[i] = Integer.parseInt(br.readLine());
			}

			long max = pass[pass.length - 1] * M;
			long min = 0;
			long ans = 0;

			while (true) {
				long mid = (max + min) / 2;
				long people = isSafe(mid);
				if (min >= max) {
					ans = min;
					break;
				}
				if (people == M) {
					ans = mid;
					break;
				} else if (people > M) {
					max = mid - 1;
				} else if (people < M) {
					min = mid + 1;
				}
			}

			System.out.println("#" + tc + " " + ans);

		}
	}

	static long isSafe(long k) { // k 시간
		long curPeople = 0L;
		for (int i = 0; i < pass.length; i++) {

			curPeople += (k / pass[i]);
//			System.out.println(curPeople);
		}
		return curPeople;
	}
}
