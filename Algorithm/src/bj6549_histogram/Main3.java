package bj6549_histogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main3 {
	static final int INF = Integer.MAX_VALUE;
	static int N;

	static long answer;

	static int leafNodeS;

	static int[] input = new int[400001];

	static int[] tree = new int[400001];

	static int End;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			answer = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());

			if (N == 0)
				break;

			for (int i = 0; i < N*4; i++) {
				input[i] = INF;
				tree[i] = 0;

			}
			for (int ts = 1; ts < N; ts *= 2) {

				leafNodeS = ts;

			}

			leafNodeS *= 2;

//			System.out.println(leafNodeS);

			End = leafNodeS + N - 1;

			for (int i = leafNodeS; i < leafNodeS + N; i++) {

				int num = Integer.parseInt(st.nextToken());
				input[i] = num;

				tree[i] = i;

			}

//			

			for (int i = leafNodeS - 1; i > 0; i--) {
//				System.out.println(i);
				tree[i] = (input[tree[i * 2]] < input[tree[i * 2 + 1]]) ? tree[i * 2] : tree[i * 2 + 1];

			}
			run(leafNodeS, End);
//			System.out.println("calc : " + calc(4, 5));
			System.out.println(answer);

		}
	}

	public static void run(int start, int end) {

		if (start < leafNodeS || end > End)
			return;

		if (end - start < 0)
			return;

		int idx = calc(start, end);
//		System.out.println("idx : " + idx);
//
//		System.out.println("start : " + start + "; end : " + end + "; idx : " + idx + "; v : "
//				+ (end - start + 1) * input[tree[idx]]);

		if (input[tree[idx]] != INF)
			answer = Math.max(answer, (long)(end - start + 1) * input[tree[idx]]);

		run(start, idx - 1);
		run(idx + 1, end);
	}

	/**
	 * 
	 * @param start 찾을 범위 시작점
	 * @param end   찾을 범위 끝점
	 * @param idx   현재 인덱스
	 * @return 최소값 인덱스 리턴 (tree[] 값)
	 */
	public static int calc(int start, int end) {

//		start += leafNodeS - 1;
//		end += leafNodeS - 1;

		int minValue = Integer.MAX_VALUE;
		int rtn = 0;
		while (start < end) {
			if (start % 2 == 1) {
				if (minValue > input[tree[start]]) {
					minValue = input[tree[start]];
					rtn = tree[start];
				}
				start++;
			}
			if (end % 2 == 0) {
				if (minValue > input[tree[end]]) {
					minValue = input[tree[end]];
					rtn = tree[end];
				}
				end--;
			}
			start /= 2;
			end /= 2;
		}
		
		if (start == end) {
			if (minValue > input[tree[end]]) {
				return tree[end];
			}
		}

		return rtn;

	}

	static String TC3 = "4 2 3 2 1\r\n" + "0";

	static String TC2 = "7 2 1 4 5 1 3 3\r\n" + "4 1000 1000 1000 1000\r\n" + "0";
	static String TC4 = "5 1000000000 1000000000 1000000000 1000000000 1000000000\r\n" + "0";
	static String loofTest = "14 3 2 1 3 2 1 1 0 2 1 1 0 1 2\r\n" + "0";

}