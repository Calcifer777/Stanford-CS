
import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class NextColor extends GraphicsProgram {
	
	public void run() {
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		/* Creating a new canvas with the dimensions of the image*/
		
		GCanvas gc = new GCanvas();
		gc.setVisible(true);
		
		gc.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);	
		
		/* Creating the square */
		
		GRect square = new GRect(200, 200);
		add(square, (getWidth()-square.getWidth())/2 , (gc.getHeight()-square.getHeight())/2 );
		square.setFilled(true);
		square.setFillColor(Color.BLACK);
		
		while (true) {
			
			pause(PAUSE_TIME);
			Color newcolor = rgen.nextColor();
			square.setFillColor(newcolor);
	
		}
		
	}

	RandomGenerator rgen = new RandomGenerator();
	
	/* Constants */
	
	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 450;
	private static final int PAUSE_TIME = 1000;
	
}
