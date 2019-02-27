package jo1828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][2]; // 0 = 시작, 1 = 끝

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i][0] = a;
			arr[i][1] = b;
		}

		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});

		int p = 0;
		int result = 1;
		int max = arr[0][1];

		for (int i = p + 1; i < N; i++) {


			if (arr[i][0] <= max) {
				if (arr[i][1] < max) { // 기준의 최대값보다 다음놈의 최대값이 작거나 같다면 바꿈
					max = arr[i][1];
				}
			} else { // 다음놈의 최소값이 맥스를 벗어나면 냉장고 생성
				p = i; // 기준 다음놈으로 이동
				max = arr[p][1];
				result++; // 냉장고 생성
			}
		}

		System.out.println(result);

	}
}
