
public class GenericTest {
	public static void main(String[] args) {
		AnotherClass<Integer> tester = new AnotherClass<Integer>();
		tester.data = Integer.MAX_VALUE;
		AnotherClass<String> tester2 = new AnotherClass<String>();
		tester2.data = "test2";
		GenericClass<Integer, String> testert = new GenericClass<Integer, String>(11, "tester");
	}
}

class AnotherClass<generic> {
	public generic data;
}
