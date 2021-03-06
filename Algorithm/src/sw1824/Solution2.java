package sw1824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(inputString));
		int T = Integer.parseInt(br.readLine());

		for (tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new char[R][C];
			List<Character> memoS[][]; // 방향
			List<Integer> memoM[][];
			memoS = new ArrayList[R][C];
			memoM = new ArrayList[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					memoM[i][j] = new ArrayList<>();
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					memoS[i][j] = new ArrayList<>();
				}
			}

			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
			}

//			if (tc == 62) {
//				for (int i = 0; i < R; i++) {
//					for (int j = 0; j < C; j++) {
//						System.out.print(map[i][j] + " ");
//					}
//					System.out.println();
//				}
//			}

			// go
			if (go(0, 0, 0, '>', memoS, memoM)) {
				System.out.println("#" + tc + " " + "YES");
			} else {
				System.out.println("#" + tc + " " + "NO");
			}
		}
	}

	static char map[][];
	static int R, C;

	static class H {
		int y;
		int x;
		int memory;
		char state;
		List<Character> sList[][] = new ArrayList[R][C];
		List<Integer> mList[][]= new ArrayList[R][C];

		public H(int y, int x, int memory, char state, List<Character>[][] sList, List<Integer>[][] mList) {
			this.y = y;
			this.x = x;
			this.memory = memory;
			this.state = state;
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					this.sList[i][j] = new ArrayList<>();
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					this.mList[i][j] = new ArrayList<>();
				}
			}
			
			for (int i = 0; i < sList.length; i++) {
				this.sList[i] = sList[i].clone();
			}
			for (int i = 0; i < mList.length; i++) {
				this.mList[i] = mList[i].clone();
			}
		}
	}

	static int tc;
	static Queue<H> q;

	static boolean go(int sy, int sx, int sMemory, char sState, List[][] Slist, List[][] Mlist) {

		q = new LinkedList<>();
		q.add(new H(sy, sx, sMemory, sState, Slist, Mlist));
		while (!q.isEmpty()) {

			H h = q.poll();

			int y = h.y;
			int x = h.x;
			int memory = h.memory;
			char state = h.state;
			boolean chkM = false;
			boolean chkS = false;
			int M = -1;
			int S = -1;
			List<Integer>[][] memoM = h.mList;
			List<Character>[][] memoS = h.sList;

			for (int i = 0; i < memoM[y][x].size(); i++) {
				if (memory == memoM[y][x].get(i)) {
					chkM = true;
					M = i;
					break;
				}
			}
			for (int i = 0; i < memoS[y][x].size(); i++) {
				if (state == memoS[y][x].get(i)) {
					chkS = true;
					S = i;
					break;
				}
			}

			if (chkM && chkS && M == S) {
				continue;
			} else {

//				if (tc == 62) {
//					System.out.println(y + " " + x + " state : " + state + " memory : " + memory);
//					System.out.println("memoS : " + memoS[y][x] + " memoM : " + memoM[y][x]);
//					try {
//						Thread.sleep(500);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
				memoS[y][x].add(state);
				memoM[y][x].add(memory);
			}

			switch (map[y][x]) {
			case '<':
				left(y, x, memory, state, memoS, memoM);
				break;
			case '>':
				right(y, x, memory, state, memoS, memoM);
				break;
			case '^':
				up(y, x, memory, state, memoS, memoM);
				break;
			case 'v':
				down(y, x, memory, state, memoS, memoM);
				break;
			case '_':
				if (memory == 0) {
					right(y, x, memory, state, memoS, memoM);
				} else {
					left(y, x, memory, state, memoS, memoM);
				}
				break;
			case '|':
				if (memory == 0) {
					down(y, x, memory, state, memoS, memoM);

				} else {
					up(y, x, memory, state, memoS, memoM);
				}
				break;
			case '?':
				up(y, x, memory, state, memoS, memoM);
				down(y, x, memory, state, memoS, memoM);
				left(y, x, memory, state, memoS, memoM);
				right(y, x, memory, state, memoS, memoM);
				break;
			case '.':
				dir(y, x, memory, state, memoS, memoM);
				break;
			case '@':
				return true;
			case '+':
				if (memory == 15)
					memory = 0;
				else
					memory++;
				dir(y, x, memory, state, memoS, memoM);
				break;
			case '-':
				if (memory == 0)
					memory = 15;
				else
					memory--;
				dir(y, x, memory, state, memoS, memoM);
				break;
			default:
				memory = map[y][x] - '0';
				dir(y, x, memory, state, memoS, memoM);
				break;
			}
		}
		return false;
	}

	static void dir(int y, int x, int memory, char state, List<Character>[][] memoS, List<Integer>[][] memoM) {
		switch (state) {
		case '<':
			left(y, x, memory, state, memoS, memoM);
			break;
		case '>':
			right(y, x, memory, state, memoS, memoM);
			break;
		case '^':
			up(y, x, memory, state, memoS, memoM);
			break;
		case 'v':

			down(y, x, memory, state, memoS, memoM);
			break;
		}
	}

	static void up(int y, int x, int memory, char state, List<Character>[][] memoS, List<Integer>[][] memoM) {
		if (y - 1 < 0) {
			y = R;
		}
		q.add(new H(y - 1, x, memory, '^', memoS, memoM));
	}

	static void down(int y, int x, int memory, char state, List<Character>[][] memoS, List<Integer>[][] memoM) {

		if (y + 1 == R) {
			y = -1;
		}
		q.add(new H(y + 1, x, memory, 'v', memoS, memoM));
	}

	static void left(int y, int x, int memory, char state, List<Character>[][] memoS, List<Integer>[][] memoM) {
		if (x - 1 < 0) {
			x = C;
		}
		q.add(new H(y, x - 1, memory, '<', memoS, memoM));

	}

	static void right(int y, int x, int memory, char state, List<Character>[][] memoS, List<Integer>[][] memoM) {

		if (x + 1 == C) {
			x = -1;
		}
		q.add(new H(y, x + 1, memory, '>', memoS, memoM));
	}

	static String inputString = "63\r\n" + "2 6\r\n" + "6>--v.\r\n" + ".^--_@\r\n" + "2 6\r\n" + "5>--v.\r\n"
			+ ".^--_@\r\n" + "2 6\r\n" + ".>--v.\r\n" + ".^--?@\r\n" + "4 4\r\n" + "v...\r\n" + "....\r\n" + "....\r\n"
			+ ">..@\r\n" + "4 4\r\n" + "...v\r\n" + "@...\r\n" + "....\r\n" + "^..<\r\n" + "4 4\r\n" + "@...\r\n"
			+ "....\r\n" + "....\r\n" + "....\r\n" + "4 4\r\n" + "....\r\n" + "....\r\n" + "....\r\n" + "....\r\n"
			+ "4 4\r\n" + "....\r\n" + ".@..\r\n" + "....\r\n" + "....\r\n" + "4 4\r\n" + ">0_@\r\n" + "....\r\n"
			+ "....\r\n" + "....\r\n" + "4 4\r\n" + "..v.\r\n" + "^._@\r\n" + "....\r\n" + "....\r\n" + "4 4\r\n"
			+ ".1v.\r\n" + ".@_.\r\n" + "....\r\n" + "....\r\n" + "4 4\r\n" + "v...\r\n" + "0...\r\n" + "|...\r\n"
			+ "@...\r\n" + "4 4\r\n" + "v...\r\n" + "0>..\r\n" + ">|..\r\n" + ".@..\r\n" + "4 4\r\n" + "v...\r\n"
			+ "1>..\r\n" + ">|..\r\n" + ".@..\r\n" + "4 10\r\n" + "v.........\r\n" + ".........>\r\n" + ">++++----|\r\n"
			+ ".........@\r\n" + "4 10\r\n" + "v.........\r\n" + ".........@\r\n" + ">++++---.|\r\n" + ".........>\r\n"
			+ "4 10\r\n" + "v.........\r\n" + ".........@\r\n" + ">+++.----|\r\n" + ".........>\r\n" + "11 14\r\n"
			+ ">0..........|.\r\n" + "v...........<.\r\n" + "..............\r\n" + "............>v\r\n"
			+ ">0.........+|v\r\n" + "v............<\r\n" + "............>.\r\n" + "..............\r\n"
			+ "............@.\r\n" + ">0.........-|.\r\n" + "............>.\r\n" + "11 14\r\n" + ">1........-.|.\r\n"
			+ "v...........<.\r\n" + "..............\r\n" + "............>v\r\n" + ">1..........|v\r\n"
			+ "v............<\r\n" + "............>.\r\n" + "..............\r\n" + "............@.\r\n"
			+ ">1........--|.\r\n" + "............>.\r\n" + "11 14\r\n" + ">2.......--.|.\r\n" + "v...........<.\r\n"
			+ "..............\r\n" + "............>v\r\n" + ">2.......-..|v\r\n" + "v............<\r\n"
			+ "............>.\r\n" + "..............\r\n" + "............@.\r\n" + ">2.......---|.\r\n"
			+ "............>.\r\n" + "11 14\r\n" + ">3......---.|.\r\n" + "v...........<.\r\n" + "..............\r\n"
			+ "............>v\r\n" + ">3......--..|v\r\n" + "v............<\r\n" + "............>.\r\n"
			+ "..............\r\n" + "............@.\r\n" + ">3......----|.\r\n" + "............>.\r\n" + "11 14\r\n"
			+ ">4.....----.|.\r\n" + "v...........<.\r\n" + "..............\r\n" + "............>v\r\n"
			+ ">4.....---..|v\r\n" + "v............<\r\n" + "............>.\r\n" + "..............\r\n"
			+ "............@.\r\n" + ">4.....-----|.\r\n" + "............>.\r\n" + "11 14\r\n" + ">5....-----.|.\r\n"
			+ "v...........<.\r\n" + "..............\r\n" + "............>v\r\n" + ">5....----..|v\r\n"
			+ "v............<\r\n" + "............>.\r\n" + "..............\r\n" + "............@.\r\n"
			+ ">5....------|.\r\n" + "............>.\r\n" + "11 14\r\n" + ">6...------.|.\r\n" + "v...........<.\r\n"
			+ "..............\r\n" + "............>v\r\n" + ">6...-----..|v\r\n" + "v............<\r\n"
			+ "............>.\r\n" + "..............\r\n" + "............@.\r\n" + ">6...-------|.\r\n"
			+ "............>.\r\n" + "11 14\r\n" + ">7..-------.|.\r\n" + "v...........<.\r\n" + "..............\r\n"
			+ "............>v\r\n" + ">7..------..|v\r\n" + "v............<\r\n" + "............>.\r\n"
			+ "..............\r\n" + "............@.\r\n" + ">7..--------|.\r\n" + "............>.\r\n" + "11 14\r\n"
			+ ">8.--------.|.\r\n" + "v...........<.\r\n" + "..............\r\n" + "............>v\r\n"
			+ ">8.-------..|v\r\n" + "v............<\r\n" + "............>.\r\n" + "..............\r\n"
			+ "............@.\r\n" + ">8.---------|.\r\n" + "............>.\r\n" + "11 14\r\n" + ">9---------.|.\r\n"
			+ "v...........<.\r\n" + "..............\r\n" + "............>v\r\n" + ">9--------..|v\r\n"
			+ "v............<\r\n" + "............>.\r\n" + "..............\r\n" + "............@.\r\n"
			+ ">9----------|.\r\n" + "............>.\r\n" + "5 5\r\n" + ">.v..\r\n" + ".....\r\n" + ".^?@.\r\n"
			+ "..>..\r\n" + ".....\r\n" + "5 5\r\n" + ">.v..\r\n" + ".....\r\n" + ".^?v.\r\n" + "..@..\r\n"
			+ ".....\r\n" + "5 5\r\n" + ">.v..\r\n" + ".....\r\n" + ".@?v.\r\n" + "..<..\r\n" + ".....\r\n" + "5 5\r\n"
			+ "v....\r\n" + "..@..\r\n" + ">.?v.\r\n" + "..<..\r\n" + ".....\r\n" + "4 4\r\n" + "...@\r\n" + "....\r\n"
			+ "....\r\n" + "....\r\n" + "4 4\r\n" + "v...\r\n" + "....\r\n" + "....\r\n" + "@...\r\n" + "4 4\r\n"
			+ "@...\r\n" + "....\r\n" + "....\r\n" + "....\r\n" + "4 4\r\n" + "....\r\n" + "....\r\n" + "....\r\n"
			+ "....\r\n" + "4 5\r\n" + "..v..\r\n" + "...<@\r\n" + "^.>..\r\n" + ">..v.\r\n" + "11 18\r\n"
			+ "v.................\r\n" + ".................<\r\n" + ">++++++++++++++++|\r\n" + "v................<\r\n"
			+ ".................<\r\n" + ">5+++++++++++....|\r\n" + "v................<\r\n" + "..................\r\n"
			+ ".................<\r\n" + ">9+++++++........|\r\n" + ".................@\r\n" + "11 18\r\n"
			+ "v.................\r\n" + ".................<\r\n" + ">----------------|\r\n" + "v-----5..........<\r\n"
			+ ".................<\r\n" + ">----------------|\r\n" + "v---------9......<\r\n" + "..................\r\n"
			+ ".................<\r\n" + ">----------------|\r\n" + ".................@\r\n" + "20 20\r\n"
			+ "????????????????????\r\n" + "????????????????????\r\n" + "????????????????????\r\n"
			+ "????????????????????\r\n" + "????????????????????\r\n" + "????????????????????\r\n"
			+ "????????????????????\r\n" + "????????????????????\r\n" + "????????????????????\r\n"
			+ "????????????????????\r\n" + "????????????????????\r\n" + "????????????????????\r\n"
			+ "????????????????????\r\n" + "????????????????????\r\n" + "????????????????????\r\n"
			+ "????????????????????\r\n" + "????????????????????\r\n" + "????????????????????\r\n"
			+ "????????????????????\r\n" + "???????????????????+\r\n" + "20 20\r\n" + "????????????????????\r\n"
			+ "????????????????????\r\n" + "????????????????????\r\n" + "????????????????????\r\n"
			+ "????????????????????\r\n" + "????????????????????\r\n" + "????????????????????\r\n"
			+ "????????????????????\r\n" + "????????????????????\r\n" + "????????????????????\r\n"
			+ "????????????????????\r\n" + "????????????????????\r\n" + "????????????????????\r\n"
			+ "????????????????????\r\n" + "????????????????????\r\n" + "????????????????????\r\n"
			+ "????????????????????\r\n" + "??????????????????>?\r\n" + "?????????????????^@v\r\n"
			+ "??????????????????<+\r\n" + "5 5\r\n" + "v.v.<\r\n" + ".....\r\n" + ">...^\r\n" + ".....\r\n"
			+ "..@..\r\n" + "2 6\r\n" + "6>--v.\r\n" + ".^--_@\r\n" + "2 6\r\n" + "5>--v.\r\n" + ".^--_@\r\n"
			+ "7 4\r\n" + "-@.+\r\n" + "?831\r\n" + ">32?\r\n" + ">8v0\r\n" + "84>>\r\n" + ".32>\r\n" + "@8@5\r\n"
			+ "11 4\r\n" + "->??\r\n" + "<7@1\r\n" + "3205\r\n" + "94^4\r\n" + "0_92\r\n" + "821?\r\n" + "v6-^\r\n"
			+ "2@29\r\n" + "9._?\r\n" + "12-2\r\n" + "1+-7\r\n" + "2 9\r\n" + "9_v>6710@\r\n" + "9_v>6710@\r\n"
			+ "14 8\r\n" + "v4<>0718\r\n" + "2+33^^v?\r\n" + "<@5933--\r\n" + "<<^5<2@5\r\n" + "4.867531\r\n"
			+ "+_8639>8\r\n" + ">4+377^+\r\n" + "881^-2v3\r\n" + "78._>943\r\n" + "v+27_.6?\r\n" + ">1-v9-2>\r\n"
			+ "9.??3v-+\r\n" + "30?_.20v\r\n" + "81_7539<\r\n" + "8 4\r\n" + "_>50\r\n" + "0?1>\r\n" + "v6?^\r\n"
			+ "?+>3\r\n" + "-@36\r\n" + "3483\r\n" + ">2-@\r\n" + "57?1\r\n" + "15 9\r\n" + ".^@<.33_2\r\n"
			+ "+.36307@8\r\n" + ">5722?<@@\r\n" + "+_v<^^+57\r\n" + "14<4+9_22\r\n" + "^^_18<7>5\r\n" + "_8<+2^@<?\r\n"
			+ "@+8+>>44>\r\n" + "?7.@-@7v^\r\n" + "670?-5_56\r\n" + "0^751_80?\r\n" + "4422^129.\r\n" + "37>2?v.?2\r\n"
			+ ">8>931+19\r\n" + "48_-+9+13\r\n" + "14 20\r\n" + "_?-3_7-?635?6@^6.1?6\r\n" + "<06>96+>7-1_33@^8+4<\r\n"
			+ "43+62@11?+@+2++9^<0_\r\n" + "_6v?>>^-82v-3-9.1_.4\r\n" + "+>662255>2+6^+631<@0\r\n"
			+ "6381v+0v46@+2?4>^v38\r\n" + "9>0@<04+78+45<@^@9v0\r\n" + "4?782?2vv1-0>5_96596\r\n"
			+ "+@-736-++419+v<?67@<\r\n" + "9243??.><9-@+5>v-@.0\r\n" + ">5>@63.2?-_^80067+<0\r\n"
			+ "7?21+5?1+680@8^?16?2\r\n" + "-4245^4743-3+<9-1039\r\n" + "68@9@@?85??v86_..>71\r\n" + "17 19\r\n"
			+ "^@49?07?7^7.^8@8@>1\r\n" + "2@?9.<46.86>+1.3480\r\n" + "34848_681.v69@@6?2@\r\n"
			+ "4>599-.?<9_??75?65>\r\n" + "5v<6<8v74>944_?016.\r\n" + "0>-<?-248643^3>636+\r\n"
			+ "@064-5@>?<?1^81198v\r\n" + "21^8_<7@9@+7v>@856.\r\n" + "4_<+15<^9.9>58^^6-1\r\n"
			+ "^10?0?<^1?.3>v24560\r\n" + "3@0+^0@4?03@v5<?^3.\r\n" + "6v3-?2>34.85@?v8@08\r\n"
			+ "5>3.5227v<90^^+v0_?\r\n" + "_795>@814?v159578^5\r\n" + "-v4.?^8-2_13092.072\r\n"
			+ "649.4>v4<_0-++33443\r\n" + "_2>374_-?<210v6v_89\r\n" + "17 17\r\n" + "89-.?82v81?26+@2v\r\n"
			+ "0.9.<9>5>v6--v6_8\r\n" + "-^^.13_61@6?948?9\r\n" + "34>-2_6>09354-8_8\r\n" + "2<141+3@0_><_8?_5\r\n"
			+ "27->-9>?785@-?3@.\r\n" + ".+_3<2+7<.9@<<^.?\r\n" + "v<6+7.98v>?936272\r\n" + "513@^0352>-0@_0@7\r\n"
			+ "797-^<v<49+43^v@-\r\n" + "3v.742_3-<-4>-38^\r\n" + ".2@51>71426_<77v-\r\n" + "?^2?.v2.20<16?+@3\r\n"
			+ "7^6<.@>1559@44^3.\r\n" + "4v@9+..1??34-4095\r\n" + "vv1v.8543@6^01988\r\n" + "6_.+785<+@@>6852v\r\n"
			+ "13 20\r\n" + "73^-@^-791>8>v0783+1\r\n" + "63^<>8<6><^<4235>1+2\r\n" + "1883-2?8+-3_8-@6?026\r\n"
			+ "92->+v?54<84v?8v_225\r\n" + "4.@285^-1>.82412_^5v\r\n" + "06-<.8+4<1>v<5@20_0<\r\n"
			+ "1_v72>1v>4<82.058-+0\r\n" + "+8-+5?@_>v2.452<8<>^\r\n" + "+++^v@>8---66<__2v<3\r\n"
			+ "?63>5+2230141_368829\r\n" + ".43037v+v514__072^>7\r\n" + "7^.^?v8v>5.3@07-9_^-\r\n"
			+ "<9_.3+^0><55_^24@28_\r\n" + "6 10\r\n" + "1678?<195@\r\n" + "21<8+18-3<\r\n" + "+_...5@9+3\r\n"
			+ "7_+-.103-7\r\n" + "-^6@->.@8-\r\n" + "6v@67^.4+3\r\n" + "4 17\r\n" + "1<6.87?.2?v9.1+?@\r\n"
			+ "9.?70>5@+^5@.0v6?\r\n" + "^46>4+>83++05>9?-\r\n" + "^0159_00_3<?_1<?>\r\n" + "10 8\r\n" + "@5<71954\r\n"
			+ "8..5_8>1\r\n" + "5<075>..\r\n" + "<5405+>8\r\n" + "212508+2\r\n" + "?<4_61@0\r\n" + "1^?04733\r\n"
			+ "-8+1857.\r\n" + "7_v^5858\r\n" + "1-02-8-.\r\n" + "2 9\r\n" + "05<?7+.+8\r\n" + "-@7+_.517\r\n"
			+ "3 15\r\n" + "^405v^5++<1v0<1\r\n" + ">-950^967?587<<\r\n" + "@v>^?_168@.0v08\r\n" + "18 14\r\n"
			+ "2?7@1+3v3<5>_4\r\n" + "+28+>>5850<673\r\n" + ">?6@9124504<.<\r\n" + "0>?8v2831_9-52\r\n"
			+ "+@@^6-_^<653-?\r\n" + "<+918._1^+89v^\r\n" + "+31_92@__73v9<\r\n" + "1>_5<711+.417_\r\n"
			+ "04.2v2-?5>v+37\r\n" + "_+1<2520v6v?0-\r\n" + "27<^+..3_-7++9\r\n" + "9^+v1^@.15.<15\r\n"
			+ ">579v90v397>?v\r\n" + "v>7_.@4-373+56\r\n" + "@v+4426<8<1@22\r\n" + "3+>4^9_?3+^4?2\r\n"
			+ "^>7?.??^^<-^19\r\n" + "0-_v07@8>682_@\r\n" + "13 3\r\n" + "3v^\r\n" + "-9@\r\n" + "031\r\n" + "1v6\r\n"
			+ "8^5\r\n" + "@_5\r\n" + "324\r\n" + "5v9\r\n" + "+<@\r\n" + "9-+\r\n" + "7+3\r\n" + "v7+\r\n" + "55v\r\n"
			+ "10 14\r\n" + "._29+2+1@598-?\r\n" + "_-1_v-67-3-v?1\r\n" + "477_393_@1^60+\r\n" + "<>38?+?4^994>0\r\n"
			+ "@701?++200>>->\r\n" + "@23>.<<9-_<7?>\r\n" + "85>1944._6-+1v\r\n" + "0639-@1^9-3v2.\r\n"
			+ "+9?95591-@<@9^\r\n" + "^v4?@_2_19+_9@\r\n" + "15 13\r\n" + "7?^86@^?08^81\r\n" + ">v0^43+9-.0+6\r\n"
			+ "7<?935805<81^\r\n" + "36?>6^11.163@\r\n" + "@.329><99_7.^\r\n" + "@90<^-6<?<_3.\r\n"
			+ "8771++81-<.<1\r\n" + "4^<716419__.4\r\n" + "09_3@+74v33?-\r\n" + "v7>28__22-^51\r\n"
			+ ">.-3^@?>?134<\r\n" + "v-453++<>@11^\r\n" + "@<7<<9_@<<53@\r\n" + "v16>>+v725923\r\n"
			+ "4<5.-7?@^2_2>\r\n" + "4 19\r\n" + ">3<073.6^7@@633..3-\r\n" + ".+8^4?7?73>4?<7^-9>\r\n"
			+ "_-58.?^___<_+1.^v-^\r\n" + "74?+2^5477_+>60?2..\r\n" + "";

}
