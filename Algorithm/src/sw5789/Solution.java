package sw5789;

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
			int arr[] = new int[N+1];
			
			int Q = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= Q; i++) {
				input = br.readLine();
				st = new StringTokenizer(input);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				for(int j=a; j<=b; j++) {
					arr[j] = i;
				}
			}
			
			System.out.print("#"+tc+" ");
			for(int i=1; i<arr.length; i++) {
				System.out.print(arr[i]+" ");
			}System.out.println();
			
			
		}

	}
}
