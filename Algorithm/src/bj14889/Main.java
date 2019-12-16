package bj14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] adj;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(TC));
		N = Integer.parseInt(br.readLine());
		adj = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = Integer.MAX_VALUE;

		go(new boolean[N], 0, 0);
		System.out.println(ans);
	}

	static int ans;

	static void go(boolean chkTeam[], int idx, int cnt) {
		if (idx == chkTeam.length) {
			if (cnt== N/2) {
				int sumA = 0;
				int sumB = 0;

				for (int i = 0; i < chkTeam.length; i++) {
					for (int j = 0; j < chkTeam.length; j++) {
						if (chkTeam[i]&&chkTeam[j]) {
							sumA += adj[i][j];
//							sumA += adj[j][i];

						} else if(!chkTeam[i]&&!chkTeam[j]) {
							sumB += adj[i][j];
//							sumB += adj[j][i];
						}
					}
				}
				ans = Math.min(Math.abs(sumA - sumB), ans);
			}
			return;
		}

		chkTeam[idx] = true;
		go(chkTeam, idx + 1, cnt + 1);
		chkTeam[idx] = false;
		go(chkTeam, idx + 1, cnt);

	}
	static String TC = "6\r\n" + 
			"0 1 2 3 4 5\r\n" + 
			"1 0 2 3 4 5\r\n" + 
			"1 2 0 3 4 5\r\n" + 
			"1 2 3 0 4 5\r\n" + 
			"1 2 3 4 0 5\r\n" + 
			"1 2 3 4 5 0";
}
