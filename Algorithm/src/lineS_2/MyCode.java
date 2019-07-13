package lineS_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//우리는 IQ 테스트문제를 많이 접합니다.
//한가지 IQ 테스트문제 유형으로 여러 개의 숫자들이 나열되고 패턴을 파악해서 다음에 나올 숫자를 맞추는 문제가 있습니다.
//예를 들어 1 2 3 4 의 숫자 목록이 주어지고 다음에 나올 숫자를 물어보는 문제같은 것들입니다.
//그리고 그 답은 5라는 걸 금방 알 수 있습니다.
//더 복잡하게 만들어서 1 3 9 27 숫자 목록이 있다면 어떤가요?
//다음 숫자가 81이라는 것을 쉽게 알 수 있나요?
//
//그러면 1 4 13 40은 어떤가요? 121 이라는 답을 구할 수 있었나요?
//이전 숫자에 3을 곱하고 1을 더하면 됩니다.
//
//자 이제 이 IQ 테스트 문제를 자동으로 풀어주는 기계를 만들어 주세요.
//기본적인 원칙은 이전 숫자에 a를 곱하고 b를 더하는 식입니다. (단 여기서 a와 b는 정수이어야 합니다. 음수는 될 수 있습니다.)
//
//입력형식
//
//입력으로는 여러 개의 숫자 목록이 주어지고 각각의 숫자는 공백(Space)으로 구분되어 집니다.
//입력 숫자 목록은 최대 30개까지 가능합니다.
//입력 숫자의 각 값은 -100 ~ 100 사이의 정수값만을 갖습니다.
//
//출력형식
//
//기본적인 원칙에 맞는 답이 없다면 ERROR를 반환합니다.
//여러 개의 가능한 답이 나온다면 VAGUE를 반환합니다.
//한 가지 답이 나온다면 그값을 반환합니다.

public class MyCode {

	static int N;
	static int[] numbers;
	static int ansCount;
	static int ans;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(TC1));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 한개일떄
		if (st.countTokens() == 1) {
			System.out.println("VAGUE");
			return;
		}

		N = st.countTokens();
		numbers = new int[N];
		ansCount = 0;
		ans = 0;

		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		searchTwoNum(0, new int[2]);

		if (ansCount == 0)
			System.out.println("ERROR");
		else if (ansCount > 1)
			System.out.println("VAGUE");
		else if (ansCount == 1)
			System.out.println(ans);

	}

	// 숫자 두개를 선택
	static void searchTwoNum(int idx, int[] searchN) {
		if (idx == 2) {
			if (chkF(searchN[0], searchN[1])) {
//				System.out.println(Arrays.toString(searchN));
				int result = numbers[N - 1] * searchN[0] + searchN[1];
				if (ansCount != 0 && ans == result) {
					return;
				} else {
					ansCount++;
					ans = numbers[N - 1] * searchN[0] + searchN[1];
				}
			}
			return;
		}

		for (int i = -100; i <= 100; i++) {
			searchN[idx] = i;
			searchTwoNum(idx + 1, searchN);
		}
	}

	// 규칙 유효성검사
	static boolean chkF(int a, int b) {

		boolean isOk = true;

		for (int i = 0; i < N - 1; i++) {
			if (numbers[i] * a + b != numbers[i + 1])
				isOk = false;
		}
//		if (isOk)
//			System.out.println(a + " " + b);
		return isOk;
	}

	static String TC1 = "1 1";
}
