
import acm.program.*;
import acm.graphics.*;

/* Application of the flipHorizontal method. 
 * The flipHorizontal method flips a GImage horizontally. */

public class RotateLeft extends GraphicsProgram {
	
	public void run() {
		
		GImage quokka = new GImage("quokka.jpg");
		
		int imageWidth = (int) quokka.getWidth();
		int imageHeight = (int) quokka.getHeight();
		
		setSize( (imageWidth+OFFSET)*3, (imageWidth>imageHeight)?imageWidth:imageHeight+OFFSET*2);
		
		add(quokka, OFFSET, OFFSET);
		
		add(rotateRight(quokka), OFFSET*2+imageWidth, OFFSET );
		
		add(rotateLeft(quokka), OFFSET*3+imageWidth+imageHeight, OFFSET );
		
		
	}
	
	private GImage rotateRight(GImage image) {
		
		int[][] array = image.getPixelArray();
		
 
		int imageHeight =  array.length;
		int imageWidth =  array[0].length;
		
		print("Image size: h "+ imageHeight+"; w "+ imageWidth);
		
		int[][] rotatedArray = new int[imageWidth][imageHeight];
		
		for (int row = 0 ; row < imageHeight; row++) {
			for (int col = 0; col < imageWidth; col++) {
 
				rotatedArray[imageWidth-col-1][imageHeight-row-1] = array[row][col];
				
			}
		}
		
		return new GImage(rotatedArray);
				
	}
	
	private GImage rotateLeft(GImage image) {
		
		int[][] array = image.getPixelArray();
		
 
		int imageHeight =  array.length;
		int imageWidth =  array[0].length;
		
		print("Image size: h "+ imageHeight+"; w "+ imageWidth);
		
		int[][] rotatedArray = new int[imageWidth][imageHeight];

		
		print("Image size: h "+ imageWidth+"; w"+imageHeight);
		
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
 