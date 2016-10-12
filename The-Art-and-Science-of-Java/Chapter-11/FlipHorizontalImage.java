
import acm.program.*;
import acm.graphics.*;

/* Application of the flipHorizontal method. 
 * The flipHorizontal method flips a GImage horizontally. */

public class FlipHorizontalImage extends GraphicsProgram {
	
	public void run() {
		
		GImage quokka = new GImage("quokka.jpg");
		
		int imageWidth = (int) quokka.getWidth();
		int imageHeight = (int) quokka.getHeight();
		
		setSize( (imageWidth+OFFSET)*2, imageHeight+OFFSET*2);
		
		add(quokka, OFFSET, OFFSET);
		add(flipHorizontal(quokka), imageWidth + 2*OFFSET, OFFSET);
		
		
	}
	
	private GImage flipHorizontal(GImage image) {
		
		int[][] array = image.getPixelArray();

		int imageHeight =  array.length;
		int imageWidth =  array[0].length;
		
		for (int row = 0 ; row < imageHeight; row++) {
			for (int col1 = 0; col1<imageWidth/2; col1++) {
				
				int col2 = imageWidth-col1-1;
				
				int temp = array[row][col2];
				array[row][col2] = array[row][col1];
				array[row][col1] = temp; 
			
			}
		}
		
		return new GImage(array);
				
	}
	
	/* Constants */
	private static final int OFFSET = 5;

}
 