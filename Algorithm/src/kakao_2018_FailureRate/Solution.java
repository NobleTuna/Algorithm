package kakao_2018_FailureRate;

import java.util.Arrays;

public class Solution {
	static class StageAndFailure {
		int stageNum;
		double failure;

		public StageAndFailure(int stageNum, double failure) {
			this.stageNum = stageNum;
			this.failure = failure;
		}
	}

	public int[] solution(int N, int[] stages) {

		int[] userOnStage = new int[N + 2];
		for (int s : stages) {
			userOnStage[s]++;
		}

		System.out.println(Arrays.toString(userOnStage));

		StageAndFailure[] arr = new StageAndFailure[N + 2];
		for (int idx = 0; idx < arr.length; idx++) {
			arr[idx] = new StageAndFailure(idx, 0);
		}

		int beforeUsers = 0;
		int reachUser = stages.length;
		System.out.println("reachUser : " + reachUser);

		for (int idx = 1; idx < userOnStage.length; idx++) {
			int tmp = (reachUser - beforeUsers);
			double failure = userOnStage[idx] / tmp;
			System.out.println("tmp : " + tmp);
			System.out.println("userOnStage : " + userOnStage[idx]);
			System.out.println("failure : " + failure);
			beforeUsers += userOnStage[idx];
			arr[idx] = new StageAndFailure(idx, failure);
		}

//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i].failure);
//		}
		int[] answer = new int[N];

		return answer;
	}

	static int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution(5, stages);
	}
}
