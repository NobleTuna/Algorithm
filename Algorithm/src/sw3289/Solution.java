package sw3289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {

	static int parents[];
	static int ranks[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			parents = new int[N + 1];
			ranks = new int[N + 1];

			StringBuilder ans = new StringBuilder();
			for (int i = 1; i < N + 1; i++) {
				parents[i] = i;
			}

			for (int n = 0; n < M; n++) {
				st = new StringTokenizer(br.readLine());
				int C = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				

				if (C == 0) {
					union(a, b);
				} else {
					if(findParent(a)==findParent(a))
						ans.append(1);
					else
						ans.append(0);
				}
			}
			
			System.out.println("#"+tc+" "+ans.toString());
		}
	}

	static void union(int a, int b) {
		int pa = findParent(a);
		int pb = findParent(b);

		if (ranks[pa] > ranks[pb]) {
			parents[pb] = pa;
		} else {
			if (ranks[pa] == ranks[pb])
				ranks[pb]++;
			parents[pa] = pb;
		}

	}

	static int findParent(int a) {

		if (parents[a] == a)
			return a;
		else {
			return findParent(parents[a]);
		}
	}
}
