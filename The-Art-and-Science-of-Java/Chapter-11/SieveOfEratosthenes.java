
/* Generates and displays the list of primes in the first N numbers;
 * it uses the Sieve of Erathostenes method. */

import acm.program.*;


public class SieveOfEratosthenes extends ConsoleProgram {

	public void run() {

		/* Initializes the array of the first N numbers */

		for (int i = 0; i < list.length; i++) {

			list[i] = 2 + i;

		}

		int[] primesList = checkForPrimes(list);

		println("List of primes between 2 and " + N + " :");

		for (int i = 0 ; i < primesList.length; i++) {

			if (primesList[i] != 0) println(primesList[i]);
		}


	}

	/* Method that selects those integers in the list
	 * that are also primes */

	private int[] checkForPrimes(int[] list) {

		int thisPrime = 0;

		for ( int index = 0; index < list.length; index++) { // For each prime, set to 0 all the multiples of that prime;

			if (list[index] != 0) {			
				
				thisPrime = list[index];
			
				for (int i = index+thisPrime ; i < list.length; i += thisPrime) {

					list[i] = 0;

				}
			}
		}

		return list;
	}

	/* Private instance variables */
	int[] list = new int[N];

	/* Constants */
	private static final int N = 1000;

}
