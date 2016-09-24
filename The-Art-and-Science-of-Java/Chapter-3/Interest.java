/* Program that reads in two numbers: an account balance and an annual interest rate
 * expressed as a percentage. It then display the new balance after a year.
 */

import acm.program.*;

public class Interest extends ConsoleProgram {
	
	public void run() {
		
		println("Interest calculation program.");
		double balance0 = readDouble("Enter starting balance: ");
		double interest = readDouble("Enter annual interest rate: ");
		println("Balance after one year: "+(balance0*(1+interest)));
	}

}
