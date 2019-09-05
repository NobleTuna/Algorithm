package bj10273_고대동굴탐사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static int N, E;
	static int[] cave;
	static int[][] connected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(TC1));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			answerValue = 0;
			answerCourse = new StringBuilder();

			StringTokenizer input = new StringTokenizer(br.readLine());
			N = Integer.parseInt(input.nextToken());
			E = Integer.parseInt(input.nextToken());
			cave = new int[N + 1];
			connected = new int[N + 1][N + 1];
			memory = new int[N + 1];

			input = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				cave[i] = Integer.parseInt(input.nextToken());
			}

			for (int i = 0; i < E; i++) {
				input = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(input.nextToken());
				int b = Integer.parseInt(input.nextToken());
				int c = Integer.parseInt(input.nextToken());
				connected[a][b] = c;
			}

			go(1, new StringBuilder("1").append(" "), cave[1]);

			StringTokenizer printT = new StringTokenizer(answerCourse.toString());
			System.out.println(answerValue + " " + printT.countTokens());
			System.out.println(answerCourse);
		}
	}

	static StringBuilder answerCourse;
	static int answerValue;
	static int memory[];

	public static void go(int point, StringBuilder course, int value) {
		if (memory[point] > value)
			return;
		else
			memory[point] = value;
		
		for (int i = 1; i <= N; i++) {
			if (connected[point][i] == 0) {
				if (answerValue < value) {
					answerValue = value;
					answerCourse = new StringBuilder(course);
				}
			} else {
				go(i, new StringBuilder(course).append(String.valueOf(i)).append(" "), value + cave[i] - connected[point][i]);
			}
		}
	}

	static String TC1 = "3\r\n" + "1 0\r\n" + "10\r\n" + "4 3\r\n" + "10 20 30 40\r\n" + "1 2 19\r\n" + "1 3 23\r\n"
			+ "1 4 34\r\n" + "4 4\r\n" + "10 20 30 40\r\n" + "1 2 10\r\n" + "2 4 20\r\n" + "1 3 20\r\n" + "3 4 10";
}