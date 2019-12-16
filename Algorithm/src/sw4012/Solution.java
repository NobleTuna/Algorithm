package sw4012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = Integer.MAX_VALUE;
			go(new boolean[N], 0, 0);
			/// 재료 이름 0,1,2,3;

			System.out.println("#" + tc + " " + ans);

		}
	}

	static int ans;
	static int map[][];
	static int N;

	static void go(boolean[] chk, int idx, int cnt) {
		if (idx == N) {
			if (cnt != N - cnt)
				return;
			int[] A = new int[cnt];
			int[] B = new int[N - cnt];

			int idxA = 0;
			int idxB = 0;

			for (int i = 0; i < N; i++) {
				if (chk[i])
					A[idxA++] = i;
				else
					B[idxB++] = i;
			}

//			System.out.println();
//			System.out.println(Arrays.toString(A));
//
//			System.out.println(Arrays.toString(B));

			int sumA = 0;
			int sumB = 0;

			for (int i = 0; i < A.length - 1; i++) {
				for (int j = i+1; j < A.length; j++) {
					sumA = sumA + map[A[i]][A[j]] + map[A[j]][A[i]];
				}
			}
			for (int i = 0; i < B.length - 1; i++) {
				for (int j = i+1; j < B.length; j++) {
					sumB = sumB + map[B[i]][B[j]] + map[B[j]][B[i]];
				}
			}
			ans = Math.min(ans, Math.abs(sumA - sumB));
			return;
		}

		chk[idx] = true;
		go(chk, idx + 1, cnt + 1);
		chk[idx] = false;
		go(chk, idx + 1, cnt);
	}

}
