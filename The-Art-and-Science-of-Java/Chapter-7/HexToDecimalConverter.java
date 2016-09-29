/* Converts number from hexadecimal to decimal form.
 * 
 *  The art and science of Java, chapter 7.
 *  */

import acm.program.*;

public class HexToDecimalConverter extends ConsoleProgram{
	
	public void run() {
		
		println("This program convers hexadecimal to decimal.");
		println("Enter 0 to stop.");
		
		while (true) {
			String hex = readLine("Enter a hexadecimal number: ");
			if (hex.equals("0")) break;
			println(hex+" hex = "+Integer.parseInt(hex,16)+" decimal.");
		}
	}
}
