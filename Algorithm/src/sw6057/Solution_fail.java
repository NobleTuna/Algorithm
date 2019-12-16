package sw6057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_fail {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 프림을 돌면서 카운트가 3일때 출발점인지 확인? - 삼각형이 한개에 세개나올듯
		// -> 정렬해서 셋에 넣어
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			boolean[][] node = new boolean[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				input = br.readLine();
				st = new StringTokenizer(input);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				node[a][b] = true;
				node[b][a] = true;
			}
			h = new HashSet<>();
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (node[i][j]) {
						int[] result = new int[3];
						result[0] = i;
						result[1] = j;
						go(node, result);
					}
				}
			}

			int result = h.size();
			System.out.println("#" + tc + " " + result);
		}
	}

	static int N;
	static HashSet<String> h;

	static void go(boolean node[][], int result[]) {

		int a = result[0];
		int b = result[1];

		for (int i = 1; i < N + 1; i++) {
			if (node[a][i] && node[i][b]) {
				result[2] = i;

				Arrays.sort(result);
				StringBuilder sb = new StringBuilder();
				for(int t=0; t<3; t++) {
					sb.append(result[t]);
				}
				h.add(sb.toString());
			}
		}
	}
}
