package sw3314; // 보충학습

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int sum = 0;
			for(int i=0; i<5; i++) {
				int k = Integer.parseInt(st.nextToken());
				if(k<40)
					k = 40;
				sum+=k;
			}
			System.out.println("#"+tc+" "+sum/5);
		}

	}
}
