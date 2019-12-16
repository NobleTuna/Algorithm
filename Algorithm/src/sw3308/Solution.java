package sw3308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {

		LinkedList<Integer> k = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			List<Integer> list = new LinkedList<>();
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			for (int i = 0; i < N; i++) { // 구현부
				int A = Integer.parseInt(st.nextToken());

				int left = 0;
				int right = list.size() - 1;
				int target = 0;

				if (list.size() == 0 || list.get(list.size() - 1) < A) {
					list.add(A);
				} else if (A < list.get(0)) {
					list.remove(0);
					list.add(0, A);

				} else {
					while (true) {

						int mid = (left + right) / 2;
						if (list.get(mid) < A && A < list.get(mid + 1)) {
							target = mid + 1;
							break;
						}

						else if (A < list.get(mid)) {
							right = mid - 1;
						} else if (list.get(mid) < A) {
							left = mid + 1;
						}
					}
					list.remove(target);
					list.add(target, A);

				}
			}
			int result = list.size();

			System.out.println("#" + tc + " " + result);

		}
	}

}
