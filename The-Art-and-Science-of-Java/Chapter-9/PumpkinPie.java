

/* Draws a n section colored circle */

import acm.program.*;
import java.awt.Color;
import acm.graphics.*;

public class PumpkinPie extends GraphicsProgram {
	
	public void run() {
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		GCanvas gc = new GCanvas();
		
		gc.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		GCompound pie = createPumpkinPie(pieRay, pieSections, pieColor);
		
		add(pie, gc.getWidth()/2-pieRay, gc.getHeight()/2-pieRay);
		
		
	}
	
	
	/** Creates a pumpkin pie centered at the origin
	 * @param ray The ray of the pie
	 * @param n The number of sections of the pie */
	
	private GCompound createPumpkinPie(double ray, int sections, Color color) {
		
		GCompound pie = new GCompound();
		
		for (int i = 0 ; i <= sections - 1 ; i++) {
			
			GArc arc = new GArc(2*ray, 2*ray, 360/sections*i, 360/sections );
			arc.setFilled(true);
			arc.setFillColor(color);
			arc.setColor(Color.BLACK);
			pie.add(arc);
			
		}
		
		return pie;
		
	}
	
	/* Instance variables */
	
	private static int pieSections = 6;
	private static int pieRay = 100;
	private static Color pieColor = new Color(255,255,0);

	
	/* Constants */
	
	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 800;
	
}
