
import java.io.*;
import java.util.*;

import javax.swing.JFileChooser;

import acm.program.*;
import acm.util.*;


/** Replaces each tab character in a text file with the number of spaces 
 * necessary to maintain the formatting style*/
public class Untabify extends ConsoleProgram {
	
	public void run() {
		
		BufferedReader rd = openFileReader();
		
		String[] text = readFileLines(rd);
		
		untabify(text);
		
		printArray(text);
		
		printToFile(text, "Files\\Untabified.txt");
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
			
				println("Can't open that file.");
			
			}		
			
		}
		
		return rd;
		
	}
	
	/** Reads the text file and stores it into a string array */
	private String[] readFileLines(BufferedReader rd) {
		
		ArrayList<String> arrayLines = new ArrayList<String>();
		
			try { 
				
				while (true) {
					
					String line = rd.readLine();
					if (line==null)	break;
					arrayLines.add(line);
				
				}
				
			} catch (IOException ex) {
				
				throw new ErrorException("Can't read the text file!");
			}
			
		String[] text = new String[arrayLines.size()];
		
		for (int i = 0 ; i < arrayLines.size() ; i++ ) {
			
			text[i] = arrayLines.get(i);
			
		}
		
		return text;
		
	}

	/** Replaces tabulation characters with spaces*/
	private void untabify(String[] text) {
		
		int lines = text.length;
		
		for (int i = 0 ; i < lines ; i++) {					// For each line
			
			StringBuilder builder = new StringBuilder("");	// Initialize a new String/line
			
			int lineLength = text[i].length();
				
			int count=0;
			for (int ch = 0; ch < lineLength ; ch++) {		// For each character
				
				if (text[i].charAt(ch)!='\t') {				// If not tab [\t], just append it
					
					builder.append(text[i].charAt(ch));
					count++;
						
				} else {									// If tab, replace it with spaces
				
					int numSpaces = 8-(count-1)%8;			// whose number depends on characters since the 
															// last tabulation point
					for (int s = 1 ; s < numSpaces ; s++) {
						
						builder.append(" ");
					}
					
					count=0;
					
				}
				
			}
			
			text[i] = builder.toString();					// Make this line a new element of a string array
			
		}
	}

	/** Prints a string array */
	private void printArray(String[] text) {
		for (int i = 0 ; i < text.length ; i++) {
			println(text[i]);			
		}
	}

	/** Prints a string array to a text file */
	private void printToFile(String[] text , String fileName) {
		
		try {
			
			PrintWriter wr = new PrintWriter(new FileWriter(fileName));
			
			for (int l = 0 ;  l < text.length; l++) {
				wr.println(text[l]);
			}
			
			wr.close();
		
		} catch (IOException ex) {
		
			throw new ErrorException(ex);
		
		}
		
	}


}
