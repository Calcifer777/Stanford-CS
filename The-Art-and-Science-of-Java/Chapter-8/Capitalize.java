/* Returns the capitalized version (Aaaaa) of a given word*/

import acm.program.*;

public class Capitalize extends ConsoleProgram {
	
	public void run() {
		
		println("Returns the capitalized version (Aaaaa) of a given word.");
		flag=readLine("Enter any key to exit.");
	
		while (flag.equals("")) {
			
			word = readLine("Enter a word: ");
			
			println(capitalize(word));
			
		}

	}
	
	private String capitalize(String word) {

		return word.substring(0, 1).toUpperCase()+word.substring(1).toLowerCase();
		
	}
	
	/* Instance variables */
	
	private String flag, word;
}
