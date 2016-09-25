/* Yields the digital root of any integer.
 * The digital root of an integer n is defined as 
 * the result of summing the digits repeatedly 
 * until only a single digit remains
 */

import acm.program.*;

public class DigitalRoot extends ConsoleProgram {
	
	public void run() {
		
		println("This program generates the digital root of an integer");
		
		int n = readInt("Enter a positive integer: ");
		int sum;
		
		while (true) {
			
			sum=0;
			
			while(true) {
				sum+=n%10;
				if (n<10) break;
				n/=10;				
			}
			
			n=sum;
			
			if (n<10) break;
		}
		
		println("The digital root of the number is "+sum);

	}

}
