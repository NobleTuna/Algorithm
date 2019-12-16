package sw3307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int arr[] = new int[N];
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int[] Lis = new int[arr.length];

			for (int i = 0; i < arr.length; i++) {
				Lis[i] = 1;
				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i] && 1 + Lis[j] > Lis[i])
						Lis[i] = 1 + Lis[j];
				}
			}
			
			int result = 0;
			for(int i=0; i<arr.length; i++) {
				if(result<Lis[i]) {
					result= Lis[i];
				}
			}
			
			System.out.println("#"+tc+" "+result);
			
		}
	}

}
