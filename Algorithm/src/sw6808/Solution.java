package sw6808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
public class Solution {
    static int xWin;
    static int fact[] = {1, 1, 2, 6, 24, 120, 720, 5040 ,40320};
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int x[] = new int[9];
            boolean[] card = new boolean[19];
            for (int i = 0; i < 9; i++) {
                x[i] = Integer.parseInt(st.nextToken());
                card[x[i]] = true;
            }
            int[] y = new int[9];
            int idx = 0;
            for(int i=1; i<=18; i++) {
            	if(!card[i]) {
            		y[idx++] = i;
            	}
            }
            xWin = 0;
            boolean[] visited = new boolean[9];
  
            go(x, y, visited, 0,0, 0);
            System.out.println("#" + tc + " " + xWin + " " + (362880 - xWin));
  
        }
    }
  
    public static void go(int[] x, int[] y, boolean[] visited, int cnt, int xSum, int ySum) {
  
        if (xSum >= 86) {
            xWin += fact[9 - cnt];
            return;
        } else if (ySum >= 86) {
            return;
        }
  
        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int goXSum = xSum;
                int goYSum = ySum;
  
                if (x[cnt] > y[i]) {
                    goXSum += y[i] + x[cnt];
                } else {
                    goYSum += x[cnt] + y[i];
                }
  
                go(x, y, visited, cnt + 1, goXSum, goYSum);
  
                visited[i] = false;
            }
        }
    }
  
}