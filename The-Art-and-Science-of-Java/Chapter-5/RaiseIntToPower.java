
import acm.program.*;

public class RaiseIntToPower extends ConsoleProgram {
	public void run() {
		println("This program calculates the first k ");
		println("powers of an integer n.");
		int n = readInt("Enter n: ");
		int k = readInt("Enter k: ");
		
		for (int i=1; i<=k; i++) {
			println(raisetopower(n,i));
		}
	}

	int raisetopower(int n, int k) {
		int total=1;
		for (int i=1; i<=k; i++) {
			total *=n;
		} 
		return total;
	}
}