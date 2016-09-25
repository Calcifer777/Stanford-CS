/* Program that bounces a ball inside the boundaries of the
graphics window. */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class BouncingBall extends GraphicsProgram {
	
	public void run() {
		
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		
		/* The ball */
		
		GOval ball = new GOval( BALL_DIAMETER, BALL_DIAMETER );
		ball.setFilled(true);
		ball.setFillColor(Color.RED);
		add( ball, (WINDOW_WIDTH-BALL_DIAMETER)/2 , (WINDOW_HEIGHT-BALL_DIAMETER)/2);
		
		
		/* Animation */

		double dx = DX;
		double dy= DY;
		
		while (true) {
			

			if ( ball.getX()+BALL_DIAMETER >= WINDOW_WIDTH || ball.getX() <= 0 ) {
				
				dx*=-1;
				
			}
			
			if ( ball.getY()+BALL_DIAMETER >= WINDOW_HEIGHT || ball.getY() <= 0 ) {
				
				dy*=-1;
				
			}
			
			
				
			ball.move(dx,dy);
			pause ( PAUSE_TIME);
			
			
		}
		
	}

	private static final int BALL_DIAMETER = 40;
	private static final int WINDOW_HEIGHT= 450;
	private static final int WINDOW_WIDTH = 800;
	private static final double PAUSE_TIME = 5;
	private static final int DX = 1;
	private static final int DY = 1;
}
