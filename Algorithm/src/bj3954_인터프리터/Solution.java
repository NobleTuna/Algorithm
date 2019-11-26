package bj3954_인터프리터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(TC));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // 메모리 배열 크기
			int C = Integer.parseInt(st.nextToken()); // 프로그램 코드 크기
			int I = Integer.parseInt(st.nextToken()); // 입력 크기

			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();

			char[] commandArr = input.toCharArray();
			int[] loofChk = new int[commandArr.length];

			st = new StringTokenizer(br.readLine());
			input = st.nextToken();
			char[] messageArr = input.toCharArray();

			int[] memory = new int[M];
			int memoryPointer = 0;
			int commandPointer = 0;
			int count = 0;
			boolean isLoof = false;

			while (true) {
				count++;

				// 무한루프
				if (count >= 50000000) {
					isLoof = true;
					break;
				}

				// 프로그램 정상 종료
				if (commandPointer == C)
					break;

				char command = commandArr[commandPointer];

				switch (command) {
				case '-':
					memory[memoryPointer]--;
					if (memory[memoryPointer] == -1)
						memory[memoryPointer] = 255;
					commandPointer++;
					break;

				case '+':
					memory[memoryPointer]++;
					if (memory[memoryPointer] == 256)
						memory[memoryPointer] = 0;
					commandPointer++;
					break;

				case '<':
					if (memoryPointer == 0)
						memoryPointer = memory.length - 1;
					else
						memoryPointer--;
					commandPointer++;
					break;

				case '>':
					if (memoryPointer == memory.length - 1)
						memoryPointer = 0;
					else
						memoryPointer++;
					commandPointer++;
					break;

				case '[':
					if (memory[memoryPointer] == 0) {
						loofChk[memoryPointer]++;
						int outCount = 1;
						for (int idx = commandPointer; idx < commandArr.length; idx++) {
							if (commandArr[idx] == '[') {
								outCount++;
							} else if (commandArr[idx] == ']') {
								outCount--;
								if (outCount == 0) {
									loofChk[idx]++;
									break;
								}
							}
						}
					}

					break;
				case ']':
					if (memory[memoryPointer] != 0) {
						loofChk[memoryPointer]++;
						int outCount = 1;
						for (int idx = commandPointer; idx >= 0; idx--) {
							if (commandArr[idx] == ']') {
								outCount++;
							} else if (commandArr[idx] == '[') {
								outCount--;
								if (outCount == 0) {
									loofChk[idx]++;
									break;
								}
							}
						}
					}
					break;
				case '.':
					break;
				case ',':
					break;
				default:
					break;
				}

			}
		}
	}

	static String TC = "";
}
