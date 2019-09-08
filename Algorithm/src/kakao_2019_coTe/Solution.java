package kakao_2019_coTe;

import java.util.ArrayList;
import java.util.List;

class Solution {
	static int M; // key
	static int N; // lock
	static int count;

	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public boolean solution(int[][] key, int[][] lock) {
		M = key.length;
		N = lock.length;
		count = 0;
		int keyCount = 0;
		List<Point> keySet = new ArrayList<Solution.Point>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if (key[i][j] == 1) {
					keyCount++;
					keySet.add(new Point(i, j));
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (lock[i][j] == 0)
					count++;
			}
		}
		
		if(keyCount < count)
			return false;

		// run
	
		if (run(keySet, lock)) {
			return true;
		}

		keySet = KeytRo(keySet);
		if (run(keySet, lock)) {
			return true;
		}

		keySet = KeytRo(keySet);
		if (run(keySet, lock)) {
			return true;
		}

		keySet = KeytRo(keySet);
		if (run(keySet, lock)) {
			return true;
		}
		
		keySet = KeytRo(keySet);
		if (run(keySet, lock)) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();

		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		System.out.println(sol.solution(key, lock));

	}

	public static boolean run(List<Point> keySet, int[][] lock) {
		for (int i = 0; i < lock.length; i++) {
			for (int j = 0; j < lock.length; j++) {
//				if (lock[i][j] == 0) {
					for (Point Dkey : keySet) {
						int dy = i - Dkey.y;
						int dx = j - Dkey.x;
						int curCount = 0;
						for (Point key : keySet) {
							int curY = key.y + dy;
							int curX = key.x + dx;

							if (isOutRange(curY, curX))
								continue;

							if (lock[curY][curX] == 1) {
								break;
							} else {
								curCount++;
							}
						}
						if (curCount == count)
							return true;
					}
				}
			}
//		}
		return false;
	}

	public static List<Point> KeytRo(List<Point> keySet) {
		List<Point> roKey = new ArrayList<Solution.Point>();

//		for(Point key : keySet) {
//			System.out.print(key.y + " " + key.x + "   ");
//		}
		for (Point key : keySet) {
			roKey.add(new Point(key.x, M - 1 - key.y));
		}
//		for(Point key : roKey) {
//			System.out.print(key.y + " " + key.x + "   ");
//		}
//		System.out.println();
//		System.out.println("======");
		return roKey;
	}

	public static boolean isOutRange(int y, int x) {
		return y < 0 || x < 0 || y >= N || x >= N;
	}
}