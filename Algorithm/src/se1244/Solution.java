package se1244;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String input = sc.next();
			int[] num = new int[input.length()];
			for(int i = 0; i < input.length(); i++) {
				num[i] = input.charAt(i) - '0';
			}
			int N = sc.nextInt();
			solve(num, 0, 0, N);
		}
	}
	static void solve(int[] num, int idx, int cnt, int N) {
		//기본 부분 구현.
		if( cnt == N ) {
			//fin
			//num배열의 숫자를 계산해보시오ㅋ
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<num.length; i++) {
				sb.append(num[i]);
			}
			int score = Integer.parseInt(sb.toString());
			return;
		}
		//여긴 이후 다르게 처리될 거임
		if(idx == num.length) {
			
			return;
		}
		
		
		//유도된 부분 구현 및 재귀 호출
		solve(num, idx+1, cnt+1, N);
	}
}

