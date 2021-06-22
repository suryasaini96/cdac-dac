package generic;
//generic
//Create a Holder class , that can hold ANY data type (primitive/ref type)
public class Holder<T> {
	//T : Type (placeholder)
	// Holder HAS-A any data type
	private T ref;
	
	public Holder(T ref) {
		super();
		this.ref = ref;
	}

	public T getRef() {
		return ref;
	}

}
