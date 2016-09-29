/* Check whether a sentence is a palindrome */

import acm.program.*;
import java.util.*;

public class SentencePalindrome extends ConsoleProgram {
	
	public void run() {
		
		println("Checks whether a sentence is a palindrome.");
		println("Enter a blank line to exit.");
				
		while(true) {
				
			sentence=readLine("Enter a sentence: ");
			
			if (sentence.equals("")) break;
			
			// println("First character: "+sentence.charAt(0)+";");
			// println("Sentence length: "+sentence.length()+";");
			
			println("This sentece is"+(isPalindrome(sentence)?"":" not")+" a palindrome;");
					
		}
				
		System.exit(0);
	}
	
	/* Checks palindrome  */ 
	
	private boolean isPalindrome(String sentence) {
		
		/* Checks if the sentence is empty*/
		
		if (sentence=="" || sentence.length()<2) return true;
		
		/* Cleans the sentence of its delimiters */
		
		StringTokenizer tokenizer = new StringTokenizer(sentence, DELIMITERS, false);
		
		cleanSentence="";
		
		while (tokenizer.hasMoreTokens()) {
			
			token = tokenizer.nextToken();
			cleanSentence += token.toLowerCase(); 
			
		}
		
		/* Checks for the palindrome property*/
		
		for (int i = 0; i < cleanSentence.length()/2 ; i++) {
			
			if ( cleanSentence.charAt(i) != cleanSentence.charAt(cleanSentence.length() - i-1) ) {
			
				return false;
		
			}
		
		}
		
		return true;
		
	}
	
	
	/* Instance variables */
	private String sentence, token, cleanSentence; 
	
	/* Constants */
	
	private static final String DELIMITERS = "!@#$%^&*()_-+={[}]:;\"'<,>.?/-`|\\ ";

}
