
import acm.program.*;
import acm.graphics.*;

/* Example of two methods that rotate a given image and display the result
 * The flipHorizontal method flips a GImage horizontally. */

public class RotateImage extends GraphicsProgram {
	
	public void run() {
		
		/* Loads the image */
		GImage quokka = new GImage("quokka.jpg");
		
		/* Records the height and width of the image and sets the window applet dimensions
		 * accordingly */
		int imageWidth = (int) quokka.getWidth();
		int imageHeight = (int) quokka.getHeight();
		setSize( (imageWidth+OFFSET)*3, (imageWidth>imageHeight)?imageWidth:imageHeight+OFFSET*2);
		
		/* Adds the original image, as well as the right-rotated and left-rotated version */ 
		add(quokka, OFFSET, OFFSET);
		add(rotateRight(quokka), OFFSET*2+imageWidth, OFFSET );
		add(rotateLeft(quokka), OFFSET*3+imageWidth+imageHeight, OFFSET );
		
		
	}
	
	private GImage rotateRight(GImage image) {
		
		/* Creates a bidimensional int array from the image */
		int[][] array = image.getPixelArray();
		
		/* Creates a bidimensional int array for the rotated image;
		 * width and height are reversed compared to the original image. */
		int imageHeight =  array.length;
		int imageWidth =  array[0].length;
		int[][] rotatedArray = new int[imageWidth][imageHeight];
		
		/* Setting the values for the rotated image */
		for (int row = 0 ; row < imageHeight; row++) {
			for (int col = 0; col < imageWidth; col++) {
 
				rotatedArray[imageWidth-col-1][imageHeight-row-1] = array[row][col];
				
			}
		}
		
		return new GImage(rotatedArray);
				
	}
	
	private GImage rotateLeft(GImage image) {
		
		/* Creates a bidimensional int array from the image */
		int[][] array = image.getPixelArray();
		
 		/* Creates a bidimensional int array for the rotated image;
		 * width and height are reversed compared to the original image. */
		int imageHeight =  array.length;
		int imageWidth =  array[0].length;
		int[][] rotatedArray = new int[imageWidth][imageHeight];

		/* Setting the values for the rotated image */
		for (int row = 0 ; row < imageWidth; row++) {
			for (int col = 0; col < imageHeight; col++) {
 
				rotatedArray[row][col] = array[col][row];
				
			}
		}
		
		return new GImage(rotatedArray);

	}

	/* Constants */
	private static final int OFFSET = 5;

}
 
