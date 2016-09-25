
import acm.program.*;

public class Digitsum extends ConsoleProgram {
	public void run() {
		long n = readInt("Enter n: ");
		
		print(digitsum(n));
	}
	
	/* Method that sums the digits of a integer number */
	
	long digitsum(long x) {
		long total = 0;
		long digit = 0;
		while (x>=1) {
			digit = x%10;
			total += digit;
			x/=10;
		}
		return total;
	}
}
