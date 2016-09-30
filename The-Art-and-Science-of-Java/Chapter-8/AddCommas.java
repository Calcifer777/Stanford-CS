

import acm.program.*;

public class AddCommas extends ConsoleProgram {

	public void run() {
		
		while (true) {
		
			String digits = readLine("Enter a number: ");
		
			if (digits.length() == 0) break;
		
			println(addCommas(digits));
		}
		
		System.exit(0);
		
	}
	
	
	/* Add commas to a digit string. */
	
	private String addCommas(String string) {
		
		String number="";
		
		int length = string.length();
		
		for (int i = length-1; i >= 0 ; i-- ) {
			
			if ((length-i)%3==0 && i!=0) {
				
				number = ","+string.charAt(i)+number; 
				
			} else {
				
				number = string.charAt(i)+number;
			}
			
		}
		
		return number;
		
	}
}
