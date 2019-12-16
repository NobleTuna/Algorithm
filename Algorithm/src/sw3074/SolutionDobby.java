package sw3074;

import java.util.Arrays;
import java.util.Scanner;
 
public class SolutionDobby {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            long N = sc.nextLong();
            long M = sc.nextLong();
            long[] t = new long[(int) N];
            for(int i=0; i<N; i++) {
                t[i] = sc.nextInt();
            }
             
            Arrays.sort(t);
 
            long max = t[(int) (N-1)];
            long left = t[0], right = max*M;
            long result = max*M;
            while(left<=right) {
                long mid = (left+right)/2;
                long total = 0;
                for(int i=0; i<N; i++) {
                    total += mid/t[i];
                }
                 
                if(total<M) {
                    left = mid+1;
                }
                else {
                    if(result > mid)
                        result = mid;
                    right = mid-1;
                }
            }
             
            System.out.println("#"+tc+" "+result);
        }
    }
}