
import acm.program.*;

public class Sumoddints extends ConsoleProgram {
	public void run() {
		int n = readInt("Enter n: ");
		int total=0;
		for (int i=1;i<=2*n-1;i+=2) {
			total +=i;
		}
		if (n==1) {
			println("The first odd number is "+n+".");
		} else {
			println("The sum of the first "+n+" odd numbers is "+total+".");
		}
	}

}
