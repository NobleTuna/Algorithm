package sw2383;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static class Position {
		int y;
		int x;
		int target;
		int depth;

		public Position(int y, int x, int target, int depth) {
			this.y = y;
			this.x = x;
			this.target = target;
			this.depth = depth;
		}

	}

	static int map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(source));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			people = new ArrayList<>();
			stair = new Position[2];
			int sIdx = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						people.add(new Position(i, j, 0, 0));
					else if (map[i][j] != 0)
						stair[sIdx] = new Position(i, j, 0, map[i][j]);
				}
			}
			ans = Integer.MAX_VALUE;
			///
			System.out.println("#" + tc + " " + ans);
		}
	}


	static int ans;
	static List<Position> people;

	

	static Position stair[];

	static void dfs(boolean [] chk, int idx) {

		if (idx == chk.length) {
			if(chk[idx]) //1번계단
				
			return;
		}

		chk[idx] = true;
		dfs(chk, idx + 1);
		chk[idx] = false;
		dfs(chk, idx + 1);

	}

	static String source = "10\r\n" + "5\r\n" + "0 1 1 0 0\r\n" + "0 0 1 0 3\r\n" + "0 1 0 1 0\r\n" + "0 0 0 0 0\r\n"
			+ "1 0 5 0 0\r\n" + "5\r\n" + "0 0 1 1 0\r\n" + "0 0 1 0 2\r\n" + "0 0 0 1 0\r\n" + "0 1 0 0 0\r\n"
			+ "1 0 5 0 0\r\n" + "6\r\n" + "0 0 0 1 0 0\r\n" + "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0\r\n" + "0 1 0 0 0 0\r\n"
			+ "2 0 1 0 0 0\r\n" + "0 0 2 0 0 0\r\n" + "6\r\n" + "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0\r\n" + "1 0 0 0 0 0\r\n" + "0 0 0 2 0 4\r\n" + "7\r\n"
			+ "0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 4\r\n" + "0 0 0 0 1 0 0\r\n" + "1 0 0 1 0 0 0\r\n"
			+ "0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0\r\n" + "0 2 0 0 0 0 0\r\n" + "7\r\n" + "0 0 0 0 0 0 0\r\n"
			+ "7 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0\r\n"
			+ "2 0 0 0 0 1 0\r\n" + "0 0 0 0 0 0 0\r\n" + "8\r\n" + "0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 2\r\n"
			+ "0 0 0 0 0 0 0 0\r\n" + "2 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 1 0 0\r\n" + "0 0 0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0 1 0\r\n" + "0 0 0 0 1 0 0 0\r\n" + "8\r\n" + "3 0 0 0 0 0 5 0\r\n" + "0 0 0 0 0 0 0 0\r\n"
			+ "1 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0\r\n" + "1 0 1 1 0 0 0 0\r\n" + "0 0 0 0 0 0 1 0\r\n"
			+ "0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0\r\n" + "9\r\n" + "0 0 0 1 0 0 0 0 0\r\n"
			+ "0 1 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 8\r\n" + "7 0 0 0 0 1 0 0 0\r\n" + "0 0 0 0 0 1 1 0 0\r\n"
			+ "0 0 0 0 0 0 0 0 0\r\n" + "1 0 0 0 0 1 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0\r\n"
			+ "10\r\n" + "0 0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 1 0 0 0 0 0\r\n" + "0 0 1 0 0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0\r\n" + "3 0 1 0 1 0 0 0 0 2\r\n"
			+ "1 1 0 0 1 0 1 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0";

}
