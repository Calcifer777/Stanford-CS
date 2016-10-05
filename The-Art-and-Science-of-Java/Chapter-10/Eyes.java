
import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;

/* Draws two eyes on the canvas. The pupils follow the cursor location*/

public class Eyes extends GraphicsProgram {

	/* Initializes the program by enabling the mouse listeners */
	
	public void init() {
	
		addMouseListeners();
	
	}
	
	/* Drawing the eyes */
	
	public void run() {
		
		setSize(800, 450);

		add(new GOval ( 300, 200, 100, 100));
		add(new GOval ( 500, 200, 100, 100));
		
		leftEye = new GOval (LEFT_CENTER.getX()-EYE_RADIUS,
				LEFT_CENTER.getY()-EYE_RADIUS, 2*EYE_RADIUS, 2*EYE_RADIUS);
		leftEye.setFilled(true);
		add(leftEye);
	
		rightEye = new GOval (RIGHT_CENTER.getX()-EYE_RADIUS, 
				RIGHT_CENTER.getY()-EYE_RADIUS, 10, 10);
		rightEye.setFilled(true);
		add(rightEye);
		
	}
	
	/* Called on mouse moved. The eyes follow the mouse movement.
	 * if the distance between the eye center and the cursor is less than
	 * the maximum displacement the eye location is just the cursor
	 * location */
	
	public void mouseMoved(MouseEvent e) {
		
		// Setting the position of the left eye
		
		if (GMath.distance(LEFT_CENTER.getX()-EYE_RADIUS,LEFT_CENTER.getY()-EYE_RADIUS, 
				e.getX(), e.getY() ) <= MAX_MOVE ) {
			
			leftEye.setLocation(e.getX(), e.getY());
			
		} else {
			
			double leftAngle  = GMath.angle(LEFT_CENTER.getX(), LEFT_CENTER.getY(),
					e.getX(), e.getY());
			
			leftEye.setLocation(LEFT_CENTER.getX()-EYE_RADIUS+GMath.cosDegrees(leftAngle)*MAX_MOVE, 
					LEFT_CENTER.getY()-EYE_RADIUS-GMath.sinDegrees(leftAngle)*MAX_MOVE);
		}
		

		// Setting the position of the right eye
		
		if (GMath.distance(RIGHT_CENTER.getX(),RIGHT_CENTER.getY(), 
				e.getX(), e.getY() ) <= MAX_MOVE ) {
			
			rightEye.setLocation(e.getX(), e.getY());
			
		} else {
			
			double rightAngle  = GMath.angle(RIGHT_CENTER.getX(), RIGHT_CENTER.getY(),
					e.getX(), e.getY());
			
			rightEye.setLocation(RIGHT_CENTER.getX()-EYE_RADIUS+GMath.cosDegrees(rightAngle)*MAX_MOVE, 
					RIGHT_CENTER.getY()-EYE_RADIUS-GMath.sinDegrees(rightAngle)*MAX_MOVE);
			
		}
	}
	

	/* Private instance variables */

	GOval leftEye;
	GOval rightEye;


	/* Constants */
	
	private static final GPoint LEFT_CENTER= new GPoint(350, 250); // Center of the left eye 
	private static final GPoint RIGHT_CENTER= new GPoint(550, 250);// Center of the right eye 
	private static final int EYE_RADIUS = 5;
	private static final int MAX_MOVE = 30;  // Maximum displacement of the eyes from the original location
	
	
}