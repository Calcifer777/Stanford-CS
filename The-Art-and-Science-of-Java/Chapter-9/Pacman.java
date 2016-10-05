
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;

/* Draws pacman at the center of the applet and moves it left to right.
 * Pacman's mouth opens and closes as Pacman moves.
 */

public class Pacman extends GraphicsProgram {
	
	public void run() {
		
		/* Sets the applet dimensions */
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		GCanvas gc = new GCanvas();
		
		gc.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		/* Pacman */
		
		GArc pacman = new GArc(ray, ray, 40, 280);
		pacman.setFilled(true);
		pacman.setFillColor(Color.YELLOW);
		pacman.setColor(Color.BLACK);
		
		add(pacman, (gc.getWidth()-ray)/2, (gc.getHeight()-ray)/2);
		
		int flag = -1; // Changes the mouth from opening to closing and vice versa  
		
		/* Loop that moves pacman */
		
		while (true) {
			
			/* Moves pacman */
			
			pacman.move(dx,0);
			
			pause(pauseTime);
			
			/* If Pacman goes further than the outer applet bound,
			 * returns it to the left bound. */
			
			if (pacman.getX()+pacman.getWidth()>gc.getWidth()) {
				
				pacman.setLocation(-pacman.getWidth(), 
						(gc.getHeight()-pacman.getWidth())/2);
			}
			
			/* Moves pacman mouth*/
			
			if (pacman.getStartAngle()>=45 || pacman.getStartAngle()<=0) {
				flag*=-1;
			}
			
			pacman.setStartAngle(pacman.getStartAngle()+deltaAngle*flag);
			pacman.setSweepAngle(pacman.getSweepAngle()-2*deltaAngle*flag);

		}
		
		
	}
	
	/* Instance variables */
	
	private int ray = 70;
	private int dx = 3;
	private int pauseTime = 10;
	private int deltaAngle = 1;
	
	/* Constants */
	
	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 450;	

}
