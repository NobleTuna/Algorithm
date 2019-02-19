package sw1954_;

import java.util.Scanner;

public class Solution {
	static int F;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			F = N * N;
			int map[][] = new int[N][N];
			boolean visited[][] = new boolean[N][N];
			map[0][0] = 1;
			visited[0][0] = true;
			right(map, visited, 0, 0, 2);
			System.out.println("#"+tc);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(map[i][j]+" ");
				}System.out.println();
			}
		}
	}

	public static void right(int map[][], boolean[][] visited, int y, int x, int cnt) {
		if (cnt == F +1) {
			return;
		}
		for (int i = 1; i <= N; i++) {
			int nX = x + i;
			if (nX >= N || visited[y][nX]) {
//				System.out.println("go down");
				down(map, visited, y, nX - 1, cnt);
				return;
			}
//			System.out.println(y+" "+nX);
			visited[y][nX] = true;
			map[y][nX] = cnt++;
		}

	}

	public static void down(int map[][], boolean[][] visited, int y, int x, int cnt) {
		if (cnt == F +1) {
			return;
		}
//		System.out.println("down");
//		System.out.println(nY+" "+x);
		for (int i = 1; i <= N; i++) {
			int nY = y + i;
			
			if (nY >= N || visited[nY][x]) {
				left(map, visited, nY - 1, x, cnt);
				return;
			}
			visited[nY][x] = true;
			map[nY][x] = cnt++;
		}

	}

	public static void left(int map[][], boolean[][] visited, int y, int x, int cnt) {
		if (cnt == F+1) {
			return;
		}
		for (int i = 1; i <= N; i++) {
			int nX = x - i;
			if (nX < 0 || visited[y][nX]) {
				up(map, visited, y, nX + 1, cnt);
				return;
			}
			visited[y][nX] = true;
			map[y][nX] = cnt++;
		}

	}

	public static void up(int map[][], boolean[][] visited, int y, int x, int cnt) {
		if (cnt == F +1) {
			return;
		}
		for (int i = 1; i <= N; i++) {
			
			int nY = y - i;
			
			if (nY < 0 || visited[nY][x]) {
				right(map, visited, nY + 1, x, cnt);
				return;
			}
			visited[nY][x] = true;
			map[nY][x] = cnt++;
		}

	}

}
