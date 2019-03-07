package sw4530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static long[] include4th;

	private static void setup() {
		// 999,999,999,999

		include4th = new long[12 + 1];
		include4th[1] = 1; // 1자리 일 경우는 4 하나
		for (int i = 2; i < include4th.length; i++) {
			include4th[i] = include4th[i - 1] * 9 + (long) Math.pow(10, i - 1);
		}
	}

	private static long getRealFloor(String floor) {
		// 층수 계산
		// 자리수 계산을 위해서 문자열을 뒤집자.
		StringBuilder sb = new StringBuilder(floor).reverse();
		boolean isMinus = false; // 마이너스 여부
		long floorCnt = 0; // 리턴할 층의 수
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c != '-') {
				int num = c - '0';
				if (num < 4) {
					// fllorCnt += A-B
					// A는 4를 빼지 않은 순수 층수
					// B 현재 상태에서 빼야하는 층수 : include4th
					floorCnt += num*Math.pow(10, i) - (num * include4th[i]);

				} else {
					// 4가 넘어가면 4X -> Math.pow(10,i)가 추가되어야 한다.
					// 위의 Math.xx 에는 include4th[i]가 중복되어 있다.
					floorCnt += num*Math.pow(10, i) - (num * include4th[i] + Math.pow(10, i) - include4th[i]);
					
				}
			} else {
				isMinus = true;
			}
		}
		return floorCnt * (isMinus ? -1 : 1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		setup(); // 4층이 포함된 것 찾기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);

			String a = st.nextToken();
			String b = st.nextToken();
			long from = getRealFloor(a);
			long to = getRealFloor(b);
			long ans;
			//같은 부호인지
			if((from>0 && to>0 )||(from<0 && to<0)) {
				ans = Math.abs(from - to);
			}else
				ans = Math.abs(from-to)-1; //0 층 뺴줌
			System.out.println("#"+tc+" "+ans);

		}
	}
}
