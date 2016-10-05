

/* Displays a label containing the name of a random color. The color of the label is set Not
 * to match the label color. Every second a new label (and a new color) are generated */


import acm.program.*;
import acm.util.RandomGenerator;
import acm.graphics.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.StringTokenizer;

public class RandomColorLabelV2 extends GraphicsProgram {
	
	public void run() {
		
		/* Setting the applet window size to the preferred dimensions*/
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		/* Creating a new canvas */
		
		GCanvas gc = new GCanvas();
		gc.setVisible(true);
		
		gc.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		GLabel label = new GLabel("");
		
		label.setFont("SansSerifs-bold-40");
		
		while (true) {
			
			/* Creating the label */
			
			String stringContent= newColor(LIST);
			
			label.setLabel(stringContent);
			
			/* Coloring the label */
			
			boolean ok = false;
			
			while (!ok) {
				
				String labelColor=newColor(LIST);
				
				if (!stringContent.equals(labelColor)) { 	// Color the label only with a color that does not
										// match the string content
				
					label.setColor(stringToColor(labelColor));
					
					ok=true;
					
				}
				
			}
				
			
			/* Sets the label at the center of the canvas */ 
			
			GPoint labelLocation = new GPoint( (gc.getWidth()-label.getWidth() )/2,
					( gc.getHeight()-label.getDescent())/2 );
					
			add(label,labelLocation);
			
			pause(PAUSE_TIME);
						
		}
		
		
	}

	/** Generates a new color from a list of colors.
	 * @param colorList is a string. Colors may be in integer format ( 200, 150, 170) or just the names of the colors
	 * (e.g. red, black, etc) */
	
	private String newColor(String colorList) {
		
		StringTokenizer tokenizer = new StringTokenizer(colorList, " ", false);
		
		/* Counts the colors in the list */
		
		int colorsNumber = tokenizer.countTokens();
		
		/* Randmly selects a color in the list, stored as a token index*/
		
		int n = rgen.nextInt(1, colorsNumber);		
		
		int i=1;
		
		while ( i< n) {
			tokenizer.nextToken();
			i++;
		}
		
		/* Returns the nth token/color in the list as a string */
		
		return tokenizer.nextToken();
		
	}
	
	
	/** Converts a given string into a color.
	  * @param value The string containing the color; either a name or an integer.
	  * @return The color. Returns black as a default color.
	  */
	
	  private static Color stringToColor(final String value) {
		  
	    
		  if (value == null) {
	      
			  return Color.black;
	
		  }
	    
		  try {
	      
			  // get color by hex or octal value
	      
			  return Color.decode(value);
	
		  } catch (NumberFormatException nfe) {
	      
			  // if we can't decode lets try to get it by name
	      
			  try {
	        
				  // try to get a color by name using reflection
	        
				  final Field f = Color.class.getField(value);

				  return (Color) f.get(null);

			  } catch (Exception ce) {
	       
				  // if we can't get any color return black
	        
				  return Color.black;
	     
			  }
	  
		  }
		  
	  }
	  
	  
	  /* Instance of the randomgenerator class */
	
	  RandomGenerator rgen = new RandomGenerator();
	

	  /* Constants */

	  private static final int WINDOW_WIDTH = 800;
	  private static final int WINDOW_HEIGHT = 450;
	  private static final int PAUSE_TIME = 500;
	
	private static final String LIST = "RED ORANGE YELLOW GREEN CYAN BLUE MAGENTA";

}
