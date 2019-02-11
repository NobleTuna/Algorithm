package se1228;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			List<String> list = new LinkedList<String>();
			int oN = sc.nextInt();
			for (int i = 0; i < oN; i++) { // 리스트에 원본 저장
				list.add(sc.next());
			}
			int cN = sc.nextInt(); // 명령어 숫자
			for (int C = 0; C < cN; C++) {
				sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				for(int i=0; i<y; i++) {
					list.add(x+i, sc.next());
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case);
			for(int i=0; i<10; i++) {
				sb.append(" ").append(list.get(i));
			}
			System.out.println(sb);
		}

	}
}
