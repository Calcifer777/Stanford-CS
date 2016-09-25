/* Displays the largest integer in a list of input numbers */

import acm.program.*;

public class LargestInteger extends ConsoleProgram {
	
	public void run() {
		
		println("This program finds the largest integer "+
			"in a list. Enter values, one per line. Use 0 "+
				"to signal the end of the list.");
		
		int n=0;
		int largest =0;

		while (true) {
			
			n = readInt("?");
			if (n==FLAG) break;
			largest = (n>largest) ? n : largest;

		}
		
		println("The largest value is: "+largest);
	}

	private static final int FLAG = 0;
}
