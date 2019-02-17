package sw1247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int cus[][];
    static int result;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int TC = 1; TC <= T; TC++) {
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
 
            // cus[0] = 회사
            // cus[1] = 집
            // 고객 집정보, cus[n][0] = x, cus[n][1] = y;
            int size = N+2;
            cus = new int[size][2];
 
            for (int i = 0; i < size; i++) {
                cus[i][0] = Integer.parseInt(st.nextToken());
                cus[i][1] = Integer.parseInt(st.nextToken());
            }
            int len[][] = new int[size][size];
            boolean visit[] = new boolean[size];
            makeSheet(len);
//          for(int i=0; i<len.length; i++) {
//              for(int j=0; j<len.length; j++) {
//                  System.out.print(len[i][j] + "\t");
//              }System.out.println();
//          }
            result = Integer.MAX_VALUE;
 
            go(len, visit, 0, 0, 0, N);
 
            System.out.println("#" + TC + " " + result);
 
        }
    }
 
/// 0 회사, 1 집
    static void go(int[][] len, boolean[] visit, int current, int sum, int cnt, int N) {
        if (cnt == N) { // 순회 다했으면 합 비교
             
            sum = sum+len[current][1];
            if (sum < result) {
                result = sum;
                return;
            }
        }
        if(sum>=result) {
            return;
        }
        for(int i=2; i<N+2; i++) {
             
            int Nsum = sum + len[current][i];
            if(!visit[i]&&Nsum<result) {
                 
                visit[i] = true;
                go(len, visit, i, Nsum, cnt+1, N);
                visit[i] = false;
            }
        }
    }
 
    static void makeSheet(int[][] len) { // 거리표 작성
        for (int i = 0; i < len.length; i++) {
            for (int j = 0; j < len.length; j++) {
                len[i][j] = road(i, j);
            }
        }
    }
 
    static int road(int a, int b) { // 거리계산
        return Math.abs(cus[a][0] - cus[b][0]) + Math.abs(cus[a][1] - cus[b][1]);
    }
 
}