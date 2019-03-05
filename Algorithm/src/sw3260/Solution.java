package sw3260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			char[] a = new char[102];
			char[] b = new char[102];
			char[] A = st.nextToken().toCharArray();
			char[] B = st.nextToken().toCharArray();
			
			int idx = a.length-1;
			for(int i=A.length-1; i>=0; i--) {
				a[idx--] = A[i];
			}
			
			idx = b.length-1;
			for(int i=B.length-1; i>=0; i--) {
				b[idx--] = B[i];
			}
			
			
			
			
			
					
			
			
		}
	}

}
