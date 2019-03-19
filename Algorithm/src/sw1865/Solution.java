	package sw1865;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.StringReader;
	import java.util.StringTokenizer;
	
	public class Solution {
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br = new BufferedReader(new StringReader(stringinput));
			int T = Integer.parseInt(br.readLine());
			for (int tc = 1; tc <= T; tc++) {
	
				N = Integer.parseInt(br.readLine());
	
				arr = new double[N][N];
				for (int i = 0; i < N; i++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					for (int j = 0; j < N; j++) {
						arr[i][j] = Double.parseDouble(st.nextToken()) * 0.01;
					}
				}
	
				ans = 0;
				go(0, 1, new boolean[N]);
				System.out.println("#" + tc + " " + String.format("%,.6f", ans * 100));
	
			}
		}
	
		static int N;
		static double arr[][];
		static double ans;
	
		static void go(int idx, double sum, boolean[] chk1) {
			if (idx >= N) {
				ans = Math.max(ans, sum);
				return;
			}
			if (sum == 0)
				return;
	
			for (int i = 0; i < N; i++) {
				if (!chk1[i]) {
					if (ans > arr[idx][i] * sum)
						continue;
					
	
					chk1[i] = true;
					go(idx + 1, sum * arr[idx][i], chk1);
					chk1[i] = false;
				}
			}
		}
	
		static String stringinput = "100\r\n" + "4\r\n" + "71 51 30 1\r\n" + "29 63 32 93\r\n" + "84 94 33 21\r\n"
				+ "56 40 80 31\r\n" + "15\r\n" + "6 82 3 49 62 7 6 24 71 22 44 86 92 30 87\r\n"
				+ "74 57 96 30 5 93 64 46 42 35 65 81 9 84 50\r\n" + "66 50 51 74 90 94 22 46 10 14 2 100 61 97 19\r\n"
				+ "95 37 82 57 35 41 72 1 81 27 92 60 73 89 83\r\n" + "51 31 77 66 27 48 23 0 11 72 42 56 54 11 51\r\n"
				+ "78 37 34 40 14 5 40 75 11 20 33 87 37 14 19\r\n" + "39 17 95 19 76 87 1 52 27 53 71 11 13 65 84\r\n"
				+ "8 23 98 29 42 21 42 88 40 49 51 36 77 85 30\r\n" + "65 56 97 70 82 35 91 92 100 94 36 50 43 93 46\r\n"
				+ "35 88 9 57 32 69 100 62 91 57 52 45 34 98 79\r\n" + "76 91 91 2 34 89 97 77 80 61 73 10 95 52 87\r\n"
				+ "84 11 33 31 37 56 4 72 12 89 71 64 23 24 56\r\n" + "30 1 53 71 72 58 14 44 4 0 7 56 19 62 98\r\n"
				+ "92 21 3 81 70 32 76 36 97 46 18 99 39 39 42\r\n" + "41 15 81 21 32 69 96 55 58 34 77 0 79 39 48\r\n"
				+ "1\r\n" + "32\r\n" + "8\r\n" + "15 16 93 35 43 17 18 94\r\n" + "50 27 69 69 46 71 65 60\r\n"
				+ "88 8 28 70 52 87 40 47\r\n" + "38 32 75 49 73 23 95 94\r\n" + "94 93 18 5 72 72 4 50\r\n"
				+ "77 62 43 32 76 57 12 12\r\n" + "28 87 91 46 23 59 7 88\r\n" + "60 97 79 21 28 40 71 21\r\n" + "9\r\n"
				+ "17 51 35 74 53 48 55 5 2\r\n" + "23 24 20 10 14 92 91 60 3\r\n" + "39 27 35 29 4 17 82 58 75\r\n"
				+ "58 33 29 71 60 6 48 51 91\r\n" + "82 98 1 19 56 32 59 69 20\r\n" + "48 9 84 61 29 90 69 66 81\r\n"
				+ "84 85 42 52 37 32 54 37 24\r\n" + "30 79 47 79 54 24 23 56 52\r\n" + "32 73 72 63 83 61 99 84 79\r\n"
				+ "5\r\n" + "41 6 56 19 15\r\n" + "42 7 60 25 46\r\n" + "60 58 35 31 75\r\n" + "78 96 60 34 13\r\n"
				+ "68 97 19 84 1\r\n" + "14\r\n" + "4 48 36 33 24 82 57 25 89 95 83 82 49 95\r\n"
				+ "13 90 11 9 17 76 34 61 11 91 3 33 90 5\r\n" + "41 98 12 12 70 97 48 21 95 55 33 54 30 6\r\n"
				+ "78 67 10 40 70 42 71 1 15 90 28 48 12 68\r\n" + "21 12 57 15 73 53 41 10 19 93 6 81 20 77\r\n"
				+ "0 12 78 7 12 18 60 33 39 99 4 57 96 80\r\n" + "52 61 43 11 60 37 54 66 18 12 22 31 72 3\r\n"
				+ "80 82 38 35 47 40 24 94 73 38 65 22 70 73\r\n" + "70 34 45 0 30 45 71 80 9 73 6 45 29 53\r\n"
				+ "44 8 68 37 95 54 68 37 0 72 0 66 37 82\r\n" + "33 28 26 16 21 64 17 43 37 90 22 1 8 0\r\n"
				+ "84 32 71 12 53 33 91 55 70 89 7 27 44 26\r\n" + "68 44 36 8 83 52 83 20 73 60 82 75 50 18\r\n"
				+ "65 7 22 35 89 14 24 60 7 25 31 67 47 34\r\n" + "13\r\n" + "80 3 25 40 34 44 50 69 69 98 24 82 31\r\n"
				+ "65 55 22 93 4 4 0 3 80 44 74 4 37\r\n" + "31 22 23 46 19 22 46 71 6 56 84 70 17\r\n"
				+ "49 9 21 62 44 53 57 60 51 59 65 66 19\r\n" + "58 69 14 15 93 35 46 24 84 28 80 41 27\r\n"
				+ "2 1 57 64 88 50 50 70 22 12 16 61 14\r\n" + "69 69 97 13 25 57 66 67 62 8 73 36 20\r\n"
				+ "91 4 36 64 0 7 41 90 31 60 68 29 18\r\n" + "1 28 38 88 44 69 74 89 95 41 35 2 16\r\n"
				+ "15 84 82 88 79 28 45 60 56 79 48 66 15\r\n" + "37 8 34 10 41 2 9 95 22 42 51 10 39\r\n"
				+ "16 45 60 83 45 84 75 10 29 47 89 1 47\r\n" + "31 32 40 35 66 12 91 82 57 33 54 4 33\r\n" + "15\r\n"
				+ "75 95 17 6 100 32 93 76 8 76 26 66 24 90 16\r\n" + "31 74 80 53 48 11 28 94 5 31 65 23 67 9 48\r\n"
				+ "8 96 61 42 7 99 27 78 20 88 3 73 88 88 22\r\n" + "35 3 5 94 73 60 61 21 91 73 49 17 11 23 50\r\n"
				+ "60 21 95 52 76 43 82 24 99 2 91 35 58 82 15\r\n" + "56 52 0 60 69 45 65 36 35 89 24 20 39 29 16\r\n"
				+ "41 2 73 75 53 100 100 78 19 56 37 80 97 75 73\r\n" + "77 0 31 10 77 19 15 26 81 57 50 41 23 73 87\r\n"
				+ "89 72 70 62 53 49 45 10 82 12 38 11 26 83 65\r\n" + "60 62 95 35 88 65 70 31 86 24 35 62 46 32 21\r\n"
				+ "23 19 70 79 18 91 4 8 59 3 21 48 96 46 27\r\n" + "4 57 52 17 60 4 42 42 53 46 72 87 0 5 96\r\n"
				+ "15 24 61 97 41 74 37 80 33 65 13 4 64 93 47\r\n" + "66 26 73 38 25 48 7 24 72 19 62 68 15 1 23\r\n"
				+ "58 83 4 47 23 12 85 46 35 62 24 95 100 74 31\r\n" + "2\r\n" + "87 34\r\n" + "30 88\r\n" + "10\r\n"
				+ "95 86 95 68 7 54 65 91 76 34\r\n" + "58 30 33 33 5 12 31 59 4 39\r\n"
				+ "84 66 75 25 89 48 93 84 11 57\r\n" + "5 4 81 53 51 87 62 28 60 49\r\n"
				+ "36 56 95 62 9 85 34 5 56 21\r\n" + "70 6 46 55 89 73 84 4 17 95\r\n"
				+ "85 100 20 2 47 55 81 10 67 98\r\n" + "48 14 4 70 32 46 90 97 34 87\r\n"
				+ "68 13 69 34 30 78 83 95 68 82\r\n" + "54 52 38 74 29 59 14 98 43 61\r\n" + "6\r\n"
				+ "39 32 19 30 79 35\r\n" + "24 31 44 94 5 22\r\n" + "58 86 7 0 33 32\r\n" + "100 98 55 71 7 42\r\n"
				+ "81 72 56 67 89 14\r\n" + "45 60 100 100 96 22\r\n" + "1\r\n" + "67\r\n" + "3\r\n" + "65 28 18\r\n"
				+ "57 60 29\r\n" + "70 57 36\r\n" + "8\r\n" + "75 93 55 76 42 7 11 4\r\n" + "10 92 85 18 49 33 87 100\r\n"
				+ "79 17 91 12 57 85 99 100\r\n" + "48 92 60 62 96 67 99 42\r\n" + "69 1 28 35 64 83 4 58\r\n"
				+ "13 74 61 95 47 63 98 86\r\n" + "54 72 18 32 49 6 72 69\r\n" + "44 42 33 56 41 43 47 44\r\n" + "7\r\n"
				+ "61 61 78 70 44 2 77\r\n" + "69 86 20 2 87 89 34\r\n" + "27 20 51 50 5 83 69\r\n"
				+ "42 23 39 59 79 75 9\r\n" + "79 41 30 56 11 33 99\r\n" + "31 100 23 96 1 44 46\r\n"
				+ "82 13 48 27 24 15 13\r\n" + "4\r\n" + "25 12 38 31\r\n" + "9 71 17 49\r\n" + "62 33 91 20\r\n"
				+ "26 30 26 37\r\n" + "9\r\n" + "8 25 32 20 0 58 5 91 50\r\n" + "33 40 32 79 29 66 97 51 2\r\n"
				+ "76 38 95 23 67 26 62 15 22\r\n" + "54 20 84 32 4 47 43 50 33\r\n" + "0 65 3 0 74 63 21 73 98\r\n"
				+ "77 26 69 83 68 18 71 73 68\r\n" + "59 35 64 13 4 1 59 93 34\r\n" + "13 62 14 27 34 15 20 30 47\r\n"
				+ "9 87 30 46 77 19 70 16 100\r\n" + "7\r\n" + "96 85 20 34 59 14 82\r\n" + "85 70 87 89 42 30 21\r\n"
				+ "40 56 85 28 43 53 48\r\n" + "94 52 54 30 24 19 10\r\n" + "64 47 64 72 70 51 45\r\n"
				+ "21 100 11 96 66 11 89\r\n" + "99 85 89 42 96 3 39\r\n" + "11\r\n"
				+ "76 37 90 45 43 72 66 47 58 89 84\r\n" + "57 98 36 90 55 7 93 85 23 75 24\r\n"
				+ "38 19 43 51 54 34 90 56 77 52 56\r\n" + "14 62 21 12 12 2 88 88 62 46 79\r\n"
				+ "37 22 40 24 95 99 16 99 53 58 13\r\n" + "41 54 68 61 29 94 31 53 21 27 73\r\n"
				+ "90 69 30 58 100 59 11 65 10 92 41\r\n" + "63 20 44 87 3 13 3 80 13 42 58\r\n"
				+ "70 12 90 33 57 0 86 89 65 13 85\r\n" + "0 34 53 67 13 34 63 7 25 92 77\r\n"
				+ "38 71 27 100 67 28 72 83 99 11 69\r\n" + "10\r\n" + "10 62 99 49 72 99 8 1 15 22\r\n"
				+ "58 15 5 2 53 61 89 36 18 15\r\n" + "76 98 34 9 91 33 48 12 73 44\r\n"
				+ "23 53 55 95 85 93 79 81 47 65\r\n" + "4 59 65 13 39 3 80 89 81 28\r\n"
				+ "74 19 83 35 1 16 27 7 94 18\r\n" + "88 31 12 11 14 65 73 79 89 54\r\n"
				+ "73 15 57 99 39 1 34 62 53 93\r\n" + "65 29 30 14 66 97 77 15 89 82\r\n"
				+ "5 8 45 63 85 76 56 14 1 62\r\n" + "5\r\n" + "92 43 0 95 89\r\n" + "84 88 43 34 55\r\n"
				+ "17 97 96 21 83\r\n" + "10 34 10 56 15\r\n" + "22 40 98 33 1\r\n" + "6\r\n" + "1 44 69 33 28 14\r\n"
				+ "14 44 65 45 34 25\r\n" + "54 57 49 38 5 41\r\n" + "89 90 26 47 89 16\r\n" + "1 64 92 5 55 33\r\n"
				+ "11 22 62 71 70 48\r\n" + "12\r\n" + "34 81 6 77 62 93 4 26 73 90 83 40\r\n"
				+ "48 79 26 2 91 68 13 45 80 42 86 9\r\n" + "25 65 52 86 69 86 14 89 44 51 36 74\r\n"
				+ "80 70 11 62 61 17 43 71 73 31 100 88\r\n" + "20 30 16 100 6 54 88 11 80 6 93 9\r\n"
				+ "4 83 47 31 5 55 90 33 61 26 4 19\r\n" + "44 62 94 49 82 2 19 54 90 69 78 74\r\n"
				+ "71 19 68 5 100 29 58 52 19 14 27 10\r\n" + "81 84 50 81 88 94 31 92 58 84 71 50\r\n"
				+ "45 66 49 1 59 9 75 32 47 26 74 95\r\n" + "66 49 54 51 73 45 71 81 93 42 74 29\r\n"
				+ "59 97 40 6 62 75 1 26 5 73 51 66\r\n" + "16\r\n" + "84 73 24 1 28 37 67 27 86 83 17 70 18 41 77 1\r\n"
				+ "75 12 41 5 10 19 87 27 30 70 33 19 6 58 29 84\r\n" + "67 68 69 68 93 63 78 2 40 87 36 72 38 65 51 77\r\n"
				+ "80 70 44 78 57 19 87 51 23 19 19 53 48 56 73 4\r\n" + "71 21 38 19 71 97 97 4 68 69 34 37 0 54 58 32\r\n"
				+ "58 56 20 28 81 28 25 21 80 70 15 56 63 61 86 76\r\n"
				+ "84 30 34 93 86 12 66 3 34 16 97 92 55 25 6 59\r\n"
				+ "40 41 59 68 35 30 71 13 55 96 40 67 63 88 57 87\r\n"
				+ "63 21 65 28 35 54 50 40 50 86 92 43 75 89 15 16\r\n"
				+ "76 9 38 39 63 15 42 11 77 7 55 91 91 17 88 72\r\n" + "64 44 49 4 93 37 19 74 96 97 70 35 19 16 27 25\r\n"
				+ "12 33 88 35 70 73 96 24 54 13 91 30 47 60 28 24\r\n"
				+ "84 26 12 61 2 63 32 24 24 5 88 22 29 25 88 56\r\n" + "85 56 13 9 52 76 90 88 34 54 17 98 58 70 91 6\r\n"
				+ "66 67 12 13 85 71 65 3 95 96 94 21 88 6 69 20\r\n" + "82 57 79 92 65 27 46 64 13 20 92 58 73 52 27 0\r\n"
				+ "13\r\n" + "8 20 91 34 85 4 66 57 48 22 89 46 42\r\n" + "2 27 14 74 0 78 75 80 92 39 61 93 15\r\n"
				+ "18 0 80 2 14 11 63 52 6 62 53 84 44\r\n" + "14 96 28 77 52 70 9 100 58 34 54 82 93\r\n"
				+ "62 19 68 77 47 20 51 74 75 31 68 72 81\r\n" + "36 46 20 64 18 78 38 41 13 70 79 70 22\r\n"
				+ "44 2 49 59 37 32 98 36 12 100 35 70 29\r\n" + "70 1 63 96 64 79 71 85 54 69 46 17 5\r\n"
				+ "22 60 3 11 88 46 59 74 7 49 7 71 43\r\n" + "46 98 16 79 5 77 30 86 95 41 74 96 56\r\n"
				+ "70 71 47 23 98 36 76 7 70 15 100 10 59\r\n" + "63 96 49 41 5 0 36 3 44 22 68 91 12\r\n"
				+ "11 44 97 30 92 85 95 87 47 36 22 67 22\r\n" + "13\r\n" + "98 42 20 35 100 1 41 8 9 3 55 5 57\r\n"
				+ "23 60 100 56 25 90 51 55 52 62 42 27 90\r\n" + "70 34 60 23 87 13 75 5 87 61 25 69 73\r\n"
				+ "3 11 46 55 12 2 21 19 73 72 47 38 93\r\n" + "11 85 83 76 54 64 86 11 11 83 34 6 7\r\n"
				+ "69 47 22 12 13 32 42 61 84 58 69 13 79\r\n" + "35 9 56 88 15 77 0 90 17 98 64 0 70\r\n"
				+ "69 50 72 25 69 15 67 30 13 17 13 13 14\r\n" + "24 98 74 98 89 99 72 5 88 87 39 15 63\r\n"
				+ "29 58 74 30 67 78 47 60 62 17 32 100 63\r\n" + "41 2 42 92 85 43 26 66 77 68 60 40 89\r\n"
				+ "18 44 51 25 64 56 46 5 77 70 97 25 27\r\n" + "30 4 82 73 97 16 49 97 71 86 83 76 47\r\n" + "15\r\n"
				+ "85 11 3 51 30 37 92 98 39 77 49 66 30 90 91\r\n" + "25 22 78 85 88 94 41 33 10 64 79 29 87 78 25\r\n"
				+ "4 32 27 54 45 34 70 29 67 38 61 33 50 17 55\r\n" + "32 89 75 43 31 69 40 31 92 57 54 96 30 97 56\r\n"
				+ "85 34 53 42 94 17 43 56 91 52 77 2 39 57 93\r\n" + "43 94 13 80 22 98 30 64 65 71 49 71 45 39 48\r\n"
				+ "25 31 44 75 20 45 55 42 99 58 61 0 9 79 37\r\n" + "57 56 75 19 49 100 57 32 69 78 33 75 41 92 47\r\n"
				+ "98 6 32 13 62 38 46 83 79 97 54 91 65 42 65\r\n" + "88 64 11 99 15 22 20 44 71 34 86 7 79 0 41\r\n"
				+ "55 43 78 77 75 75 95 51 99 86 51 61 93 24 66\r\n" + "87 65 56 5 65 81 20 67 8 47 40 36 72 66 72\r\n"
				+ "40 41 65 11 84 85 89 71 95 68 98 7 83 52 0\r\n" + "14 28 36 50 68 76 18 7 22 89 15 88 55 36 15\r\n"
				+ "47 86 15 64 79 84 22 49 95 10 24 82 20 11 16\r\n" + "5\r\n" + "100 86 61 11 78\r\n" + "4 71 19 9 51\r\n"
				+ "82 98 50 11 68\r\n" + "2 46 16 36 83\r\n" + "9 52 27 80 58\r\n" + "13\r\n"
				+ "65 1 12 38 41 62 90 75 50 36 60 26 13\r\n" + "10 60 82 60 95 97 63 88 71 31 69 88 16\r\n"
				+ "71 0 77 70 59 23 79 10 15 81 61 100 47\r\n" + "12 3 85 96 32 86 95 100 68 40 29 93 100\r\n"
				+ "73 86 24 38 89 68 58 72 12 7 72 15 49\r\n" + "80 51 28 43 37 17 24 96 97 43 48 40 87\r\n"
				+ "15 57 78 72 74 99 11 54 51 32 52 90 13\r\n" + "96 85 61 66 98 81 90 38 59 10 75 35 65\r\n"
				+ "35 46 37 61 79 1 1 61 43 65 19 68 22\r\n" + "8 46 31 95 20 8 12 39 23 97 80 85 14\r\n"
				+ "3 13 57 12 42 11 31 56 72 35 9 13 17\r\n" + "100 17 75 41 100 16 5 58 20 51 41 75 62\r\n"
				+ "29 42 83 68 100 65 8 77 10 49 59 54 13\r\n" + "2\r\n" + "28 55\r\n" + "2 95\r\n" + "3\r\n"
				+ "55 52 96\r\n" + "28 20 85\r\n" + "59 51 19\r\n" + "8\r\n" + "79 87 13 100 34 58 41 10\r\n"
				+ "16 82 66 26 58 22 67 63\r\n" + "46 35 15 19 62 13 83 33\r\n" + "98 59 72 14 70 59 61 38\r\n"
				+ "39 77 87 5 98 64 73 16\r\n" + "34 80 17 18 11 53 19 38\r\n" + "79 70 69 58 98 30 10 49\r\n"
				+ "98 57 50 98 25 43 0 43\r\n" + "9\r\n" + "41 27 70 78 30 66 37 56 48\r\n" + "90 39 1 32 9 2 43 74 80\r\n"
				+ "69 15 2 97 13 88 61 20 28\r\n" + "12 40 84 76 88 64 6 24 0\r\n" + "23 72 44 79 54 49 10 85 57\r\n"
				+ "74 88 50 16 9 85 48 59 44\r\n" + "69 16 60 66 36 95 1 19 11\r\n" + "58 31 6 1 79 14 17 62 5\r\n"
				+ "94 55 57 29 19 76 29 56 80\r\n" + "5\r\n" + "84 85 99 34 87\r\n" + "48 0 90 49 74\r\n"
				+ "51 49 62 81 55\r\n" + "65 98 34 7 58\r\n" + "56 53 71 3 20\r\n" + "16\r\n"
				+ "90 3 16 76 2 86 78 51 77 98 95 8 40 20 9 26\r\n" + "79 40 81 67 0 97 91 78 74 62 83 29 23 65 67 82\r\n"
				+ "70 3 0 62 96 19 9 34 3 9 9 39 72 56 31 38\r\n" + "82 64 96 10 97 20 89 75 49 6 92 87 73 97 65 67\r\n"
				+ "82 65 68 84 75 85 22 28 25 24 95 10 11 64 53 87\r\n"
				+ "33 12 14 1 78 67 75 95 86 38 59 47 52 1 77 24\r\n"
				+ "96 61 37 25 86 95 59 97 99 90 24 88 13 89 83 80\r\n"
				+ "16 20 55 64 5 83 94 96 100 3 68 86 99 97 72 84\r\n"
				+ "94 82 25 99 56 55 20 24 97 19 96 71 80 79 63 20\r\n"
				+ "13 52 14 100 95 64 31 95 70 59 11 95 33 22 13 30\r\n"
				+ "65 66 57 94 59 1 71 71 70 11 17 98 78 72 57 23\r\n"
				+ "82 77 49 77 80 33 60 99 36 38 20 70 46 91 16 67\r\n"
				+ "33 72 12 26 8 73 23 63 88 31 44 89 56 61 9 68\r\n" + "89 44 37 57 30 59 7 49 44 20 40 73 45 45 63 75\r\n"
				+ "86 87 99 52 52 81 91 95 14 11 81 38 83 9 67 51\r\n"
				+ "88 14 84 75 95 63 25 91 67 97 21 31 41 31 37 73\r\n" + "4\r\n" + "55 83 92 3\r\n" + "79 51 5 44\r\n"
				+ "20 58 12 74\r\n" + "13 62 70 39\r\n" + "6\r\n" + "98 85 100 51 54 51\r\n" + "9 54 68 17 70 19\r\n"
				+ "92 95 41 14 33 94\r\n" + "96 79 41 92 95 55\r\n" + "3 59 17 20 13 39\r\n" + "80 55 81 90 17 11\r\n"
				+ "10\r\n" + "90 58 23 59 100 46 47 17 30 91\r\n" + "98 94 78 66 46 73 57 39 71 71\r\n"
				+ "74 0 35 76 38 93 41 74 46 42\r\n" + "4 86 17 53 37 79 20 69 80 58\r\n" + "9 59 41 15 2 70 32 83 2 13\r\n"
				+ "80 82 58 1 13 55 33 56 54 37\r\n" + "68 29 72 91 74 12 73 33 91 95\r\n"
				+ "14 87 50 29 66 3 7 96 42 36\r\n" + "7 29 31 18 67 9 36 9 52 23\r\n" + "79 43 94 88 41 2 65 99 100 57\r\n"
				+ "11\r\n" + "59 43 20 3 78 87 31 18 83 77 51\r\n" + "30 38 11 23 27 14 38 69 54 72 60\r\n"
				+ "48 9 93 52 78 24 5 82 62 23 39\r\n" + "33 82 15 19 98 96 11 39 42 34 17\r\n"
				+ "2 95 35 93 55 3 32 30 16 65 94\r\n" + "35 48 68 32 40 41 36 76 64 3 83\r\n"
				+ "39 75 15 93 47 45 17 12 45 52 84\r\n" + "80 44 20 49 22 93 91 93 29 34 38\r\n"
				+ "66 60 41 5 27 86 64 72 47 6 22\r\n" + "72 89 47 100 26 73 8 5 65 16 74\r\n"
				+ "86 37 58 52 39 71 7 79 97 95 21\r\n" + "4\r\n" + "5 87 33 73\r\n" + "1 87 33 34\r\n" + "12 81 47 65\r\n"
				+ "14 95 33 11\r\n" + "2\r\n" + "6 64\r\n" + "35 25\r\n" + "3\r\n" + "49 5 64\r\n" + "19 92 4\r\n"
				+ "95 12 62\r\n" + "7\r\n" + "6 86 72 42 58 61 67\r\n" + "30 26 63 6 94 0 43\r\n" + "38 9 31 49 9 71 44\r\n"
				+ "22 36 85 95 79 68 63\r\n" + "10 1 12 55 68 77 36\r\n" + "46 77 37 99 94 7 3\r\n"
				+ "81 85 70 53 93 92 68\r\n" + "4\r\n" + "45 63 74 99\r\n" + "99 35 19 51\r\n" + "12 34 9 25\r\n"
				+ "57 99 5 26\r\n" + "2\r\n" + "1 60\r\n" + "4 5\r\n" + "5\r\n" + "84 51 93 70 56\r\n"
				+ "39 43 66 94 14\r\n" + "31 14 55 38 73\r\n" + "51 57 80 90 50\r\n" + "12 85 92 40 54\r\n" + "12\r\n"
				+ "56 12 63 47 25 60 78 13 11 6 48 43\r\n" + "75 28 0 73 83 19 69 100 73 56 88 7\r\n"
				+ "76 54 9 33 61 25 10 68 35 1 25 13\r\n" + "65 34 64 45 57 4 76 42 65 51 88 65\r\n"
				+ "32 56 34 93 37 78 38 1 30 52 55 11\r\n" + "40 44 72 37 86 78 5 13 56 58 0 69\r\n"
				+ "88 98 45 13 15 84 55 41 44 2 31 46\r\n" + "64 74 22 2 69 74 11 45 29 7 50 17\r\n"
				+ "22 56 22 46 42 76 9 97 1 44 0 99\r\n" + "49 98 69 90 84 100 11 57 52 10 56 50\r\n"
				+ "37 43 86 26 88 20 59 31 18 21 52 92\r\n" + "99 39 15 11 97 97 68 86 9 58 35 87\r\n" + "8\r\n"
				+ "73 82 45 84 90 24 15 34\r\n" + "70 20 72 30 98 73 1 98\r\n" + "53 32 30 99 22 45 80 50\r\n"
				+ "44 49 45 18 75 21 44 46\r\n" + "71 74 59 26 22 100 96 98\r\n" + "46 49 16 72 61 61 92 39\r\n"
				+ "24 73 2 13 61 94 2 44\r\n" + "32 99 70 67 88 69 42 91\r\n" + "9\r\n" + "9 73 19 58 27 50 70 63 57\r\n"
				+ "92 57 13 50 58 14 27 38 14\r\n" + "79 48 9 20 99 68 7 74 60\r\n" + "66 93 55 45 71 91 6 19 45\r\n"
				+ "6 49 75 53 90 0 76 21 33\r\n" + "0 19 35 55 63 4 70 16 91\r\n" + "3 94 80 64 87 1 78 24 99\r\n"
				+ "23 64 26 21 48 84 21 34 65\r\n" + "91 25 60 76 76 36 33 93 13\r\n" + "15\r\n"
				+ "74 14 34 37 69 88 80 68 96 47 10 45 1 21 69\r\n" + "6 72 94 17 13 80 0 91 50 56 27 76 95 39 12\r\n"
				+ "91 85 74 40 60 56 24 30 58 68 22 77 92 75 86\r\n" + "37 30 12 58 99 72 91 64 99 32 32 42 45 25 29\r\n"
				+ "67 82 97 33 73 86 24 14 5 27 86 10 18 100 42\r\n" + "55 81 38 61 60 88 15 36 29 77 50 53 72 76 42\r\n"
				+ "54 49 28 20 24 88 38 96 95 0 63 43 87 50 85\r\n" + "26 21 11 48 81 44 23 86 62 98 1 29 95 14 63\r\n"
				+ "64 10 75 58 15 30 62 25 50 78 58 98 19 38 86\r\n" + "17 15 52 0 57 46 78 97 0 65 9 45 80 22 54\r\n"
				+ "37 72 67 41 22 69 3 20 19 83 19 30 74 22 36\r\n" + "28 48 89 74 87 24 66 32 99 74 50 93 20 0 91\r\n"
				+ "14 58 92 96 63 35 59 3 94 37 93 40 0 81 30\r\n" + "50 67 29 94 79 90 22 99 89 11 6 82 41 75 34\r\n"
				+ "14 67 99 76 19 36 80 75 100 99 85 25 42 42 66\r\n" + "5\r\n" + "3 48 10 72 23\r\n" + "44 54 77 16 67\r\n"
				+ "36 58 29 50 35\r\n" + "52 26 17 48 97\r\n" + "16 58 11 78 32\r\n" + "14\r\n"
				+ "68 3 49 77 80 100 84 29 85 77 65 75 22 41\r\n" + "97 68 22 100 78 1 43 66 72 70 40 44 7 27\r\n"
				+ "57 92 42 26 58 83 37 58 21 86 76 70 52 12\r\n" + "34 62 3 52 23 50 80 5 38 38 83 42 61 27\r\n"
				+ "59 41 21 100 76 5 2 37 62 11 34 8 91 87\r\n" + "47 97 82 47 83 45 74 56 93 53 86 98 38 24\r\n"
				+ "9 97 13 59 1 41 21 83 93 54 69 85 86 44\r\n" + "92 40 55 61 47 52 40 20 37 63 88 71 35 62\r\n"
				+ "22 67 77 72 1 61 87 60 67 67 36 39 49 53\r\n" + "73 14 94 0 74 22 47 22 61 81 77 70 69 26\r\n"
				+ "89 8 60 69 34 0 3 44 75 6 24 17 46 9\r\n" + "45 12 75 79 54 65 34 89 96 65 31 22 98 26\r\n"
				+ "8 25 59 66 88 15 13 23 92 84 89 75 7 84\r\n" + "26 98 68 49 62 1 92 55 56 51 74 4 71 37\r\n" + "3\r\n"
				+ "70 9 28\r\n" + "85 42 63\r\n" + "81 52 48\r\n" + "8\r\n" + "86 6 64 86 98 87 11 68\r\n"
				+ "95 91 75 95 33 50 81 3\r\n" + "46 85 97 32 9 65 76 47\r\n" + "34 71 52 55 78 37 34 65\r\n"
				+ "100 12 57 12 77 29 23 86\r\n" + "59 95 83 16 12 97 99 12\r\n" + "26 69 86 10 80 18 17 96\r\n"
				+ "4 92 34 12 88 1 79 11\r\n" + "14\r\n" + "8 29 51 34 60 96 15 22 87 42 64 87 2 27\r\n"
				+ "47 94 28 70 85 49 64 59 28 66 14 40 84 52\r\n" + "53 1 20 77 31 86 19 2 35 91 19 60 65 28\r\n"
				+ "42 82 70 11 24 29 31 20 16 13 17 36 49 6\r\n" + "80 51 74 39 66 35 91 55 93 69 50 11 68 26\r\n"
				+ "43 33 38 44 41 60 62 0 1 67 41 32 13 35\r\n" + "52 4 32 67 11 20 32 54 88 99 88 10 27 63\r\n"
				+ "37 29 63 30 20 81 0 33 26 25 43 59 69 97\r\n" + "8 19 3 95 69 12 65 51 52 69 1 97 76 61\r\n"
				+ "80 67 99 0 92 49 27 65 37 1 94 1 41 100\r\n" + "78 22 41 67 98 78 14 69 52 71 46 66 43 95\r\n"
				+ "42 66 34 32 66 50 33 2 54 44 16 56 58 30\r\n" + "51 54 52 80 25 49 66 25 24 65 73 56 66 18\r\n"
				+ "53 59 19 25 90 23 75 13 8 92 5 11 43 28\r\n" + "11\r\n" + "92 53 54 25 33 64 38 41 57 76 71\r\n"
				+ "69 90 87 20 26 50 44 28 82 91 84\r\n" + "35 61 32 55 70 60 94 16 42 92 6\r\n"
				+ "66 98 29 71 3 60 36 21 69 87 81\r\n" + "7 91 69 64 90 58 1 64 36 69 52\r\n"
				+ "16 58 15 52 59 0 63 72 0 82 72\r\n" + "14 74 24 43 1 4 19 53 9 82 12\r\n"
				+ "60 5 76 47 33 74 42 83 0 2 44\r\n" + "35 25 53 24 9 97 31 85 91 35 57\r\n"
				+ "5 14 57 88 87 12 24 48 18 97 71\r\n" + "60 68 38 22 87 4 25 90 41 89 27\r\n" + "3\r\n" + "70 55 45\r\n"
				+ "60 97 44\r\n" + "94 27 46\r\n" + "8\r\n" + "88 89 5 48 85 28 54 74\r\n" + "95 75 72 79 96 85 76 40\r\n"
				+ "57 82 9 22 21 93 57 85\r\n" + "70 82 8 24 45 99 52 39\r\n" + "37 38 17 94 33 92 73 63\r\n"
				+ "53 16 96 100 36 28 20 49\r\n" + "0 78 44 76 27 28 34 91\r\n" + "75 50 89 81 90 50 79 55\r\n" + "16\r\n"
				+ "38 32 72 26 44 31 75 86 60 6 46 92 45 73 21 24\r\n"
				+ "83 79 98 86 87 83 80 48 56 42 99 56 73 48 14 39\r\n"
				+ "33 94 55 10 49 50 97 39 31 39 71 28 53 3 29 42\r\n"
				+ "14 56 61 84 15 3 88 58 11 18 40 56 32 14 58 63\r\n" + "28 40 78 87 50 21 80 26 37 3 72 100 7 8 50 38\r\n"
				+ "49 65 64 20 12 0 57 52 61 5 64 65 30 51 9 85\r\n" + "15 60 79 45 80 94 11 99 89 89 87 61 69 54 7 69\r\n"
				+ "42 33 23 18 24 21 98 59 18 41 41 92 75 6 42 92\r\n" + "74 26 56 46 11 1 6 57 2 30 32 71 74 46 52 96\r\n"
				+ "28 41 30 51 29 70 7 59 18 83 32 92 45 6 36 83\r\n" + "76 86 54 72 6 38 65 31 18 91 6 32 11 59 41 11\r\n"
				+ "37 54 34 2 62 77 24 7 32 89 0 5 83 3 39 43\r\n" + "68 70 94 58 85 91 65 50 66 72 6 95 34 77 70 100\r\n"
				+ "35 62 45 32 94 10 96 4 26 16 26 91 23 23 5 74\r\n" + "35 47 70 92 31 19 83 37 72 81 39 2 85 96 66 41\r\n"
				+ "5 13 68 25 67 18 35 34 13 59 96 8 86 57 90 79\r\n" + "6\r\n" + "56 10 15 86 16 90\r\n"
				+ "43 39 18 88 55 53\r\n" + "57 38 16 61 0 18\r\n" + "77 44 42 33 2 51\r\n" + "49 50 69 30 40 16\r\n"
				+ "98 19 49 4 5 20\r\n" + "12\r\n" + "41 31 4 97 52 27 8 57 14 97 43 60\r\n"
				+ "4 52 49 64 44 8 66 31 37 32 96 14\r\n" + "70 11 53 63 33 73 2 89 32 28 41 40\r\n"
				+ "41 0 84 68 61 67 51 52 54 34 24 24\r\n" + "78 57 49 8 89 82 65 72 94 78 22 62\r\n"
				+ "82 36 87 27 51 97 52 8 87 90 99 68\r\n" + "14 94 48 97 54 22 53 63 78 88 75 49\r\n"
				+ "20 55 98 6 71 68 99 14 89 89 94 38\r\n" + "78 20 1 38 56 27 62 87 26 29 80 12\r\n"
				+ "71 17 48 61 60 40 54 65 95 77 87 9\r\n" + "99 27 1 77 6 56 1 99 69 99 85 31\r\n"
				+ "32 31 2 38 6 28 44 47 24 25 90 5\r\n" + "3\r\n" + "40 34 33\r\n" + "98 15 45\r\n" + "20 49 2\r\n"
				+ "11\r\n" + "54 3 40 36 41 72 23 98 35 63 37\r\n" + "32 77 63 88 97 73 14 19 46 88 66\r\n"
				+ "65 74 17 15 31 48 66 21 6 22 37\r\n" + "90 54 51 59 3 83 49 53 29 44 70\r\n"
				+ "17 20 66 77 91 6 86 34 47 89 42\r\n" + "57 47 26 31 28 55 51 38 32 80 43\r\n"
				+ "92 54 47 19 62 57 57 61 46 91 59\r\n" + "8 47 49 24 83 17 65 86 9 59 77\r\n"
				+ "91 78 33 34 28 14 42 89 29 87 18\r\n" + "1 56 81 63 49 30 95 87 69 50 88\r\n"
				+ "5 43 30 87 63 10 80 44 12 9 90\r\n" + "8\r\n" + "65 71 88 15 49 16 99 79\r\n"
				+ "39 84 22 5 48 6 41 48\r\n" + "57 24 54 42 85 100 69 63\r\n" + "52 72 16 58 89 47 100 29\r\n"
				+ "6 69 98 27 48 8 19 7\r\n" + "24 72 97 72 61 5 72 12\r\n" + "39 15 76 83 30 59 93 84\r\n"
				+ "39 88 66 19 26 28 45 27\r\n" + "16\r\n" + "15 58 80 87 44 96 61 14 56 17 29 61 54 6 2 40\r\n"
				+ "88 46 24 86 69 19 36 19 83 63 21 25 32 77 86 23\r\n"
				+ "24 37 96 89 79 48 61 56 55 88 71 80 46 100 56 11\r\n"
				+ "89 90 7 78 95 3 57 45 7 91 71 96 32 85 56 24\r\n" + "31 58 33 37 12 11 16 63 93 13 77 51 95 46 57 49\r\n"
				+ "34 97 59 1 16 100 71 12 17 46 40 32 32 40 33 72\r\n"
				+ "40 90 6 28 82 95 79 38 38 79 45 92 41 100 4 78\r\n"
				+ "16 94 69 42 13 41 16 83 60 33 56 86 93 40 7 73\r\n"
				+ "83 64 54 4 96 69 29 98 67 55 30 86 92 44 24 71\r\n" + "58 62 20 93 71 1 92 97 25 84 52 50 3 58 8 12\r\n"
				+ "99 83 98 66 84 98 55 36 13 94 68 47 54 30 1 51\r\n"
				+ "26 28 56 61 54 93 54 9 72 72 93 85 77 96 74 85\r\n" + "40 35 91 3 9 88 76 26 82 51 84 99 87 75 89 19\r\n"
				+ "9 34 28 49 0 95 88 73 93 100 58 15 46 90 11 59\r\n"
				+ "73 83 79 14 61 56 74 26 45 43 41 57 8 63 60 78\r\n" + "28 65 75 15 4 47 1 82 78 89 11 99 67 52 23 94\r\n"
				+ "2\r\n" + "97 38\r\n" + "6 38\r\n" + "12\r\n" + "6 31 23 46 87 94 39 74 29 27 38 74\r\n"
				+ "81 52 49 52 55 4 68 67 28 3 51 3\r\n" + "54 52 54 43 63 15 52 58 32 63 24 9\r\n"
				+ "56 4 23 15 18 1 27 63 74 40 17 89\r\n" + "77 55 94 23 58 32 71 59 71 99 81 19\r\n"
				+ "81 44 88 77 58 45 19 64 59 31 13 65\r\n" + "24 67 50 100 35 37 25 60 58 93 38 45\r\n"
				+ "50 39 36 30 51 67 70 33 1 27 76 74\r\n" + "58 42 23 73 19 87 51 36 74 33 60 32\r\n"
				+ "94 30 57 50 0 46 36 6 92 5 18 31\r\n" + "58 28 49 94 23 1 4 13 28 16 55 13\r\n"
				+ "6 31 31 35 5 17 29 41 2 45 55 81\r\n" + "11\r\n" + "76 68 73 25 61 34 4 92 88 9 2\r\n"
				+ "1 58 58 99 90 47 39 7 72 83 79\r\n" + "46 74 50 99 55 70 1 79 45 67 26\r\n"
				+ "41 11 71 36 55 24 2 41 69 48 72\r\n" + "98 71 61 23 4 95 82 97 67 8 0\r\n"
				+ "22 37 83 82 34 30 3 43 26 74 48\r\n" + "69 3 30 15 60 74 86 80 49 4 35\r\n"
				+ "93 26 32 5 22 46 63 48 41 89 79\r\n" + "68 20 38 28 97 68 65 34 46 60 27\r\n"
				+ "36 14 43 40 57 76 19 11 15 1 68\r\n" + "61 95 79 58 1 73 82 30 61 74 61\r\n" + "15\r\n"
				+ "86 29 38 46 91 49 15 12 42 70 5 27 9 36 90\r\n" + "16 14 65 94 11 21 49 96 3 56 80 18 92 31 75\r\n"
				+ "13 5 36 48 50 84 19 94 100 91 53 20 83 89 41\r\n" + "34 31 36 28 22 34 88 26 84 54 4 47 32 87 5\r\n"
				+ "90 87 61 79 28 84 45 57 26 38 53 78 83 63 65\r\n" + "82 64 7 89 79 68 35 18 88 33 93 82 48 40 0\r\n"
				+ "51 53 94 52 36 99 83 37 48 4 67 18 9 70 14\r\n" + "29 60 80 40 44 44 32 89 77 71 13 62 35 90 55\r\n"
				+ "87 17 19 36 49 81 73 5 29 86 56 47 14 94 58\r\n" + "56 80 50 60 35 62 42 5 20 77 93 38 52 70 47\r\n"
				+ "16 40 62 68 42 1 83 61 75 56 19 89 40 36 68\r\n" + "3 90 38 77 2 61 73 86 62 4 5 66 32 28 87\r\n"
				+ "26 4 64 86 16 14 11 95 75 73 91 4 22 84 4\r\n" + "27 39 99 52 79 34 32 45 23 35 75 90 66 31 34\r\n"
				+ "98 68 40 68 9 88 25 65 45 1 92 3 3 8 94\r\n" + "7\r\n" + "53 60 49 58 86 75 83\r\n"
				+ "47 15 47 67 65 63 57\r\n" + "70 71 18 55 21 92 50\r\n" + "80 88 65 68 83 87 27\r\n"
				+ "27 18 53 46 71 38 70\r\n" + "46 94 6 8 14 74 0\r\n" + "94 72 13 42 30 2 69\r\n" + "16\r\n"
				+ "97 16 59 58 41 20 0 1 81 35 51 22 26 27 40 86\r\n" + "62 17 97 16 94 14 95 56 73 92 6 42 36 37 74 75\r\n"
				+ "38 48 31 41 3 0 59 33 10 54 42 36 61 0 10 56\r\n" + "92 34 1 4 72 98 74 26 56 9 16 1 78 21 46 60\r\n"
				+ "36 59 10 1 93 95 24 62 60 31 31 34 25 24 42 53\r\n"
				+ "97 8 23 36 51 42 43 74 100 6 95 53 39 72 69 98\r\n"
				+ "60 12 48 81 86 50 35 21 77 37 62 19 68 67 23 69\r\n"
				+ "51 17 2 65 42 58 33 20 10 50 90 66 6 28 39 55\r\n" + "9 36 92 96 17 86 85 90 89 0 34 85 11 10 54 77\r\n"
				+ "95 88 86 15 16 43 39 38 1 78 90 64 61 14 60 33\r\n"
				+ "11 86 73 81 92 85 60 45 63 66 81 27 40 53 68 97\r\n"
				+ "73 23 36 69 14 80 68 100 91 76 83 42 37 31 96 39\r\n"
				+ "82 51 30 36 71 58 82 68 3 22 23 53 81 5 7 78\r\n" + "72 45 67 11 2 58 25 57 44 57 89 87 49 54 72 89\r\n"
				+ "35 100 98 87 68 57 20 24 7 52 97 1 42 71 9 22\r\n"
				+ "89 73 84 69 85 67 62 50 95 100 40 25 76 99 24 22\r\n" + "9\r\n" + "89 64 89 68 95 98 82 39 37\r\n"
				+ "28 89 62 28 67 5 26 36 17\r\n" + "2 6 89 35 38 71 72 24 12\r\n" + "56 12 17 51 45 14 80 26 33\r\n"
				+ "97 77 63 63 96 5 95 51 99\r\n" + "94 19 7 70 87 50 81 56 60\r\n" + "9 99 93 93 39 34 53 47 31\r\n"
				+ "84 45 33 57 27 17 87 79 76\r\n" + "6 11 25 7 73 17 17 51 89\r\n" + "4\r\n" + "100 33 82 26\r\n"
				+ "65 25 79 76\r\n" + "71 36 83 54\r\n" + "45 36 93 30\r\n" + "11\r\n"
				+ "93 29 6 80 72 12 1 61 61 24 66\r\n" + "43 49 32 43 53 33 61 94 48 67 58\r\n"
				+ "53 80 18 31 16 9 74 36 4 17 62\r\n" + "16 45 67 74 75 5 32 75 39 4 18\r\n"
				+ "50 36 92 26 21 72 95 19 50 26 69\r\n" + "4 59 85 42 21 11 73 88 66 88 99\r\n"
				+ "76 81 45 88 56 48 89 13 42 95 44\r\n" + "15 13 68 30 73 60 84 56 7 13 64\r\n"
				+ "89 17 79 77 46 57 55 55 98 76 74\r\n" + "75 68 32 98 18 65 95 84 46 85 76\r\n"
				+ "100 73 55 12 57 80 97 17 69 17 67\r\n" + "8\r\n" + "40 96 72 64 79 59 98 92\r\n"
				+ "25 3 65 8 50 13 22 71\r\n" + "62 44 35 23 38 26 30 16\r\n" + "43 34 63 63 87 61 77 39\r\n"
				+ "65 40 39 91 99 86 3 54\r\n" + "13 3 88 62 24 66 87 81\r\n" + "98 48 65 35 49 40 6 46\r\n"
				+ "99 46 62 28 40 67 94 28\r\n" + "8\r\n" + "51 81 31 23 40 66 38 19\r\n" + "72 37 78 51 17 39 3 82\r\n"
				+ "36 52 78 81 11 71 79 95\r\n" + "86 40 69 22 55 69 33 79\r\n" + "8 73 95 13 95 26 14 72\r\n"
				+ "78 61 90 71 10 27 71 16\r\n" + "1 97 18 63 89 84 17 90\r\n" + "20 21 7 55 0 31 27 4\r\n" + "8\r\n"
				+ "57 75 0 45 42 49 88 88\r\n" + "12 91 73 55 74 54 82 67\r\n" + "41 71 63 14 81 2 31 20\r\n"
				+ "66 96 88 1 13 66 24 13\r\n" + "94 93 89 96 39 65 49 87\r\n" + "25 4 15 40 5 33 63 16\r\n"
				+ "88 98 2 4 53 49 45 35\r\n" + "15 86 30 88 33 18 39 9\r\n" + "5\r\n" + "58 56 21 47 4\r\n"
				+ "28 89 26 18 38\r\n" + "84 20 6 8 67\r\n" + "10 71 39 80 21\r\n" + "23 67 89 86 76\r\n" + "5\r\n"
				+ "46 16 73 41 88\r\n" + "74 59 6 60 68\r\n" + "72 4 82 77 80\r\n" + "12 75 25 43 1\r\n"
				+ "100 99 7 65 99\r\n" + "8\r\n" + "25 23 89 40 95 50 14 66\r\n" + "38 59 85 52 22 71 3 98\r\n"
				+ "43 69 73 4 61 51 61 3\r\n" + "24 95 43 1 97 3 44 54\r\n" + "57 99 86 30 78 53 18 92\r\n"
				+ "86 3 90 66 67 73 81 64\r\n" + "14 2 26 8 45 35 15 42\r\n" + "0 49 64 84 26 28 37 14\r\n" + "15\r\n"
				+ "74 100 17 87 44 76 70 55 65 56 19 78 32 80 78\r\n" + "57 43 50 11 34 31 97 84 97 14 47 40 58 35 58\r\n"
				+ "83 33 98 77 26 66 28 14 93 2 16 63 7 82 97\r\n" + "31 10 24 46 63 65 50 4 52 24 91 88 41 85 13\r\n"
				+ "78 42 8 65 17 35 76 97 32 22 60 16 18 87 68\r\n" + "47 23 23 55 29 34 31 7 35 23 24 59 82 13 87\r\n"
				+ "47 50 22 85 63 49 45 37 61 49 91 43 26 99 66\r\n" + "60 94 80 12 85 15 93 99 63 80 30 42 48 91 14\r\n"
				+ "65 61 0 94 43 35 90 81 98 6 33 7 97 77 78\r\n" + "67 29 13 23 84 82 17 76 29 61 33 46 69 88 17\r\n"
				+ "88 81 6 72 84 0 36 49 37 10 43 81 90 13 20\r\n" + "78 79 86 8 50 25 60 30 13 48 37 94 15 77 19\r\n"
				+ "98 28 96 45 7 75 43 33 30 25 60 48 16 39 95\r\n" + "81 2 35 41 88 92 68 80 12 82 41 74 5 70 69\r\n"
				+ "38 12 43 86 74 60 91 77 95 19 26 39 7 65 40\r\n" + "6\r\n" + "73 4 73 41 82 6\r\n"
				+ "3 62 99 99 93 42\r\n" + "82 80 21 39 25 67\r\n" + "58 98 51 11 96 55\r\n" + "75 54 96 83 73 73\r\n"
				+ "80 0 85 36 48 16\r\n" + "8\r\n" + "55 40 48 99 32 40 72 72\r\n" + "52 71 35 50 37 12 37 47\r\n"
				+ "28 66 29 35 12 39 57 9\r\n" + "15 23 92 35 16 19 79 45\r\n" + "93 67 43 84 20 15 76 39\r\n"
				+ "76 67 68 74 54 13 51 59\r\n" + "54 29 13 43 22 66 52 36\r\n" + "60 71 86 8 23 38 39 2\r\n" + "7\r\n"
				+ "99 35 26 37 17 75 56\r\n" + "23 30 64 94 12 50 75\r\n" + "53 49 10 93 23 26 18\r\n"
				+ "30 42 81 65 89 67 95\r\n" + "44 65 47 50 48 20 100\r\n" + "29 86 53 4 7 94 62\r\n"
				+ "88 82 1 73 14 17 90\r\n" + "2\r\n" + "92 60\r\n" + "12 4\r\n" + "7\r\n" + "81 55 41 25 58 16 93\r\n"
				+ "10 10 36 85 34 43 82\r\n" + "30 35 84 99 47 92 82\r\n" + "83 56 36 57 30 72 89\r\n"
				+ "37 81 42 0 7 31 70\r\n" + "16 92 74 55 19 55 36\r\n" + "92 12 37 20 33 18 47\r\n" + "9\r\n"
				+ "46 55 94 61 8 80 98 90 46\r\n" + "77 60 28 96 8 92 65 69 19\r\n" + "37 45 57 7 63 6 97 95 39\r\n"
				+ "69 90 89 82 53 56 68 20 31\r\n" + "24 80 28 78 58 28 15 38 55\r\n" + "61 99 0 23 56 35 46 32 21\r\n"
				+ "34 11 43 36 11 71 94 65 4\r\n" + "43 37 66 41 7 37 92 45 55\r\n" + "27 84 75 12 38 90 32 49 38\r\n"
				+ "15\r\n" + "90 40 44 24 54 62 27 39 98 99 61 26 82 57 76\r\n"
				+ "50 7 52 67 11 80 72 88 47 99 60 70 4 57 69\r\n" + "56 28 62 91 88 48 1 9 55 31 64 96 30 97 32\r\n"
				+ "42 36 49 25 42 65 1 39 74 23 89 59 24 81 46\r\n" + "10 47 99 71 64 58 70 99 40 87 46 11 16 86 38\r\n"
				+ "18 44 93 88 21 0 93 99 91 13 22 37 79 54 32\r\n" + "3 12 80 79 54 95 86 85 84 52 9 51 4 67 13\r\n"
				+ "95 98 13 53 5 65 17 58 7 4 2 95 53 16 48\r\n" + "94 14 59 93 67 52 40 53 54 97 81 95 29 33 53\r\n"
				+ "13 60 9 54 71 29 9 78 98 40 11 97 79 20 45\r\n" + "85 42 75 57 72 46 52 29 48 99 54 74 99 94 66\r\n"
				+ "45 95 11 84 93 21 36 66 56 87 21 55 40 20 51\r\n" + "62 9 30 98 0 27 0 84 51 26 32 42 72 85 64\r\n"
				+ "9 47 72 20 14 4 77 4 99 77 14 51 73 78 19\r\n" + "93 8 15 32 92 80 36 87 0 30 31 88 80 6 21\r\n"
				+ "12\r\n" + "86 95 98 91 44 38 93 39 42 20 38 27\r\n" + "79 48 93 23 60 49 97 28 31 100 41 94\r\n"
				+ "66 52 70 61 22 59 50 100 20 68 73 4\r\n" + "86 64 81 33 34 47 80 94 57 61 13 42\r\n"
				+ "1 24 51 21 35 73 79 40 68 17 30 6\r\n" + "59 28 67 17 75 37 81 53 82 56 2 95\r\n"
				+ "31 52 22 84 12 97 2 88 39 97 32 30\r\n" + "14 99 74 71 75 31 73 18 10 46 27 50\r\n"
				+ "85 20 24 92 59 52 13 25 97 79 53 33\r\n" + "55 41 40 54 91 54 9 44 26 68 24 6\r\n"
				+ "12 80 65 77 10 27 66 47 14 40 84 84\r\n" + "56 71 18 45 61 91 11 44 24 19 37 91\r\n" + "10\r\n"
				+ "22 49 16 33 22 23 32 17 21 7\r\n" + "24 69 44 22 76 33 96 96 95 83\r\n"
				+ "18 34 18 37 56 79 74 20 45 67\r\n" + "89 53 47 75 44 15 48 95 22 61\r\n"
				+ "25 11 62 18 68 94 11 70 75 9\r\n" + "60 29 64 76 95 52 63 7 72 8\r\n"
				+ "67 2 73 72 71 28 11 35 21 13\r\n" + "65 40 82 28 95 10 57 32 73 79\r\n"
				+ "98 50 76 97 14 32 12 3 98 42\r\n" + "17 96 11 77 82 69 55 92 9 77\r\n" + "10\r\n"
				+ "91 85 58 25 50 34 59 98 62 84\r\n" + "79 2 1 37 68 86 11 34 91 44\r\n"
				+ "82 59 72 50 47 80 23 5 4 30\r\n" + "51 56 43 62 74 80 49 51 10 90\r\n"
				+ "58 42 48 54 3 14 75 5 35 15\r\n" + "57 23 32 76 20 14 23 14 25 89\r\n"
				+ "55 61 29 30 24 100 12 65 70 25\r\n" + "35 5 93 73 45 84 89 56 33 87\r\n"
				+ "74 41 89 8 8 93 87 76 6 27\r\n" + "58 10 64 9 72 87 56 38 66 16\r\n" + "3\r\n" + "10 21 57\r\n"
				+ "31 57 0\r\n" + "37 70 57\r\n" + "14\r\n" + "76 29 54 67 54 3 63 77 44 0 34 64 31 23\r\n"
				+ "25 4 93 89 10 52 40 87 54 41 31 16 0 73\r\n" + "8 61 66 66 43 44 11 70 18 63 69 92 7 11\r\n"
				+ "54 68 42 78 81 35 35 49 10 5 71 5 37 42\r\n" + "51 58 70 82 8 71 51 98 32 13 61 44 69 38\r\n"
				+ "11 98 46 63 28 85 90 34 86 39 72 67 8 89\r\n" + "88 36 64 39 30 47 65 15 86 53 36 3 5 25\r\n"
				+ "64 52 74 95 16 26 88 42 39 36 97 46 52 70\r\n" + "11 73 44 31 25 98 44 50 26 29 6 54 38 90\r\n"
				+ "72 83 23 100 11 21 8 75 4 37 50 59 64 89\r\n" + "93 48 75 60 39 30 76 27 2 75 92 35 27 38\r\n"
				+ "17 14 25 70 71 86 68 73 2 14 22 50 72 62\r\n" + "33 11 52 43 67 53 62 76 92 35 73 20 23 17\r\n"
				+ "26 20 35 35 70 95 58 7 32 49 70 50 29 18\r\n" + "7\r\n" + "3 60 60 33 85 29 12\r\n"
				+ "18 53 88 6 59 77 99\r\n" + "57 19 94 99 13 49 86\r\n" + "16 45 54 90 43 13 38\r\n"
				+ "76 32 98 16 64 73 19\r\n" + "51 91 9 77 50 61 43\r\n" + "74 100 41 51 5 95 90\r\n" + "4\r\n"
				+ "40 70 88 24\r\n" + "86 17 25 54\r\n" + "44 100 0 21\r\n" + "73 48 11 78\r\n" + "5\r\n"
				+ "58 26 65 74 45\r\n" + "25 42 31 10 94\r\n" + "88 58 4 74 81\r\n" + "64 1 84 31 13\r\n"
				+ "48 93 37 23 88\r\n" + "15\r\n" + "61 100 46 93 22 70 92 52 75 83 84 58 82 38 57\r\n"
				+ "9 59 61 77 92 99 8 43 41 75 48 8 87 20 6\r\n" + "11 94 48 34 96 80 48 14 8 65 92 96 91 23 68\r\n"
				+ "49 3 67 40 21 23 32 93 45 49 17 73 19 7 46\r\n" + "25 92 75 4 93 7 49 85 6 6 21 84 34 6 88\r\n"
				+ "32 49 87 77 0 95 70 0 50 59 85 77 49 52 69\r\n" + "50 97 87 96 16 41 15 81 80 46 91 36 12 21 63\r\n"
				+ "7 47 65 76 52 93 26 87 15 32 56 54 50 39 91\r\n" + "96 76 77 73 68 54 95 33 75 17 99 95 0 24 91\r\n"
				+ "100 48 64 99 26 21 77 22 16 68 91 83 63 67 44\r\n" + "37 19 77 31 86 61 70 80 3 39 0 31 41 48 46\r\n"
				+ "18 25 49 2 46 87 93 79 5 99 10 14 48 83 67\r\n" + "20 93 48 3 37 69 0 10 10 36 37 92 72 24 87\r\n"
				+ "99 27 69 49 26 0 21 87 32 21 70 91 29 64 100\r\n" + "75 14 18 21 1 20 18 1 37 92 29 27 78 68 69\r\n"
				+ "13\r\n" + "99 82 48 7 97 29 35 79 79 41 23 94 0\r\n" + "29 52 67 6 15 0 13 46 73 43 17 0 46\r\n"
				+ "23 38 57 58 49 70 66 44 33 34 78 1 66\r\n" + "5 20 13 96 8 42 31 65 86 94 21 79 92\r\n"
				+ "66 89 4 8 88 56 49 78 27 20 76 59 22\r\n" + "46 41 53 31 68 76 74 38 72 47 10 91 38\r\n"
				+ "10 43 38 5 30 15 44 93 99 72 72 5 27\r\n" + "32 55 38 35 24 63 92 69 95 31 58 3 29\r\n"
				+ "56 79 24 12 32 43 48 50 39 88 34 53 8\r\n" + "98 10 24 25 19 35 24 98 5 81 28 53 73\r\n"
				+ "69 4 27 67 9 88 66 26 60 44 88 92 28\r\n" + "30 3 84 33 47 94 22 81 96 36 1 5 43\r\n"
				+ "4 57 61 62 18 30 44 58 75 8 53 95 44\r\n" + "4\r\n" + "98 13 75 48\r\n" + "94 0 6 79\r\n"
				+ "75 3 43 34\r\n" + "91 73 49 48\r\n" + "";
	
	}