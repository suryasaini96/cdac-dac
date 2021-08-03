
public class Stack implements StackInf {
	
	int arr[];
	int top;
	int capacity;

	public Stack(int c) {
		super();
		this.capacity = c;
		this.arr = new int[c];
		this.top = -1;
	}

	@Override
	public void Push(int elem) {
		if (top>=capacity) 
			System.out.println("Stack overflow");
		else
			arr[++top] = elem;
	}

	@Override
	public int Pop() {
		if (IsEmpty()) {
			System.out.println("Stack underflow");
			return 0;
		}
		return arr[top--];
	}

	@Override
	public boolean IsEmpty() {
		if (top == -1)
			return true;
		return false;
	}

	@Override
	public boolean IsFull() {
		if (top>=capacity-1)
			return true;
		return false;
	}
	
}
