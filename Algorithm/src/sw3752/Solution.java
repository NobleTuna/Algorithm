package sw3752;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			scores = new int[N];

			int sum = 0;

			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			for (int n = 0; n < N; n++) {
				scores[n] = Integer.parseInt(st.nextToken());
				sum += scores[n];
			}
			scoreMap = new boolean[sum+1];
			// 다 틀린 경우 = 0
			scoreMap[0] = true;
			
			for(int i=0; i<scores.length; i++) {
				int nowScore = scores[i];
				for(int j = sum; j>=0; j--) {
					if(scoreMap[j]) {  // 기존에 어떤 점수가 있었다면
						scoreMap[j+nowScore] = true;
					}
				}
			}
			int ans = 0;
			
			for(int i=0; i<scoreMap.length; i++) {
				if(scoreMap[i])
					ans++;
			}


			System.out.println("#" + tc + " " + ans);
		}
	}
	static boolean[] scoreMap;
	static int[] scores;
	static int N;

}
