/* Displays a check board */

import acm.graphics.*;
import acm.program.*;

public class Checkboard extends GraphicsProgram {
	/* Length of each square */ 
	private static final int SQ_LENGTH = 20;
	
	public void run() {
		
		
		for (int i = 1; i<=8 ; i++) {
			for (int j = 1; j<=8 ; j++) {
				
				add( new GRect(10+(i-1)*SQ_LENGTH,10+(j-1)*SQ_LENGTH,SQ_LENGTH,SQ_LENGTH) );
				
				if ( (i+j) % 2 == 1) {
					add( new GOval(12+(i-1)*SQ_LENGTH,12+(j-1)*SQ_LENGTH,16,16));
				}
			}
		}
	}
}
