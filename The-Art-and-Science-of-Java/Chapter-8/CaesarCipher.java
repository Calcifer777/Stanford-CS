/* This program encodes a message using a Caesar cipher.
Enter the number of character positions to shift: */ 

import acm.program.*;

public class CaesarCipher extends ConsoleProgram {
	
	public void run() {
		
		println("This program encodes a message using a Caesar cipher.");

		println("('z'-'a'+1)="+('z'-'a'+1));
		while (true) {
			
			shift = readInt("Enter the number of character positions to shift:");
			message= readLine("Enter a message:");
		
			println("Encoded message: "+ encodeCaesarCipher(message, shift) );
			
			if (readLine("Do you want to chipher another message? ").equals("")) break;
		}
		
		System.exit(0);

		
		
	}
	
	
	/* Caesar cipher method */
	
	private String encodeCaesarCipher( String message, int shift) {
		
		/* Initializing the ciphred message */
		
		String ciphredMessage ="";

		/* Recalculating shift so that is it at most ['z'-'a'] (32), the number of alphabet letters. */
		
		shift=shift%('z'-'a'+1);
		
		/* If shift is negative, changing it to positive  while 
		 * maintaining its meaning */
		
		shift=(shift<0)?('z'-'a'+1)-shift:shift;
		
		char ch;
		
		for (int i = 0 ; i <= message.length()-1 ; i++ ) {
			
			ch = message.charAt(i);
						
			if ( Character.isLetter(ch) ) {
				
				if (Character.isUpperCase(ch)) {
					
					ch =  (char) ((ch+shift-'A')%('z'-'a'+1)+'A');
					ciphredMessage +=  ch;
							
				} else if(Character.isLowerCase(ch)) {
					
					ch =  (char) ((ch+shift-'a')%('z'-'a'+1)+'a');
					ciphredMessage += ch;
					
				} else {
					
					ciphredMessage+=ch;
					
				}
				
			} else {
				
				ciphredMessage+=ch;
			}
			
			
		}
		
		return ciphredMessage;
		
	}
	
	
	
	/* Instance variables */
	
	private int shift;
	private String message;


}
