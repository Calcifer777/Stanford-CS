/* Program to display the famous Chicago Tribune headline 
 * from when the paper incorrectly called the
 * result of the 1948 presidential election:
 * DEWEY DEFEATS TRUMAN 
 */

import acm.program.*;
import acm.graphics.*;

public class DeweyDefeatsHuman extends GraphicsProgram{

	public void run() {
		
		setSize(WINDOW_WIDTH, 100);
		
		GLabel headLine = new GLabel(LABEL);
		headLine.setFont("Times-bold-100");
		add(headLine,WINDOW_WIDTH,100);
		
		/* Animation */
		
		while (true) {
			
			headLine.move(DX,0);
			pause(PAUSE_TIME);
			
			if (headLine.getX() <= -headLine.getWidth()) {
				
				headLine.setLocation(WINDOW_WIDTH,100);
				
			}
			
		}
		
	}
	
	private static final int PAUSE_TIME = 10;
	private static final String LABEL = "DEWEY DEFEATS HUMAN";
	private static final int WINDOW_WIDTH = 800;
	private static final int DX = -1;
}
