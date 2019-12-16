import java.io.BufferedReader; // 1475 1871
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo31_광주_2_위영웅 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int[] cnt = new int[10];

		String inputString = br.readLine();

		char[] input = inputString.toCharArray();

		for (int i = 0; i < input.length; i++) {
			if (input[i] == '6' || input[i] == '9') {
				if (cnt[6] < cnt[9]) {
					cnt[6]++;
				} else {
					cnt[9]++;
				}
			} else {
				int k = input[i] - '0';

				cnt[k]++;
			}
		}
//			System.out.println(Arrays.toString(cnt));
		int ans = 0;

		for (int i = 0; i < cnt.length; i++) {
			ans = Math.max(ans, cnt[i]);
		}
		System.out.println(ans);

	}

}
