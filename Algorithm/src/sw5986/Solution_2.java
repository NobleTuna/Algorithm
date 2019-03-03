package sw5986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution_2 {

	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 소수 구하기
		boolean[] sosu = new boolean[1000];

		int k = 2;
		while (true) {
			if (k > Math.sqrt(sosu.length))
				break;
			for (int i = 2; i * k < sosu.length; i++) {
				sosu[k * i] = true;
			}
			k++;
		}

		list = new ArrayList<Integer>();
		for (int i = 2; i < sosu.length; i++) {
			if (!sosu[i])
				list.add(i);
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			result = 0;
			go(N, 0, 0, new int[3]);

			System.out.println("#" + tc + " " + result);
		}

	}

	static int result;

	static void go(int N, int rIdx, int post, int[] num) {
		if (rIdx == 3) {
			if (num[0] + num[1] + num[2] == N) {
				result++;
			}
			return;
		}


		for (int i = post; i < list.size(); i++) {
			
			int k = list.get(i);
			if(k>N)
				break;
			num[rIdx] = k;
			go(N, rIdx + 1, i, num);
		}
	}
}
