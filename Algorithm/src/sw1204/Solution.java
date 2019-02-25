package sw1204;
import java.util.Scanner;

public class Solution {
	static int score[];
	static int max;
	static int Answer;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			Answer = 0;
			max = 0;
			int test_C = sc.nextInt();
			score = new int[101];
			for (int i = 0; i < 1000; i++) {
				score[sc.nextInt()]++;
			}
			max = 0;

			System.out.println("#" +test_C+ " " + Answer);
		}
	}
}
