package bj16234; // 국가이동

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken()); // 비교 최소값 //이하, 이상
		R = Integer.parseInt(st.nextToken()); // 비교 최대값

		int map[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		isFinish = false;
		int ans = 0;

		while (true) { // 구현부

			isFinish = true;
			union = new int[N][N];
			unionNum = 1; // 유니온 넘버 초기화
			unionSum = new int[(N + 1) * (N + 1)]; // 유니온 숫자당 인구수 담을 배열
			unionCount = new int[(N + 1) * (N + 1)]; // 유니온 숫자당 몇국가인지 저장해놀 배열

			for (int i = 0; i < N; i++) { // 유니온이 아닌놈들을 찾아서 유니온시킴
				for (int j = 0; j < N; j++) {
					if (union[i][j] == 0) { // 연합이 없으면
						searchUnion(i, j, map);
						unionNum++;
					}
				}
			}

//			for (int i = 0; i < N; i++) {  // 연합체크
//				for (int j = 0; j < N; j++) {
//					System.out.print(union[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			// 유니온만 시키고 이동은 나중에 해야함 (중간에 인구수가 바뀌면 유니온 꼬임)

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int thisUnion = union[i][j];
					int people = unionSum[thisUnion] / unionCount[thisUnion];
					map[i][j] = people;
				}
			}
			
			if (isFinish)
				break;
			
			ans++;
		}//
		
		System.out.println(ans);
	}

	static boolean isFinish;
	static int L;
	static int R;
	static int N;
	static int union[][];
	static int unionNum;

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };

	static class Country {
		int y;
		int x;

		public Country(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int[] unionSum;
	static int[] unionCount;

	static void searchUnion(int sy, int sx, int map[][]) {
		Queue<Country> q = new LinkedList<>();

		union[sy][sx] = unionNum;
		unionSum[unionNum] += map[sy][sx];
		unionCount[unionNum]++;
		q.add(new Country(sy, sx));

		while (!q.isEmpty()) {

			Country C = q.poll();

			int y = C.y;
			int x = C.x;

			int cNum = map[y][x]; // 현재 나라 인구수

			for (int d = 0; d < 4; d++) { // 사방탐색
				int cy = y + dy[d];
				int cx = x + dx[d];

				if (cy < 0 || cx < 0 || cy >= N || cx >= N || union[cy][cx] != 0)
					continue; // 0이 아니면 이미 연합임

				int nNum = map[cy][cx]; // 다음 나라 인구 수
				int P = Math.abs(cNum - nNum);

				if (L <= P && P <= R) { // 인구수가 사이이면 연합진행
					isFinish = false;
					union[cy][cx] = unionNum;
					unionSum[unionNum] += map[cy][cx];
					unionCount[unionNum]++;
					q.add(new Country(cy, cx));
				}
			}

		} // 탐색 종료
	}
}
