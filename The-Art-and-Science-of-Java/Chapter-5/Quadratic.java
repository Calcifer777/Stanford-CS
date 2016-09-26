
/* Calculates the solutions of a quadratic equation.
 * 
 */
import acm.program.*;

public class Quadratic extends ConsoleProgram {
	public void run() {
		
		println("Enter coefficients for the quadratic equation:");
		int a = readInt("a:");
		int b = readInt("b:");
		int c = readInt("c:");
		
		double sol1 = ( - b + Math.sqrt(b*b-4*a*c) ) / (2*a);
		double sol2 = ( - b - Math.sqrt(b*b-4*a*c) ) / (2*a);
		
		println("The first soution is: "+sol1);
		println("The second solution is: "+sol2);
	}

}
