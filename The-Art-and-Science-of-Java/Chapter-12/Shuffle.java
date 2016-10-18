import acm.program.*;
import acm.util.*;

/** Shuffles an array of 52 elements, simulating the shuffling of a french cards deck*/
public class Shuffle extends ConsoleProgram {
	
	public void run() {
		
		/* Initializing the array */
		for (int i = 0 ; i < cardsArray.length ; i++) {
			
			cardsArray[i] = i+1;
			
		}
		
		shuffle(cardsArray);
		
		/* Displaying the array */
		for ( int i = 0 ; i < cardsArray.length ; i++ ) {
			println(cardsArray[i]);
		}
		
	}
	
	/** Shuffles the elements of an array of integers */
	private void shuffle(int[] array) {
		
		int randIndex;
		
		for (int i = 0 ; i < array.length; i++ ) {			// For each element
			
			randIndex = rgen.nextInt(0, array.length-1);	// Pick a random one in the array
			
			int temp = array[i];							// And swap the two of them
			
			array[i] = array[randIndex];
			array[randIndex] = temp;
			
		}
		
	}
	
	
	RandomGenerator rgen = new RandomGenerator();
	
	int[] cardsArray = new int[52];

}
