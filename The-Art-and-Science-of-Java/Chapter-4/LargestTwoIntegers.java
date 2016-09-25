/* Displays the two largest integers in a list of input numbers */

import acm.program.*;

public class LargestTwoIntegers extends ConsoleProgram {
	
	public void run() {
		
		println("This program finds the two largest integers "+
			"in a list. Enter values, one per line. Use 0 "+
				"to signal the end of the list.");
		
		int n=0;
		int firstlargest =0;
		int secondlargest=0;

		while (true) {
			
			n = readInt("?");
			if (n==FLAG) break;
			
			if (n>firstlargest) {
				secondlargest = firstlargest;
				firstlargest=n;
			}

		}
		
		println("The largest value is: "+firstlargest);
		println("The second largest value is: "+secondlargest);
	}

	private static final int FLAG = 0;
}