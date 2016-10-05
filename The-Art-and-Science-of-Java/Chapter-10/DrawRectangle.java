
import acm.graphics.*;
import acm.program.*;

import java.awt.Color;
import java.awt.event.*;

/* Draws two eyes on the canvas. The pupils follow the cursor location*/

public class DrawRectangle extends GraphicsProgram {

	/* Initializes the program by enabling the mouse listeners */
	
	public void init() {
	
		addMouseListeners();
	
	}
	
	
	/* Called on mouse is pressed. */
	
	public void mousePressed(MouseEvent e) {
		
		rect = new GRect(e.getX(), e.getY(), 0, 0);
		rect.setFilled(true);
		rect.setFillColor(Color.DARK_GRAY);
		add(rect);
		
		lastX=rect.getX();
		lastY=rect.getY();
		
	}
	
	/* Called on mouse is dragged. */
	
	public void mouseDragged(MouseEvent e) {
		
		double X0 =  (lastX<e.getX())?	lastX	:	e.getX();
		double Y0 =  (lastY<e.getY())?	lastY	:	e.getY();
			
		double width =  (lastX<e.getX())?	e.getX()-lastX	: 	lastX - e.getX();
		double height =  (lastY<e.getY())?	e.getY()-lastY	:	lastY - e.getY();

		rect.setBounds(X0, Y0, width, height);
		
		
		
		
	}
	
	
	

	/* Private instance variables */

	GRect rect;
	double lastX;
	double lastY;
	
	/* Constants */
	
	
	
}