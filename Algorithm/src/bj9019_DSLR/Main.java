package bj9019_DSLR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class register {
        StringBuilder command;
        int number;

        public register(StringBuilder command, int number) {
            this.command = command;
            this.number = number;
        }
    }

    static int result;
    static int origin;
    static boolean[] visited;
    static Queue<register> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(TC1));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            origin = Integer.parseInt(st.nextToken());
            result = Integer.parseInt(st.nextToken());
            register start = new register(new StringBuilder(), origin);
            q = new LinkedList<>();
            visited = new boolean[10005];
            q.add(start);

            while (!q.isEmpty()) {
                register thisQ = q.poll();

                if (visited[thisQ.number])
                    continue;
                else
                    visited[thisQ.number] = true;

                if (answerChk(thisQ)) {
                    break;
                }
                q.add(D(thisQ));

                q.add(S(thisQ));

                q.add(L(thisQ));

                q.add(R(thisQ));

            }
        }
    }

    public static register D(register thisQ) {
        StringBuilder command = new StringBuilder(thisQ.command);
        command.append("D");
        int number = thisQ.number * 2;
        number = (number > 9999) ? number % 10000 : number;
        return new register(command, number);
    }

    public static register S(register thisQ) {
        StringBuilder command = new StringBuilder(thisQ.command);
        command.append("S");
        int number = thisQ.number;
        number = (number == 0) ? 9999 : number - 1;
        return new register(command, number);
    }

    public static register L(register thisQ) {
        StringBuilder command = new StringBuilder(thisQ.command);
        command.append("L");
        int number = thisQ.number;
        // if (number < 10) {

        // } else if (number < 100) {
        //     int k = number / 10;
        //     number = ((number * 10) % 100) + k;
        // } else if (number < 1000) {
        //     int k = number / 100;
        //     number = ((number * 10) % 1000) + k;
        // } else if (number < 10000) {
            int k = number / 1000;
            number = ((number * 10) % 10000) + k;
        // }
        return new register(command, number);
    }

    public static register R(register thisQ) {
        StringBuilder command = new StringBuilder(thisQ.command);
        command.append("R");
        int number = thisQ.number;

        // if (number < 10) {

        // } else if (number < 100) {
        //     int k = number % 10;
        //     number = (number / 10) + k * 10;
        // } else if (number < 1000) {
        //     int k = number % 10;
        //     number = (number / 10) + k * 100;
        // } else if (number < 10000) {
            int k = number % 10;
            number = (number / 10) + k * 1000;
        // }
        return new register(command, number);
    }

    public static boolean answerChk(register r) {
        if (r.number == result) {
            System.out.println(r.command.toString());
            return true;
        } else
            return false;
    }

    static String TC1 = "3\r\n" + "1234 3412\r\n" + "1000 1\r\n" + "1 16";
}
