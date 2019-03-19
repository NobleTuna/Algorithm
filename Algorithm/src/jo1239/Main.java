package jo1239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	final static String A = "000000";
	final static String B = "001111";
	final static String C = "010011";
	final static String D = "011100";
	final static String E = "100110";
	final static String F = "101001";
	final static String G = "110101";
	final static String H = "111010";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] msg = new String[N];

		String input = br.readLine();

		int idx = 0;
		for (int i = 0; i < input.length(); i += 6) {
			msg[idx++] = input.substring(i, i + 6);
		}

//		for (int i = 0; i < msg.length; i++) {
//			System.out.println(msg[i]);
//		}
		
		

	}

}
