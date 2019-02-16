package dfs;

import java.util.Scanner;

public class N_queen {
	static int x[] = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static int y[] = { 0, -1, 0, 1, 1, -1, -1, 1 };
	static int cnt;

	public static void main(String[] args) {
		// 사용자로부터 n을 입력받아서 n*n 체스판에서 n개의 퀸이 서로 위협받지 않는 배치의 경우를 출력하시오.

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int map[][] = new int[N][N];
		backtrack(map, 0, N);
		System.out.println(cnt);
	}

	static void backtrack(int map[][], int line, int N) {
		if (line == N) {
			// 마지막 줄 까지 잘 놓은 경우.
			// 현재 상황이 N-Queen 들이 서로 위협인지 검사해서, 문제 없으면 Cnt++ (같은 라인을 뺀 완탐)
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			boolean isOk = true;
			for (int j = 0; j < line; j++) {
				if (map[j][i] == 1) {
					isOk = false;
				}
			}
			int left = i;
			int right = i;
			for (int j = line; j >= 0; j--) {
				if (left >= 0 && map[j][left] == 1) {
					isOk = false;
				}
				if (right < N && map[j][right] == 1) {
					isOk = false;
				}
				left--;
				right++;

			}
			if (isOk) {
				// 현재 높을라고 하는 좌표가 line, 1 인데 그 자리에 퀸을 놔도 기존에 자리잡은 퀸들을 위협하지 않는지 검사.
				map[line][i] = 1;
				backtrack(map, line + 1, N);
				map[line][i] = 0;
			}
		}
		// 0번 랑니 안에ㅓ 어딘가에 퀸을 놓고 다음 라인 호출

	}
}
