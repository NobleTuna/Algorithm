package sw1928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Base64;
 
public class Solution {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String msg = br.readLine();
//            String result = new String(Base64.getDecoder().decode(msg));
//            System.out.println("#"+tc+" "+result);
        }
    }
 
}