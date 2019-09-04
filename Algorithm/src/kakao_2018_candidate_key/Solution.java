// https://www.welcomekakao.com/learn/courses/30/lessons/42890
package kakao_2018_candidate_key;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
	public int solution(String[][] relation) {
		N = relation[0].length;
		answers = new ArrayList<boolean[]>();
		run(0, new boolean[N], relation);
		int answer = 0;
		return answer;
	}

	static int N;
	static List<boolean[]> answers;

	static public void run(int idx, boolean[] chk, String[][] relation) {
		if (idx == N) {
			chkKey(chk, relation);
			return;
		}

		chk[idx] = true;
		run(idx + 1, chk, relation);
		chk[idx] = false;
		run(idx, chk, relation);
	}

	static public boolean chkKey(boolean[] chk, String[][] relation) {

		for (boolean[] answer : answers) {
			boolean[] arr = new boolean[chk.length];
			for (int idx = 0; idx < answer.length; idx++) {
				arr[idx] = (answer[idx] & chk[idx]);
			}
			if (Arrays.equals(arr, answer))
				return false;
		}

		HashMap<String, Boolean> chkMap = new HashMap<String, Boolean>();
		for (int i = 0; i < relation.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < relation[i].length; j++) {
				if (chk[j]) {
					sb.append(relation[i][j]);
				}
			}
			if (chkMap.containsKey(sb.toString()))
				return false;
			else
				chkMap.put(sb.toString(), true);
		}
		return true;
	}

	public static void main(String[] args) {
		String[][] TC1 = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };

		Solution sol = new Solution();
		sol.solution(TC1);
	}
}