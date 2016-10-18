
import acm.program.*;

/** Sorts an array of integers using the insertion sort method: 
 * go through each element in the array in turn, as with the selection sort algorithm. 
 * At each step in the process, however, your goal is not to find the smallest value 
 * remaining value and switch it into its correct position, but rather to ensure that the 
 * values you’ve covered so far in the array are correctly ordered with respect to one
 * another. Although those values may shift as more elements are processed, they form 
 * an ordered sequence in and of themselves*/

public class InsertionSort extends ConsoleProgram {
	
	public void run() {
		
		printArray(numList);
		
		insertionSort(numList);
		
		printArray(numList);
		
		
	}

	/** The insertion sort method */ 
	private void insertionSort(int[] array) {
		
		for (int i = 1 ; i < array.length ; i++) {			// For each element in the array
			
			int thisIndex = i; 
			
			// As long as it is greater than the one on its left, swap it with that element
			// Keep going until either you reach the left/upper end of the array, 
			// or a smaller element is on the left of the one selected.
			
			while (thisIndex>0 && array[thisIndex]<array[thisIndex-1]) {		
				
				swapElements(array, thisIndex, thisIndex-1);
				thisIndex--;
				
			}
		
		}
		
	}
	
	/** Exchanges two elements in an array */
	private void swapElements(int[] array, int p1, int p2) {
		int temp = array[p1];
		array[p1] = array[p2];
		array[p2] = temp;
	}
	
	/** Prints an array of integers */
	private void printArray(int[] array) {
		
		for (int i = 0; i < array.length; i++ ) {
			
			print(array[i]+ ((i!=array.length-1)?", ":";"));
		}
		
		println("");
		
	}
	
	private int[] numList = {100, 11 , 276, 2553, 759, 7, 124, 41, 523, 3521 };

}
