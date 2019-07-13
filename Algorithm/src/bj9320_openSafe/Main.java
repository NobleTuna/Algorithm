package bj9320_openSafe;
// 괄호가 문제인가?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(TC1));

		N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] password = new int[4];

			for (int i = 0; i < 4; i++) {
				password[i] = Integer.parseInt(st.nextToken());
			}

			isOk = false;
			go(password, 0);
			if (isOk)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	static boolean isOk;

	public static void go(int[] password, int idx) {
		if (idx == 4) {
			chkPassword(password, password[0], 1);
			return;
		}

		for (int i = idx; i < 4; i++) {
			swap(password, idx, i);
			go(password, idx + 1);
			swap(password, idx, i);
		}

	}

	static void swap(int[] password, int idx, int i) {
		int tmp = password[idx];
		password[idx] = password[i];
		password[i] = tmp;
	}

	public static void chkPassword(int[] password, int num, int idx) {
		if (idx == 4) {
			if (num == 24)
				isOk = true;
			return;
		}
		chkPassword(password, num + password[idx], idx + 1);
		chkPassword(password, num * password[idx], idx + 1);
		chkPassword(password, num - password[idx], idx + 1);
		chkPassword(password, num / password[idx], idx + 1);
	}

	static String TC1 = "4\r\n" + "4 7 8 8\r\n" + "1 1 2 4\r\n" + "1 1 1 1\r\n" + "1 3 4 6";

}
