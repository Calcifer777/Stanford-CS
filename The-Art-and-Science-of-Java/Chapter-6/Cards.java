
/* This toy program displays the name of a card randomly chosen from
 * a complete deck of french cards.
 */

import acm.program.*;
import acm.util.*;

public class Cards extends ConsoleProgram {
	
	public void run() {
		println("This program displays a randomly chosen card.");
		
		/* Generating the two random values for the suit and rank */
		
		int rank = rgen.nextInt(1,13);
		int suit = rgen.nextInt(1,4);
		println(getrank(rank)+" of "+getsuit(suit)+".");

	}
	
		/* Method that converts the random suit to String for UI purposes */

	private String getsuit(int n ) {
		switch (n) {
		case 1: 
			return ("Clubs"); 
		case 2:
			return ("Diamonds");
		case 3:
			return ("Hearts");
		case 4:
			return ("Spades");
		default: 
			return ("Illegal suit?!");
	}
}

		/* Method that converts the random suit to String for UI purposes */	

	private String getrank (int rank) {
		switch (rank) {
		case 1: 
			return ("Ace"); 
		case 11:
			return ("Jack");
		case 12:
			return ("Queen");
		case 13:
			return ("King");
		default: 
			return Integer.toString(rank);
		}
	}

	

	/* Create an instance of a random generator */
	
	private RandomGenerator rgen = new RandomGenerator();
}
