/* Returns the ordinal form of a number.*/ 

import acm.program.*;

public class CreateOrdinalForm extends ConsoleProgram {
	
	public void run() {
		
		println("Returns the ordinal form of a number. Enter a void line to exit.");

		while (true) {
		
			n = readLine("Enter a word: ");
			
			if (n.equals("")) break;
			println("The ordinal form of "+n+" is "+createOrdinalForm(n)+";");
		}
		
		System.exit(0);
		
	}
	
	/* Method to create the ordinal form of a number */
	
	private String createOrdinalForm( String n) {
		
		int l = n.length()-1;
		
		if ( (l+1==1) || ( (l+1>1) && n.charAt(l-1)!='1') ) {
		
			switch (n.charAt(l)) {
			
			case '1': return n+"st";
			
			case '2': return n+"nd";
			
			case '3': return n+"rd";
			
			default: return n+"th";
			
			} 
		
		} else {
			
			return n+"th";
		}
		
	}

	/* Instance variables */
	
	private String n;
}
