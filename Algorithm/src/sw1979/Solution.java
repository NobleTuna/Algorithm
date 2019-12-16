package sw1979;

import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        int dx[] = { 0, 0, -1, 1 };
        int dy[] = { -1, 1, 0, 0 };
        int box[][];
        int Answer;
 
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int TC = 1; TC <= T; TC++) {
            Answer = 0;
            int N = sc.nextInt();
            int W = sc.nextInt();
            box = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    box[i][j] = sc.nextInt();
                }
            }
//          for(int i=0; i<N; i++) {
//              for(int j=0; j<N; j++) {
//                  System.out.print(box[i][j]);
//              }System.out.println();
//          }
            int result = 0;
            for (int i = 0; i < N; i++) {
                int count = 0;
                for (int j = 0; j < N; j++) {
                    if (box[i][j] == 1)
                        count++;
                    else
                        count = 0;
 
                    if (count == W)
                        result++;
                    if (count == W + 1) {
                        count = 0;
                        result--;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                int count = 0;
                for (int j = 0; j < N; j++) {
                    if (box[j][i] == 1)
                        count++;
                    else
                        count = 0;
 
                    if (count == W)
                        result++;
                    if (count == W + 1) {
                        count = 0;
                        result--;
                    }
                }
            }
 
            System.out.println("#" + TC + " " + result);
        }
    }
 
}