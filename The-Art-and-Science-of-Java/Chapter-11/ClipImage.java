import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class ClipImage extends GraphicsProgram {
	
	public void init() {
		
		image = new GImage(IMAGE);
		array = image.getPixelArray();

		setSize((int) image.getWidth()+OFFSET*2, (int) image.getHeight()+OFFSET*2);  
		
		add(image, OFFSET, OFFSET);
		addMouseListeners();
		addKeyListeners();
	}

	/** Called when the mouse is pressed */
	public void mousePressed(MouseEvent e) {
		
		vertex = e.getPoint();
		selection = new GRect((int) vertex.getX(),(int) vertex.getY(), 0, 0);
		selection.setColor(Color.WHITE);
		add(selection);
		
	}
	
	/** Called when the mouse is dragged */
	public void mouseDragged(MouseEvent e) {
		
		last = e.getPoint();
		Double X0 = (last.getX()>vertex.getX())?vertex.getX():last.getX();
		Double Y0 = (last.getY()>vertex.getY())?vertex.getY():last.getY();
		Double width = (last.getX()>vertex.getX())?last.getX()-vertex.getX():
			vertex.getX()-last.getX();
		Double height = (last.getY()>vertex.getY())?last.getY()-vertex.getY():
			vertex.getY()-last.getY();
		
		selection.setBounds(X0,Y0,width,height);
		
	}

	/** Called when the mouse is released */
	public void mouseReleased(MouseEvent e) {
		
		int X0 = (int) selection.getX()-OFFSET;
		int Y0 = (int) selection.getY()-OFFSET;
		int width = (int) selection.getWidth();
		int height = (int) selection.getHeight();
		
		clippedArray = new int[height][width];
		
		if (width > 0 && height > 0) {
			
			int leftBound = (X0>OFFSET)?X0-OFFSET:0;
			int rightBound = (X0+width<image.getWidth()+OFFSET)?
					width : (int) image.getWidth()-X0;
			int topBound = (Y0>OFFSET)?Y0:0;
			int botBound = (Y0+height<image.getHeight()+OFFSET)?
					height : (int) image.getHeight()-Y0;
			
			for (int row = 0 ; row < botBound ; row++) {
				
				for ( int col = 0 ; col < rightBound ; col++) {
					
					clippedArray[row][col] = array[topBound+row][leftBound+col];
					
				}
				
			}
			clippedImage = new GImage(clippedArray);
			
			removeAll();
			add(clippedImage);
		
		} else {
			
			remove(selection);
		}
		
		
		
	}
	
	/** Called when a key is pressed */
	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		
		case (KeyEvent.VK_ENTER): 
			remove(clippedImage);
			remove(selection);
			add(image);
			break;
		case (KeyEvent.VK_ESCAPE): 
			System.exit(0);
			break;
		}
		
	}
	/* Instance variables */
	private GImage image, clippedImage;
	private Point last, vertex;
	private GRect selection;
	private int[][] array, clippedArray;
	
	
	/* Constants */
	private static final String IMAGE = "quokka.jpg";
	private static final int OFFSET = 5;
}
