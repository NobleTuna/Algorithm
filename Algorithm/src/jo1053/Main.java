package jo1053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] arr;
	static int[] chk;

	static void makeArr() {
		arr = new int[150001];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 10000;
		}
	}

	static void arrChk() {

		for (int i = 100; i < arr.length; i++) {
			if (arr[i] == 0 && arr[i + 1] == 1 && arr[i + 2] == 1) {
				System.out.println(i);
				break;
			}

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		makeArr();
//		arrChk();
		while (true) {
			int input = Integer.parseInt(br.readLine());

			if (input == -1)
				break;


			int k = input % 15000;
			System.out.println(arr[k]);

		}

	}
}
