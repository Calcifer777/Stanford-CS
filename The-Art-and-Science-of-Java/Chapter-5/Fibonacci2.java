
/* Prints the first n numbers of the Fibonacci sequence.
 * 
 */

import acm.program.*;

public class Fibonacci2 extends ConsoleProgram {
	
	public void run() {
		
		print("This program calculates the ");
		print("first n numbers of the Fibonacci ");
		println("sequence.");
				
		int x = readInt("Enter n:");
		
		println("The first "+x+" Fibonacci numbers are: ");
		for (int i = 1 ; i<=x ; i++ ) {
		
			println(fibonacci(i));
		
		}
	}

/* Method that calculates the nth Fibonacci number */
	
	private int fibonacci(int x) {
		
		int sum1=0;
		int sum2=1;
		int sum = 0;
		
		if (x==1) {
			
			return sum;
		
		} if (x==2) {
			
			return sum=1;
			
		} else {
		
		
			for (int i=3; i<=x;i++) {
			
				sum = sum1 + sum2;
				sum1 = sum2;
				sum2 = sum;
			
			}
			
			return sum;
		
		}
	}
}