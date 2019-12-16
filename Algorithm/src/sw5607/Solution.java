package sw5607; // 완료

import java.util.Scanner;

public class Solution {
	static int P = 1234567891;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] fact = new long[1000000 + 1];
		fact[0] = 1;
		for(int i = 1; i < fact.length; i++) {
			fact[i] = fact[i-1] * i % P;
		}
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			//1000000! mod p 를 구하시오
			long result = fact[N] * pow( fact[N-R] * fact[R] % P , P-2) % P;
			System.out.println("#" + tc + " " + result);
		}
	}
	static long pow(long a, int n) {
		int k = n;
		int cnt = 0;
		while(k != 1) {
			k/=2;
			cnt++;
		}
		long[] powMap = new long[ cnt + 1 ];
		powMap[0] = a;
		for(int i = 1; i < powMap.length; i++)
			powMap[i] = powMap[i-1] * powMap[i-1] % P;
		long result = 1;
		for(int i = 0; i < cnt+1; i++) {
			if(  ( n & (1<<i) ) != 0 ) {
				result = powMap[i] * result % P;
			}
		}
		return result;
	}
	
	static long divisionPow(long a, int n) {
		if(n == 1)
			return a;
		long result = divisionPow(a, n/2) % P;
		if( n % 2 == 0)
			return result * result % P;
		else
			return result * result % P * a % P;
	}
}
