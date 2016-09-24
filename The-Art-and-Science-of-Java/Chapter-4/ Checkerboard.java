/* Displays a check board */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class Checkerboard extends GraphicsProgram {
	/* Length of each square */ 
	private static final int SQ_LENGTH = 20;
	
	public void run() {
		
		GCompound checkerboard = new GCompound();
		GOval piece ;
		GRect square ;
		for (int i = 1; i<=8 ; i++) {
			for (int j = 1; j<=8 ; j++) {
				
				square = new GRect(10+(i-1)*SQ_LENGTH,10+(j-1)*SQ_LENGTH,SQ_LENGTH,SQ_LENGTH);
				
				if ( (i+j) % 2 == 1) {
					 piece = new GOval(12+(i-1)*SQ_LENGTH,12+(j-1)*SQ_LENGTH,.8*SQ_LENGTH,.8*SQ_LENGTH);
					 piece.setFilled(true);
					 piece.setFillColor(Color.BLACK);
					 checkerboard.add(piece);
					 checkerboard.add(square);
				} else {
					square.setFilled(true);
					square.setFillColor(Color.RED);
					checkerboard.add(square);
				}
			}
			
		}
		
		add(checkerboard);
	}
}
