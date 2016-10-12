
import acm.program.*;
import acm.graphics.*;

/* Application of the makeColorNegative method. 
 * The method returns the negative of a given image*/

public class MakeColorNegative extends GraphicsProgram {
	
	public void run() {
		
		/* Importing the image and setting the window size */
		GImage quokka = new GImage("quokka.jpg");
		
		int imageWidth = (int) quokka.getWidth();
		int imageHeight = (int) quokka.getHeight();
		
		setSize( (imageWidth+OFFSET)*2, imageHeight+OFFSET*2);
				
		/* Adding the original image and its negative*/
		add(quokka, OFFSET, OFFSET);
		add(makeColorNegative(quokka), OFFSET*2+imageWidth, OFFSET );
		
	}
	
	/* Returns an image that is the negative of the one used as argument */
	private GImage makeColorNegative(GImage image) {
		
		int[][] array = image.getPixelArray();
		
		int width = array[0].length;
		int height = array.length;
		
		for (int row = 0 ;  row < height; row++) {
			
			for (int col = 0 ; col < width ; col ++) {
				
				int pixel = array[row][col];
				
				/* Isolating each color */
				int alpha = (pixel >> 24) & 0xFF;
				int red = ( pixel >> 16 )  & 0xFF;
				int green = ( pixel >> 8 ) & 0xFF;
				int blue = pixel & 0xFF;
				
				/* Taking the negative of each color
				 * The transparency is set to the same value as the image */
				red = Math.abs(red-255);
				green = Math.abs(green-255);
				blue = Math.abs(blue-255);
				
				/* The new image. */
				array[row][col] = (alpha<<24)|(red<<16)|(green<<8)|(blue);
				
			}
		}

		return new GImage(array);
				
	}

	/* Constants */
	private static final int OFFSET = 5;

}
 