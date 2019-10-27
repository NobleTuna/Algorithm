import java.util.ArrayList;
import java.util.List;

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

	}

}
