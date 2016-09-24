/* Program that reads in two numbers: an account balance and an annual interest rate
 * expressed as a percentage. It then display the new balance after a year.
 */

import acm.program.*;

public class Interest extends ConsoleProgram {
	
	public void run() {
		
		println("Interest calculation program.");
		double balance0 = readDouble("Enter starting balance: ");
		double interest = readDouble("Enter annual interest rate: ");
		double balance1 = balance0*(1+interest);
		double balance2 = balance1*(1+interest);
		println("Balance after one year: "+ balance1+".");
		println("Balance after two years: "+ balance2+".");
	}

}
