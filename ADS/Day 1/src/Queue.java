
public class Queue implements QueueInf{
	int arr[] = new int[100];
	int head = 0;
	int tail = 0;

	@Override
	public void AddQ(int elem) {
		if (tail==100)
			System.out.println("Queue is full");
		else
			arr[tail++] = elem;	
	}

	@Override
	public int DeleteQ() {
		if (IsEmpty()) {	
			System.out.println("Queue is empty");
			return 0;
		}
		int elem = arr[0];
		// Shift the elements to the left
		for (int i=0; i<tail-1; i++)
			arr[i] = arr[i+1];
		tail--;
		return elem;
	}

	@Override
	public boolean IsEmpty() {
		if (head==tail)
			return true;
		return false;
	}

	@Override
	public boolean IsFull() {
		if(tail == 100)
			return true;
		return false;
	}
}
