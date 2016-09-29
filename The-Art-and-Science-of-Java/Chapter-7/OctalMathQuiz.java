/* Displays sum exercises of two random integers in base 8.
 * Differs from the first file in that it doesn't require a convertbase method.
 * 
 * The art and science of Java, chapter 7
 **/

import acm.program.*;
import acm.util.RandomGenerator;

public class OctalMathQuiz extends ConsoleProgram {
	
	public void run() {
	
		println("This program displays sum exercises of two random integers in base 8. ");
		print("Enter -1 to stop.");
		println("");
		
		while (true) {
			
			count=0;
			num1 = rgen.nextInt(1,10);
			num2 = rgen.nextInt(1,10);
			sum = num1+num2;
				 
			guess = readLine("What is: "+ Integer.toString(num1,8) + " + " + Integer.toString(num2,8) + " in base 8? ");
			
			if (guess.equals(Integer.toString(sum,8))) {
				println("That's the answer!");
				} if (guess=="-1") {
					break;
				} else {
					while(count<3 && !guess.equals(Integer.toString(sum,8) ) ) {
					count++;
					guess = readLine("Incorrect, try another answer: ");	
					}
					
					if (guess.equals(Integer.toString(sum,8))) {
						println("Correct!");
					}
					
					if (count==3 && !guess.equals(Integer.toString(sum,8) ) ) {
						println("The correct answer is " + Integer.toString(sum,8) );
					}
				}
			}
	}

	/* Creating an instance of the RandomGenerator object */
	private RandomGenerator rgen = new RandomGenerator();
	
	/* Instance variables */
	private int num1, num2, sum, count;
	private String guess;
}
