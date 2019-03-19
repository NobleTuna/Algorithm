package sw3074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SolutionT {
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
			

			Arrays.sort(pass);


//			System.out.println("#" + tc + " " + ans);

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
