/* This toy program converts inches and feet to centimeters */

import acm.program.*;

@SuppressWarnings("serial")

public class Inches2centimeters extends ConsoleProgram {
	public void run() {
		println("This program converts feets (integer) and inches to centimeters.");
		int feet=readInt("Enter the number of feet: ");
		double inches=readDouble("Enter the number of inches: ");
		double total_cm = (12*feet+inches)*INCHES_TO_CM;
		println(feet+" feet and "+inches+" inches correspond to "+total_cm+" cm.");

	}
	
	public static final double INCHES_TO_CM = 2.54;

}
