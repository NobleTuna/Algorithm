package bj17071__;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken()); // 코니
		int C = Integer.parseInt(st.nextToken()); // 브라운

		Queue<Item> q = new LinkedList<>();

		q.add(new Item(C, 1));
		q.add(new Item(B, 2));
		ans = 0;

		// go
		go(q);
		if(ans==-1)
			System.out.println(-1);
		else
			System.out.println(ans-1);

	}

	static class Item {
		int x; // 위치
		int who; // 1 : 코니 // 2 : 브라운

		public Item(int x, int who) {
			this.x = x;
			this.who = who;
		}
	}

	static int ans;

	static void go(Queue<Item> q) {

		int Coniy = -1;
		boolean visited[] = new boolean[500001];

		while (!q.isEmpty()) {
			ans++;

			int loop = q.size();

			for (int i = 0; i < loop; i++) {

				Item cur = q.poll();

				if (cur.who == 1) { // 1 : 코니
					
//					System.out.println("코니"+ cur.x);
					if (cur.x > 500000) {
						ans = -1;
						return;
					} else {
						Coniy = cur.x;
						q.add(new Item(cur.x + ans, 1));
					}
				} else { // 2 : 브라운
					visited[cur.x]=true;
//					System.out.println("브라운"+ cur.x);
					
					if (cur.x == Coniy) {
//						System.out.println("잡음" + Coniy+" "+cur.x);
						
						return;
					} else {
						if (cur.x - 1 >= 0 )
							q.add(new Item(cur.x - 1, 2));
						if (cur.x + 1 <= 500000) {
							q.add(new Item(cur.x + 1, 2));
						}
						if (cur.x * 2 <= 500000) {
							q.add(new Item(cur.x * 2, 2));
						}

					}
				}
			}

		}

	}

}
