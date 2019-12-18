package bj2206_벽부수기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int y;
        int x;
        boolean isBreak;

        public Point(int y, int x, boolean isBreak) {
            this.y = y;
            this.x = x;
            this.isBreak = isBreak;
        }
    }

    static int dy[] = {1, -1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    static int N, M;

    static boolean outRange(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= M;
    }

    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(TC7));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - 48;
            }
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, true));

        boolean visitedTrue[][] = new boolean[N][M];
        boolean visitedFalse[][] = new boolean[N][M];

        visitedTrue[0][0] = true;
        visitedFalse[0][0] = true;
        int answer = -1;
        int D = 0;

        go:while (!q.isEmpty()) {

            int size = q.size();
            D++;
            for (int s = 0; s < size; s++) {
                Point p = q.poll();

                if (p.y == N - 1 && p.x == M - 1) {
                    answer = D;
                    break go;
                }

                for (int d = 0; d < 4; d++) {
                    int ny = p.y + dy[d];
                    int nx = p.x + dx[d];

                    if (outRange(ny, nx))
                        continue;

                    // 벽을 부술 수 있음
                    if (p.isBreak) {

                        // 벽이 아닐때
                        if (map[ny][nx] == 0) {

                            // 지나간 적이 있으면 아무것도 안함
                            if (visitedTrue[ny][nx])
                                continue;

                            visitedTrue[ny][nx] = true;
                            q.add(new Point(ny, nx, true));

                            // 벽일때 벽을 부수고 지나감
                        } else {
//                            visitedFalse[ny][nx] = true;
                            q.add(new Point(ny, nx, false));
                        }

                        // 벽을 부술 수 없음
                    } else {

                        //벽이 아닐 때
                        if (map[ny][nx] == 0) {

                            // 지나간 적이 있으면 아무것도 안함
                            if (visitedFalse[ny][nx])
                                continue;

                            visitedFalse[ny][nx] = true;
                            q.add(new Point(ny, nx, false));

                            // 벽일 때
                        } else {
                            // 아무것도 못함
                        }

                    }

                }
            }
        }
        System.out.println(answer);
    }

    static String TC1 = "6 4\n" +
            "0100\n" +
            "1110\n" +
            "1000\n" +
            "0000\n" +
            "0111\n" +
            "0000";

    static String TC2 = "4 4\n" +
            "0111\n" +
            "1111\n" +
            "1111\n" +
            "1110";

    static String TC3 = "4 4\n" +
            "0000\n" +
            "1111\n" +
            "0000\n" +
            "0000";

    static String TC4 = "4 4\n" +
            "0000\n" +
            "1111\n" +
            "1101\n" +
            "0000";

    static String TC5 = "5 4\n" +
            "0000\n" +
            "1110\n" +
            "0000\n" +
            "0111\n" +
            "0010";

    static String TC6 = "6 5\n" +
            "00000\n" +
            "11110\n" +
            "00000\n" +
            "01111\n" +
            "01111\n" +
            "00010";

    static String TC7 = "6 4\n" +
            "0000 \n" +
            "1110 \n" +
            "0110 \n" +
            "0000 \n" +
            "0111 \n" +
            "0000";
}
