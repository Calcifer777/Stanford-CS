/* Draws a tic tac toe board */ 

import acm.graphics.*;
import acm.program.*;

public class TicTacToeBoard extends GraphicsProgram {
	
	public void run() {
		
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);

		
		GCompound board = new GCompound();
		
		GLine leftVertLine = new GLine( (WINDOW_WIDTH-BOARD_SIZE/3)/2, (WINDOW_HEIGHT-BOARD_SIZE)/2, 
				(WINDOW_WIDTH-BOARD_SIZE/3)/2, (WINDOW_HEIGHT+BOARD_SIZE)/2);
		
		GLine rightVertLine = new GLine( (WINDOW_WIDTH+BOARD_SIZE/3)/2, (WINDOW_HEIGHT-BOARD_SIZE)/2, 
				(WINDOW_WIDTH+BOARD_SIZE/3)/2, (WINDOW_HEIGHT+BOARD_SIZE)/2);
		
		GLine topHorLine = new GLine( (WINDOW_WIDTH-BOARD_SIZE)/2, (WINDOW_HEIGHT-BOARD_SIZE/3)/2, 
				(WINDOW_WIDTH+BOARD_SIZE)/2, (WINDOW_HEIGHT-BOARD_SIZE/3)/2);
		
		GLine botHorLine = new GLine( (WINDOW_WIDTH-BOARD_SIZE)/2, (WINDOW_HEIGHT+BOARD_SIZE/3)/2, 
				(WINDOW_WIDTH+BOARD_SIZE)/2, (WINDOW_HEIGHT+BOARD_SIZE/3)/2);
		
		board.add(leftVertLine);
		board.add(rightVertLine);
		board.add(topHorLine);
		board.add(botHorLine);
		
		add(board);
		
	}
	
	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 450;
	private static final int BOARD_SIZE = 400;
	
	
}
