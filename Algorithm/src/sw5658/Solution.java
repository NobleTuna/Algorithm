package sw5658;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(tmpInput));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			String input = br.readLine();
			
			set = new TreeSet<Item>();
			int K = N / 4;

			for (int i = 0; i < K; i++) {
				input = turn(input);
//				System.out.println(input);
				for (int j = 0; j < input.length(); j += K) {
					String tmp = input.substring(j, j + K);
//					System.out.println(tmp+" "+hexToDec(tmp));
					set.add(new Item(tmp, hexToDec(tmp)));
				}
			}

//			for(Item item : list) {
//				System.out.println(item.dec + " "+ item.hex);
//			}
			
			List<Item> list = new ArrayList<>(set);
			
			Long ans = list.get(M-1).dec;

			System.out.println("#" + tc + " " + ans);
		}
	}

	static Long hexToDec(String hex) {
		return Long.parseLong(hex, 16);
	}

	static class Item implements Comparable<Item> {
		String hex;
		Long dec;

		public Item(String hex, Long dec) {
			this.hex = hex;
			this.dec = dec;
		}

		@Override
		public int compareTo(Item o) {
			// TODO Auto-generated method stub
			return Long.compare(o.dec, this.dec);
		}
	}

	static Set<Item> set;

	static String turn(String input) {

		char tmp = input.charAt(input.length() - 1);
		char[] msg = input.toCharArray();

		for (int i = input.length() - 1; i > 0; i--) {
			msg[i] = msg[i - 1];
		}
		msg[0] = tmp;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < msg.length; i++) {
			sb.append(msg[i]);
		}
		return sb.toString();
	}

	static String tmpInput = "5\r\n" + "12 10\r\n" + "1B3B3B81F75E\r\n" + "16 2\r\n" + "F53586D76286B2D8\r\n"
			+ "20 14\r\n" + "88F611AE414A751A767B\r\n" + "24 16\r\n" + "044D3EBA6A647B2567A91D0E\r\n" + "28 11\r\n"
			+ "8E0B7DD258D4122317E3ADBFEA99";

}
