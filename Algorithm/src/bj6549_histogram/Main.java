package bj6549_histogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, startLeafNode;
	static int[] hightTree = new int[100001 * 4];
	static int[] tree = new int[100001 * 4];
	static int[] hights;
	static long ANS;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			if (N == 0)
				break;
			hights = new int[N + 1];
			startLeafNode = 1;

			Arrays.fill(hightTree, Integer.MAX_VALUE);
			Arrays.fill(tree, 0);

			while (startLeafNode < N)
				startLeafNode *= 2;

			for (int i = 0; i < N; i++) {
				int hight = Integer.parseInt(st.nextToken());
				hights[i + 1] = hight;
				hightTree[startLeafNode + i] = hight;
				tree[startLeafNode + i] = i + 1;
			}

			for (int i = startLeafNode - 1; i > 0; i--) {
				int idx;
				if (hightTree[i * 2] > hightTree[i * 2 + 1])
					idx = i * 2 + 1;
				else
					idx = i * 2;

				hightTree[i] = hightTree[idx];
				tree[i] = tree[idx];
			}

			ANS = Integer.MIN_VALUE;
			run(1, N);
			System.out.println(ANS);
		}
	}

	static void run(int left, int right) {
		if (right - left < 0)
			return;
		if (left <= 0 || right > N)
			return;

		int idx = query(left, right);

		long val = (long)(right - left + 1) * (long)hights[idx];
		ANS = Math.max(val, ANS);
		run(left, idx - 1);
		run(idx + 1, right);
	}

	static int query(int left, int right) {
		int target = 0;
		int min = Integer.MAX_VALUE;
		left += startLeafNode - 1;
		right += startLeafNode - 1;
		while (left < right) {
			if (left % 2 == 1) {
				if (min > hightTree[left]) {
					min = hightTree[left];
					target = tree[left];
				}
				left++;
			}
			if (right % 2 == 0) {
				if (min > hightTree[right]) {
					min = hightTree[right];
					target = tree[right];
				}
				right--;
			}
			left /= 2;
			right /= 2;
		}
		if (right == left) {
			if (min > hightTree[left]) {
				min = hightTree[left];
				target = tree[left];
			}
		}
		return target;
	}

	static String TC1 = "7 2 1 4 5 1 3 3\r\n" + "4 1000 1000 1000 1000\r\n" + "0";
}