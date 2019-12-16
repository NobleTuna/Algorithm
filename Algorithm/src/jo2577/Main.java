package jo2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(TC2));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int ans = 0;
		int cnt = 0;
		int[] chkNum = new int[d + 1];

		for (int i = 0; i < k; i++) {
			if (chkNum[arr[i]] == 0) {
				cnt++;
			}
			chkNum[arr[i]]++;
		}
		if (chkNum[c] == 0)
			ans = Math.max(ans, cnt + 1);
		else
			ans = Math.max(ans, cnt);

//		for (int r = 0; r < chkNum.length; r++) {
//			if (chkNum[r] != 0) {
//				for (int kk = 0; kk < chkNum[r]; kk++)
//					System.out.print(r + " ");
//			}
//		}System.out.println();
//		System.out.println(cnt);
		int front = 0;
		int end = k - 1;
		for (int i = 0; i < N; i++) {

			chkNum[arr[front]]--;
			if (chkNum[arr[front]] == 0) {
				cnt--;
			}
//			System.out.println(arr[front]+" : "+chkNum[arr[front]]);
//			System.out.println("cnt : "+cnt);
//			System.out.println();
			front++;
//			System.out.print(arr[front]);
			end++;
			if (end >= N)
				end -= N;
//			System.out.println();
//			System.out.println(arr[end]+"  : "+chkNum[arr[end]]);
			chkNum[arr[end]]++;
			if (chkNum[arr[end]] == 1) {
				cnt++;
			}

//			System.out.println(" " + arr[end] + "cnt : " + cnt + " CCCCCCCCC " + chkNum[c]);
			if (chkNum[c] == 0) {
//				System.out.println("이벤트 대상자  : " + front + " " + end);
				ans = Math.max(ans, cnt + 1);
			} else
				ans = Math.max(ans, cnt);

//			for (int r = 0; r < chkNum.length; r++) {
//				if (chkNum[r] != 0) {
//					for (int kk = 0; kk < chkNum[r]; kk++)
//						System.out.print(r + " ");
//				}
//			}
//			System.out.println();

		}

		System.out.println(ans);
	}

	static String TC1 = "8 30 4 30\r\n" + "7\r\n" + "9\r\n" + "7\r\n" + "30\r\n" + "2\r\n" + "7\r\n" + "9\r\n" + "25";
	static String TC2 = "8 50 4 7\r\n" + "2\r\n" + "7\r\n" + "9\r\n" + "25\r\n" + "7\r\n" + "9\r\n" + "7\r\n" + "30";
	static String C1 = "10 30 5 30\r\n" + "1\r\n" + "29\r\n" + "1\r\n" + "3\r\n" + "1\r\n" + "2\r\n" + "1\r\n" + "1\r\n"
			+ "2\r\n" + "29";
}
