package sw5213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static long[] oddDivisorSum = new long[1000001];
	private static long[] sigmaOddSum = new long[1000001];

	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		// 주어진 범위에서 홀수/약수의 합 구하기
		init();
		// 각 범위까지 합을 미리 계산해놓기.
		calSigma();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long result = sigmaOddSum[b] - sigmaOddSum[a-1];

			System.out.println("#" + tc + " " + result);

		}
	}

	public static void init() {
		for (int odd = 1; odd < oddDivisorSum.length; odd += 2) {
			for (int i = 1; odd * i < oddDivisorSum.length; i++) {
				oddDivisorSum[odd * i] += odd;
			}
		}

	}

	// 홀수 약수의 합의 누적합
	public static void calSigma() {
		for (int i = 1; i < sigmaOddSum.length; i++) {
			sigmaOddSum[i] = sigmaOddSum[i - 1] + oddDivisorSum[i];
		}

	}

}
