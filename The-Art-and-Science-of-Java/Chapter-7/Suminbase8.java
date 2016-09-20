/* Displays sum exercises of two random integers in base 8
 * 
 * The art and science of Java, chapter 7
 **/

import acm.program.*;
import acm.util.RandomGenerator;

public class Suminbase8 extends ConsoleProgram {
	
	public void run() {
	
		println("This program displays sum exercises of two random integers in base 8. ");
		print("Enter -1 to stop.");
		println("");
		
		while (true) {
			
			count=0;
			num1 = rgen.nextInt(1,10);
			num2 = rgen.nextInt(1,10);
			sum = num1+num2;
			
			num1base8 = convertbase(num1,10,8);
			num2base8 = convertbase(num2,10,8);
			sumbase8 = convertbase(sum,10,8);
			 
			guess = readInt("What is: "+ num1base8 + " + " + num2base8 + " in base 8? ");
			
			if (guess==sumbase8) {
				println("That's the answer!");
				} if (guess==-1) {
					break;
				} else {
					while(count<3 && guess!=sumbase8) {
					count++;
					guess = readInt("Incorrect, try another answer: ");	
					}
					
					if (guess==sumbase8) {
						println("Correct!");
					}
					if (count==3 && guess!=sumbase8) {
						println("The correct answer is"+sumbase8);
					}
				}
			}
	}
	
	/** Method to convert a number x from base n to base m.
	 * @param x The number of which you want to change base.
	 * @param n The original base of the number.
	 * @param m The new base of the number
	 * */
	
	private int convertbase(int x, int n, int m) {
		String stringx = Integer.toString(x,m);
		int result = Integer.parseInt(stringx,n);
		return result;
	}
	

	/* Creating an instance of the RandomGenerator object */
	private RandomGenerator rgen = new RandomGenerator();
	
	/* Instance variables */
	private int num1, num2, sum, num1base8, num2base8, sumbase8, guess, count;
}
