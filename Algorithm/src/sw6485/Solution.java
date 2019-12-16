package sw6485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int arr[] = new int[5001];
			int N = Integer.parseInt(br.readLine());
			for (int n = 0; n < N; n++) {
				String input = br.readLine();
				StringTokenizer st = new StringTokenizer(input);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				for (int i = a; i <= b; i++) {
					arr[i]++;
				}
			}
			int P = Integer.parseInt(br.readLine());
			List<Integer> list = new ArrayList<>();
			for(int i=0; i<P; i++) {
				int t = Integer.parseInt(br.readLine());
				list.add(t);
			}
			
			System.out.print("#"+tc+" ");
			for(int t:list) {
				System.out.print(arr[t]+" ");
			}
			System.out.println();
		}
	}

}
