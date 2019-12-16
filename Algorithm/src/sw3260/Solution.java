package sw3260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			char[] a = new char[102];
			char[] b = new char[102];
			Arrays.fill(a, '0');
			Arrays.fill(b, '0');
			
			int[] ans = new int[102];
			char[] A = st.nextToken().toCharArray();
			char[] B = st.nextToken().toCharArray();

			int idx = a.length - 1;
			for (int i = A.length - 1; i >= 0; i--) {
				a[idx--] = A[i];
			}

			idx = b.length - 1;
			for (int i = B.length - 1; i >= 0; i--) {
				b[idx--] = B[i];
			}
			
//			for(int i=0; i<b.length; i++) {
//				System.out.print(b[i]);
//			}System.out.println();

			int carry = 0;
			for (int i = ans.length - 1; i >= 0; i--) {
				int x = a[i] - '0';
				int y = b[i] - '0';

				int c = carry + x + y;

				ans[i] = c % 10;
				carry = c / 10;

			}

			int k = 0;
			while (ans[k] == 0) {
				k++;
			}
			System.out.print("#"+tc+" ");
			for(int i = k; i<ans.length; i++) {
				System.out.print (ans[i]);
			}
			System.out.println();
		}
	}

}
