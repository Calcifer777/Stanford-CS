/* Calculates the average of a list of submitted numbers.
 * 
 * The art and science of Java, chapter 4.
 **/

import acm.program.*;

public class AverageList extends ConsoleProgram{
	
	public void run() {
			
		println("Calculates the average of a list of submitted numbers.");
		println("Enter -1 to stop.");
		int sum=0;
		int count=0;
		while (true) {
			int score = readInt("Enter score: ");
			if (score==-1) break;
			sum+=score;
			count++;
		}
		double average = sum/count;
		println("The list average is: "+average);
	}
}
