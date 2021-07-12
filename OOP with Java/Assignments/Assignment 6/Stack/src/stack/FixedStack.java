package stack;

public class FixedStack implements Stack {
	
	private Employee[] stack = new Employee[STACK_SIZE];
	private int top = -1;

	@Override
	public void push(Employee emp) {
		if (top!=STACK_SIZE-1) 
			stack[++top] = emp;
		else 
			System.out.println("Stack Overflow!");
	}

	@Override
	public Employee pop() {
		if (top!=-1) {
			Employee emp = stack[top];
			stack[top--] = null;
			return emp;	
		}
		return null;
	}

}
