package bj1726_Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int y;
        int x;
        int direction;
        int count;

        public Point(int y, int x, int direction, int count) {
            this.y = y;
            this.x = x;
            this.direction = direction;
            this.count = count;
        }
    }

    static boolean outRange(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= M;
    }

    static int N, M;
    static int[][] map;
    static int Sy, Sx, Sd;
    static int Fy, Fx, Fd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(TC3));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        Sy = Integer.parseInt(st.nextToken()) - 1;
        Sx = Integer.parseInt(st.nextToken()) - 1;
        Sd = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Fy = Integer.parseInt(st.nextToken()) - 1;
        Fx = Integer.parseInt(st.nextToken()) - 1;
        Fd = Integer.parseInt(st.nextToken());

//        for(int i=0; i<N; i++){
//            System.out.println(Arrays.toString(map[i]));
//        }
//        System.out.println(Sy);
//        System.out.println(Sx);
//        System.out.println(Sd);
//        System.out.println(Fy);
//        System.out.println(Fx);
//        System.out.println(Fd);


        boolean[][][] visited = new boolean[N][M][5];
        visited[Sy][Sx][Sd] = true;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(Sy, Sx, Sd, 0));
        // 1 2 3 4 (동 서 남 북)

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.y == Fy && p.x == Fx && p.direction == Fd) {
                System.out.println(p.count);
//                map[p.y][p.x] = 9;
                break;
            }

            int tL = turnLeft(p.direction);
            if (!visited[p.y][p.x][tL]) {
                visited[p.y][p.x][tL] = true;
                q.add(new Point(p.y, p.x, tL, p.count + 1));
            }

            int tR = turnRight(p.direction);
            if (!visited[p.y][p.x][tR]) {
                visited[p.y][p.x][tR] = true;
                q.add(new Point(p.y, p.x, tR, p.count + 1));
            }

            for (int d = 1; d <= 3; d++) {

                int ny = p.y;
                int nx = p.x;

                if (p.direction == 1)
                    nx += d;
                else if (p.direction == 2)
                    nx -= d;
                else if (p.direction == 3)
                    ny += d;
                else if (p.direction == 4)
                    ny -= d;

//                System.out.println(ny + " " + nx + " " + p.direction);

//                if (outRange(ny, nx))
//                    System.out.println("out range " + ny + " " + nx);
//                if (!outRange(ny, nx) && map[ny][nx] == 1)
//                    System.out.println("map in 1 " + ny + " " + nx);
//                if (!outRange(ny, nx) && visited[ny][nx][p.direction])
//                    System.out.println("is visited " + ny + " " + nx + " " + p.direction);

                if (outRange(ny, nx) || visited[ny][nx][p.direction])
                    continue;

                if (map[ny][nx] == 1)
                    break;

//                System.out.println("이동후 추가");
                visited[ny][nx][p.direction] = true;
                q.add(new Point(ny, nx, p.direction, p.count + 1));

            }
        }
//        for(int i=0; i<N; i++){
//            System.out.println(Arrays.toString(map[i]));
//        }
    }


    static int turnLeft(int d) {
        if (d == 1)
            return 4;
        else if (d == 2)
            return 3;
        else if (d == 3)
            return 1;
        else
            return 2;
    }

    static int turnRight(int d) {
        if (d == 1)
            return 3;
        else if (d == 2)
            return 4;
        else if (d == 3)
            return 2;
        else
            return 1;
    }

    static String TC1 = "5 6\n" +
            "0 0 0 0 0 0\n" +
            "0 1 1 0 1 0\n" +
            "0 1 0 0 0 0\n" +
            "0 0 1 1 1 0\n" +
            "1 0 0 0 0 0\n" +
            "4 2 3\n" +
            "2 4 1";

    static String TC2 = "9 12\n" +
            "0 0 0 0 0 0 0 0 0 0 0 1\n" +
            "0 1 1 1 1 0 0 1 1 1 1 0\n" +
            "0 0 0 0 0 0 0 1 1 1 1 0\n" +
            "0 1 1 1 1 0 0 1 1 1 1 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 1 1 1 1 0 0 1 1 1 1 0\n" +
            "0 1 1 1 1 0 0 0 0 0 0 0\n" +
            "0 1 1 1 1 0 0 1 1 1 1 0\n" +
            "1 0 0 0 0 0 0 0 0 0 0 0\n" +
            "1 1 3\n" +
            "9 12 3";

    static String TC3 = "4 2\n" +
            "0 0\n" +
            "0 0\n" +
            "1 0\n" +
            "0 0\n" +
            "1 1 3\n" +
            "4 1 3";
}
