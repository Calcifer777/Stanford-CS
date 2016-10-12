
/* Program that generates a list of primes in
 * the first N numbers.*/

import acm.program.*;


public class SieveOfEratosthenes extends ConsoleProgram {

	public void run() {

		/* Initializing the array */

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

		for ( int index = 0; index < list.length; index++) {

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
