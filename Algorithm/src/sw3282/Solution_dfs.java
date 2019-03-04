package sw3282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_dfs {

	static class M {
		int v;
		int c;

		public M(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

	static int N;
	static int K;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			M[] list = new M[N];

			for (int i = 0; i < N; i++) {
				input = br.readLine();
				st = new StringTokenizer(input);

				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list[i] = new M(v, c);
			}
			
			result = 0;

			go(list, 0, 0, 0);

			System.out.println("#" + tc + " " + result);

		}
	}
	
	
	static int result;

	static void go(M[] list, int idx, int C, int V) {
		if (idx == N) {
			if (C > result)
				result = C;
			return;
		}
		//bound 계산해서 현재로부터 얻을 수 있는 최대 가치를 계산
		//현재 담아야될 아이템을 담을 수 있다면 누적합
		//담을 수 없다면 가성비로 무게당 가치 만큼만 cost에 더하고 가치는 초과치까지.
		//해당 최대가치가 이미 발견된 ans보다 작으면 return

		M m = list[idx];

		if (V + m.v <= K)
			go(list, idx + 1, C + m.c, V + m.v);

		go(list, idx + 1, C, V);

	}
}
