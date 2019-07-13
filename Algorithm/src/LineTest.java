import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class LineTest {

	public int[] solution(int[][] v) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int ansx = 0;
		int ansy = 0;

		int vx1 = v[0][0];
		int vx2 = v[1][0];
		int vx3 = v[2][0];

		if (vx1 == vx2)
			ansx = vx3;
		else if (vx2 == vx3)
			ansx = vx1;
		else if (vx3 == vx1)
			ansx = vx2;

		int vy1 = v[0][1];
		int vy2 = v[1][1];
		int vy3 = v[2][1];

		if (vy1 == vy2)
			ansy = vy3;
		else if (vy2 == vy3)
			ansy = vy1;
		else if (vy3 == vy1)
			ansy = vy2;

		int[] answer = { ansx, ansy };

//		System.out.println("Hello Java");

		return answer;
	}

}
