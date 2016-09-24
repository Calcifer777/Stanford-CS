/* Asks the user for the radius of a circle and 
 * then computes the area of that circle using the formula A = r^2*pi
 */

import acm.program.*;

public class CircleArea extends ConsoleProgram {
	
	public void run() {
		
		double radius = readDouble("Enter the radius of the circle: ");
		double area = radius*radius*PI;
		println("The area of the cirlce is : "+area);
	}

	private static final double PI = 3.1415926535;
}
