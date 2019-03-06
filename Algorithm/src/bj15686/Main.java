package bj15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Position {
		int y;
		int x;

		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		M = Integer.parseInt(st.nextToken()); // 치킨집 최대 숫자

		house = new ArrayList<>();
		List<Position> tmp = new ArrayList<>();

		for (int i = 0; i < N; i++) { // 맵으로 받을 필요가 없지않나?
			input = br.readLine();
			st = new StringTokenizer(input);
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					house.add(new Position(i, j));
				else if (map[i][j] == 2) {
					tmp.add(new Position(i, j));
				}
			}
		}

		chicken = new Position[tmp.size()];
		int idx = 0;
		for (Position p : tmp) {
			chicken[idx++] = p;
		}
		

		ans = Integer.MAX_VALUE;

		searchCK(0, new boolean[chicken.length], 0);
		

		/// 조합으로 치킨집 선택하고 집 좌표마다 최소값 비교해서 구한다? <
		// 집마다 가까운놈 골라가면서 M개가 넘어가기 전까지 구한다?
		System.out.println(ans);

	}

	static List<Position> house; // 집정보들
	static Position chicken[]; // 닭집정보들
	static int M; // 최대 치킨집 숫자
	static int[][] map;
	static int ans;

	static void searchCK(int cnt, boolean[] isOPen, int idx) {
		if (cnt > M) {
			return;
		}
		if (idx == chicken.length) {
			
//			for(int i=0; i<chicken.length; i++) {
//				if(isOPen[i])
//					System.out.print("1");
//				else
//					System.out.print("0");
//			}
//			System.out.println();

			int chickenRoad = 0;
			
			for (Position hp : house) { // 집주소 꺼냄
				int hy = hp.y;
				int hx = hp.x;

				int curMin = Integer.MAX_VALUE;

				for (int i = 0; i < chicken.length; i++) {
					if (isOPen[i]) { // 현재 가능한 닭집이면
						Position cp = chicken[i];
						int cy = cp.y;
						int cx = cp.x;

						int distance = Math.abs(cy - hy) + Math.abs(cx - hx);
						curMin = Math.min(curMin, distance); 
					}
				}
				if(curMin !=Integer.MAX_VALUE)
					chickenRoad += curMin; // 최소값들의 합
			}
			if(chickenRoad!=0)
				ans = Math.min(chickenRoad, ans);
			return;
		}

		isOPen[idx] = true;
		searchCK(cnt + 1, isOPen, idx + 1);
		isOPen[idx] = false;
		searchCK(cnt, isOPen, idx + 1);

	}

}
