package jo1545_bitmask_returnHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main2 {
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
		h = new HashMap<>();
		ans = Integer.MAX_VALUE;
		boolean visited[] = new boolean[N];
		visited[0] = true;
		go(visited, 0, 0, 0);
		System.out.println(ans);

	}

	static int ans;
	static int N;
	static int map[][];
	static HashMap<String, Integer> h;

	static void go(boolean[] visited, int idx, int sum, int cnt) {

		if (sum >= ans)
			return;

		if (cnt == N - 1) {
			if (map[idx][0] == 0)
				return;
			ans = Math.min(ans, sum + map[idx][0]);
		}

		String key = makeKey(visited); // 안간놈들이 key
		if (key.length() != 0) {

			idx = key.charAt(key.length() - 1) - '0';
			go(visited, idx, sum + h.get(key), N - 1);
		}

		for (int i = 1; i < N; i++) {
			if (map[idx][i] != 0 && !visited[i] && i != idx) {
				visited[i] = true;
				
				go(visited, i, sum + map[idx][i], cnt + 1);
				visited[i] = false;
			}
		}
	}

	static String makeKey(boolean[] visited) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (!visited[i])
				sb.append(i);
		}
		return sb.toString();
	}
}
