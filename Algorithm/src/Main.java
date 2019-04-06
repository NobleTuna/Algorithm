import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> list = new LinkedList<>();

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int people = 1;

		for (int i = 0; i < N; i++) {

			list.add(Integer.parseInt(st.nextToken()), people++);
		}

//			System.out.println(list);

		int ans = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = list.size()-1; i >=0; i--) {
			sb.append(list.get(i) + " ");
//				ans += list.get(i) - list.get(i - 1);

		}

		System.out.println(sb);

	}

}
