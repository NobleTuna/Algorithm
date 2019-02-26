package sw1240_; // 안해시발

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int N = Integer.parseInt(st.nextToken()); // 세로
			int M = Integer.parseInt(st.nextToken()); // 가로

			int map[][] = new int[N][M];
			result = 0;
			boolean token = false;
			for (int i = 0; i < N; i++) {
				input = br.readLine();
				char[] msg = input.toCharArray();
				for (int j = 0; j < msg.length; j++) {
					if (msg[j] != '0') { // 숫자시작
						String[] seven = new String[8];
						int idx = 0;
						int cnt = 0;
						StringBuilder sb = new StringBuilder();

						for (int k = 0; k < 56; k++) {
							{
								sb.append(msg[j + k]);
							}
						} // 여기까지 암호문한개 저장함, 이제 확인
//						System.out.println(sb.toString());
//						System.out.println(Arrays.toString(seven));
						int arr[] = comp(sb.toString());
						int k = (arr[0] + arr[2] + arr[4] + arr[6]) * 3 + arr[1] + arr[3] + arr[5] + arr[7];
						if (k % 10 == 0) {
							for (int z = 0; z < arr.length; k++) {
								result += arr[z];
							}
							token = true;
							break;
						}
						j = j + 56;
					}
				}
				if (token)
					break;

			}
			System.out.println("#" + tc + " " + result);
		}
	}

	public static int[] comp(String m) {
		System.out.println(m);

		int arr[] = new int[8];
		String[] msg = new String[8];

		char[] tmp = m.toCharArray();
		int cnt = 0;
		int idx = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tmp.length; i++) {
			if (cnt == 7) {
				msg[idx] = sb.toString();
				cnt = 0;
				idx++;
				sb.setLength(0);
			}
			cnt++;
			sb.append(tmp[i]);
		}
		msg[7] = m.substring(49, m.length());
		System.out.println(Arrays.toString(msg));

		for (int i = 0; i < msg.length; i++) {
			if (msg[i].equals("0001101")) {
				arr[i] = 0;
			} else if (msg[i].equals("0011001")) {
				arr[i] = 1;
			} else if (msg[i].equals("0010011")) {
				arr[i] = 2;
			} else if (msg[i].equals("0111101")) {
				arr[i] = 3;
			} else if (msg[i].equals("0100011")) {
				arr[i] = 4;
			} else if (msg[i].equals("0110001")) {
				arr[i] = 5;
			} else if (msg[i].equals("0101111")) {
				arr[i] = 6;
			} else if (msg[i].equals("0111011")) {
				arr[i] = 7;
			} else if (msg[i].equals("0110111")) {
				arr[i] = 8;
			} else if (msg[i].equals("0001011")) {
				arr[i] = 9;
			}
		}
		System.out.println(Arrays.toString(arr));

		return arr;
	}

}
