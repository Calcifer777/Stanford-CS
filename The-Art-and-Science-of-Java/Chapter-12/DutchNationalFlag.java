
import java.util.ArrayList;

import acm.program.*;
import acm.util.RandomGenerator;

/* Solves the dutch national flag problem for 3 colors */
public class DutchNationalFlag extends ConsoleProgram {
	
	public void run() {
		
		/* Initializing the flag to a random initial state */
		newFlag(flag, COLORS);
		
		println("The initial array: ");
		printArray(flag);
		println("");
		
		/* Sorting the flag */
		flagSort(flag);	
		
	}

	/** Initializes the Dutch flag to a new random initial state 
	 * @param flag The integer array to initialize;
	 * @param classes The number of classes of elements (the standard is 3);*/
	private void newFlag(int[] flag, int classes) {
		
		/* Counts how many elements of each colors have been already used */
		int[] count = new int[classes]; 			

		int newElement;
		
		/* Initializing the flag with a random elements order*/
		for (int i = 0; i < flag.length ; i++ ) {								// For each index
			

			while (true ) {
								
				newElement = rgen.nextInt(1,classes);							// Pick a new element					
				
				/* Keep it as long as the number of elements of the same class if lower than 
				 	the length of the flag divided by the number of classes. This ensures the same
				 	number of elements per class */
				
				if ( count[newElement-1] < flag.length/classes ) {				
					
					count[newElement-1]+=1;
					break;
					
				} 
			
			}
			
			flag[i] = newElement;
				
		}
	}
	
	/** Sorting the flag */
	private void flagSort(int[] flag) {
		
		int lb = 0;							// Lower bound index when sorting
		int ub = flag.length-1;				// Upper bound index when sorting
		
		while (flag[lb]==1) lb++;			// Increase the lower bound as long as the lb element is a 1
		while (flag[ub]==3) ub--;			// Decrease the upper bound as long as the ub  element is a 3
		
		int i = lb;							// Start from the lower bound index element
		
		while (i <= ub) {
						
			if (flag[i]==1) {				// If it is 1, increase the lb index
				
				if (i==lb) {				// Also, if i == lb, increase the selection index
					
					i++;
					lb++;
					
				} else {					// or, if i != lb, switch this element with that in lb
					
					println("After changing element "+lb+" with "+i+": ");
					
					int temp = flag[i];
					flag[i] = flag[lb];
					flag[lb] = temp;
					lb++;
					
					printArray(flag);

				}
			
			} else if (flag[i]==3 && i!=ub) {// If i == 3, decrease the ub index				
				
				while (flag[ub]==3) ub--;	// As long as ub == 3, decrease the ub index 

				println("After changing "+i+" with "+ub+": ");	// Swap the ith element with that in ub
				
				int temp = flag[i];
				flag[i] = flag[ub];
				flag[ub] = temp;
				ub--;
				
				printArray(flag);
								
			} else {
				
				i++;
			
			}
			
			
		}
		
	}
	
	/** Prints an array of integers */
	private void printArray(int[] array) {
		
		for (int i = 0; i < array.length; i++ ) {
			
			print(array[i]+ ((i!=array.length-1)?", ":";"));
		}
		
		println("");
		
	}
	
	RandomGenerator rgen = new RandomGenerator();
	
	int[] flag = new int[15];
	
	private static final int COLORS = 3;
	
	
}


