package sw1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			// sb형 리스트
			StringBuilder sb = new StringBuilder();
			for (int n = 0; n < N; n++) {
				String input = br.readLine();
				StringTokenizer st = new StringTokenizer(input);
				char alpa = st.nextToken().charAt(0);
				int k = Integer.parseInt(st.nextToken());
				for (int i = 0; i < k; i++) {
					sb.append(alpa);
				}
			}
			System.out.println("#"+tc);
			
			for(int i=1; i<sb.length()+1; i++) {
				System.out.print(sb.charAt(i-1));
				if(i%10==0)
					System.out.println();
			}
			System.out.println();
		}

	}

}
