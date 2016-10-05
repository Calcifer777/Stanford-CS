
import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;

/** This class displays a mouse-draggable rectangle and oval */

public class DragObjects extends GraphicsProgram {

	/* Initializes the program */

	public void init() {
	
		GRect rect = new GRect(100, 100, 150, 100);

		rect.setFilled(true);
		rect.setColor(Color.RED);
	
		add(rect);
		
		GOval oval = new GOval(300, 115, 100, 70);
		oval.setFilled(true);
		oval.setColor(Color.GREEN);
		add(oval);
	
		addMouseListeners();
		addKeyListeners();
	}

	/* Called on mouse press to record the coordinates of the click */

	public void mousePressed(MouseEvent e) {

		last = new GPoint(e.getPoint());
		gobj = getElementAt(last);
	
	}

	/* Called on mouse drag to reposition the object */
	
	public void mouseDragged(MouseEvent e) {
	
		if (gobj != null) {

			gobj.move(e.getX() - last.getX(), e.getY() - last.getY());
			last = new GPoint(e.getPoint());
		}
	}

	
	/* Called on mouse click to move this object to the front */

	public void mouseClicked(MouseEvent e) {

		if (gobj != null) gobj.sendToFront();

	}
	
	
	/* Called on arrows type to reposition the object */
	
	public void keyPressed(KeyEvent e) {
			
		if (gobj != null) {
		
			switch (e.getKeyCode()) {
			case KeyEvent.VK_W: gobj.move(0, -1); break;
			case KeyEvent.VK_S: gobj.move(0, +1); break;
			case KeyEvent.VK_A: gobj.move(-1, 0); break;
			case KeyEvent.VK_D: gobj.move(+1, 0); break;
			
			}
			
		}
	}

	/* Private instance variables */

	private GObject gobj; /* The object being dragged */
	private GPoint last; /* The last mouse position */

}