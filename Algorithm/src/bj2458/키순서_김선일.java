package bj2458;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 키순서_김선일 {
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(b.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		int arr[][] = new int[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(b.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			arr[from][to] = 1;

		}

		answer = new int[N][N];
		for (int i = 0; i < arr.length; i++) {
			findChild(arr, i, i);
			findPar(arr, i, i);
		}
		for (int i[] : answer) {
			int temp = 0;
			for (int ii : i) {
				temp += ii;
			}
			if (temp == N - 1)
				count++;
		}
		bw.write(count + "");
		bw.flush();
	}

	static int answer[][];

	static void findPar(int arr[][], int idx, int num) {

		for (int i = 0; i < arr.length; i++) {
			if (answer[num][i] == 1)
				continue;
			if (arr[idx][i] == 1) {
				answer[num][i] = 1;
				findPar(arr, i, num);
			}
		}
	}

	static void findChild(int arr[][], int idx, int num) {
		for (int i = 0; i < arr.length; i++) {
			if (answer[num][i] == 1)
				continue;

			if (arr[i][idx] == 1) {
				answer[num][i] = 1;
				findChild(arr, i, num);
			}
		}

	}

}
