package bj5373; // 큐빙  안함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static char[][] U = new char[3][3]; // w
	static char[][] D = new char[3][3]; // y
	static char[][] F = new char[3][3]; // r
	static char[][] B = new char[3][3]; // o
	static char[][] L = new char[3][3]; // g
	static char[][] R = new char[3][3]; // b

	static void reset() {
		for (int i = 0; i < 3; i++)
			Arrays.fill(U, 'w');
		for (int i = 0; i < 3; i++)
			Arrays.fill(D, 'y');
		for (int i = 0; i < 3; i++)
			Arrays.fill(F, 'r');
		for (int i = 0; i < 3; i++)
			Arrays.fill(B, 'o');
		for (int i = 0; i < 3; i++)
			Arrays.fill(L, 'g');
		for (int i = 0; i < 3; i++)
			Arrays.fill(R, 'b');
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // +시계, -반시계

			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);

			for (int n = 0; n < N; n++) {
				String command = st.nextToken();
				char a = command.charAt(0); // 면
				char b = command.charAt(0); // 방향

				switch (a) { // +이면 클락 / - 이면 언클락
				case 'W':
					break;
				case 'D':
					break;
				case 'F':
					break;
				case 'B':
					break;
				case 'L':
					break;
				case 'R':
					break;
				}

			}
		}
	}

	static void UClock() {
		/// 현재면, 위, 오른쪽, 아래, 왼쪽

		char[][] rU = new char[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) { // 정면 n
				rU[i][j] = U[2 - j][i];
			}
		}
		U = rU.clone();

		char[][] rL = L.clone();
		char[][] rB = B.clone();
		char[][] rR = R.clone();
		char[][] rF = F.clone();

		rL[0][0] = F[0][0];
		rL[0][1] = F[0][1];
		rL[0][2] = F[0][2];
		
		rB[0][0] = L[0][2];
		rB[0][1] = L[0][1];
		rB[0][2] = L[0][0];
		
		

	}

	static void UUnClock() {

	}
}
