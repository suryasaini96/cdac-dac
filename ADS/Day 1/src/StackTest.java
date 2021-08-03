import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {

	@Test
	void testForEmpty() {
		Stack stack = new Stack(3);
		assertTrue(stack.IsEmpty());
	}
	
	@Test
	void testForFull() {
		Stack stack = new Stack(3);
		assertFalse(stack.IsFull());
	}
	
	@Test
	void testPushUtilFull() {
		Stack stack = new Stack(1);
		stack.Push(1);
		assertTrue(stack.IsFull());
	}
	
	@Test
	void testPushPopAndValidate() {
		Stack stack = new Stack(1);
		int e = 10;
		stack.Push(e);
		assertTrue(stack.Pop() == e);
	}

}
