package bj10026_적녹색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }


    static int N;
    static char[][] map;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static boolean isOutRange(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= N;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new StringReader(TC1));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray().clone();
        }

        System.out.println(check0()+" "+check1());
//        for (int i = 0; i < N; i++) {
//            System.out.println(map[i]);
//        }

    }

    // 색약 아닐경우 체크
    static int check0() {
        int answer = 0;
        Queue<Point> q = new LinkedList<>();

        char color;
        boolean[][] isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    answer++;
                    color = map[i][j];
                    isVisited[i][j] = true;
                    q.add(new Point(i, j));

                    while (!q.isEmpty()) {
                        Point n = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int ny = n.y + dy[k];
                            int nx = n.x + dx[k];

                            if (isOutRange(ny, nx) || isVisited[ny][nx] || !(map[ny][nx] == color))
                                continue;
                            isVisited[ny][nx] = true;
                            q.add(new Point(ny, nx));
                        }
                    }
                }
            }
        }
        return answer;
    }

    // 색약 체크
    static int check1() {

        int answer = 0;
        Queue<Point> q = new LinkedList<>();

        char color;
        boolean[][] isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    answer++;
                    color = map[i][j];
                    isVisited[i][j] = true;
                    q.add(new Point(i, j));

                    while (!q.isEmpty()) {
                        Point n = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int ny = n.y + dy[k];
                            int nx = n.x + dx[k];

                            if (color == 'R' || color == 'G') {
                                if (isOutRange(ny, nx) || isVisited[ny][nx] || map[ny][nx] == 'B')
                                    continue;
                            } else {
                                if (isOutRange(ny, nx) || isVisited[ny][nx] || !(map[ny][nx] == color))
                                    continue;
                            }
                            isVisited[ny][nx] = true;
                            q.add(new Point(ny, nx));
                        }
                    }
                }
            }
        }
        return answer;

    }


    static String TC1 = "5\n" +
            "RRRBB\n" +
            "GGBBB\n" +
            "BBBRR\n" +
            "BBRRR\n" +
            "RRRRR";
}
