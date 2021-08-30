import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDoublyLinkedList {
	
	@Test
	void testAddAtFront() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.AddAtFront(2);
		int[] elements = list.GetAllElements();
		assertTrue(elements.length == 1 && elements[0] == 2);
	}
	
	@Test
	void testAddElementAtPosition() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.AddAtFront(2);
		list.AddElementAtPosition(26, 7);
		int[] elements = list.GetAllElements();
		assertTrue(elements.length == 2 && elements[1] == 26);
	}
	
	@Test
	void testGetAllElements() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.AddAtFront(2);
		int[] elements = list.GetAllElements();
		assertTrue(elements.length == 1);
	}
	
	@Test
	void testGetAllElementsInReverse() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.AddAtFront(2);
		list.AddElementAtPosition(26, 7);
		int[] elements = list.GetAllElementsInReverse();
		assertTrue(elements.length == 2 && elements[0] == 26);
	}
	
	
	@Test
	void testDeleteAll() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.AddAtFront(2);
		list.AddAtFront(2);
		list.AddElementAtPosition(26, 7);
		list.DeleteAll(2);
		int[] elements = list.GetAllElements();
		assertTrue(elements.length == 1 && elements[0] == 26);
	}

}
