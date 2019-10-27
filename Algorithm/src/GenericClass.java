public class GenericClass<D, N> {

	D data;
	N next;

	public GenericClass(D data, N next) {
		this.data = data;
		this.next = next;
	}

	public <G> int run(G parameter) {
		System.out.println(parameter);
		return 3;
	}
}
