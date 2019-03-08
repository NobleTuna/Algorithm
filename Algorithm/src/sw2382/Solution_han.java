package sw2382;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_han{
	static int[][] dir = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
	static int[][] map,kong;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int result = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			map = new int[N][N];
			kong = new int[K][4];
			for(int i=0;i< K;i++) {
				kong[i][0] = sc.nextInt();	// 세로위치
				kong[i][1] = sc.nextInt();	// 가로위치
				kong[i][2] = sc.nextInt();  // 미생물 수
				kong[i][3] = sc.nextInt();	// 이동방향
			}
			for(int time=0;time< M;time++) { // 시간만큼 반복
				Arrays.sort(kong, new Comparator< int[]>() { // 미생물 수로 정렬
					
					@Override
					public int compare(int[] o1, int[] o2) {
						// TODO Auto-generated method stub
						return o1[2]-o2[2];
					}
				});
				
				for(int i=0;i< K;i++) {  // 미생물 이동
					if(kong[i][3]==-1) { // 합쳐진 미생물은 지나감
						continue;
					}
					int a = kong[i][0]+dir[kong[i][3]][0];  // 각 미생물 이동 좌표
					int b = kong[i][1]+dir[kong[i][3]][1];
					
					// 미생물 약품을 만났을 때
					if(a==0) {
						kong[i][3] = 2;
						kong[i][2] /= 2;
					}else if(a==N-1) {
						kong[i][3] = 1;
						kong[i][2] /= 2;
					}else if(b==0) {
						kong[i][3] = 4;
						kong[i][2] /= 2;
					}else if(b==N-1) {
						kong[i][3] = 3;
						kong[i][2] /= 2;
					}
					if(map[a][b]!=0) { // 이전에 이동한 미생물이 있을 때
						kong[i][2] = kong[map[a][b]][2]+kong[i][2]; // 미생물을 합쳐준다.
						kong[map[a][b]][3]=-1;  // 없어진 미생물 표시
						kong[map[a][b]][2]=0;   // 없어진 미생물을 0으로 처리
					}
					map[a][b] = i;  // 각 이동한 미생물의 좌표에 index값 설정
					kong[i][0] = a; // 이동한 좌표 저장
					kong[i][1] = b;
					
				}
				for(int i=0;i< K;i++) { // 미생물이 이동한 좌표 초기화
					map[kong[i][0]][kong[i][1]] = 0;
				}
				
				
			}
			for(int i=0;i< K;i++) {  // 남아있는 미생물의 총합
				result += kong[i][2];
			}
			System.out.println("#"+tc+" "+result);
		}
		sc.close();
	}
}
