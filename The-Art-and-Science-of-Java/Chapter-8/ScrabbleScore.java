
/* Calculates the score of the capital letters in a given word,
 * according to the typical scrabble score*/

import acm.program.*;

public class ScrabbleScore extends ConsoleProgram{
	
	public void run() {
		
		println("Calculates the score of the capital letters in a given word,"+
		 " according to the typical scrabble score.");
		println("Enter a blank line to exit.");
		
		while(true) {
			
			word=readLine("Enter a word: ");
			if (word.equals("")) break;
			println("The score of the word is: "+scrabbleScore(word)+";");
			
		}
		
		System.exit(0);
	}
	
	/* Computes the score of the word */
	
	private int scrabbleScore(String word) {
		
		int score=0;
		
		for (int i = 0; i < word.length() ; i++ ) {
			
			switch (word.charAt(i)) {
			case 'A': case 'E': case 'I': case 'L': case 'N': case 'O': case'R': case 'S': case 'T': case 'U': score +=1; 
			break;
			case 'D': case 'G': score += 2; 
			break;
			case 'B': case 'C': case 'M': case 'P': score += 3; 
			break;
			case 'F': case 'H': case 'V': case 'W': case 'Y': score += 4; 
			break;
			case 'K': score += 5; 
			break;
			case 'J': case 'X': score += 8; 
			break;
			case 'Q': case 'Z': score += 10; 
			break;
			default: score += 0;
	
			}		
		}
		
		return score;
	}
	
	/* Instance variables */
	
	private String word;
	
	

}
