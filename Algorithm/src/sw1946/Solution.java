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
			List<String> list = new ArrayList<String>();
			
			// sb형 리스트
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				StringTokenizer st = new StringTokenizer(input);
				char alpa = st.nextToken().charAt(0);
				int k = Integer.parseInt(br.readLine());
				
				

			}

		}

	}

}
