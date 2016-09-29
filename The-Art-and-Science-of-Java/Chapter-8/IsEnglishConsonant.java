/* Checks whether the character is a consonant*/

import acm.program.*;

public class IsEnglishConsonant extends ConsoleProgram {
	
	public void run() {
		
		String line = readLine("Enter a character: ");
		char ch = line.charAt(0);
		
		println(ch+" is a "+(isEnglishConsonant(ch)?"consonant":"not a consonant"+"."));

	}
	
	
	private boolean isEnglishConsonant(char ch) {
	
		switch (Character.toLowerCase(ch)) {
			
		case 'a': case 'e': case 'i': 
		case 'o': case 'u': return false;

		default: return true;

		}
	

	}
}
