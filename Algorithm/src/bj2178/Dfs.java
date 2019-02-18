package bj2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dfs {
	static int R;
	static int C;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int arr[][] = new int[R][C];
		for (int i = 0; i < R; i++) {
			input = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		boolean[][] visited = new boolean[R][C];
		visited[0][0] = true;
		result = 0;
		go(arr, visited, 0, 0, 1);
		System.out.println(result);

	}

	static int[] dc = { 0, 0, -1, 1 };
	static int[] dr = { 1, -1, 0, 0 };
	
	

	public static void go(int[][] arr, boolean[][] visited, int r, int c, int cnt) {
		if (r == R - 1 && c == C - 1) {
			if (result < cnt)
				result = cnt;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int next_r = r + dr[i];
			int next_c = c + dc[i];

			if (next_r < 0 || next_c < 0 || next_r >= R || next_c >= C) {
				continue;
			}
			if (arr[next_r][next_c] == 1 && !visited[next_r][next_c]) {
				
				visited[next_r][next_c] = true;
				go(arr, visited, next_r, next_c, cnt + 1);
				visited[next_r][next_c] = false;
			}
			
		}

	}
}