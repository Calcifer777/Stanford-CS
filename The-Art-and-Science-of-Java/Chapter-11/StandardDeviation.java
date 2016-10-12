import acm.program.*;
import acm.util.*;

/* Computes the sample standard deviation of a series of randomly generated numbers */
public class StandardDeviation extends ConsoleProgram {

	public void run() {

		println("Creating an array of "+list.length+" numbers with the "+
		       "RandomGenerator method.");
		println("");
		
		for (int i = 0; i <= list.length-1; i++) {

			list[i] = rgen.nextDouble(1, 1000);

		}

		println("The st. deviation of the list is: " + standardDeviation(list) + ".");

	}

	private double standardDeviation(double[] array) {

		double mean = meanArray(array);

		/* Sum of the square differences */

		double sum = 0;

		for (int i = 0 ; i <= array.length-1; i++) {

			sum += (mean - array[i]) * (mean - array[i]);
		}

		double stDev = Math.sqrt(sum / (array.length - 1));

		return stDev;

	}

	private double meanArray(double[] array) {

		double average = 0;
		for (int i = 0 ; i <= array.length-1; i++) {

			average += array[i];

		}

		return average;
	}

	/* Random Generator */
	RandomGenerator rgen = new RandomGenerator();

	/* Private instance variables */
	double[] list = new double[LENGTH];

	/* Constants */
	private static final int LENGTH = 200;
}
