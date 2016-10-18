
import acm.program.*;

/* Play guess the number with the pc; relies on the binary sort method*/

public class GuessTheNumber extends ConsoleProgram {
	
	public void run() {
		
		println("Think of a number between 1 and 100.");
		
		while (true) {	
			
			// At each iteration check whether the hidden number is below or above half the remaining
			// interval 
			
			int m = (rh+lh)/2;
			
			guess = readLine("Is it "+m+"? ");
			if ( guess.equalsIgnoreCase("yes") ) {
				
				println("I guessed the number !!!");
				break;
			}
			
			if ( readLine("Is it greater than "+m+"? ").equalsIgnoreCase("yes")) {
				 
				 lh=(int) m;
				 
			} else {
				 
				 rh = (int) m ; 
			}
			
		}
		
	}
	
	private int lh = 1; 
	private int rh = 100;
	private String guess;

}
