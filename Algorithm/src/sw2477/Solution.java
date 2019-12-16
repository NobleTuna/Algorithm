package sw2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static class People {
		int num;
		int wait;
		int counterNum;

		public People(int num, int wait, int counterNum) {
			this.num = num;
			this.wait = wait;
			this.counterNum = counterNum;
		}

		public void count() {
			this.wait--;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(TC));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 접수창구 갯수
			int M = Integer.parseInt(st.nextToken()); // 정비창구갯수
			int K = Integer.parseInt(st.nextToken()); // 사람수
			int A = Integer.parseInt(st.nextToken()) - 1; // 타겟 접수창구
			int B = Integer.parseInt(st.nextToken()) - 1; // 타겟 정비창구

			int[] counter = new int[N];
			int[] repair = new int[M];
			int[] peopleT = new int[K];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				counter[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				repair[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				peopleT[i] = Integer.parseInt(st.nextToken());
			}

			int ans = 0;
			// 기다리는 큐가 두개, 창구가 두개,

			Queue<People> waitRepair = new LinkedList<>();
			Queue<People> waitCounter = new LinkedList<>();
			People[] rCounter = new People[N];
			People[] rRepair = new People[M];

			int time = 0;
			int out = 0;

			while (true) {

				// 먼저 리페어창구 1씩뺴줌, 0되면 바로 null처리
				for (int i = 0; i < rRepair.length; i++) {
					if (rRepair[i] != null) {
						rRepair[i].count();
						if (rRepair[i].wait == 0) {
							rRepair[i] = null;
							out++;
						}
					}
				}
				if (out == K)
					break;

				// 리페어창구 null인곳에 큐에서 꺼내서 하나씩 넣음, 이때 ans에창구번호 더함
				for (int i = 0; i < rRepair.length; i++) {
					if (rRepair[i] == null) {
						if (!waitRepair.isEmpty()) {
							People P = waitRepair.poll();
							rRepair[i] = new People(P.num, repair[i], i); // 꺼내서 옮기고

							if (A == P.counterNum && B == i) { // 창구번호 둘다 같으면 사람번호 더해줌
								ans += P.num;
							}
						}
					}
				}

				/// 접수처 -1처리하면서 리페어웨이크 큐에 넣음

				for (int i = 0; i < rCounter.length; i++) {
					if (rCounter[i] != null) {
						rCounter[i].count(); // --
						if (rCounter[i].wait == 0) {
							People P = rCounter[i];
							waitRepair.add(new People(P.num, 0, i)); // 리페어웨이트 큐에 넣음
							rCounter[i] = null;
						}
					}
				}

				// 접수처 빈곳찾아 접수대기큐에서 꺼내넣음
				for (int i = 0; i < rCounter.length; i++) {
					if (rCounter[i] == null) {
						if (!waitCounter.isEmpty()) {
							People P = waitCounter.poll();
							rCounter[i] = new People(P.num, counter[i], i); // 꺼내서 옮겨
						}
					}
				}

				for (int i = 0; i < peopleT.length; i++) {
					if (peopleT[i] == time) {
						waitCounter.add(new People(i + 1, 0, 0));
					}
				}

				time++;
			}

			System.out.println("#" + tc + " " + ((ans==0)?-1:ans));

		}
	}

	static String TC1 = "1\r\n" + "1 1 2 1 1\r\n" + "5\r\n" + "7\r\n" + "7 10";
	static String TC = "10\r\n" + "1 1 2 1 1\r\n" + "5\r\n" + "7\r\n" + "7 10\r\n" + "2 2 6 1 2\r\n" + "3 2\r\n"
			+ "4 2\r\n" + "0 0 1 2 3 4\r\n" + "2 1 4 2 1\r\n" + "2 5\r\n" + "1\r\n" + "0 1 3 10\r\n" + "4 1 10 3 1\r\n"
			+ "4 6 4 8\r\n" + "1\r\n" + "0 3 4 4 5 6 9 9 9 10\r\n" + "2 2 8 2 1\r\n" + "10 3\r\n" + "2 9\r\n"
			+ "0 2 3 3 4 6 6 7\r\n" + "3 2 10 1 2\r\n" + "5 5 8\r\n" + "3 5\r\n" + "0 0 4 7 8 8 9 9 10 10\r\n"
			+ "4 2 30 4 2\r\n" + "3 2 2 10\r\n" + "2 6\r\n"
			+ "0 2 2 4 5 6 7 9 9 15 15 16 17 18 18 19 19 22 23 24 24 24 25 25 25 26 27 27 28 29\r\n" + "5 2 70 5 1\r\n"
			+ "6 6 6 4 5\r\n" + "5 6\r\n"
			+ "0 0 0 1 1 5 6 8 10 12 12 14 15 15 17 17 18 18 19 19 22 24 26 26 28 30 30 31 32 32 32 33 33 33 34 35 35 35 37 38 40 40 41 42 46 46 47 48 48 51 53 54 55 56 56 57 59 60 61 61 63 63 64 65 65 66 67 67 70 70\r\n"
			+ "4 3 100 1 3\r\n" + "9 9 5 2\r\n" + "8 7 8\r\n"
			+ "0 3 5 6 10 12 13 14 15 15 19 19 20 20 21 22 22 23 23 26 26 26 26 30 31 33 33 35 36 39 39 39 40 40 41 41 42 43 43 45 47 48 49 50 50 51 51 51 51 51 52 54 58 58 59 60 60 60 60 61 61 62 62 63 63 66 69 69 69 70 71 72 73 73 74 75 76 76 79 81 82 82 82 85 87 87 88 91 91 91 94 94 96 96 96 98 98 99 99 100\r\n"
			+ "5 3 100 1 1\r\n" + "9 10 3 5 3\r\n" + "8 8 10\r\n"
			+ "0 0 0 0 1 1 3 3 4 5 7 8 8 9 9 11 11 13 14 15 16 17 17 18 19 19 22 22 23 23 25 26 26 27 27 30 30 34 34 36 36 38 41 44 44 45 45 47 47 49 50 50 51 53 53 58 61 62 62 63 64 65 67 67 69 70 72 73 75 76 77 80 80 80 81 81 83 83 83 84 87 87 89 89 89 90 90 91 92 93 93 93 93 95 95 98 99 100 100 100";

}
