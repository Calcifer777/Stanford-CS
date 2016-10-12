
import acm.program.*;

/* Converts text to morse code */

public class MorseCode extends ConsoleProgram {

	public void run() {

		String text = readLine("Enter the text to convert " +
		                       "in morse code: ");

		println(textToMorse(text));
		
	}

	/* Converts text to morse */

	private String textToMorse(String str) {

		int length = str.length();
		String morse = "";

		for (int i = 0 ; i < length - 1; i++) { 			// Reads each character in the input text

			String ch = str.substring(i, i + 1).toUpperCase();
			index = -1;

			for (int j = 0; j < MORSE_CODE.length; j++ ) {		// Searches the character in the morse array

				if (ch.equals(MORSE_CODE[j][0])) {
					
					index = j;	// Returns the corresponding code
				} else if (ch.equals(" ")) { 
					index = -1; 
				} else {
					index = -2;
				}

			}

			if (index == -1) {					// Adds the morse code to the output string
				morse += " ";					// if a space is found returns a double space
			} else if (index!=-2) {
				morse += MORSE_CODE[index][1];
			}

		}

		return morse;

	}

	/* Morse Code array */

	String[][] MORSE_CODE = {
		{"A", ".-"},
		{"B", "-..."},
		{"C", "-.-."},
		{"D", "-.."},
		{"E", "."},
		{"F", "..-."},
		{"G", "--."},
		{"H", "...."},
		{"I", ".."},
		{"J", ".---"},
		{"K", "-.-"},
		{"L", ".-.."},
		{"M", "--"},
		{"N", "-."},
		{"O", "---"},
		{"P", ".--."},
		{"Q", "--.-"},
		{"R", ".-."},
		{"S", "..."},
		{"T", "-"},
		{"U", "..-"},
		{"V", "...-"},
		{"W", ".--"},
		{"X", "-..-"},
		{"Y", "-.--"},
		{"Z", "--.."}
	};
}
