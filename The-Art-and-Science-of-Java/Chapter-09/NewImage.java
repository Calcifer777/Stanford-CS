
import acm.program.*;
import acm.graphics.*;

public class NewImage extends GraphicsProgram {
	
	public void run() {

		/* Loading the image */ 

		GImage myimage = new GImage("quokka.jpg");
		
		int width = (int) myimage.getWidth();
		int height = (int) myimage.getHeight();

		/* Creating a new canvas with the dimensions of the image*/
		
		GCanvas gc = new GCanvas();
		
		gc.setSize(width, height);
		
		/* Setting the applet window to the dimensions of the image */
		
		setSize(width, height);

		double x = (gc.getWidth() - myimage.getWidth()) / 2;
		double y = (gc.getHeight() - myimage.getHeight()) / 2;
		
		add(myimage, x, y);
		
	}

}
