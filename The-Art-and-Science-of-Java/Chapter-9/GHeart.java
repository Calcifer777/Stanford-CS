
import acm.graphics.*;

/**
* Defines a new GObject class that appears as an heart.
*/

import java.awt.*;

public class GHeart extends GPolygon {

	/**
	* Creates a new GHeart centered at the origin with the specified
	* horizontal width, and height
	* @param width The width of the heart
	* @param height The height of the heart 
	*/

	public GHeart(double width, Color color) {
		
		
		addVertex(0,0);
		addArc(width/2, width/2, -40, 40+90+45);
		addArc(width/2, width/2, 45, 40+90+45);
		
		GPoint vertex = getCurrentPoint();
		
		addEdge(-vertex.getX()/2, -vertex.getX()/2);
		addEdge(-vertex.getX()/2, vertex.getX()/2);
		
		setFilled(true);
		setFillColor(color);
		
		recenter();
		
	}
	
}