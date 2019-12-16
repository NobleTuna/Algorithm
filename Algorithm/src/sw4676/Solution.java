package sw4676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			char[] msg = input.toCharArray();
			List<Character> list = new ArrayList<Character>();
			for(int i=0; i<msg.length; i++)
				list.add(msg[i]);
			
			int N = Integer.parseInt(br.readLine());
			
			input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int[] arr = new int[N];
			for(int i=0; i<arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			for(int i=0; i<N; i++) {
				
				list.add(arr[i]+i, '-');
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<list.size(); i++) {
				System.out.print(list.get(i));
			}System.out.println();
			
		}
	}

}
