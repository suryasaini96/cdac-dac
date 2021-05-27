public class Main {
	
	public static void main(String[] args) {
		int arr[] = new int[] {2,3,4,5,-11,0};
		int n = arr.length;
		System.out.println("Largest: " + largest(arr,n));
	}
	
	static int largest(int arr[], int n) {
		if (n==1)
			return arr[0];
		return Math.max(arr[n-1], largest(arr,n-1));
	}
}