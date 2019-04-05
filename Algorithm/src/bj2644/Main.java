package bj2644; // 촌수계산

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(TC1));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int targetA = Integer.parseInt(st.nextToken());
		int targetB = Integer.parseInt(st.nextToken());

		parents = new int[N + 1];
		for (int i = 1; i < parents.length; i++) {
			parents[i] = i;
		}

		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		ans = -1;
		Chone = new int[N + 1];
		findPA(targetA, targetB, 0);
//		System.out.println(Arrays.toString(Chone));
		if (ans != -1) {
			System.out.println(ans);
			return;
		} else {
			findPB(targetB, targetA, 0);
			System.out.println(ans);
		}

	}

	static int Chone[];
	static int ans;

	static void findPB(int a, int target, int cnt) {
		if (Chone[a] != 0) {
			ans = cnt + Chone[a];
			return;
		}

		if (parents[a] == target) {
			cnt++;
			ans = cnt;
			return;
		}
		if(parents[a] ==a)
			return;
		
		cnt++;
		findPB(parents[a], target, cnt);

	}

	static void findPA(int a, int target, int cnt) {
		if (parents[a] == a) {
			return;
		}

		if (parents[a] == target) {
			cnt++;
			ans = cnt;
			return;
		}

		else {
			cnt++;
			Chone[parents[a]] = cnt;
			findPA(parents[a], target, cnt);
		}
	}

	static void union(int a, int b) {
		parents[b] = a;
	}

	static String TC1 = "9\r\n" + "7 3\r\n" + "7\r\n" + "1 2\r\n" + "1 3\r\n" + "2 7\r\n" + "2 8\r\n" + "2 9\r\n"
			+ "4 5\r\n" + "4 6";
}
