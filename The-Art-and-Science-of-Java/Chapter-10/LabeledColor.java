

import java.awt.Color;

/* Extends the Color class, allowing to retrieve the name of 
 * the color chosen with the toString() method */

public class LabeledColor extends Color {


	public LabeledColor(Color  c, String str) {

		super(c.getRGB()); 
		colorName = str;

	}
	
	public LabeledColor(int  r,int g, int b, String str) {

		super(r,g,b);
		colorName = str;

	}

	public String toString() {
		
		return colorName;
		
	}
	
	/* Instance variables */
	
	String colorName;


}
