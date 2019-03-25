package bj2458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 키순서_이수현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean check[][] = new boolean[n][n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			check[a][b] = true;
		}

		int ans = 0;

		label : for (int i = 0; i < n; i++) {
			boolean student[] = new boolean[n];
			student[i] = true;
			Queue<int[]> q = new LinkedList<>();

			for (int j = 0; j < n; j++) {
				if (check[i][j]) {
					q.add(new int[] { j, 1 });
					student[j] = true;
				} else {
					if (check[j][i]) {
						q.add(new int[] { j, -1 });
						student[j] = true;
					}
				}
			}

			while (!q.isEmpty()) {
				int now[] = q.poll();

				if (now[1] < 0) {
					for (int j = 0; j < n; j++) {
						if(now[0] !=j) {
							if(!student[j] && check[j][now[0]]) {
								student[j] =true;
								q.add(new int[] {j,now[1]});
							}
						}
					}
				} else {
					for (int j = 0; j < n; j++) {
						if(now[0] !=j) {
							if(!student[j] && check[now[0]][j]) {
								student[j] =true;
								q.add(new int[] {j,now[1]});
							}
						}
					}
				}
			}
			
			for(int j=0; j<n; j++)
				if(!student[j])
					continue label;
			ans++;
		}

		System.out.println(ans);
	}

}
