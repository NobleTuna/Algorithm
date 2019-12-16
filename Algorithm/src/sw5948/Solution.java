package sw5948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);

			int arr[] = new int[7];

			for (int i = 0; i < 7; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			set = new HashSet<Integer>();

			go(arr, 0, 0, 0);
			
			List<Integer> list = new ArrayList<Integer>(set);		

			Collections.sort(list, Collections.reverseOrder());


			System.out.println("#" + tc + " " + list.get(4));

		}
	}

	static HashSet<Integer> set;

	public static void go(int[] arr, int idx, int cnt, int sum) {
		if (cnt == 3) {
			set.add(sum);
			return;
		}
		if (idx >= arr.length)
			return;

		go(arr, idx + 1, cnt + 1, sum + arr[idx]);

		go(arr, idx + 1, cnt, sum);

	}

}
