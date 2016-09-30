
/* Adds two integers. Relies on the readLine() method to input 
 * the two numbers. */
import acm.program.*;

public class Add2IntegersV2 extends ConsoleProgram {

	public void run() {
		
		println("This program adds 2 integers.");
		println("Enter a blank line to exit.");
				
		while (true) {
			
			long n1 = myReadInt("Enter n1: ");
			long n2 = myReadInt("Enter n2: "); 
			
			long total = n1 + n2;
			println("The total is "+ total+ ".");
			
			String flag = readLine( "Again? " );
			if ( flag==""|| flag.toLowerCase().startsWith("n") ) break;
		}
		
		System.exit(0);
	}
	
	
	
	/* Reads a string and converts it into a long primitive when all values are digits.
	 * Accommodates for negative numbers*/
	
	private long myReadInt(String string) {
		
		int DigitsCount=0;		// Counts the characters that are digits
		boolean positive=true; 	// Records the sign of the number
		String number=" ";		// The number to be converted into long

		while (DigitsCount < number.length()) {
			
			/* Reads the number */
			
			number=readLine(string);
			
			/* Checks the sign of the number.
			 * If negative, records the sign in the boolean variable 
			 * [positive], then works with the substring without the hyphen.
			 */
			
			if (number.startsWith("-")) {
				
				number = number.substring(1);
				positive=false;
		
			} else {
				
				positive=true;
				
			}
			
			/* Checks that each character in the string is a digit. 
			 * If not, asks to input a new number and ends the check.*/
			
			for (int i = 0; i <= number.length()-1; i++ ) {		
				
				if ( !Character.isDigit(number.charAt(i)) ) {		
				
					println("Illegal integer format");
					number=readLine(string);
					i=number.length();

			
				} else {
					
					DigitsCount++;
					
				}
		
			}
			
			/* The loop ends when all characters are digits */
		}
		
		
		/* Converts the string to an integer */
		
		int n=0; 		// The value that the method returns
		int ch;
		int count=1;	// Counts the digits in the number
		
			/* Starting from the unit digits, reads each character, 
			 * multiplies it by the corresponding power of 10
			 * and adds it to [n]. */
		
		for (int i = number.length()-1; i >= 0 ; i-- ) {
			
			ch = Character.getNumericValue(number.charAt(i));
			n+= ch*count;
							
			count*=10;
		
		}
		
		/* Returns the value*/
		
		return (long) n*((positive)?1:-1);
		
	}

}
