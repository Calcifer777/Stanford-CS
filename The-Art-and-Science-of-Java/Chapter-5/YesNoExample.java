/* Ask for instructions and returns a sample */

import acm.program.*;

public class YesNoExample extends ConsoleProgram {
	public void run() {
		if (askYesNoQuestions("Would you like some instructions? ")) {
			println("Sorry, instructions are a WIP.");
		} else {
			println("Joke's on you, there are no instructions.");
		}
		
	}

	/* Method askYesNoQuestions; */
	
	private boolean askYesNoQuestions(String str) {
		String answer=readLine(str);
		boolean result =false;
		while (answer.equalsIgnoreCase("yes")!=true  && answer.equalsIgnoreCase("no")!=true) {
			println("Please answer yes or no.");
			answer = readLine(str);
		}
		
		if (answer.equals("yes")) {
			result=true;
		} 
		
		return result ;
	}
}
