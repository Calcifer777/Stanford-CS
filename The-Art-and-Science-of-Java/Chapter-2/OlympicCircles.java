
/* Toy Program that draw the Olympic games 
 * circles
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class OlympicCircles extends GraphicsProgram {
		
	public void run() {
		
		setSize(WIDTH, HEIGHT);		
		
		GCompound blackc = GOvalExtended( (WIDTH-CIRCLE_DIAMETER)/2, (HEIGHT-CIRCLE_DIAMETER)/3 ,
				CIRCLE_DIAMETER, CIRCLE_THICKNESS);
		add(blackc);
		
		GCompound bluec = GOvalExtended( blackc.getX()-6*CIRCLE_DIAMETER/5, (HEIGHT-CIRCLE_DIAMETER)/3 ,
				CIRCLE_DIAMETER, CIRCLE_THICKNESS);
		bluec.setColor(Color.blue);
		add(bluec);
		
		GCompound redc = GOvalExtended( blackc.getX()+6*CIRCLE_DIAMETER/5, (HEIGHT-CIRCLE_DIAMETER)/3 ,
				CIRCLE_DIAMETER, CIRCLE_THICKNESS);
		redc.setColor(Color.red);
		add(redc);
		
		GCompound yellowc = GOvalExtended( (blackc.getX()+bluec.getX())/2, bluec.getY()+CIRCLE_DIAMETER/2 ,
				CIRCLE_DIAMETER, CIRCLE_THICKNESS);
		yellowc.setColor(Color.yellow);
		add(yellowc);
		
		GCompound greenc = GOvalExtended( (redc.getX()+blackc.getX())/2, blackc.getY()+CIRCLE_DIAMETER/2 ,
				CIRCLE_DIAMETER, CIRCLE_THICKNESS);
		greenc.setColor(Color.green);
		add(greenc);
		
	
	}
	
	/** Method that allows to set a thickness of the 
	 * objects in the GOval class.
	 * @param x X of the top left vertex of the square inscribing the circle.
	 * @param x Y of the top left vertex of the square inscribing the circle.
	 * @param size Diameter of the circle.
	 * @param thickness The thickness in pixels of the circle.
	 */
	
	private GCompound GOvalExtended(double x, double y, double size, int thickness ) {
		
		GCompound circle = new GCompound();

		for (int i =0 ; i<thickness ; i++) {
		
			circle.add(new GOval(i,i,size-2*i,size-2*i));
			
		}
		
		circle.setLocation(x,y);
		return circle;
	}
	
	private static int WIDTH = 800;
	private static int HEIGHT = 450;
	private static int CIRCLE_DIAMETER = 100;
	private static int CIRCLE_THICKNESS = 4;
}
