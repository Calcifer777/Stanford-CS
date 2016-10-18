
import java.util.ArrayList;

import acm.program.*;
import acm.util.*;

/** Finds the median and the mode in an array  */

public class FindMedian extends ConsoleProgram {
	
	public void run() {
		
		/* Initializing an array of doubles*/
		for (int i = 0 ; i < numList.length ; i++) {
			
			int num = rgen.nextInt(1,10000);
			numList[i] = (double) num/100;
			
		}
		
		/* Initializing an array of integers*/
		for (int i = 0 ; i < numListInt.length ; i++) {
			numListInt[i] = rgen.nextInt(1,10);
		}
		
		for (int i = 0 ; i < numList.length ; i++) {
			println(numList[i]);
		}
		
		println("The median of the above list is: "+ median(numList)+";");
		
		for (int i = 0 ; i < numListInt.length ; i++) {
			println(numListInt[i]);
		}
		
		println("The mode of the above list is: "+ mode(numListInt)+";");
		
		
	}
	
	// Finds the mean of an array of doubles
	private double median( double[] array ) {
		
		int size = array.length; 
		
		if (size==1) return array[0];
		int end = size/2+1;
		
		/* Sorts the array*/
		for (int i = 0 ; i <= end ; i++) {
			
			int smallestIndex = findSmallest(array, i, size-1); 
			
			swapElements(array, i, smallestIndex);
			
		}
		
		/* Returns the median value */
		return (size%2==0)?(array[size/2-1]+array[size/2])/2:array[size/2];
		
	}
	
	/** Finds and returns the index of the smallest number in an array of doubles
	 * @param array The array in which to search.
	 * @param lb The first index from which to search.
	 * @param ub The last index to which to search. */
	private int findSmallest(double[] array , int lb, int ub) {
		
		int smallestIndex = lb;
		
		for (int i = lb+1 ; i <= ub ; i++) {
			
			if (array[i]<array[smallestIndex]) smallestIndex = i;
			
		}
		
		return smallestIndex;
		
		
	}
	
	/** Swaps two elements in a given array of doubles */
	private void swapElements(double[] array , int index1, int index2) {
		
		double temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		
	}
	
	/** Finds the mode of an array of doubles */
	private double mode(int[] array ){
		
		
		/* Creating an ArrayList of the unique values in the input array */
		
		ArrayList<Integer> uniqueValues = new ArrayList<Integer>();
		
		/* Counts how many times each unique value appears in the input array*/
		int[] count = new int[array.length];
		
		for (int i = 0 ; i < array.length ; i++ ) {
			
			if (uniqueValues.indexOf(array[i]) == -1 ) {
				
				uniqueValues.add(array[i]);
				
			} else {
				
				count[uniqueValues.indexOf(array[i])]+=1;
				
			}
			
		}
		
		/* Returns the values that appears most often in the array */ 
		
		int mostFrequentValue = count[0];
		
		for (int i = 1 ; i < array.length ; i++) {
			
			if ( count[i] > count[mostFrequentValue] ) mostFrequentValue = i;
			
		}
		
		return uniqueValues.get(mostFrequentValue);
	}
	
	RandomGenerator rgen = new RandomGenerator();
	
	double[] numList = new double[10];
	int[] numListInt = new int[10];


}
