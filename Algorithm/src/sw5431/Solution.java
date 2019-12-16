package sw5431; // 민석이의 과제 체크하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			input = br.readLine();
			st = new StringTokenizer(input);
			boolean[] student = new boolean[N + 1];
			for (int i = 0; i < K; i++)
				student[Integer.parseInt(st.nextToken())] = true;
			
			System.out.print("#"+tc+" ");
			for(int i=1; i<N+1; i++) {
				if(!student[i])
					System.out.print(i+" ");
			}System.out.println();

		}
	}
}
