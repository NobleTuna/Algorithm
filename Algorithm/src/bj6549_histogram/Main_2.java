package bj6549_histogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2 {
	static final int INF = Integer.MAX_VALUE;
	static int N;

	static long answer;

	static int leafNodeS;

	static int[] from = new int[400001];

	static int[] to = new int[400001];

	static int[] tree = new int[400001];

	static int End;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		br = new BufferedReader(new StringReader(TC3));

		while (true) {
			for (int i = 0; i < tree.length; i++) {

				tree[i] = INF;

			}

			answer = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());

			if (N == 0)
				break;

			for (int ts = 1; ts < N; ts *= 2) {

				leafNodeS = ts;

			}

			leafNodeS *= 2;

//			System.out.println(leafNodeS);

			End = leafNodeS + N;

			int idx = 1;

			for (int i = leafNodeS; i < leafNodeS + N; i++) {

				int num = Integer.parseInt(st.nextToken());

				tree[i] = num;

				from[i] = idx;

				to[i] = idx;

				idx++;

			}

//			

			for (int i = leafNodeS - 1; i > 0; i--) {
//				System.out.println(i);
				tree[i] = (tree[i * 2] < tree[i * 2 + 1]) ? i * 2 : i * 2 + 1;

				from[i] = from[i * 2];

				if (to[i * 2 + 1] == 0)
					to[i] = to[i * 2];
				else
					to[i] = to[i * 2 + 1];

			}
			/**
			 * // 탐색부분 잘못됨 for (int i = 1; i < End; i++) { if (tree[i] != Integer.MAX_VALUE)
			 * answer = Math.max((to[i] - from[i] + 1) * tree[i], answer);
			 * 
			 * }
			 **/

			System.out.print("TREE ");
			for (int i = 0; i < 18; i++) {
				System.out.print(tree[i] + " ");
			}
			System.out.println();
			for (int i = 0; i < 18; i++) {
				System.out.print(from[i] + " ");
			}
//			System.out.println();
//			for (int i = 0; i < 18; i++) {
//				System.out.print(to[i] + " ");
//			}
			System.out.println();
//			System.out.println(Arrays.toString(to));
			System.out.println("calc : " + calc(1, 4, 1));
//			System.out.println(answer);

		}
	}

	/**
	 * 
	 * @param start 찾을 범위 시작점
	 * @param end 찾을 범위 끝점
	 * @param idx 현재 인덱스
	 * @return 최소값 인덱스 리턴 (tree[] 값)
	 */
	public static int calc(int start, int end, int idx) {

		if (idx >= 400001 || idx < 0)
			return 0;

		if (start <= from[idx] && to[idx] <= end) {
//			System.out.println("return" + tree[idx]);
			return tree[idx];
		}

		int leftValue = 0;
		int rightValue = 0;
		if (start > from[idx])
			leftValue = calc(start, end, idx * 2 + 1);

		if (end < to[idx])
			rightValue = calc(start, end, idx * 2);

//		System.out.println("left: " + leftValue);
//		System.out.println("right: " + rightValue);
		return Math.min(tree[leftValue], tree[rightValue]);

	}

	static String TC1 = "1\r\n" + "7\r\n" + "2 1 4 5 1 3 3";
	static String TC3 = "5 1 3 2 4 6\r\n" + "0";

	static String TC2 = "7 2 1 4 5 1 3 3\r\n" + "4 1000 1000 1000 1000\r\n" + "0";

}