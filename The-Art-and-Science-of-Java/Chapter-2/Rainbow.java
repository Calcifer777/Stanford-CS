
/* Toy program that draws a rainbow in the applet window.
 * This program uses the clipping method to display the arcs
 * of the rainbow
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Rainbow extends GraphicsProgram {
	
	public void run() {
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		double rainbowDiameter = WINDOW_HEIGHT*3.5;
		setBackground(Color.CYAN);
		GCompound rainbow = new GCompound();
		
		GOval c;
		
		for (int n = 1; n <= 7; n++) {
			
			c = new GOval((n-1)*ARC_THICKNESS,(n-1)*ARC_THICKNESS, 
					rainbowDiameter-2*(n-1)*ARC_THICKNESS, rainbowDiameter-2*(n-1)*ARC_THICKNESS);
			c.setFilled(true);
			
			switch (n) {
			case (1):
				c.setColor(Color.RED);
				c.setFillColor(Color.RED);
				break;
			case (2):
				c.setColor(Color.ORANGE);
				c.setFillColor(Color.ORANGE);
				break;
			case (3):
				c.setColor(Color.YELLOW);
				c.setFillColor(Color.YELLOW);
				break;
			case (4):
				c.setColor(Color.GREEN);
				c.setFillColor(Color.GREEN);
				break;
			case (5):
				c.setColor(Color.BLUE);
				c.setFillColor(Color.BLUE);
				break;
			case (6): 
				c.setColor(Color.MAGENTA);
				c.setFillColor(Color.MAGENTA);
				break;
			case (7):
				c.setColor(Color.CYAN);
				c.setFillColor(Color.CYAN);
				break;
			default: 
				c.setColor(Color.WHITE);
				c.setFillColor(Color.WHITE);
					
			}
			
			rainbow.add(c);
			
		}
		
		add(rainbow, (WINDOW_WIDTH-rainbowDiameter)/2, WINDOW_HEIGHT/4);
		
	}
	
	
	private static int WINDOW_WIDTH = 400;
	private static int WINDOW_HEIGHT= 250;
	private static int ARC_THICKNESS= 15;

}
