package kakao_2019_coTe;

class Solution1 {
	public int solution(String s) {

		int minLength = s.length();

		for (int jump = 1; jump < s.length(); jump++) {
			int idx = 0;
			StringBuilder answerString = new StringBuilder();
			int count = 0;
			String before = s.substring(idx, jump);

			while (true) {
				if (minLength < answerString.length()) {
					break;
				}

				if (idx + jump > s.length()) {

					if (count == 1) {
						answerString.append(before);
					} else {
						answerString.append(count).append(before);
					}
					answerString.append(s.substring(idx, s.length()));
//					System.out.println("answer : " + answerString.toString());
					break;
				}

				String current = s.substring(idx, idx + jump);

				if (current.equals(before)) {
					idx += jump;
					count++;
				} else {
					if (count == 1) {
						answerString.append(before);
					} else {
						answerString.append(count).append(before);
					}
					count = 0;
					before = current;
				}

			}
//			System.out.println();
			minLength = Math.min(minLength, answerString.length());
		}

		int answer = minLength;
//		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		String input = "abcabcabcabcdededededede";
		sol.solution(input);
	}
}