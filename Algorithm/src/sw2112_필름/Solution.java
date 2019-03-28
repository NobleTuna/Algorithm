package sw2112_필름; // 필름

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int D, W, K;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(TC));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken()); // 두깨
			W = Integer.parseInt(st.nextToken()); // 가로
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int tmp[] = new int[D];
			Arrays.fill(tmp, 2);

			if (chk(tmp)) {
				System.out.println("#" + tc + " " + 0);
				continue;
			}
			ans = Integer.MAX_VALUE;
			go(0, new int[D], 0);

			System.out.println("#" + tc + " " + ans);

		}
	}

	static int ans;

	static void go(int idx, int[] arr, int cnt) { // 조합배열, 먹인 숫자,인덱스
		if (cnt >= ans)
			return;
		if (idx == arr.length) {
			if (chk(arr)) {
//				System.out.println("사용한 약ㅣ :" + cnt);
//				System.out.println(Arrays.toString(arr));
//				System.out.println();
				ans = Math.min(ans, cnt);
			}
			return;
		}

		for (int i = 0; i < 3; i++) {
			arr[idx] = i;

			if (i == 2) // 시약안씀
				go(idx + 1, arr, cnt);
			else
				go(idx + 1, arr, cnt + 1);
		}
	}

	static boolean chk(int[] seeyak) {
		int resultMap[][] = new int[D][W];

		for (int i = 0; i < D; i++) {
			if (seeyak[i] == 0) {
				Arrays.fill(resultMap[i], 0);
			} else if (seeyak[i] == 1) {
				Arrays.fill(resultMap[i], 1);
			} else
				resultMap[i] = map[i].clone();
		}

//		for(int i=0; i<D; i++) {
//			System.out.println(Arrays.toString(resultMap[i]));
//		}
//		System.out.println();

		for (int i = 0; i < W; i++) {
			int cnt = 1;
			int curNum = resultMap[0][i];
			boolean isOk = false;
			for (int j = 1; j < D; j++) {
				if (resultMap[j][i] == curNum) {
					cnt++;
				} else {
					cnt = 1;
					curNum = resultMap[j][i];
				}
				if (cnt == K) {
					isOk = true;
					break;
				}
			}
			if (!isOk) {
				return false;
			}
		}

		return true;
	}

	static String TC2 = "1\r\n" + "6 8 3\r\n" + "1 1 1 1 0 0 1 0\r\n" + "0 0 1 1 0 1 0 1\r\n" + "1 1 1 1 0 0 1 0\r\n"
			+ "1 1 1 0 0 1 1 0\r\n" + "1 1 0 1 1 1 1 0\r\n" + "1 1 1 0 0 1 1 0";
	static String TC1 = "1\r\n" + "6 8 3\r\n" + "0 0 1 0 1 0 0 1\r\n" + "0 1 0 0 0 1 1 1\r\n" + "0 1 1 1 0 0 0 0\r\n"
			+ "1 1 1 1 0 0 0 1\r\n" + "0 1 1 0 1 0 0 1\r\n" + "1 0 1 0 1 1 0 1";
	static String TC = "10\r\n" + "6 8 3\r\n" + "0 0 1 0 1 0 0 1\r\n" + "0 1 0 0 0 1 1 1\r\n" + "0 1 1 1 0 0 0 0\r\n"
			+ "1 1 1 1 0 0 0 1\r\n" + "0 1 1 0 1 0 0 1\r\n" + "1 0 1 0 1 1 0 1\r\n" + "6 8 3\r\n"
			+ "1 1 1 1 0 0 1 0\r\n" + "0 0 1 1 0 1 0 1\r\n" + "1 1 1 1 0 0 1 0\r\n" + "1 1 1 0 0 1 1 0\r\n"
			+ "1 1 0 1 1 1 1 0\r\n" + "1 1 1 0 0 1 1 0\r\n" + "6 8 4\r\n" + "1 1 0 0 0 1 1 0\r\n"
			+ "1 0 1 0 0 1 1 1\r\n" + "0 1 0 0 1 1 0 0\r\n" + "1 0 1 0 0 0 0 0\r\n" + "1 1 0 0 0 0 0 0\r\n"
			+ "1 0 0 0 1 1 1 1\r\n" + "6 4 4\r\n" + "1 1 0 0\r\n" + "0 1 0 1\r\n" + "0 0 0 1\r\n" + "1 1 1 1\r\n"
			+ "1 1 0 1\r\n" + "1 0 1 0\r\n" + "6 10 3\r\n" + "0 1 0 0 0 1 0 0 1 1\r\n" + "0 1 1 0 0 1 0 0 1 0\r\n"
			+ "0 1 0 0 1 0 1 1 1 1\r\n" + "0 0 0 0 0 1 1 1 1 0\r\n" + "0 1 0 0 1 1 1 1 1 1\r\n"
			+ "1 0 0 0 1 1 0 0 1 1\r\n" + "6 6 5\r\n" + "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0\r\n" + "6 6 4\r\n" + "1 1 1 1 1 1\r\n"
			+ "0 0 0 0 0 1\r\n" + "0 1 1 1 0 1\r\n" + "0 1 0 1 0 1\r\n" + "0 1 0 0 0 1\r\n" + "0 1 1 1 1 1\r\n"
			+ "8 15 3\r\n" + "0 1 1 0 0 1 1 0 1 1 0 0 0 0 0\r\n" + "1 0 0 0 1 1 0 0 0 0 0 1 0 1 1\r\n"
			+ "1 1 0 1 0 1 0 1 0 1 0 1 0 0 0\r\n" + "0 1 1 1 0 0 1 0 0 0 0 1 0 0 0\r\n"
			+ "0 0 0 0 0 0 1 0 0 0 1 1 0 0 1\r\n" + "1 0 1 0 0 1 0 1 1 1 1 0 1 1 1\r\n"
			+ "0 0 0 0 0 1 1 1 0 0 0 0 0 1 0\r\n" + "0 0 1 0 1 1 0 1 1 0 0 0 1 0 0\r\n" + "10 20 4\r\n"
			+ "1 0 1 1 1 1 1 1 1 1 0 0 1 1 1 0 1 1 0 1\r\n" + "1 1 0 1 1 1 0 0 1 0 0 0 1 1 1 1 0 0 1 0\r\n"
			+ "1 1 0 1 1 0 0 0 1 1 1 1 1 0 0 1 1 0 1 0\r\n" + "0 0 0 1 1 0 0 0 0 1 0 0 1 0 1 1 1 0 1 0\r\n"
			+ "0 1 1 0 1 0 1 0 1 0 0 1 0 0 0 0 1 1 1 1\r\n" + "1 0 1 0 1 0 1 1 0 0 0 0 1 1 1 0 0 0 0 0\r\n"
			+ "0 1 0 0 1 1 0 0 0 0 0 1 1 0 0 1 1 0 1 1\r\n" + "1 0 0 0 0 1 0 1 1 0 1 1 0 1 0 0 1 1 1 0\r\n"
			+ "0 1 1 0 0 1 0 1 0 0 0 0 0 0 0 1 1 1 0 1\r\n" + "0 0 0 0 0 0 1 1 0 0 1 1 0 0 0 0 0 0 1 0\r\n"
			+ "13 20 5\r\n" + "1 1 0 1 0 0 0 1 1 1 1 0 0 0 1 1 1 0 0 0\r\n"
			+ "1 1 1 1 0 1 0 1 0 0 0 0 1 0 0 0 0 1 0 0\r\n" + "1 0 1 0 1 1 0 1 0 1 1 0 0 0 0 1 1 0 1 0\r\n"
			+ "0 0 1 1 0 1 1 0 1 0 0 1 1 0 0 0 1 1 1 1\r\n" + "0 0 1 0 0 1 0 0 1 0 0 0 0 1 0 0 0 0 1 1\r\n"
			+ "0 0 1 0 0 0 0 0 0 0 0 0 1 1 1 0 0 1 0 1\r\n" + "0 0 0 1 0 0 0 0 0 0 1 1 0 0 0 1 0 0 1 0\r\n"
			+ "1 1 1 0 0 0 1 0 0 1 1 1 0 1 0 1 0 0 1 1\r\n" + "0 1 1 1 1 0 0 0 1 1 0 1 0 0 0 0 1 0 0 1\r\n"
			+ "0 0 0 0 1 0 1 0 0 0 1 0 0 0 0 1 1 1 1 1\r\n" + "0 1 0 0 1 1 0 0 1 0 0 0 0 1 0 1 0 0 1 0\r\n"
			+ "0 0 1 1 0 0 1 0 0 0 1 0 1 1 0 1 1 1 0 0\r\n" + "0 0 0 1 0 0 1 0 0 0 1 0 1 1 0 0 1 0 1 0\r\n" + "";
}
