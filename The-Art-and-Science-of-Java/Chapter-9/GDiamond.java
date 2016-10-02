
import acm.graphics.*;

/**
* Defines a new GObject class that appears as a romboid.
*/

public class GDiamond extends GPolygon {

	/**
	* Creates a new GDiamond centered at the origin with the specified
	* horizontal width and height
	* @param width The width of the diamond
	* @param width The height of the diamond
	*/

	public GDiamond(double width, double height) {
		
		addVertex(-width / 2, 0);
		
		addVertex(0, height / 2);
		
		addVertex(width / 2, 0);
		
		addVertex(0, -height / 2);

	}

}
