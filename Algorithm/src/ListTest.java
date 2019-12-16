import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ListTest {

	static class ListClass<T, C> {
		T a;
		C b;

		ListClass(T a, C b) {
			this.a = a;
			this.b = b;
		}

		<testG> void setA(T a, testG k) {
			this.a = a;
			System.out.println(k);
		}

	}

	public static void main(String[] args) {

		ListClass<ListClass, String> list2 = new ListClass<ListTest.ListClass, String>(null, "data3");
		ListClass<ListClass, Integer> list1 = new ListClass<ListTest.ListClass, Integer>(list2, Integer.MAX_VALUE);
		list2.a = list1;
		List<Integer> list = new ArrayList<Integer>();

		ArrayList<String> places = new ArrayList<String>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));

		List<?> wildCard = new ArrayList<>();
		List<? extends Object> wc = new ArrayList<Object>();
		List<? extends Object> wc1 = new ArrayList<String>(Arrays.asList("가", "나", "다"));
		List<? extends Number> wc2 = new ArrayList<Double>(Arrays.asList(33.44, 241.5));
		Number e = 3;
		for (Object k : wc1) {
			System.out.println(k);
		}
		for (Number k : wc2) {
			System.out.println(k);
		}

		List<String> sList = new ArrayList<String>();
		sList.add("kk");

		Queue<String> q = new LinkedList<String>();
		Stack<String> ss = new Stack<String>();

		String[] garbage = new String[3];
		garbage = new String[] { "가 나 ", "다 라" };
	}

}
