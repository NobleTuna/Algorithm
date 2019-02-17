package se1983;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken())-1;
			double arr[][] = new double[N][2];
			for(int n=0; n<N; n++) {
				input = br.readLine();
				st = new StringTokenizer(input);
				double a = Integer.parseInt(st.nextToken())*0.35;
				double b = Integer.parseInt(st.nextToken())*0.45;
				double c = Integer.parseInt(st.nextToken())*0.2;
				arr[n][0] = n;
				arr[n][1] = a+b+c;
			}
			Arrays.sort(arr, new Comparator<double[]>() {

				public int compare(double[] o1, double[] o2) {
					// TODO Auto-generated method stub
					double a = o1[1];
					double b = o2[1];
					return Double.compare(b,a);
				}
			});
			for(int i=0; i<N; i++) {
//				System.out.println("등수 : "+ (i+1)+ " 학생번호 "+ arr[i][0] +" 점수 "+ arr[i][1]+ " ");
			}
			int target =0;
			for(int i=0; i<N; i++) {
				if(arr[i][0]==K) {
					target = i; // 등수
//					System.out.println( "등수 : "+ (target+1)+ " 학생번호 "+ arr[i][0] +" 점수 "+ arr[i][1]+ " ");

					break;
				}
			}
//			System.out.println();
			
			target = target*10/N;
			
//			System.out.println("k = "+k+" N = "+N+ " target :" + target + " 학생번호 : "+ K);
			
			if(target == 0) {
				System.out.println("#"+tc+" "+"A+");
			}else if(target == 1) {
				System.out.println("#"+tc+" "+"A0");
			}
			else if(target == 2) {
				System.out.println("#"+tc+" "+"A-");
			}
			else if(target == 3) {
				System.out.println("#"+tc+" "+"B+");
			}
			else if(target == 4) {
				System.out.println("#"+tc+" "+"B0");
			}
			else if(target == 5) {
				System.out.println("#"+tc+" "+"B-");
			}
			else if(target == 6) {
				System.out.println("#"+tc+" "+"C+");
			}
			else if(target == 7) {
				System.out.println("#"+tc+" "+"C0");
			}
			else if(target == 8) {
				System.out.println("#"+tc+" "+"C-");
			}
			else if(target == 9) {
				System.out.println("#"+tc+" "+"D0");
			}
		}

	}

}
