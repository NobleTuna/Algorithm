package jo1239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	final static String masks[] = { "000000", "001111", "010011", "011100", "100110", "101001", "110101","111010" };
	final static char result[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };

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
//		System.out.println();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < msg.length; i++) {
			char[] target = msg[i].toCharArray();
			boolean isOk = false;

			for (int j = 0; j < masks.length; j++) {
				char[] mask = masks[j].toCharArray();
				int cnt = 0;
				for (int k = 0; k < mask.length; k++) {
					if (target[k] != mask[k])
						cnt++;
				}
				if (cnt == 0 || cnt == 1) {
//					System.out.println(msg[i]+" "+masks[j]);
//					System.out.println(cnt);
					sb.append(result[j]);
					isOk = true;
					break;
				}
			}

			if (!isOk) {
				System.out.println(i + 1);
				return;
			}

		}
		System.out.println(sb);

	}

}
