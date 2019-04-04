import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Algo32_광주_2_위영웅 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		

			List<Integer> list = new LinkedList<>();

			int N = Integer.parseInt(br.readLine());
			


			int people = 1;

			for (int i = 0; i < N; i++) {

				list.add(Integer.parseInt(br.readLine()), people++);
			}

//			System.out.println(list);

			int ans = 0;

			for (int i = 1; i < list.size(); i++) {
				ans += list.get(i) - list.get(i - 1);
			}
			
			System.out.println(ans);

		

	}

}
