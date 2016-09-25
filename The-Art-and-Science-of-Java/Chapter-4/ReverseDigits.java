/* Given any integer, generates the number that has the same digits in the
reverse order */

import acm.program.*;

public class ReverseDigits extends ConsoleProgram {
	
	public void run() {
		
		println("This program reverses the digits of an integer");
		
		int n = readInt("Enter a positive integer: ");
		int reverse=0;
		
		while (true) {
			reverse+=n%10;
			if (n<=1) break;
			reverse*=10;
			n/=10;
		}
		
		println("The reversed number is: "+reverse);
		
	}

}
