
import acm.program.*;

/** From wiki: radix sort is a non-comparative integer sorting algorithm that 
 * sorts data with integer keys by grouping keys by the individual digits 
 * which share the same significant position (unit/tenths/hundreds digits) and value.*/

public class RadixSort extends ConsoleProgram {
	
	public void run() {
		
		println("The array:");
		printArray(numList);
		println("");
		println("Max digits : "+ digits(numList));
		radixSort(numList);
		
	}	

	/** The radix sort method */
	private void radixSort( int[] array ) {
		
		/* Determining the max length in digits among the array elements */
		
		int digits = digits(array);
		
		/* Sorting the array for each digit */
				
		for (int d = 0 ; d < digits ; d++) {
			
			digitSort(array, d);	
			
		}
		
	}
	
	/** Returns the max length in digits among the array elements */
	private int digits(int[] array ) {
		
		double maxElement = array[0];
		
		for (int i = 1 ; i < array.length ; i++ ) {
			
			if (array[i] > maxElement ) maxElement = array[i];
			
		}
	
		int digitCount=0;
		
		while (maxElement>1) {
			
			digitCount++;
			
			maxElement/=10;
		}
		
		return digitCount;	
	}
	
	
	/** Sorts an array of integers with respect to the nth digit */
	private void digitSort(int[] array, int n) {
		
		/* Creates an array that stores the relevant digit value for each array element */ 
		int[] buckets = createBuckets(array, n);
		
		println("Arranging for digit "+n+":");
		println("Buckets");
		printArray(buckets);
		
		int[] sortedArray = new int[array.length];
		int thisCell = 0; 
		
		for (int d = 0 ; d <= 9 ; d++ ) { 				// For each bucket class 0-9...
				
			// println("adding bucket "+d);
			for (int i = 0 ; i < array.length; i++) {	// If the element has the same digit value
				if (buckets[i] == d) {
					// println(array[i]);
					sortedArray[thisCell] = array[i];	// add it to the sorted array
					thisCell++;
					
				}
			}
		}
		
		println("Sorted array:");
		printArray(sortedArray);
		
		for (int i = 0 ; i < array.length; i++) {		// Replace the array values with the sortedArray's
			array[i] = sortedArray[i];
		}
	}
	
	/** Creates the buckets classes with the relevant digits of each array element */
	private int[] createBuckets(int[] array, int n) {
		
		int[] buckets = new int[array.length];
		
		for (int i = 0 ; i < array.length; i++) {
			
			buckets[i] = (array[i]/(int) Math.pow(10, n))%(10);
			
		}
		
		return buckets;
	}
	
	/** Prints an array of integers */
	private void printArray(int[] array) {
		
		for (int i = 0; i < array.length; i++ ) {
			
			print(array[i]+ ((i!=array.length-1)?", ":";"));
		}
		
		println("");
		
	}
	
	/* Test array*/
	private int[] numList = {100, 11 , 276, 2553, 759, 7, 124, 41, 523, 3521 };
}
