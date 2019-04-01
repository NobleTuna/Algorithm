package sw3378_스타일리쉬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static String[] master;
	static int[] masterK;
	static String[] mine;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(TC));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			master = new String[p];
			mine = new String[q];

			for (int i = 0; i < p; i++) {
				master[i] = br.readLine();
			}
			for (int i = 0; i < q; i++) {
				mine[i] = br.readLine();
			}

			masterK = new int[p + 1];
			for (int i = 1; i < p + 1; i++) {
				int cnt = 0;
				for (int j = 0; j < master[i - 1].length(); j++) {
					if (master[i - 1].charAt(j) != '.')
						break;
					cnt++;
				}

				masterK[i - 1] = cnt;
			}
			ans = new int[q+1];
			Arrays.fill(ans, -7);
//			System.out.println(Arrays.toString(masterK));

			int R = -1;
			int C = -1;
			int S = -1;
			for (int i = 1; i <= 20; i++) {
				for (int j = 1; j <= 20; j++) {
					for (int k = 1; k <= 20; k++) {
						if (chk(i, j, k)) {
							R = i;
							C = j;
							S = k;
							ansChk(R, C, S);
						}
					}
				}
			}

//			for(int i=0; i<master.length; i++) {
//				System.out.println(master[i]);
//			}
			
			StringBuilder sb = new StringBuilder();
			sb.append(0+" ");
			for(int i=0; i<ans.length-2; i++) {
				sb.append(ans[i]+" ");
			}
			
			System.out.println("#"+tc+" "+sb.toString());

		}
	}

	static void ansChk(int R, int C, int S) {

		int r = 0, c = 0, s = 0;
		for (int i = 0; i < mine.length; i++) {
			for (int j = 0; j < mine[i].length(); j++) {
				char key = mine[i].charAt(j);
				switch (key) {
				case '(':
					r++;
					break;
				case ')':
					r--;
					break;
				case '{':
					c++;
					break;
				case '}':
					c--;
					break;
				case '[':
					s++;
					break;
				case ']':
					s--;
					break;
				}
			}
			if (ans[i] == -7) {
				ans[i] = R * r + C * c + S * s;
			} else if (ans[i] != R * r + C * c + S * s) {
				ans[i] = -1;
			}
		}

	}

	static int ans[];

	static boolean chk(int R, int C, int S) {
		int r = 0, c = 0, s = 0;

		for (int i = 0; i < master.length; i++) {
			for (int j = 0; j < master[i].length(); j++) {
				char key = master[i].charAt(j);
				switch (key) {
				case '(':
					r++;
					break;
				case ')':
					r--;
					break;
				case '{':
					c++;
					break;
				case '}':
					c--;
					break;
				case '[':
					s++;
					break;
				case ']':
					s--;
					break;
				}
			}
//			if (R == 9 && C == 5 && S == 2)
//				System.out.println(r + " " + c + " " + s + " : " + (R * r + C * c + S * s));
			if (masterK[i + 1] != (R * r + C * c + S * s)) {
				return false;
			}

		}
		return true;
	}

	static String tmp = "1\r\n" + "9 9\r\n" + "(Welcome.to\r\n" + ".........Stylish)\r\n" + "{Stylish.is\r\n"
			+ ".....[.(a.programming.language.fun.to.learn)\r\n" + ".......]\r\n" + ".....Maybe.[\r\n"
			+ ".......It.will.be.an.official.SAMSUNG.language\r\n" + ".......]\r\n" + ".....}\r\n" + "(Welcome.to\r\n"
			+ ".........Stylish)\r\n" + "{Stylish.is\r\n" + ".....[.(a.programming.language.fun.to.learn)\r\n"
			+ ".......]\r\n" + ".....Maybe.[\r\n" + ".......It.will.be.an.official.SAMSUNG.language\r\n"
			+ ".......]\r\n" + ".....}";

	static String TC = "9\r\n" + "5 4\r\n" + "(Follow.my.style\r\n" + ".........starting.from.round.brackets)\r\n"
			+ "{then.curly.brackets\r\n" + ".....[.and.finally\r\n" + ".......square.brackets.]}\r\n" + "(Thank.you\r\n"
			+ "{for.showing.me\r\n" + "[all\r\n" + "the.secrets]})\r\n" + "4 2\r\n" + "(This.time.I.will.show.you\r\n"
			+ ".........(how.to.use.round.brackets)\r\n" + ".........[but.not.about.square.brackets]\r\n"
			+ ".........{nor.curly.brackets})\r\n" + "(I.learned\r\n" + "how.to.use.round.brackets)\r\n" + "4 2\r\n"
			+ "(This.time.I.will.show.you\r\n" + ".........(how.to.use.round.brackets)\r\n"
			+ ".........[but.not.about.square.brackets]\r\n" + ".........{nor.curly.brackets})\r\n"
			+ "[I.have.not.learned\r\n" + "how.to.use.square.brackets]\r\n" + "2 2\r\n"
			+ "(Be.smart.and.let.fear.of\r\n" + "..(closed.brackets).go)\r\n"
			+ "(A.pair.of.round.brackets.enclosing\r\n" + "[A.line.enclosed.in.square.brackets])\r\n" + "1 2\r\n"
			+ "Telling.you.nothing.but.you.can.make.it\r\n" + "[One.liner.(is).(never.indented)]\r\n"
			+ "[One.liner.(is).(never.indented)]\r\n" + "2 4\r\n" + "([{Learn.from.my.KungFu\r\n" + "...}])\r\n"
			+ "((\r\n" + "{{\r\n" + "[[\r\n" + "]]}}))\r\n" + "1 2\r\n"
			+ "Do.not.waste.your.time.trying.to.read.from.emptiness\r\n" + "(\r\n" + ")\r\n" + "2 3\r\n"
			+ "({Quite.interesting.art.of.ambiguity\r\n" + "....})\r\n" + "{\r\n" + "(\r\n" + ")}\r\n" + "2 4\r\n"
			+ "({[\r\n" + "............................................................]})\r\n" + "(\r\n" + "{\r\n"
			+ "[\r\n" + "]})";
}
