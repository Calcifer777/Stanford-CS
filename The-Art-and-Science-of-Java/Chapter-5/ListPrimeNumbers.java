/* Lists all prime numbers less than n.*/

import acm.program.*;

public class ListPrimeNumbers extends ConsoleProgram {
	
	public void run() {
	
		println("This program lists all prime nubmers less than n.");
		int n = readInt("Enter n: ");
		println("Prime numbers less than n:");
		
		for (int i = 1; i <= n; i++) {
			
			if (isPrime(i)) print(i+", ");
		}
		
	}
	
	
	/* Checks whether n is a prime number 
	 * following Sieve_of_Eratosthenes's method */
	
	private Boolean isPrime(int n) {
		
		boolean test = true;
		
		if (n==1 || n==2 ) return test;
		
		/* Checks whether n is even */
		if (n%2==0) return test=false; 
		
		/* Checks for any odd divisor less than the sqrt of n */
		
		for (int i = 3 ; i*i<=n ; i+=2) {
			
			if (n%i==0) {
				return test = false;
			}
			
		}
		
		return test;
		
	}
}
