
/* Toy program that simulates coin flips and reports 
* the outcome until heads comes up three times in a row. 
* The Art and Science of Java - Chapter 6 */

import acm.program.*;
import acm.util.*;

public class CoinFlip extends ConsoleProgram {
	
	public void run() {
		
		/*Initializing the program by extracting the first 3 results */
		
		n=rgen.nextBoolean(0.5);
		n1=rgen.nextBoolean(0.5);
		n2=rgen.nextBoolean(0.5);
		
		println(getCoinResult(n1));
		println(getCoinResult(n));
		println(getCoinResult(n2));
		
		int flips =3;
		
		while (!n || !n1 || !n2){
			n2=n1;
			n1=n;
			n=rgen.nextBoolean(0.5);
			println(getCoinResult(n));
			flips++;

		}
		
		println("The last three flips were three heads, congrats. XD");
		println("Btw, it took you "+ flips +" coinflips"+(flips==3 ? ", LUL" : "")+".");
		
		
		
	}

	/* Method converting a boolean value in the coinflip UI equivalent; true is heads*/
	
	private String getCoinResult(Boolean str) {
		if (str) {
			return ("Heads");
		} else {
			return ("Tails");
		}
	}
	
	/* Creating an instance of the random generator class.*/
	
	private RandomGenerator rgen = new RandomGenerator();
	
	/* Instance variables*/
	Boolean n;
	Boolean n1;
	Boolean n2;
	
}
