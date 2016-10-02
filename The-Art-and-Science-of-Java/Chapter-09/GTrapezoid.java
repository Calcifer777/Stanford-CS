
import acm.graphics.*;

/**
* Defines a new GObject class that appears as a trapezoid.
*/

public class GTrapezoid extends GPolygon {

	/**
	* Creates a new GTrapezoid centered at the origin with the specified
	* horizontal width, bottom and top base
	* @param baseBot The bottom base of the trapezoid;
	* @param baseTop The top base of the trapezoid;
	* @param height The bottom base of the trapezoid;
	*/

	public GTrapezoid (double baseBot, double baseTop, double height) {
		
		addVertex(- baseBot / 2, height / 2);
		
		addVertex( -baseTop / 2 , -height / 2);
		
		addVertex( baseTop/2 , -height / 2);
		
		addVertex( baseBot/2 , height / 2);


	}

}
