
/* Toyprogram that graphs a house */ 

import acm.program.*;
import acm.graphics.*;

public class House extends GraphicsProgram {
	
	public void run() {
		
		double height = getHeight();
		double width = getWidth();
		
		GRect front = new GRect(9*width/10, 4.5*height/10);	
		GPolygon roof = createRoof(9*width/10, 2.5*height/10);
		GRect door = new GRect(front.getWidth()/6, 2*front.getHeight()/3);
		GRect window1 = new GRect(front.getHeight()/4, front.getHeight()/4);
		GRect window2 = new GRect(front.getHeight()/4, front.getHeight()/4);
		GOval handle = new GOval(door.getWidth()/10,door.getWidth()/10);
		
		add(front,  (width-front.getWidth() )/2 , (height-front.getHeight() )/2 );
		add(roof, front.getX(), front.getY());
		add(door, (front.getWidth()-door.getWidth() )/2+front.getX(), 
				front.getY()+front.getHeight()-door.getHeight());
		add(window1, front.getX() +( front.getWidth()-window1.getWidth() )/6 ,
				front.getY()  +( front.getHeight()-window1.getHeight() )/4);
		add(window2, front.getX() + 5*( front.getWidth()-window2.getWidth() )/6 ,
				front.getY()  + ( front.getHeight()-window2.getHeight() )/4);
		add(handle, 95*(door.getX()+door.getWidth())/100,
				front.getY()+(front.getHeight()-door.getHeight()/2) );
	}
	
	
	/* Method that draws the roof */
	
	private GPolygon createRoof(double base, double height ) {
		
		GPolygon roof = new GPolygon();
		roof.addVertex(0,0);
		roof.addVertex(base, 0);
		roof.addVertex(base/2 , - height);
		return roof;
		
	}

}
