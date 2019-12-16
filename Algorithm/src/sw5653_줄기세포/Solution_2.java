package sw5653_줄기세포;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2 {

	static class Position {
		int y;
		int x;
		int curAge;
		int age;
		int generation;
		boolean isStart;

		public Position(int y, int x, int curAge, int age, int generation, boolean isStart) {
			this.y = y;
			this.x = x;
			this.curAge = curAge;
			this.age = age;
			this.generation = generation;
			this.isStart = isStart;
		}

	}

	static class mapPoint {
		int age;
		int generation;

		public mapPoint(int age, int generation) {
			this.age = age;
			this.generation = generation;
		}
	}

	static int N;
	static int M;
	static mapPoint map[][];
	static int K;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(TC1));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int ans = 0;
			Queue<Position> q = new LinkedList<>();
			map = new mapPoint[600][600];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int age = Integer.parseInt(st.nextToken());
					if (age != 0) {
						map[i + 300][j + 300] = new mapPoint(age, 0);
						q.add(new Position(i + 300, j + 300, age, age, 0, false));
						ans++;
					}
				}
			}

			for (int g = 0; g < K; g++) {
				System.out.println(g + " : " + ans);
				int size = q.size();
				for (int s = 0; s < size; s++) {

					Position p = q.poll();
					int y = p.y;
					int x = p.x;
					int curAge = p.curAge;
					int age = p.age;
					int generation = p.generation;
					boolean isStart = p.isStart;

					// 꺼냇는데 내자리에 다른놈이 이미있으면 컨티뉴, 죽은놈
					System.out.println(map[y][x].age + "   " + age);
					if (map[y][x].age != age) {
						System.out.println("컨티뉴");
						continue;
					}
					// isStart 이면 일단 배양
					if (isStart) { // int y, int x, int curAge, int age, int generation, boolean isStart
						isStart = false;
						for (int d = 0; d < 4; d++) {
							int ny = y + p.y + dy[d];
							int nx = x + p.x + dx[d];

							if (map[ny][nx] == null) { // 없으면
								map[ny][nx] = new mapPoint(age, g);
								q.add(new Position(ny, nx, age, age, g, false));
								ans++;
							} else { // 있으면

								mapPoint origin = map[ny][nx];
								if (origin.generation < g) // 원래놈이 앞세대이면 컨티뉴
									continue;

								if (origin.generation == g && origin.age < age) {// 같은세대이고 생명력이 크면 덮어씌운다
									map[ny][nx] = new mapPoint(age, g);
									q.add(new Position(ny, nx, age, age, g, false));
								}
							}
						}
					}

					if (curAge > 0 && age != 0) {
						curAge--;
						if (curAge == 0) {
							q.add(new Position(y, x, age, 0, generation, true));
							continue;

						} else { // 맵은 손댈 필요 없음
							q.add(new Position(y, x, curAge, age, generation, isStart));
							continue;
						}
					}

					if (curAge > 0 && age == 0) {
						curAge--;
						if (curAge == 0) { // 진짜 죽음
							map[y][x] = new mapPoint(age, generation);
							ans--;
							continue;
						} else {
							q.add(new Position(y, x, curAge, age, generation, isStart));
							continue;
						}
					}
				}

			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static String TC1 = "1\r\n" + "2 2 10\r\n" + "1 1\r\n" + "0 2";
	static String TC = "5\r\n" + "2 2 10\r\n" + "1 1\r\n" + "0 2\r\n" + "5 5 19\r\n" + "3 2 0 3 0 \r\n"
			+ "0 3 0 0 0 \r\n" + "0 0 0 0 0 \r\n" + "0 0 1 0 0 \r\n" + "0 0 0 0 2\r\n" + "9 10 37\r\n"
			+ "0 0 0 0 0 0 0 0 3 0 \r\n" + "0 0 0 0 0 0 0 0 5 3 \r\n" + "0 0 2 0 0 0 0 4 0 0 \r\n"
			+ "3 0 0 0 0 0 4 0 0 0 \r\n" + "0 0 0 0 0 3 5 0 0 2 \r\n" + "0 0 0 0 0 0 0 0 0 5 \r\n"
			+ "0 0 0 0 0 0 0 0 2 3 \r\n" + "0 0 0 0 0 0 0 0 0 0 \r\n" + "0 0 2 2 0 0 0 0 0 0 \r\n" + "20 18 83\r\n"
			+ "0 0 0 0 0 0 0 0 0 0 0 2 0 0 6 0 0 0 \r\n" + "0 0 0 0 0 0 0 3 0 0 0 0 0 0 0 0 0 0 \r\n"
			+ "0 0 0 6 0 0 0 0 0 0 0 0 0 0 2 0 3 0 \r\n" + "4 0 2 0 0 0 0 0 0 0 0 0 5 0 0 0 0 3 \r\n"
			+ "0 0 0 0 0 5 4 4 6 0 0 0 0 0 0 0 0 0 \r\n" + "5 0 0 0 0 0 2 0 2 6 0 0 0 0 0 4 0 0 \r\n"
			+ "4 0 0 3 0 0 0 0 0 0 0 3 0 0 0 5 0 0 \r\n" + "0 0 0 0 0 0 0 2 2 0 0 0 0 3 0 0 0 0 \r\n"
			+ "0 0 0 0 5 0 0 0 3 0 3 0 0 4 0 0 0 0 \r\n" + "0 0 0 0 6 0 0 0 0 0 0 0 0 0 0 0 0 0 \r\n"
			+ "0 0 0 0 6 0 2 0 0 0 0 0 3 0 0 0 3 0 \r\n" + "0 5 2 0 0 0 0 4 0 0 0 0 0 0 0 0 0 0 \r\n"
			+ "3 0 0 0 0 0 0 0 6 0 2 0 5 0 0 0 0 0 \r\n" + "5 0 0 0 4 0 0 0 0 0 0 0 0 0 0 0 0 0 \r\n"
			+ "0 6 0 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \r\n" + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \r\n"
			+ "0 0 0 4 0 0 0 0 0 0 0 0 0 0 2 0 0 0 \r\n" + "0 0 3 4 5 0 0 0 0 0 0 0 0 0 0 6 0 0 \r\n"
			+ "2 0 0 0 0 3 0 0 0 0 0 0 0 0 0 5 0 0 \r\n" + "0 0 0 0 0 0 0 0 0 3 6 2 0 0 0 0 0 0 \r\n" + "49 43 283\r\n"
			+ "0 6 0 0 0 10 0 0 0 0 0 0 9 0 0 0 0 0 0 0 0 0 0 4 0 8 0 0 0 0 0 0 0 0 0 0 0 0 0 0 4 0 0 \r\n"
			+ "0 5 0 0 0 2 0 0 0 0 0 0 8 0 0 8 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \r\n"
			+ "0 0 3 7 0 0 0 0 0 0 9 0 1 0 5 0 0 1 0 0 0 0 0 0 0 0 0 0 0 9 0 7 0 0 0 0 0 0 0 0 1 0 0 \r\n"
			+ "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 7 0 8 0 0 0 0 0 0 0 0 0 3 0 0 0 6 0 0 0 0 6 0 0 0 0 0 0 \r\n"
			+ "7 0 0 0 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 7 0 0 0 0 8 0 0 0 0 0 0 0 0 1 0 0 \r\n"
			+ "0 9 0 0 0 0 0 0 0 0 9 6 0 2 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9 \r\n"
			+ "0 0 0 0 1 0 0 0 0 0 0 3 0 0 0 0 0 0 5 0 10 0 0 0 0 0 0 0 0 0 9 4 0 0 0 0 0 0 9 0 9 0 8 \r\n"
			+ "0 0 0 0 0 0 0 0 0 7 0 0 0 0 9 0 0 0 0 0 0 0 0 0 0 8 0 0 0 0 0 0 0 0 0 0 0 0 0 3 2 0 1 \r\n"
			+ "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 3 3 0 0 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2 0 0 0 0 0 \r\n"
			+ "0 0 0 0 0 0 0 0 0 7 0 0 0 2 0 0 0 0 0 0 8 0 0 0 0 10 0 0 1 7 0 8 0 0 0 0 0 0 0 0 0 0 0 \r\n"
			+ "0 0 0 0 0 0 0 2 0 0 9 0 0 0 0 0 8 0 0 0 0 0 4 0 6 0 0 0 0 0 0 6 0 0 0 0 0 0 0 0 0 0 0 \r\n"
			+ "1 0 0 0 0 0 0 6 0 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 6 0 5 0 0 0 0 0 0 7 0 0 0 \r\n"
			+ "8 0 0 0 0 0 0 0 0 0 0 0 0 0 0 10 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9 0 0 0 0 0 0 5 8 \r\n"
			+ "0 0 0 10 0 9 0 8 0 0 0 0 0 0 2 9 0 0 0 7 2 7 0 7 0 0 0 0 2 0 4 3 0 0 0 0 0 0 0 0 0 2 0 \r\n"
			+ "1 0 0 0 0 0 0 4 9 1 0 0 0 0 0 0 0 0 0 5 0 0 0 0 6 0 0 5 0 0 0 0 0 0 0 0 0 0 0 3 3 0 0 \r\n"
			+ "0 0 0 0 0 0 0 0 0 0 0 0 1 0 3 1 10 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 5 0 1 0 0 0 9 0 0 \r\n"
			+ "0 0 0 0 0 0 0 10 0 0 0 0 0 0 9 6 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 7 0 0 1 3 0 0 \r\n"
			+ "0 0 0 0 0 0 6 0 0 0 1 0 0 2 0 0 0 0 9 0 0 0 0 0 0 0 3 0 0 0 0 0 0 0 0 0 0 0 0 7 7 0 0 \r\n"
			+ "0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 5 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 10 \r\n"
			+ "0 0 0 0 9 0 8 0 0 0 0 0 0 4 0 0 0 10 8 0 0 0 0 0 0 10 0 0 0 5 0 0 0 0 0 0 0 1 0 0 10 4 7 \r\n"
			+ "0 0 0 0 0 0 0 0 0 0 0 6 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 8 0 0 0 4 0 7 0 0 0 0 0 3 0 \r\n"
			+ "0 0 0 0 5 0 3 0 0 0 0 0 0 0 8 1 0 0 7 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \r\n"
			+ "0 0 9 0 1 0 0 0 0 10 7 0 0 0 0 0 2 0 0 7 0 0 0 0 0 0 0 7 0 0 4 0 0 0 0 0 0 0 0 0 0 0 0 \r\n"
			+ "0 0 0 0 0 0 0 8 2 0 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 3 0 0 8 0 0 7 0 2 0 0 0 0 \r\n"
			+ "0 8 0 0 0 0 0 0 0 0 3 0 0 1 0 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 8 0 0 5 0 9 0 0 0 0 0 \r\n"
			+ "0 0 0 0 0 0 0 0 3 5 0 0 1 0 4 0 0 0 0 9 0 0 0 0 0 0 0 0 0 0 5 0 0 4 0 0 0 0 10 8 0 0 0 \r\n"
			+ "0 0 0 0 0 0 0 0 4 0 0 7 10 0 10 0 0 0 0 0 0 0 0 0 0 9 0 0 0 0 0 0 0 8 3 9 6 7 0 0 0 0 2 \r\n"
			+ "0 0 0 0 0 0 0 0 0 0 0 0 0 5 0 0 0 8 7 10 0 0 0 0 0 0 6 0 0 0 5 0 0 0 0 0 0 0 0 0 0 10 0 \r\n"
			+ "7 0 0 0 8 0 0 0 8 9 0 0 0 0 0 0 9 0 0 0 0 0 0 0 0 6 0 0 5 0 0 0 0 0 0 0 0 0 0 3 0 0 0 \r\n"
			+ "0 0 0 0 0 0 0 0 0 0 0 6 0 6 0 0 0 0 3 0 0 5 3 0 0 0 0 1 9 0 6 0 0 0 0 0 0 0 0 0 0 0 0 \r\n"
			+ "0 0 0 7 2 0 0 0 0 0 0 0 0 0 0 5 0 0 0 0 8 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 7 6 \r\n"
			+ "0 9 0 0 0 0 0 0 0 0 0 3 0 9 2 0 0 0 4 0 2 9 2 0 6 0 0 0 0 0 0 0 0 0 0 0 0 0 8 0 0 0 0 \r\n"
			+ "0 0 0 3 0 1 0 0 8 0 0 0 0 0 0 0 0 0 0 0 0 3 0 0 0 0 0 7 0 6 0 0 0 0 0 7 0 0 0 0 4 7 10 \r\n"
			+ "1 0 0 0 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 5 0 8 0 0 0 0 0 0 0 0 3 9 2 \r\n"
			+ "5 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 6 0 0 0 0 0 0 0 0 9 0 8 0 0 0 0 0 0 0 3 0 0 0 0 0 \r\n"
			+ "0 0 0 0 7 0 10 0 0 0 6 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 3 0 0 0 0 0 0 0 0 0 0 0 8 2 3 0 0 \r\n"
			+ "0 0 0 0 0 5 0 0 6 0 0 3 0 0 0 0 0 8 0 0 6 0 0 0 8 0 0 5 0 0 0 0 8 0 0 0 0 0 0 0 5 0 1 \r\n"
			+ "7 0 9 0 7 0 0 9 0 0 0 0 4 0 0 0 0 0 0 8 1 0 4 0 0 0 0 0 0 0 0 0 4 7 0 0 8 0 0 0 0 0 0 \r\n"
			+ "0 0 0 1 0 0 0 0 0 0 0 0 6 0 0 0 0 0 0 0 4 0 0 0 0 0 0 0 0 0 2 3 1 0 0 4 0 3 10 0 0 0 5 \r\n"
			+ "0 0 4 0 0 0 0 0 0 4 4 0 0 0 8 0 4 0 2 0 8 0 0 0 0 0 0 0 9 0 0 0 0 5 0 0 0 0 0 0 0 0 0 \r\n"
			+ "0 0 8 0 7 0 0 0 0 0 0 0 0 0 0 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2 6 0 0 0 0 1 0 0 0 0 4 3 \r\n"
			+ "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 10 3 0 0 0 0 0 3 0 \r\n"
			+ "0 0 2 0 0 0 0 0 8 5 0 0 0 0 0 0 0 0 0 0 0 0 4 8 0 0 0 0 0 1 0 5 0 0 0 0 2 3 9 0 0 0 0 \r\n"
			+ "0 5 8 9 0 0 0 0 0 4 0 0 0 10 0 0 0 1 0 0 0 0 0 10 0 7 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \r\n"
			+ "6 0 0 0 0 0 10 0 5 0 0 0 0 0 0 0 0 0 0 0 6 0 0 0 0 0 0 0 0 10 0 0 0 0 0 0 0 0 0 0 0 0 0 \r\n"
			+ "0 0 0 0 0 0 9 0 0 0 0 0 0 2 0 0 0 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 3 0 0 0 0 0 2 4 0 \r\n"
			+ "0 3 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 1 0 0 0 \r\n"
			+ "0 0 0 9 0 0 0 0 4 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 9 0 0 0 0 0 0 0 0 0 0 0 5 0 0 0 9 2 0 \r\n"
			+ "0 0 0 0 0 2 0 0 0 0 0 0 10 0 0 0 0 0 2 0 0 0 8 0 0 0 0 0 0 10 0 0 0 0 0 0 7 0 0 0 0 0 0 ";
}
