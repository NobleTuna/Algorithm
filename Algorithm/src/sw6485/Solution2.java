package sw6485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int arr[] = new int[5000 + 1];
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				StringTokenizer st = new StringTokenizer(input);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				for (int j = a; j <= b; j++) {
					arr[j]++;
				}
			}
			System.out.print("#"+tc+" ");
			int P = Integer.parseInt(br.readLine());
			for(int i=0; i<P; i++) {
				int k = Integer.parseInt(br.readLine());
				System.out.print(arr[k]+" ");
			}System.out.println();
			
			

		}
	}

}
