
public class DoublyLinkedList implements LinkedListIntf {
	
	private DoublyListNode head;
	private DoublyListNode tail;

	@Override
	public void AddAtFront(int element) {
		DoublyListNode node = new DoublyListNode(element);
		if (head == null) {
			head = node;
			tail = node;
			return;
		}
		node.next = head;
		head.prev = node;
		head = node;
	}

	@Override
	public void AddElementAtPosition(int element, int position) {
		// Get the list size
		int size = listSize();
        if (position < 1)
            position = 1;
        else if (position > size)
        	position = size + 1;
        
		DoublyListNode curr = head;
		DoublyListNode prev = null;
        DoublyListNode newNode = new DoublyListNode(element);
        // Insert at head
        if (position == 1) {
        	newNode.next = head;
        	head.prev = newNode;
            head = newNode;
        } else if (position == size + 1) { // If out of bounds or at end
        	tail.next = newNode;
        	newNode.prev = tail;
        	tail = newNode;
        } else {
        	// Iterate position - 1 times
        	for (int i=0; i<position-1; i++) {
        		prev = curr;
        		curr = curr.next;
        	}
        	prev.next = newNode;
        	newNode.next = curr;
        	newNode.prev = prev;
        	curr.prev = newNode;
        }
	}

	@Override
	public int[] GetAllElements() {
		if (head == null) {
			return new int[0];
		}
		int[] elements = new int[listSize()];
		DoublyListNode curr = head;
		for (int i=0; i<listSize(); i++) {
			elements[i] = curr.val;
			curr = curr.next;
		}
		return elements;
	}

	@Override
	public int[] GetAllElementsInReverse() {
		if (head == null) {
			return new int[0];
		}
		int[] elements = new int[listSize()];
		DoublyListNode curr = tail;
		for (int i=0; i<listSize(); i++) {
			elements[i] = curr.val;
			curr = curr.prev;
		}
		return elements;
	}

	@Override
	public void DeleteAll(int element) {
		// Base case if list is empty 
        if (head == null)
            return;
        
        DoublyListNode curr = head;
        DoublyListNode next;
        while (curr != null) { 
            if (curr.val == element) { 
                next = curr.next;
                head = deleteNode(head, curr);
                curr = next; 
            } 
            else
            	curr = curr.next;
        }
	}
	
	/* Helper functions */
	
	// List size
	private int listSize() {
		int size = 0;
		DoublyListNode curr = head;
		while (curr != null) {
			++size;
			curr = curr.next;
		}
		return size;
	}
	
	// Deletes a node and return the new head
	private DoublyListNode deleteNode(DoublyListNode head, DoublyListNode deleteNode) { 
        if (head == null || deleteNode == null) 
            return null;
  
        // If head needs to be removed
        if (head == deleteNode) 
            head = deleteNode.next;
  
        // If node is not the last node
        if (deleteNode.next != null) 
        	deleteNode.next.prev = deleteNode.prev; 
  
        // If node is not the head node
        if (deleteNode.prev != null) 
        	deleteNode.prev.next = deleteNode.next; 
        
        // In all cases
        deleteNode = null;
        return head; 
    }
}
