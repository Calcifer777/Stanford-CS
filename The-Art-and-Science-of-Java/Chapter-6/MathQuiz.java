/* Program that poses a series of simple arithmetic
 * problems for a student to answer
 */

import acm.program.*;
import acm.util.*;

public class MathQuiz extends ConsoleProgram {
	
	public void run() {
		
		println("Welcome to the Math Quiz!");
		println("This program displays sum and subtraction exercises of two random integers. ");
		println("");
		
		int questionCount = 1; // Counts the number of question asked.
		questionsAnswered= 0; // Counts the number of question answered.
		String operation;
		
		while (questionCount<=QUESTIONS_NUMBER) {
			
			operation = rgen.nextBoolean(0.5) ? "plus" : "minus";
			
			if (operation =="plus") {
				
				/* Initializing the two numbers*/
				
				n1 = rgen.nextInt(1, 20);
				n2 = rgen.nextInt(1, 20);
				
				/* Controlling for the appropriateness of the 
				 * two numbers. If the sum is greater than 20
				 * re-roll the numbers.
				 */
				
				while (n1+n2>20) {
					
					n1 = rgen.nextInt(1, 20);
					n2 = rgen.nextInt(1, 20);
					
				}
				
				/* Counting the number of tries. After the third wrong submitted
				 * answer, the program will display the correct answer.*/
				
				answerCount = 1;
				
					/* Displaying the exercise */
				
				sum = readInt("What is "+ n1 + "+"+ n2 + " ? ");
				
				while (answerCount<3 && sum!=n1+n2 ) {					
					
					sum = readInt("Incorrect, try again: ");
					answerCount++;
					
				}
				
				/* Outcome of the exercise */
				
				if (sum==n1+n2) {
					
					println("Correct!");
					questionsAnswered++;
					
				} else {
					
					println("Incorrect; "+ n1 + " + " + n2 + " is " + (n1+n2) + ".");
				}
				

			} else {
				
					/* Initializing the two numbers*/
				
				n1 = rgen.nextInt(1, 20);
				n2 = rgen.nextInt(1, 20);
				
				/* Controlling for the appropriateness of the 
				 * two numbers. If the sum is greater than 20
				 * re-roll the numbers.
				 */
				
				while (n1-n2<0) {
					
					n1 = rgen.nextInt(1, 20);
					n2 = rgen.nextInt(1, 20);
					
				}
				
				/* Counting the number of tries. After the third wrong submitted
				 * answer, the program will display the correct answer.*/
				
				answerCount = 1;

				/* Displaying the exercise */
				
				difference = readInt("What is "+ n1 + "-"+ n2 + " ? ");
				
				while (answerCount<3 && difference!=n1-n2) {
								
					difference = readInt("Incorrect, try again: ");
					answerCount++;
					
				}
				
				/* Outcome of the exercise */
				
				if (difference==n1-n2) {
					
					println("Correct!");
					questionsAnswered++;
					
				} else {
					
					println("Incorrect; "+ n1 +" - " + n2 + " is " + (n1-n2) + ".");
				}
			
			}
			
			questionCount++;
			
		}
		
		println("You have completed the exercise!");
		println("You answered correctly to "+ questionsAnswered + " questions.");
		
		
	}
	
	/* Initializing the RandomGenerator */
	
	RandomGenerator rgen = new RandomGenerator();
	
	/* Instance variables */
	
	private int n1, n2,answerCount, sum, difference, questionsAnswered;
	private static final int QUESTIONS_NUMBER = 5;
	
	
}
