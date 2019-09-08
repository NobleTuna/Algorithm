package kakao_2019_coTe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution2 {

	static Queue<Character> q;
	static List<String> answerList;

	public String solution(String p) {

		q = new LinkedList<Character>();
		answerList = new ArrayList<String>();

		String answer = run(p);
		System.out.println("answer : " + answer);
		return answer;
	}

	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		sol.solution("(()())()");
	}

	public static String run(String curString) {
		if (curString.length() == 0) {
			return "";
		}

		int left = 0;
		int right = 0;
		int cutIdx = 0;
		for (int idx = 0; idx < curString.length(); idx++) {
			if (curString.charAt(idx) == '(')
				left++;
			else
				right++;
			if (left == right) {
				cutIdx = idx;
				break;
			}
		}

		String beforeString = curString.substring(0, cutIdx + 1);
		String afterString = curString.substring(cutIdx + 1, curString.length());
//		System.out.println("before : " + beforeString);
//		System.out.println("after : " + afterString);

		if (beforeString.charAt(0) == '(')
			return beforeString + run(afterString);
		else {
			return "(" + run(afterString) + ")" + reverse(beforeString);
		}
	}

	static String reverse(String input) {
		StringBuilder st = new StringBuilder();
		for (int idx = 0; idx < input.length(); idx++) {
			if (input.charAt(idx) == '(')
				st.append(')');
			else
				st.append('(');
		}

		return st.substring(1, input.length() - 1);
	}
}