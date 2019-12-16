package bj17136_색종이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int map[][] = new int[10][10];
	static int ans;
	static int allCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		allCnt = 0;
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					allCnt++;
			}
		}

		ans = 18;
		go(5, 5, 5, 5, 5, 0, 0, map, 0, 0);

		System.out.println(ans == 18 ? -1 : ans);

	}

	static void go(int five, int four, int three, int two, int one, int cnt, int paperCnt, int[][] curMap, int i,
			int j) {
		if (cnt == allCnt) {
			ans = Math.min(ans, paperCnt);
			return;
		}
		if (ans <= paperCnt) {
			return;
		}
		if (five == 0 && four == 0 && three == 0 && two == 0 && one == 0)
			return;

		if (j == 10) {
			j = 0;
			i++;
		}

		if (i == 10)
			return;

//		System.out.println(i + "" + j + " " + curMap[i][j]);

		if (curMap[i][j] == 1) {

			if (five > 0 && checkMap(curMap, i, j, 5)) {
				coverOne(curMap, i, j, 5);
				go(five - 1, four, three, two, one, cnt + 25, paperCnt + 1, curMap, i, j + 1);
				coverZero(curMap, i, j, 5);
			}

			if (four > 0 && checkMap(curMap, i, j, 4)) {
				coverOne(curMap, i, j, 4);
				go(five, four - 1, three, two, one, cnt + 16, paperCnt + 1, curMap, i, j + 1);
				coverZero(curMap, i, j, 4);
			}

			if (three > 0 && checkMap(curMap, i, j, 3)) {
				coverOne(curMap, i, j, 3);
				go(five, four, three - 1, two, one, cnt + 9, paperCnt + 1, curMap, i, j + 1);
				coverZero(curMap, i, j, 3);
			}

			if (two > 0 && checkMap(curMap, i, j, 2)) {
				coverOne(curMap, i, j, 2);
				go(five, four, three, two - 1, one, cnt + 4, paperCnt + 1, curMap, i, j + 1);
				coverZero(curMap, i, j, 2);
			}

			if (one > 0 && checkMap(curMap, i, j, 1)) {
				coverOne(curMap, i, j, 1);
				go(five, four, three, two, one - 1, cnt + 1, paperCnt + 1, curMap, i, j + 1);
				coverZero(curMap, i, j, 1);
			}
		} else {
			go(five, four, three, two, one, cnt, paperCnt, curMap, i, j+1);
		}

	}

	// 체크하는 함수
	static boolean checkMap(int[][] curMap, int y, int x, int num) {
		for (int i = y; i < y + num; i++) {
			for (int j = x; j < x + num; j++) {
				if (i >= 10 || j >= 10 || curMap[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	// 색칠하는 함수
	static void coverOne(int[][] curMap, int y, int x, int num) {
//		int[][] resultMap = cloneMap(curMap);
//		int[][] resultMap = curMap;

		for (int i = y; i < y + num; i++) {
			for (int j = x; j < x + num; j++) {
				curMap[i][j] = 0;
			}
		}
//		return curMap;
	}

//
	// 지우는 함수
	static void coverZero(int[][] curMap, int y, int x, int num) {
//		int[][] resultMap = curMap(curMap);

		for (int i = y; i < y + num; i++) {
			for (int j = x; j < x + num; j++) {
				curMap[i][j] = 1;
			}
		}
//		return curMap;
	}

	// 맵복사 함수
//	static int[][] cloneMap(int[][] curMap) {
//		int[][] resultMap = new int[10][10];
//
//		for (int i = 0; i < 10; i++) {
//			resultMap[i] = curMap[i].clone();
//		}
//		return resultMap;
//	}
}
