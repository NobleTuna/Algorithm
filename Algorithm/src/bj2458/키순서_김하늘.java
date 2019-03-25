package bj2458;

// 백준 2468. 키 순서

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 키순서_김하늘 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		List<Integer>[] list = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
		}

		for (int i = 1; i < N + 1; i++) {
			System.out.println(list[i]);
		}

		int answer = 0;
		arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			boolean[] visited = new boolean[N + 1];
			visited[i] = true;
			cnt = 1;
			go(list, visited, i);
			arr[i] += cnt;
		}

		for (int i = 1; i < N + 1; i++) {
			if (arr[i] == N)
				answer++;
		}
		System.out.println(answer);
	}

	static int cnt;
	static int[] arr;

	static void go(List<Integer>[] list, boolean[] visited, int idx) {
		// 내가 가리키고 있는걸 다 방문
		for (int i = 0; i < list[idx].size(); i++) {
			int x = list[idx].get(i);
			if (!visited[x]) {
				visited[x] = true;
				arr[x]++; // 나를 가리키는 수.
				cnt++; // 내가 가리킬 수 있는 수.
				go(list, visited, x);
			}
		}
	}

}
