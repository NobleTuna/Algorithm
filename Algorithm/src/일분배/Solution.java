package 일분배;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
//		첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//		각 테스트 케이스의 첫 번째 줄에는 하나의 정수 N(1 ≤ N ≤ 16)이 주어진다.
//		다음 N개의 줄의 i번째 줄에는 N개의 정수 Pi, 1, … , i, N(0 ≤ Pi, j ≤ 100)이 주어진다.
//		Pi, j는 i번 사람이 j번 일을 성공할 확률을 퍼센트 단위로 나타낸다.
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			double[][] P = new double[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++)
					P[i][j]	 = sc.nextInt() /100.0;
			}
			System.out.println(String.format("%.6f", dfs(P, 0, 0)));
		}
	}
//	static HashMap<String, Double> memo = new HashMap<>();
	static double[] memo = new double[1<<16];
	static double dfs(double[][] p, int mask, int idx) {
		if( idx == p.length )
			return 100;
//		String status = Arrays.toString(sel);
//		if( memo.containsKey(status)) {
//			return memo.get(status);
//		}
		if( memo[mask] != 0)
			return memo[mask];
		double max = 0;
		for(int i = 0; i < p.length; i++) {
			int pos = 1 << i;
			if( (mask & pos) == 0 ) {
				double current = dfs(p, mask | pos, idx+1);
				max = Math.max(max, current);
			}
//			if(!sel[i]) {
//				sel[i] = true;
//				double current = dfs(p, sel, idx+1) * p[idx][i];
//				sel[i] = false;
//				max = Math.max(max, current);
//			}
		}
//		memo.put(status, max);
		memo[mask] = max;
		return max;
	}
}








