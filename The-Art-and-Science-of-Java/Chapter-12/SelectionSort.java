import java.util.ArrayList;

public class SelectionSort {

	public void run() {
		
	}
	
	/**
	* Sorts an integer array into increasing order. The implementation uses
	* an algorithm called selection sort, which can be described informally
	* in English as follows:
	*
	* With your left hand, point at each element in the array in turn, starting
	* at index 0. At each step in the cycle:
	*
	* 1. Find the smallest element in the range between your left hand and the
	* end of the array, and point at that element with your right hand.
	*
	* 2. Move that element into its correct index position by switching the
	* elements indicated by your left and right hands.
	*/
	
	private void selectionSort(ArrayList<Integer> array) {
	
		for (int lh = 0; lh < array.size(); lh++) {
	
			int rh = findSmallest (array, lh, array.size());
	
			swapElements(array, lh, rh);
	
		}
	}
	
	/** Returns the index of the smallest array element between p1 and p2 - 1 */
	private int findSmallest(ArrayList<Integer> array, int p1, int p2) {
	
		int smallestlndex = p1;
	
		for (int i = p1 + 1; i < p2 ; i++) {
	
			if (array.get(i) < array.get(smallestlndex)) smallestlndex = i;
	
		}
	
		return smallestlndex;
	}
	
	/* Exchanges the elements in an array at index positions pi and p2. */
	private void swapElements(ArrayList<Integer> array, int p1, int p2) {
		
		int temp = array.get(p1);
		
		array.set(p1, array.get(p2));
		
		array.set(p2, temp );
	
	}
}
