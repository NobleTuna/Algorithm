package bj17140_이차원배열과연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int r, c, k;
	static int map[][];
	static int curR, curC;

	public static void main(String[] args) throws IOException, InterruptedException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new StringReader(TC2));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[101][101];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		curR = 3;
		curC = 3;

		int ans = -1;
		// 정렬을 위해서 클래스형배열 해야함

		for (int t = 0; t < 100; t++) {
			if (curR >= curC) {
				for (int i = 0; i < map.length; i++) {

					num cnt[] = new num[101];
					for (int n = 0; n < 101; n++) {
						cnt[n] = new num(n, 0);
					}

					for (int j = 0; j < map[i].length; j++) {
						if (map[i][j] != 0)
							cnt[map[i][j]].cnt++;
					}
//					
//					for (int n = 0; n < cnt.length; n++) {
//						System.out.println("cnt : " + cnt[n].cnt + "   i : " + cnt[n].i);
//					}
//					System.out.println();
//					
					Arrays.sort(cnt, new Comparator<num>() {

						@Override
						public int compare(num o1, num o2) {
							if (o2.cnt < o1.cnt)
								return 1;
							else if (o2.cnt > o1.cnt)
								return -1;
							else if (o2.cnt == o1.cnt)
								return o1.i - o2.i;

							return 0;
						}
					});

					for (int n = 0; n < cnt.length; n++) {
						if (cnt[n].cnt == 0)
							continue;
//						System.out.println("cnt : " + cnt[n].cnt + "   i : " + cnt[n].i);
					}
//					System.out.println();

					int idx = 0;
					int arr[] = new int[101];
					for (int n = 0; n < cnt.length; n++) {
						if (cnt[n].i == 0)
							continue;
						if (cnt[n].cnt == 0)
							continue;

						arr[idx++] = cnt[n].i;
						arr[idx++] = cnt[n].cnt;
					}
					curR = Math.max(curR, idx);
//					System.out.println(Arrays.toString(arr));
					map[i] = arr.clone();
				}

			} else {
				for (int i = 0; i < map[i].length; i++) {

					num cnt[] = new num[101];
					for (int n = 0; n < 101; n++) {
						cnt[n] = new num(n, 0);
					}

					for (int j = 0; j < map.length; j++) {
						if (map[j][i] != 0)
							cnt[map[j][i]].cnt++;
					}
//					
//					for (int n = 0; n < cnt.length; n++) {
//						System.out.println("cnt : " + cnt[n].cnt + "   i : " + cnt[n].i);
//					}
//					System.out.println();
//					
					Arrays.sort(cnt, new Comparator<num>() {

						@Override
						public int compare(num o1, num o2) {
							if (o2.cnt < o1.cnt)
								return 1;
							else if (o2.cnt > o1.cnt)
								return -1;
							else if (o2.cnt == o1.cnt)
								return o1.i - o2.i;

							return 0;
						}
					});

					for (int n = 0; n < cnt.length; n++) {
						if (cnt[n].cnt == 0)
							continue;
						System.out.println("cnt : " + cnt[n].cnt + "   i : " + cnt[n].i);
					}
					System.out.println();

					int idx = 0;
					int arr[] = new int[101];
					for (int n = 0; n < cnt.length; n++) {
						if (cnt[n].i == 0)
							continue;
						if (cnt[n].cnt == 0)
							continue;

						arr[idx++] = cnt[n].i;
						arr[idx++] = cnt[n].cnt;
					}
					curR = Math.max(curR, idx);
//					System.out.println(Arrays.toString(arr));
				}

			}

			if (map[r - 1][c - 1] == k) {
				ans = t;
				break;
			}
		}
		System.out.println(ans);
	}

	static class num {
		int i;
		int cnt;

		public num(int i, int cnt) {
			this.i = i;
			this.cnt = cnt;
		}
	}

	static String TC2 = "1 2 1\r\n" + "1 2 1\r\n" + "2 1 3\r\n" + "3 3 3";
}
