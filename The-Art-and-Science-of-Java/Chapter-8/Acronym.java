

import acm.program.*;
import java.util.*;

public class Acronym extends ConsoleProgram {

	public void run() {

		while (true) {
			
			String sentence = readLine("Enter a sentence: ");
		
			if (sentence.length() == 0) break;
		
			println("The acronym of the sentence is: "+acronym(sentence)+".");
		}
		
		System.exit(0);	
	}
	
	
	/* Returns the acronym of a sentence */
	
	private String acronym(String sentence) {
		
		StringTokenizer tokenizer = new StringTokenizer(sentence, DELIMITERS, false);
		
		String acronym="";
		
		while(tokenizer.hasMoreTokens()) {
			
			String token = tokenizer.nextToken();
			acronym+=token.toUpperCase().charAt(0);
			
		}

		return acronym;
	}
	
	
	/* Define the characters that delimit a token*/
	
	private static final String DELIMITERS = "!@#$%^&*()_-+={[}]:;\"'<,>.?/-`|\\ ";
}
