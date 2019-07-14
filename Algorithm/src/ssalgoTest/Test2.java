package ssalgoTest;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
	private static int W, N; // 밀가루 무게, 봉지의 개수
	private static int[] map; // 사용되는 봉지의 종류
	private static int[] dp; // 무게별로 사용할 수 있는 봉지의 최소 개수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			W = sc.nextInt();
			N = sc.nextInt();
			map = new int[N];
			dp = new int[W + 1];
			for (int i = 0; i < N; i++) {
				map[i] = sc.nextInt();
			}
// 봉지를 순서대로 정렬
			Arrays.sort(map);
// 모든 중량을 다 처리해 줄 수 있도록 dp 배열 초기화
			dp = new int[W + 1];
			Arrays.fill(dp, -1); // 기본 값은 -1

// 봉지가 1장 사용될 수 있는 경우
			for (int i = 0; i < map.length && map[i] < dp.length; i++) { // 배열에 어떤 값을 할당할 때는 범위에 벗어나지 않도록 주의 또 주의!!
				dp[map[i]] = 1;
			}

// 각 중량별로 최소 값 찾기
			for (int i = map[0] + 1; i < dp.length; i++) { // 가장 작은 봉지가 있는 그 다음부터 찾아보자.
				
				if (dp[i] > 0) { // 이지 최소값 ==> 고민할 필요가 없다.
					continue;
				}

// ex) 1, 4, 6 키로의 봉지가 주어질 때 dp[n] = dp[n-1]+1 or dp[n-4]+2 or dp[n-6]+1 중 최소값
				int min = Integer.MAX_VALUE;
				
				for (int j = 0; j < map.length; j++) {
					int m = map[j];
					if (i > m && dp[i - m] > 0) {
						min = Math.min(dp[i - m], min);
					}
				}
				dp[i] = (min == Integer.MAX_VALUE) ? -1 : min + 1; // 아직도 MAX_VALUE라면 적절한 값을 못 찾은 경우... 아니라면 +1 즉 한장 추가
			}

			System.out.println("#" + tc + " " + dp[W]);
		}
		sc.close();
	}
}