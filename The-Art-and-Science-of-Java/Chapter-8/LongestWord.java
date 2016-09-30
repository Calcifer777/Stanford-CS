
import acm.program.*;
import java.util.*;

public class LongestWord extends ConsoleProgram {

	public void run() {
		
		while (true) {
			
			String sentence = readLine("Enter a sentence: ");
		
			if (sentence.length() == 0) break;
		
			println("The longest word in the above sentence is: "+longestWord(sentence)+".");
		}
		
		System.exit(0);
		
	}
	
	private String longestWord( String sentence ) {
		
		StringTokenizer tokenizer = new StringTokenizer(sentence, DELIMITERS, false);
		
		String longestWord="";
		
		while(tokenizer.hasMoreTokens()) {
			
			String token = tokenizer.nextToken();
			longestWord += (token.length()>longestWord.length())?token:"";

		}		
		
		return longestWord;
	}
	
	
	/* Define the characters that delimit a token*/
	
	private static final String DELIMITERS = "!@#$%^&*()_-+={[}]:;\"'<,>.?/-`|\\ ";

}


