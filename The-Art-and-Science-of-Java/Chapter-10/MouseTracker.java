
import acm.program.*;
import acm.graphics.*;
import java.awt.event.MouseEvent;;

public class MouseTracker extends GraphicsProgram {
	
	/* Initializes the program by enabling the mouse listeners */
	
	public void init() {
	
		addMouseListeners();
	}
	
	public void run() {
		
		setSize(800, 450);
		
	}
	
	public void mouseMoved(MouseEvent e) {
		tracker.setLabel("("+e.getX()+", "+e.getY()+")");
		tracker.setLocation(e.getX()-tracker.getWidth()-2, e.getY());
		add(tracker);
	}
	
	private GLabel tracker = new GLabel("");
	
}
