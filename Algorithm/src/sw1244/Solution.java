package sw1244; // 완료

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
			ans = 0;
			solve(num, 0, 0, N);
			System.out.println(ans);
		}
	}
	static int ans = 0;
	static void solve(int[] num, int idx, int cnt, int N) {
		//기본 부분 구현.
		if( cnt == N ) {
			//fin
			//num배열의 숫자를 계산해보시오ㅋ
			int score = 0;
			for(int i = 0; i < num.length; i++) {
				score = (score * 10 + num[i]);
			}
			if( ans < score)
				ans = score;
			
			return;
		}
		//여긴 이후 다르게 처리될 거임
		if(idx == num.length-2) {
			if(cnt % 2==0) {
				solve(num, idx, N, N);
			}
			else {
				swap(num, idx, idx+1);
				solve(num, idx, N, N);
				swap(num, idx, idx+1);
			}
			return;
		}
		
		//젤 큰놈 찾자.(내 뒷놈중에)
		int bigNum = -1;
		for(int i = idx+1; i < num.length; i++) {
			if( num[i] >= bigNum)
				bigNum = num[i];
		}
		for(int i = idx+1; i < num.length; i++) {
			if(num[i] == bigNum) {
				//바꾸는 경우.
				swap(num, i, idx);
				solve(num, idx+1, cnt+1, N);
				swap(num, i, idx);
				solve(num, idx+1, cnt, N);
			}
		}
		//그놈을 idx번째와 바꾸자.
	}
	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
