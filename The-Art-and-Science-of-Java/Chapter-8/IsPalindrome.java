/* Check whether a word is a palindrome */

import acm.program.*;

public class IsPalindrome extends ConsoleProgram {
	
	public void run() {
		
		println("Checks whether a word is a palindrome.");
		println("Enter a blank line to exit.");
				
		while(true) {
				
			word=readLine("Enter a word: ");
			
			if (word.equals("")) break;
			
			// println("First character: "+word.charAt(0)+";");
			// println("Word length: "+word.length()+";");
			println("The word is"+(isPalindrome(word)?"":" not")+" a palyndrome;");
					
		}
				
		System.exit(0);
	}
	
	/* Checks palindromes */ 
	
	private boolean isPalindrome(String word) {
		
		if (word=="") return true;
		
		for (int i = 0; i < word.length()/2 ; i++) {
			
			if ( word.charAt(i) != word.charAt(word.length() - i-1) ) {
			
				return false;
		
			}
		
		}
		
		return true;
		
	}
	
	
	/* Instance variables */
	private String word; 

}
