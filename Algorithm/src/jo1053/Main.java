package jo1053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int input = Integer.parseInt(br.readLine());

			if (input == -1)
				break;

			if (input == 0)
				System.out.println(0);

			if (input == 1)
				System.out.println(1);

			int a = 0;
			int b = 1;
			int c = 0;
			for (int i = 2; i <= input; i++) {
				c = a  + b ;
				System.out.println(c);
				a = b%10000;
				b = c%10000;
				
			}

			System.out.println(c%10000);
		}
	}
}
