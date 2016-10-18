
import java.io.*;
import javax.swing.*;
import java.util.*;
import acm.program.*;
import acm.util.*;

/** Translates a text into Greek, i.e. replacing each letter into
 * a random one, keeping case distinctions. */
public class Greek extends ConsoleProgram {

	public void run() {
		
		/* Opening the selected file*/
		BufferedReader rd = openFileReader();
		
		String[] text = readFile(rd);
		
		println("Original text:");
		printText(text);
		println("");
		println("Text into Greek: ");
		String[] greek = toGreek(text);
		
		
		printText(greek);
				
	}
	
	/** Opens a file via JFileChooser */
	private BufferedReader openFileReader() {
		
		BufferedReader rd = null;
		
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);
		
		if (result == JFileChooser.APPROVE_OPTION) {
			
			try {
				
				File file = chooser.getSelectedFile();
				rd = new BufferedReader(new FileReader(file));
				
			} catch (IOException ex) {
				
				throw new ErrorException(ex);
			}
		}
	
		return rd;
	}

	/** Reads the text file and stores it into a string array */
	private String[] readFile(BufferedReader rd) {
		
		ArrayList<String> lines = new ArrayList<String>();
		
		try {
		
			while(true) {
			
				String line = rd.readLine();
			
				if (line==null) break;
			
				lines.add(line);
			}
			
		} catch (IOException ex) {
			
			throw new ErrorException(ex);
		}
		 
		
		String[] text = new String[lines.size()];
		
		for (int i = 0 ; i < text.length ; i++ ) {
			
			text[i] = lines.get(i);
			
		}
		
		return text;
	}
	
	/** Replaces each letter into a random one, keeping cases distinctions */
	private String[] toGreek(String[] text) {
		
		ArrayList<String> newString = new ArrayList<String>();

		for (int l = 0 ; l < text.length ; l++) {						// For each line
			
			String line = "";
						
			for (int ch = 0 ;  ch < text[l].length() ; ch ++) {			// For each character
				
				char character = text[l].charAt(ch);					
								
				if ( Character.isLowerCase(character)) {				// Replace it with a random one
					
					line+= (char) ( 'a' + rgen.nextInt(0,'z'-'a'));	
				
				} else if (Character.isUpperCase(character)) {			// If uppercase, it will be uppercase
					
					line+=(char) ('A'+rgen.nextInt(0, 'Z'-'A'));
				
				} else {												// If punctuation, it will not be changed
					
					line+= character;
				}
			
			}
		
			newString.add(line);										// Add the greek line to an ArrayList
		}
		
		String[] newText = new String[newString.size()];				// Return a string array
		
		for (int l = 0 ; l < newText.length ; l++ ) {
			
			newText[l] = newString.get(l);
			
		}
				
		return newText;
	}
	
	/** Prints the contents of a string array*/
	private void printText(String[] text) {
		
		for (int l = 0 ; l < text.length ; l++) {
			
			println(text[l]);
			
		}
	}
	
	RandomGenerator rgen = new RandomGenerator();

}

