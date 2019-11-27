package bj3954_인터프리터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(TC3));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // 메모리 배열 크기
			int C = Integer.parseInt(st.nextToken()); // 프로그램 코드 크기
			int I = Integer.parseInt(st.nextToken()); // 문자열 입력 크기

			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();

			char[] commandArr = input.toCharArray();
			int[] loofChkNum = new int[commandArr.length];
			Arrays.fill(loofChkNum, -1);
			int loofPointer = 0;
			st = new StringTokenizer(br.readLine());
			input = st.nextToken();
			char[] messageArr = input.toCharArray();

			int[] memory = new int[M];
			int memoryPointer = 0;
			int commandPointer = 0;
			int oppositionpointer = 0;
			int charPointer = 0;
			int count = 0;
			boolean isLoof = false;

			while (true) {
				count++;

				// 무한루프
				if (count > 50000000) {
//					isLoof = true;
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
						// 반복된 루프
						if (loofChkNum[commandPointer] == memory[memoryPointer]) {

							isLoof = true;
							loofPointer = commandPointer;

							int outCount = 0;
							for (int idx = commandPointer; idx < commandArr.length; idx++) {
								if (commandArr[idx] == '[') {
									outCount++;
								} else if (commandArr[idx] == ']') {
									outCount--;
									if (outCount == 0) {
										oppositionpointer = idx;
										break;
									}
								}
							}

							// 루프는 아님
						} else {
							loofChkNum[commandPointer] = memory[memoryPointer];

							int outCount = 0;
							for (int idx = commandPointer; idx < commandArr.length; idx++) {
								if (commandArr[idx] == '[') {
									outCount++;
								} else if (commandArr[idx] == ']') {
									outCount--;
									if (outCount == 0) {
										commandPointer = idx;
										break;
									}
								}
							}
						}

					} else
						commandPointer++;

					break;
				case ']':
					if (memory[memoryPointer] != 0) {
						// 반복된 루프
						if (loofChkNum[commandPointer] == memory[memoryPointer]) {

							isLoof = true;
							loofPointer = commandPointer;

							int outCount = 0;
							for (int idx = commandPointer; idx >= 0; idx--) {
								if (commandArr[idx] == ']') {
									outCount++;
								} else if (commandArr[idx] == '[') {
									outCount--;
									if (outCount == 0) {
										oppositionpointer = idx;
										break;
									}
								}
							}

							// 루프는 아님
						} else {
							loofChkNum[commandPointer] = memory[memoryPointer];

							int outCount = 0;
							for (int idx = commandPointer; idx >= 0; idx--) {
								if (commandArr[idx] == ']') {
									outCount++;
								} else if (commandArr[idx] == '[') {
									outCount--;
									if (outCount == 0) {
										commandPointer = idx;
										break;
									}
								}
							}
						}

					} else
						commandPointer++;

					break;
				case '.':
					commandPointer++;
					break;
				case ',':
					int inputChar = 0;
					if (charPointer == I)
						inputChar = 255;
					else
						inputChar = messageArr[charPointer++];

					memory[memoryPointer] = inputChar;
					commandPointer++;
					break;
				default:
					break;
				}

			}

			if (isLoof) {
				System.out.println("Loops " + Math.min(loofPointer, oppositionpointer) + " "
						+ Math.max(loofPointer, oppositionpointer));

			} else {
				System.out.println("Terminates");
			}
		}
	}

	static String TC = "4\r\n" + "10 4 3\r\n" + "+-.,\r\n" + "qwe\r\n" + "1000 5 1\r\n" + "+[+-]\r\n" + "a\r\n"
			+ "100 74 4\r\n" + "+++++[->++<]>[-<+++++++>]<[->+>+>+>+<<<<]>+++>--->++++++++++>---<<<.>.>.>.\r\n"
			+ "xxyz\r\n" + "9999 52 14\r\n" + "+++++[>+++++++++<-],+[-[>--.++>+<<-]>+.->[<.>-]<<,+]\r\n"
			+ "this_is_a_test";

	static String TC1 = "1\r\n" + "1000 5 1\r\n" + "+[+-]\r\n" + "a";

	static String TC2 = "1\r\n" + "1000 10 1\r\n" + "+[,[+-]-].\r\n" + "a";
	static String TC3 = "1\r\n" + "10 9 3\r\n" + "+[-[><]-]\r\n" + "qwe";
}
