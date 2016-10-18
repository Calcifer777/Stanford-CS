
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import acm.program.*;
import acm.util.ErrorException;

/** Counts the nubmer of characters, words and lines in a text file */
public class CharacterCount extends ConsoleProgram {
	
	public void run() {
		
		BufferedReader rd = openFileReader("Enter the file directory: ");
		
		String [] text = readLineArray(rd);
		
		println("Number of lines: "+text.length+";");
		
		println("Number of words: "+wordCount(text)+";");
		
		println("Number of words: "+characterCount(text)+";");
		
	}
	
	/** Opens a file via FileReader */
	private BufferedReader openFileReader(String prompt) {
		
		BufferedReader rd = null;
		
		while ( rd == null ) {
			
			try {
				
				String fileName = readLine(prompt);
				
				rd = new BufferedReader( new FileReader( fileName));
				
			} catch (IOException ex) {
				
				println("Can't open this file");
				
			}
		}
		
		return rd;
		
	}

	/** Stores the content of a text file into a string array */
	private String[] readLineArray(BufferedReader rd) {
		
		ArrayList<String> lineList = new ArrayList<String>();
		
		try {
		
			while (true) {
		
				String line = rd.readLine();
		
				if (line == null) break;
		
				lineList.add(line);
			}
			
			rd.close();
		
		} catch (IOException ex) {
		
			throw new ErrorException(ex);
		
		}
		
		String[] result = new String[lineList.size()];
		
		
		for (int i = 0; i < result.length; i++) {
		
			result[i] = lineList.get(i);
		
		}
		
		return result;
		
		}

	/** Counts the number of words in the text*/
	private int wordCount(String[] text ) {
		
		int count = 0 ;
		
		for (int i = 0 ; i < text.length ; i++ ) {								// For each line
			
			StringTokenizer tokenizer = new StringTokenizer(text[i],DELIMITERS, false);
			
			println("Words in line "+(i+1)+" : "+tokenizer.countTokens());		// count the number of tokens
			
			count+=tokenizer.countTokens();
			
		}
		
		return count;
		
	}
	
	/** Counts the number of characters in the text */
	private int characterCount(String[] text ) {
		
		int count = 0; 
		for ( int i = 0 ; i < text.length ; i++ ) {					// For each line
			
			count +=  text[i].length(); 							// Add to the count the line length
			
		}
		
		return count;
		
	}
	
	// File directory: Files\Lear.txt

	private static final String DELIMITERS = " ";

}
