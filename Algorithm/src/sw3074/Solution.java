package sw3074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static class Item implements Comparable<Item> {
		int time;
		Long curTime;

		public Item(int time, Long curTime) {
			this.time = time;
			this.curTime = curTime;
		}

		@Override
		public int compareTo(Item o) {
			if (this.curTime == o.curTime)
				return o.time - this.time;
			return Long.compare(o.curTime, this.curTime);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] pass = new int[N];
			for (int i = 0; i < N; i++) {
				pass[i] = Integer.parseInt(br.readLine());
			}

			Arrays.sort(pass);
			List<Item> list = new ArrayList<>();
			list.add(new Item(pass[0], (long) (pass[0] * M)));
			for (int i = 1; i < N; i++) {
				list.add(new Item(pass[i], (long) 0));
			}

			Long max = Long.MAX_VALUE;

//			for(Item item : list) {
//				System.out.println(item.curTime+" "+item.time);
//			}

			while (true) {
				Collections.sort(list);
				int time = list.get(0).time;
				Long curTime = list.get(0).curTime;
				if (max > curTime) {
					max = curTime;
					list.set(0, new Item(time, curTime - time));

					Item lastItem = list.get(list.size() - 1);

					list.set(list.size() - 1, new Item(lastItem.time, lastItem.curTime + lastItem.time));

				} else
					break;
			}

			System.out.println("#" + tc + " " + max);

		}
	}
}
