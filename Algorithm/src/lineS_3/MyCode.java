package lineS_3;

//몇개의 정수 구간을 입력으로 받습니다.
//그리고 정수 구간이 겹치는 경우 다음과 같이 합칠 수가 있습니다.
//
//예를 들어 1과 3사이의 정수 구간과 2와 6사이의 정수 구간은 1과 6사이의 구간으로 합칠 수가 있습니다.
//이런 식으로 여러 개의 정수 구간을 입력으로 받고 구간을 합친 결과를 만들어 주세요.
//합쳐진 결과는 작은 순으로 정렬하시기 바랍니다.
//
//입력형식
//
//하나의 입력라인에는 공백(Space)으로 구분된 두개의 숫자들 받습니다.
//입력은 여러 라인에 걸쳐서 숫자 구간을 받을 수 있습니다. (최대 10개)
//입력 숫자의 각 값은 -100 ~ 100 사이의 정수값만을 갖습니다.
//
//출력형식
//
//하나의 출력라인에는 공백(Space)으로 구분된 두개의 숫자를 출력합니다.
//구간이 여러 개인 경우에는 여러 출력라인에 걸쳐 출력합니다.
//구간은 작은 순으로 정렬하시기 바랍니다.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MyCode {

	static class Space implements Comparable<Space> {
		int a;
		int b;

		public Space(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Space o) {
			// TODO Auto-generated method stub
			return a - o.a;
		}
	}

	static List<Space> list = new ArrayList<Space>();
	static List<Integer> garbage = new ArrayList<Integer>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			Space addRange = new Space(a, b);
			if (!chk(addRange)) {
				list.add(addRange);
			}

			Collections.sort(list);
		}
		for (Space l : list) {
			System.out.println(l.a + " " + l.b);
		}

	}

	private static boolean chk(Space n) {
		for (int i = 0; i < list.size(); i++) {
			Space r = list.get(i);
			if (r.a <= n.a && r.b >= n.b) {
				for (int j = i + 1; j < list.size(); j++) {
					Space nextRange = list.get(j);

					if (nextRange.a <= n.b) {
						garbage.add(j); 
						n.b = Math.max(n.b, nextRange.b);
					} else {
						break;
					}
				}

				r.b = Math.max(r.b, n.b);
				removeAll();
				return true;
			}
		}
		return false;
	}

	private static void removeAll() {
		Collections.sort(garbage);
		for (int i = garbage.size() - 1; i >= 0; i--) {
			list.remove(garbage.get(i));
		}
		garbage.clear();
	}

}
