package sw1952; // 수영징

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_dp {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(tmpString));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			money = new int[4]; // 1일, 한달, 3달, 1년
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 4; i++) {
				money[i] = Integer.parseInt(st.nextToken());
			}

			int[] month = new int[12];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < 12; i++) {
				if (month[i] != 0)
					month[i] = Math.min(month[i] * money[0], money[1]);
			}

//			System.out.println(Arrays.toString(month));

			ans = money[3];
			go(0, 0, month);
			System.out.println("#" + tc + " " + ans);

		}
	}

	static int ans;
	static int money[];

	public static void go(int sum, int idx, int[] month) {
		if (idx >= 12) {
			ans = Math.min(ans, sum);
			return;
		}

		go(sum + month[idx], idx + 1, month);


		go(sum + money[2], idx + 3, month);

	}

	static String tmpString = "10\r\n" + "10 40 100 300\r\n" + "0 0 2 9 1 5 0 0 0 0 0 0\r\n" + "10 100 50 300\r\n"
			+ "0 0 0 0 0 0 0 0 6 2 7 8\r\n" + "10 70 180 400\r\n" + "6 9 7 7 7 5 5 0 0 0 0 0\r\n" + "10 70 200 550\r\n"
			+ "0 0 0 0 8 9 6 9 6 9 8 6\r\n" + "10 80 200 550\r\n" + "0 8 9 15 1 13 2 4 9 0 0 0\r\n"
			+ "10 130 360 1200\r\n" + "0 0 0 15 14 11 15 13 12 15 10 15\r\n" + "10 180 520 1900\r\n"
			+ "0 18 16 16 19 19 18 18 15 16 17 16\r\n" + "10 100 200 1060\r\n" + "12 9 11 13 11 8 6 12 8 7 15 6\r\n"
			+ "10 170 500 1980\r\n" + "19 18 18 17 15 19 19 16 19 15 17 18\r\n" + "10 200 580 2320\r\n"
			+ "12 28 24 24 29 25 23 26 26 28 27 22";

}
