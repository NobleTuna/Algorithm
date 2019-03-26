package jo1545_bitmask_returnHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_T {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		memo = new int[1 << N][N];
		System.out.println(go(0, 0, 0));

	}

	static int ans;
	static int N;
	static int map[][];
	static int[][] memo;

	// boolean 배열 대신 int 자료를 통해서 방문체크, 메모이제이션 시 키값으로 활용할 때 더 유리
	static int go(int status, int idx, int current) {
		if (idx == N - 1) {
			if (map[current][0] == 0)
				return 9876515;
			else
				return map[current][0];
		}
		if (memo[status][current] != 0) {
			return memo[status][current];
		}

		int opt = 9874153;
		for (int i = 1; i < N; i++) {
			int mask = 1 << i;
			if ((mask & status) == 0 && map[current][i] != 0 && current!=i) {
				int tmp = go(status | mask, idx + 1, i) + map[current][i];
				opt = Math.min(opt, tmp);
			}
		}
		memo[status][current] = opt;
		return opt;

	}
}
