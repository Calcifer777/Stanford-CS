/* Prints a random word of lowercase characters*/

import acm.program.*;
import acm.util.*;

public class RandomWord extends ConsoleProgram {
	
	public void run() {
		
		println("This program displays random \" words \". "+
		"Enter any key to stop the program:");
		
		while (true) {
		
			if(!readLine("").equals("")) break;
			
			println("Random word: "+randomWord(MIN_LETTERS, MAX_LETTERS));
			
		}
		
	}
	
	/* Method */
	
	private String randomWord(int n, int N) {
		
		letterNumber=rgen.nextInt(n,N);
		
		word ="";
		
		for ( int i = 1 ; i <= letterNumber ; i++) {
			
			word+=(char) rgen.nextInt((int) 'a',(int) 'z');
		}
		
		return word;
	}
	
	
	/* Random generator*/
	
	RandomGenerator rgen = new RandomGenerator();
	
	/* Constants*/

	private static final int MIN_LETTERS=4;
	private static final int MAX_LETTERS=10;
	private int letterNumber;
	private String word;
	
	
}
