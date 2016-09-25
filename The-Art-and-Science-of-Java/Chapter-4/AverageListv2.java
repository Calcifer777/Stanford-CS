/* Calculates the average of a list of submitted numbers.
 * 
 * The art and science of Java, chapter 7
 **/

import acm.program.*;

public class AverageListv2 extends ConsoleProgram {
	
	public void run() {
		
		println("Calculates the average of a list of submitted numbers.");
		println("Enter a blank space to stop and calculate the average.");

		while (true) {
			String scorestring = readLine("Enter score: ");
			if (scorestring.equals(" ")) break;
			int score = Integer.parseInt(scorestring); 
			sum+=score;
			count++;		
		}
		double average=sum/count;
		println("The list average is: "+average);
	}
	
	/* Instance variables */
	private int sum;
	private int count;

}
