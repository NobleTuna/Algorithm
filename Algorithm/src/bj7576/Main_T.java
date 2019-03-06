package bj7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_T {
	static class Point{
		int r; 
		int c;
		Point(int r, int c){
			this.r=r;
			this.c=c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N =sc.nextInt();
		int[][] map = new int[N][M];
		Queue<Point> queue = new LinkedList<Point>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==1)
					queue.add(new Point(i,j));
			}
		}
		while( !queue.isEmpty()) {
			Point p = queue.poll();
			int r = p.r;
			int c = p.c;
			for(int i = 0; i<4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if( nr < 0 || nc < 0 || nr >= map.length || nc >= map[nr].length)
					continue;
				if( map[nr][nc] == 0 ) {
					map[nr][nc] = map[r][c]+1;
					queue.add(new Point(nr,nc));
				}
			}
		}
		int max = 0;
		boolean isOk = true;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if( map[i][j] == 0 ) {
					isOk = false;
				}
				if( max < map[i][j])
					max = map[i][j];
			}
		}
		System.out.println(isOk?max-1:-1);
	}

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
}
