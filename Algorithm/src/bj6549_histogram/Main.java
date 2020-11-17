package bj6549_histogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, startLeafNode;

	static int[] tree = new int[100001 * 4];
	static long ANSWER;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		startLeafNode = 1;

		while (startLeafNode < N)
			startLeafNode *= 2;

		for (int i = 0; i < N; i++) {
			
		}

	}

}
