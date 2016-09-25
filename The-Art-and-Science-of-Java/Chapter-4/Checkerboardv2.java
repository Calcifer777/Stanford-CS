/* Draws a checkerboard with checker pieces */

import acm.program.*;
import java.awt.Color;
import acm.graphics.*;

public class Checkerboardv2 extends GraphicsProgram {

	public void run() {
		
		/* Drawing the checkerboard*/
		
		GCompound checkerboard = new GCompound();
		GRect cell;
		
		for (int n = 1 ; n <= ROW_NUMBER; n++) {
			for (int m = 1 ; m <= COLUMN_NUMBER; m++) {
				
				cell = new GRect(m*SQ_LENGTH, n*SQ_LENGTH, SQ_LENGTH, SQ_LENGTH);
				cell.setFilled(true);
				
				if ( (n+m)%2 == 0) {
					cell.setFillColor(Color.GREEN);
				} else {
					cell.setFillColor(Color.LIGHT_GRAY);
				}
				
				checkerboard.add(cell);
				
			}
		}
		
		add(checkerboard);
		
		/* Adding the pieces*/
		
		
		GOval piece;
		
		for (int n = 1 ; n <= ROW_NUMBER; n++) {
			for (int m = 1 ; m <= COLUMN_NUMBER; m++) {
						
				if ( (n+m)%2 == 0 && n<=3 ) {
					
					piece = new GOval( m*SQ_LENGTH+(SQ_LENGTH-PIECE_SIZE)/2, n*SQ_LENGTH+(SQ_LENGTH-PIECE_SIZE)/2,
							PIECE_SIZE, PIECE_SIZE );
					piece.setFilled(true);
					piece.setFillColor(Color.BLACK);
					add(piece);
				} if ( (n+m)%2 == 0 && n>=6) {
					piece = new GOval( m*SQ_LENGTH+(SQ_LENGTH-PIECE_SIZE)/2, n*SQ_LENGTH+(SQ_LENGTH-PIECE_SIZE)/2,
							PIECE_SIZE, PIECE_SIZE );
					piece.setFilled(true);
					piece.setFillColor(Color.WHITE);
					add(piece);
				}		
			}
		}
	}

	private static final int ROW_NUMBER=8; 
	private static final int COLUMN_NUMBER=8;
	private static final int SQ_LENGTH = 20; /* Length of each square */
	private static final int PIECE_SIZE = 18; /* Length of each square */

}
