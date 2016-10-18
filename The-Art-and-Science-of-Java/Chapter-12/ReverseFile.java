import java.io.*;
import java.util.ArrayList;

import acm.program.*;
import acm.util.*;

/** Reverses the lines of a text file*/
public class ReverseFile extends ConsoleProgram {
	
	public void run() {
		
		println("This program reverses the lines in a file.");
		
		BufferedReader rd = openFileReader("Enter input file: ");
		
		String[] lines = readLineArray(rd);
		
		for (int i = lines.length - 1; i >= 0; i-- ) {		// Prints the lines of a string array in reverse order
		
			println(lines[i]);
		
		}
		
	}

	/** Opens a text file*/
	private BufferedReader openFileReader(String prompt) {
		
		BufferedReader rd = null;
		
		while (rd == null) {
		
			try {
				
				String name = readLine(prompt);
				rd = new BufferedReader(new FileReader(name));
		
			} catch (IOException ex) {
		
				println("Can't open that file.");
			}
			
		}
		
		return rd;
	}
	
	/** Stores the content of the reader into a string array */
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
}
