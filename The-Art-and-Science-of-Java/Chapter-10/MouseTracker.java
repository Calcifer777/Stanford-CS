
import acm.program.*;
import acm.graphics.*;
import java.awt.event.MouseEvent;

/* Tracks the mouse movements inside the applet window and returns a label with 
 * cursor location (in java coordinates) */

public class MouseTracker extends GraphicsProgram {
	
	/* Initializes the program by enabling the mouse listeners */
	
	public void init() {
	
		addMouseListeners();
	}
	
	/* Stes up the window dimensions */
	
	public void run() {
		
		setSize(800, 450);
		
	}
	
	/* Called when the mouse is moved */
	
	public void mouseMoved(MouseEvent e) {
		tracker.setLabel("("+e.getX()+", "+e.getY()+")");
		tracker.setLocation(e.getX()-tracker.getWidth()-2, e.getY());
		add(tracker);
	}
	
	/* Instance variables */
	private GLabel tracker = new GLabel("");
	
}
