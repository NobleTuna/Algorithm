package bj2851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int ans = 0;
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += Integer.parseInt(br.readLine());
			int a = Math.abs(100 - ans);
			int b = Math.abs(100 - sum);
			if (a >= b) {
				ans = sum;
			}
		}
		System.out.println(ans);
	}

}
