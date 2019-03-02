package sw1493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		int arr[][] = new int[1000000][2];
		int idx = 1;
		int k = 1;
		while (true) {

			for (int i = 1; i <= k; i++) {
				arr[idx][0] = i;
				arr[idx][1] = k - i + 1;

				idx++;
				if (idx == arr.length)
					break;
			}
			if (idx == arr.length)
				break;

			k++;
		}
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int x = arr[a][0] + arr[b][0];
			int y = arr[a][1] + arr[b][1];

			int result = 0;

			for (int i = 1; i <= arr.length-1; i++) {
				if (arr[i][0] == x && arr[i][1] == y) {
					result = i;
					break;
				}
			}
			System.out.println("#"+tc+" "+result);
		}

	}

}
