package kakao_2018_FailureRate;

import java.util.Arrays;

public class Solution {
	static class StageAndFailure implements Comparable<StageAndFailure> {
		int stageNum;
		double failure;

		public StageAndFailure(int stageNum, double failure) {
			this.stageNum = stageNum;
			this.failure = failure;
		}

		@Override
		public int compareTo(StageAndFailure o) {
			if (o.failure > this.failure)
				return 1;
			else if (o.failure < this.failure)
				return -1;

			return this.stageNum - o.stageNum;

		}
	}

	public int[] solution(int N, int[] stages) {

		int[] userOnStage = new int[N + 2];
		for (int s : stages) {
			userOnStage[s]++;
		}


		StageAndFailure[] arr = new StageAndFailure[N + 2];
		for (int idx = 0; idx < arr.length; idx++) {
			arr[idx] = new StageAndFailure(idx, 0);
		}

		int beforeUsers = 0;
		int reachUser = stages.length;

		for (int idx = 1; idx < userOnStage.length; idx++) {
			int tmp = (reachUser - beforeUsers);
			double failure = (double) userOnStage[idx] / (double) tmp;
			beforeUsers += userOnStage[idx];
			arr[idx] = new StageAndFailure(idx, failure);
		}

		Arrays.sort(arr);

		int[] answer = new int[N];
		int idx = 0;
		for (StageAndFailure s : arr) {
			if(s.stageNum == 0 || s.stageNum == N+1)
				continue;
			answer[idx++] = s.stageNum;
			
		}
//		System.out.println(Arrays.toString(answer));

		return answer;
	}

	static int[] stages1 = { 2, 1, 2, 6, 2, 4, 3, 3 };
	static int[] stages2 = {4,4,4,4,4};

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution(5, stages1);
	}
}
