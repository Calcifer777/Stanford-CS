
/* Toy program to draw a red and white circled target */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class Target extends GraphicsProgram {
	
	public void run() {
		
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		
		double xCenter = WINDOW_WIDTH/2;
		double yCenter = WINDOW_HEIGHT/2;
		
		GCompound target = CreateTarget((xCenter+TARGET_DIAMETER)/2, yCenter/2,
				TARGET_DIAMETER, CIRCLES_NUMBER );	
		
		add(target);
	}
	
	
	/** Method to draw the target.
	 * 
	 * @param x The x of the top right vertex of the square inscribing the circle;
	 * @param y The y of the top right vertex of the square inscribing the circle;
	 * @param diameter The diameter of the circle.
	 * @param circles The number of sections in the target
	 * @return Returns the target figure as a GCompound object
	 */
	
	private GCompound CreateTarget( double x , double y , double diameter , int circles) {
		
		double thickness = diameter/(circles*2);
		GCompound target = new GCompound();
		GOval c ;
		
		for (int n = 0 ; n <= circles ; n++ ) {
			
			c = new GOval(x + thickness*n, y + thickness*n, diameter-2*thickness*n, diameter-2*thickness*n);
			c.setFilled(true);
			
			if (n%2==0 ){
				c.setColor(Color.RED);
				c.setFillColor(Color.RED);
			} else {
				c.setColor(Color.WHITE);
				c.setFillColor(Color.WHITE);
			}
			
			target.add(c);
			
		}
		
		return target;
	}

	private static int CIRCLES_NUMBER = 10;
	private static int TARGET_DIAMETER = 200;
	private static int WINDOW_WIDTH = 800;
	private static int WINDOW_HEIGHT = 450;

}
