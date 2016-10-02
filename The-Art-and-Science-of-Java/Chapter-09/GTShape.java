
import acm.graphics.*;

/**
* Defines a new GObject class that appears as a T-Shape.
*/

public class GTShape extends GPolygon {

	/**
	* Creates a new GTrapezoid centered at the origin with the specified
	* horizontal width, bottom and top base
	* @param width The width of the shape;
	* @param height The height of the shape;
	* @param thickness The ratio of the thickness to the width of the shape. Should be between 0 and 1
	*/

	public GTShape (double width, double height, double thickness) {
		
		addVertex(- width / 2, - height / 2);
		
		addEdge( width, 0);
		
		addEdge( 0, thickness*width);
		
		addEdge( -(1-thickness)*width/2, 0);
		
		addEdge( 0, height-thickness*width);
		
		addEdge( -thickness*width, 0);
		
		addEdge( 0, -(height-thickness*width));
		
		addEdge( -(1-thickness)*width/2, 0);

		addEdge( 0, -thickness*width);

	}

}
