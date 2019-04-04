package sw5653_줄기세포;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static class Position {
		int y;
		int x;
		int v; // 생명력
		int rv;
		int g; // 세대

		public Position(int y, int x, int v, int rv, int p) {
			this.y = y;
			this.x = x;
			this.v = v;
			this.rv = rv;
			this.g = p;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(TC1));
		int T = Integer.parseInt(br.readLine());

		// 배열쓰지않고 해쉬맵으로 구현해보자

		for (int tc = 1; tc <= T; tc++) {

			HashMap<String, Position> map = new HashMap<String, Position>();
			Queue<Position> q = new LinkedList<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int ans = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int v = Integer.parseInt(st.nextToken());
					if (v != 0) {
						ans++;
						Position tmp = new Position(i, j, v, v, 0);
						q.add(tmp);
						String key = i + "" + j;
						map.put(key, tmp);
					}
				}
			}

			System.out.println("초기 : " + ans);
			System.out.println();

			for (int i = 0; i < K; i++) {

				int size = q.size();
				for (int s = 0; s < size; s++) {

					Position p = q.poll();

					int y = p.y;
					int x = p.x;
					int v = p.v;
					int rv = p.rv;
					int g = p.g;

					if (v > 0 && g != -1) { // 죽을때가 안됫으면 다시 넣고 진행
						v--;
						System.out.println(y + " " + x + " 의 생명력 을 깎음: " + (v));

						if (v == 0) {
							System.out.println(y + " " + x + " 는 죽기시작함");
							String deadkey = y + "" + x;
							map.put(deadkey, new Position(y, x, -1, -1, -1));
							q.add(new Position(y, x, rv, 0, -1));
						} else
							q.add(new Position(y, x, v, rv, g));

						continue;
					} else if (g == -1) { // 활성화상태로 곧죽음
						System.out.println(y + " " + x + " 죽기시작한 처음");
						if (v - 1 != 0)
							q.add(new Position(y, x, v - 1, 0, 0));
						else if(v-1 ==0)
							ans--;
					} else if (v == 0 && rv == 0 && g == 0) { // 진짜 죽음
						ans--;
						continue;
					}

					for (int d = 0; d < 4; d++) { // 번식
						int ny = y + dy[d];
						int nx = x + dx[d];
						System.out
								.println(y + " " + x + " 로부터 " + ny + " " + nx + " 가 번식을 시도함, v : " + v + " g : " + g);
						String key = ny + "" + nx;
						if (!map.containsKey(key)) { // 맵이 비었을때
							System.out.println(ny + " " + nx + " 에 " + rv + " 생명력이 들어감");
							ans++;
							map.put(key, new Position(ny, nx, rv, rv, i));
							q.add(new Position(ny, nx, rv, rv, i));

						} else { // 맵에 누군가 있을때 우선 시체이거나 앞세대이면 컨티뉴
							Position orign = map.get(key);
							if (orign.v == -1 || orign.g < i) {
								System.out.println(
										ny + " " + nx + " 에  있던놈의 조건때문에 못감.  orign v : " + orign.v + " orign.g : " + i);
								continue;
							} else if (i == orign.g) { // 동세대이니 생명력 비교
								System.out.println(ny + " " + nx + "가 동세대이기 때문에 rv가 크면 들어감." + i + " vs " + orign.g);
								if (orign.rv < rv) {
									System.out.println(ny + " " + nx + " 의 rv가 더 크기때문에 덮어들어감");
									map.put(key, new Position(ny, nx, rv, rv, i));
									q.add(new Position(ny, nx, rv, rv, i));
								}
							}
						}
					}
				}

				System.out.println(i + 1 + "시간 : " + ans);
				System.out.println();
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };
	static String TC1 = "1\r\n" + "2 2 10\r\n" + "1 1\r\n" + "0 2";
	static String TC2 = "1\r\n" + "5 5 19\r\n" + "3 2 0 3 0 \r\n" + "0 3 0 0 0 \r\n" + "0 0 0 0 0 \r\n"
			+ "0 0 1 0 0 \r\n" + "0 0 0 0 2";

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
