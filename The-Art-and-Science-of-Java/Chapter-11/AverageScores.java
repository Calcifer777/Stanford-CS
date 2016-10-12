import acm.program.*;
import java.util.*;


/* Returns the average of a series of input numbers/scores. */
public class AverageScores extends ConsoleProgram {
	
	public void run() {

		ArrayList<Integer> scores = new ArrayList<Integer>();

		/* Reads the judge scores and stores them in an array */
		for (int i = 1; i<= N_JUDGES ; i++) {
			scores.add( readInt("Enter the score for judge "+i+" : "));
		}

		println(scores.toString());

		/* Computes the average score */ 

		Collections.sort(scores);
		
		println(scores);

		for (int i = 1; i<scores.size()-1;i++) {

			average += scores.get(i);

		}

		println("The average of the judges' scores is : "+
		(average/scores.size()-1)+".");

	}

	/* Constants */

	private static final int N_JUDGES = 7;

	/* Private instance variables */

	private double average;

}
