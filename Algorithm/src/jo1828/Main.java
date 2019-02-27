package jo1828; // 냉장고 // _APS_0227

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class C {
		int min;
		int max;
		int tum;

		public C(int x, int y) {
			this.min = x;
			this.max = y;
			this.tum = Math.abs(x - y);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		C arr[] = new C[N];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new C(a, b);
		}

		Arrays.sort(arr, new Comparator<C>() {
			@Override
			public int compare(C o1, C o2) {
				// TODO Auto-generated method stub
				return o1.tum - o2.tum;
			}
		});

//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i].tum + " ");
//		}

		Queue<C> q = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			q.add(arr[i]);
		}
		int result = 0;
		while (!q.isEmpty()) {

			C rfri = q.poll();
			int min = rfri.min;
			int max = rfri.max;

			int size = q.size();
			for (int i = 0; i < size; i++) {
				C item = q.poll();
				if (item.min <= min && item.max >= min) {
					max = item.max;
					System.out.println("나간놈" + item.min + " " + item.max);
				} else if (item.min <= max && item.max >= max) {
					min = item.min;
					System.out.println("나간놈" + item.min + " " + item.max);
				} else {
					q.add(item);
				}
			}
			System.out.println("최종냉장고 범위 : " + min + " " + max);
			result++;
		}
		System.out.println(result);
	}
}
