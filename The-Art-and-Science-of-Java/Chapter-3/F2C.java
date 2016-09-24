/* Converts Fahrenheit to Celsius degrees */

import acm.program.*;

@SuppressWarnings("serial")
public class F2C extends ConsoleProgram {
	public void run() {
		println("This program converts Fahrenheit to Celsius  degrees.");
		double f_deg=readDouble("Enter the number of Fahrenheit degrees: ");
		double c_deg = ( 5*(f_deg-32) )/ 9;
		println(f_deg+" F correspond to "+c_deg+" C.");

	}

}
