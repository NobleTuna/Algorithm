package lineS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//1분에 한 번씩 온도를 측정하는 장치를 가지고 있습니다.
//이 장치의 온도 센서는 100% 신뢰할 수 없으며 때로는 엄청나게 부정확한 값을 보입니다.
//하지만 새로운 장치를 구입할 비용이 없어 소프트웨어를 이용해 오차를 보정하기로 했습니다.
//
//다음항목 중 하나라도 만족하면 오차로 판단합니다.
//
//온도 < -200
//온도 > 200
//측정값 전후 2분이내에 측정한 온도 모두가 3도 이상으로 차이가 날 경우
//입력형식
//
//입력값은 최근 몇 분 동안 측정된 온도를 시간순으로 주어집니다.
//각각의 온도는 공백(Space)으로 구분되어 집니다.
//
//출력형식
//
//오차 범위 내의 유효한 측정값의 평균을 계산하여 반환합니다.
//만약 소수점이 존재한다면 버림하고 정수만 반환합니다.
//유효한 측정값이 없으면 ERROR 를 반환합니다.

public class MyCode {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(TC1));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = st.countTokens();

		int[] input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		int count = 0;
		for (int i = 0; i < N; i++) {

			boolean isOk = false;

			if (input[i] < -200 || input[i] > 200)
				continue;

			// 전후 체크
			if (i - 1 >= 0 && Math.abs(input[i - 1] - input[i]) < 3) {
				isOk = true;
			}

			if (i - 2 >= 0 && Math.abs(input[i - 2] - input[i]) < 3) {
				isOk = true;
			}

			if (i + 1 < N && Math.abs(input[i + 1] - input[i]) < 3) {
				isOk = true;
			}

			if (i + 2 < N && Math.abs(input[i + 2] - input[i]) < 3) {
				isOk = true;
			}


			if (isOk) {
				count++;
				sum += input[i];
			}
		}
		if (count == 0)
			System.out.println("ERROR");
		else {
			int ans = (int) Math.floor(sum/count);
			System.out.println(ans);
		}

	}

	static String TC1 = "10 12";

}
