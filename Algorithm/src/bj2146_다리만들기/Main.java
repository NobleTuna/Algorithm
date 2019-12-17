package bj2146_다리만들기;

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
        int label;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Point(int y, int x, int label) {
            this.y = y;
            this.x = x;
            this.label = label;
        }
    }

    static int dy[] = {1, -1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    static boolean outRange(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= N;
    }

    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(TC1));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 라벨링
        boolean visited[][] = new boolean[N][N];
        int label = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    visited[i][j] = true;
                    label++;
                    map[i][j] = label;
                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i, j));

                    while (!q.isEmpty()) {
                        Point p = q.poll();

                        for (int d = 0; d < 4; d++) {
                            int ny = p.y + dy[d];
                            int nx = p.x + dx[d];

                            if (outRange(ny, nx) || visited[ny][nx] || map[ny][nx] == 0)
                                continue;

                            visited[ny][nx] = true;
                            map[ny][nx] = label;
                            q.add(new Point(ny, nx));
                        }
                    }

                }
            }
        }

//        System.out.println("finished");
//        for (int i = 0; i < N; i++) {
//            System.out.println();
//            for (int j = 0; j < N; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//        }


        // 탐색

        int D = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    if ((i - 1 >= 0 && map[i - 1][j] == 0) || (i + 1 < N && map[i + 1][j] == 0) || (j - 1 >= 0 && map[i][j - 1] == 0) || (j + 1 < N && map[i][j + 1] == 0)) {
                        Queue<Point> q = new LinkedList<>();
                        visited = new boolean[N][N];

                        q.add(new Point(i, j, map[i][j]));
                        int curD = -1;
                        visited[i][j] = true;

                        while (!q.isEmpty()) {
                            curD++;
                            if (curD > D)
                                break;
                            int size = q.size();

                            for (int s = 0; s < size; s++) {
                                Point p = q.poll();

                                for (int d = 0; d < 4; d++) {
                                    int ny = p.y + dy[d];
                                    int nx = p.x + dx[d];

                                    if (outRange(ny, nx) || visited[ny][nx] || map[ny][nx] == p.label)
                                        continue;

                                    if (map[ny][nx] != 0) {
                                        D = Math.min(D, curD);
                                        break;
                                    } else {
                                        visited[ny][nx] = true;
                                        q.add(new Point(ny, nx, p.label));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(D);


    }

    static String TC1 = "10\n" +
            "1 1 1 0 0 0 0 1 1 1\n" +
            "1 1 1 1 0 0 0 0 1 1\n" +
            "1 0 1 1 0 0 0 0 1 1\n" +
            "0 0 1 1 1 0 0 0 0 1\n" +
            "0 0 0 1 0 0 0 0 0 1\n" +
            "0 0 0 0 0 0 0 0 0 1\n" +
            "0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 1 1 0 0 0 0\n" +
            "0 0 0 0 1 1 1 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0";
}
