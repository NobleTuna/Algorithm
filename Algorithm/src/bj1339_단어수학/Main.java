package bj1339_단어수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

//		char A = 'A';
//		int k = A+0;
//		System.out.println(k); A = 65, 26개

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(TC1));
		int N = Integer.parseInt(br.readLine());

		int[] alpha = new int[26];
		String[] inputs = new String[N];

		for (int n = 0; n < N; n++) {
			inputs[n] = br.readLine();
		}

		for (int i = 0; i < N; i++) {

			int idx = 1;
			for (int j = inputs[i].length() - 1; j >= 0; j--) {
				char alphabet = inputs[i].charAt(j);
				alpha[alphabet - 65] += idx;
				idx *= 10;
			}
		}

		

		int sum = 0;

		int maxIdx = 0;
		int max = 0;
		for (int num = 9; num >= 0; num--) {
			for (int i = 0; i < alpha.length; i++) {
				if (alpha[i] > max) {
					maxIdx = i;
					max = alpha[i];
				}
			}
			sum += (num * alpha[maxIdx]);
			alpha[maxIdx] = 0;
			max = 0;
		}
		System.out.println(sum);

	}

	static String TC1 = "2\r\n" + 
			"GCF\r\n" + 
			"ACDEB";

}
