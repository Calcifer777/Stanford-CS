/*
* File: Breakout.java
* -------------------
* This file implements the game of Break-out. Move the paddle with arrow keys or with the mouse.
*/
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;


public class Breakout extends GraphicsProgram {

	/* Initializes the game */ 
	
	public void init() {
		
		setSize(APPLICATION_WIDTH,APPLICATION_HEIGHT);
		
		/* Creating the game objects */
		createBricks();
		createPaddle();
		createBall();
		
		/* Adding key and mouse listeners*/
		addKeyListeners();
		addMouseListeners();
				
		/* Initializing the turns*/
		turn=0;
		brickCount=0;
		
		/* Initializing the status of the game. The game is paused at the start.
		 * Press space bar to start.*/
		gamePaused =true;
		
		/* Pause time between each loop refresh*/
		pauseTime = INIT_PAUSE_TIME;
		
		/* Initializing the speed of the ball*/
		vx = rgen.nextDouble(0.5, 2.5);
		if (rgen.nextBoolean(0.5)) vx = -vx;
		vy=1;
		
		/* Adding a GLabel on the top right of the window that 
		 * records the turns left. */
		
		turnsLeft = new GLabel("Turns left: "+ (NTURNS-turn));
		add(turnsLeft, WIDTH-turnsLeft.getWidth()-5, turnsLeft.getAscent()+5);
		
		/* Adding a GLabel on the top left of the window that 
		 * records the score. */
		
		score = new GLabel("Score: "+ brickCount);
		add(score, 5, turnsLeft.getAscent()+5);
		
	}

	/* Runs the game */
	
	public void run() {
				
		while(true) {
			
			if (gamePaused==false) {
			
				checkBoundaries();
				
				GObject collider = getCollidingObject();
				
				/* If the ball bounces on the paddle, bounce the ball upwards */
				if (collider == paddle ) getPaddleCollisionOutcome();
					
 				/* If the ball bounces on a brick, bounce the ball
 				 * according to the brick location and [remove] the brick */
				
				if (collider != null && collider != paddle 
						&& collider!=turnsLeft && collider != score) {
					getBrickCollisionOutcome(collider);
				}
				
				ball.move(vx,vy);
				pause(pauseTime);
				
				/* Increase the vertical velocity at the end of each refresh*/
				vy*=1.00005;
				
				
				/* Checks the win condition */
				checkWinCondition();
				
				/* Checks the current turn. After 3 turns the game is over. */
				checkDefeat();

			} else {
				
				pause (100);
			}
			
		}
		
	}
	
	/** Creates the bricks*/
	private void createBricks() {
		
		for (int i = 0 ; i < NBRICK_ROWS; i++ ) {
			
			for (int j = 0 ; j < NBRICKS_PER_ROW; j++ ) {
				
				
				GRect brick = new GRect(BRICK_WIDTH,BRICK_HEIGHT);
				brick.setLocation(BRICK_SEP+j*(BRICK_WIDTH+BRICK_SEP), BRICK_Y_OFFSET+i*(BRICK_HEIGHT+BRICK_SEP));
				brick.setFilled(true);
				
				switch (i) {
				case 0: case 1: brick.setColor(Color.red); break;
				case 2: case 3: brick.setColor(Color.orange); break;
				case 4: case 5: brick.setColor(Color.yellow); break;
				case 6: case 7: brick.setColor(Color.green); break;
				case 8: case 9: brick.setColor(Color.cyan); break;
				}
				
				add(brick);
			}	
		}
	}

	/** Creates the paddle 
	 */
	private void createPaddle() {
		
		paddle = new GRect(PADDLE_WIDTH,PADDLE_HEIGHT);
		paddle.setLocation((WIDTH-PADDLE_WIDTH)/2, HEIGHT-PADDLE_Y_OFFSET-PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle);
		
	}

	/** Creates the ball 
	 * */
	private void createBall() {
		
		ball = new GOval(BALL_RADIUS*2, BALL_RADIUS*2);
		ball.setFilled(true);
		ball.setColor(Color.DARK_GRAY);
		//ball.setLocation(WIDTH/2-BALL_RADIUS, HEIGHT/2-BALL_RADIUS);
		ball.setLocation(WIDTH/2-BALL_RADIUS, HEIGHT/2-BALL_RADIUS);
		add(ball);
		
	}
	
	/** Returns any objects colliding with the ball. Returns any object colliding
	 * with the ball. Returns null is no object is found.
	 */ 
	private GObject getCollidingObject() {
		
		for (int i = 0; i <=1 ; i++) {
			
			for (int j = 0; j <=1 ; j++) {
			
				if (getElementAt(ball.getX()+2*j*BALL_RADIUS, 
						ball.getY()+2*i*BALL_RADIUS)!=null) {
					
					return getElementAt(ball.getX()+2*j*BALL_RADIUS, 
							ball.getY()+2*i*BALL_RADIUS);
						
				}
				
			}
			
		}
		
		return null;
		
	}
	
	/** Checks for any collision with the boundaries. If the 
	 * ball is beyond the bottom edge of the window, decreases the number
	 * of lives and returns the ball to the center, with the game paused */
	private void checkBoundaries() {
		
		if ( (ball.getX()+2*BALL_RADIUS >= APPLICATION_WIDTH && vx>0) // If beyond right edge AND moving right
				|| (ball.getX() <= 0 && vx<0)  ) { 	// ... or beyond left edge AND moving left	
			
			vx*=-1;		// Change horizontal velocity
			
		} else if ( ball.getY() <= 0 && vy<0) { // If beyond top edge AND going upwards
			
			vy*=-1; 	// Change vertical velocity
			
		} else if ( ball.getY() + 2*BALL_RADIUS >= APPLICATION_HEIGHT) { // If beyond bottom edge
			
			/* Reset the game to the initial state*/ 
			gamePaused=true;
			vx = rgen.nextDouble(0.5, 2.5); // ...and generate a new speed vector
			if (rgen.nextBoolean(0.5)) vx = -vx;
			vy=1;
			
			ball.setLocation(WIDTH/2-BALL_RADIUS, HEIGHT/2-BALL_RADIUS);
			
			turn++;				// Update the turn count
			turnsLeft.setLabel("Turns left: "+ (NTURNS-turn));
					
		}
		
	}
	
	/** Changes the direction of the ball when a collision with the paddle occurs 
	 */
	private void getPaddleCollisionOutcome() {
		
		/* Collisions from above only */
		
		double offset = (ball.getX()+BALL_RADIUS-paddle.getX()-PADDLE_WIDTH/2) / (PADDLE_WIDTH/2);
		
		if (ball.getY()+2*BALL_RADIUS>=paddle.getY() && ball.getX()>=paddle.getX() 
				&& ball.getX()+BALL_RADIUS*2>=paddle.getX() && vy>0) {
			vy*=-1;
			
			/* Adjusting the horizontal velocity based on which section of the paddle
			 * the ball has collided with */
			vx= offset*2;
			return;
		}
		
		/* Side collisions with the paddle from the left [ BALL  -> PADDLE ] */
		
		if (ball.getX()<paddle.getX() && ball.getX()+BALL_RADIUS*2>paddle.getX()) {
			vx= offset*2;
			if (vy>0) vy*=-1;
		}
		
		/* Side collisions with the paddle from the right [ PADDLE <- BALL ]*/
		
		if (ball.getX()>paddle.getX() && paddle.getX()+PADDLE_WIDTH+BALL_RADIUS*2>=ball.getX()) {
			vx= offset*2;
			if (vy>0) vy*=-1;
		}
	}
	
	/** Changes the direction of the ball when a collision with a brick occurs 
	 */
	private void getBrickCollisionOutcome(GObject collider) {
		
		if (collider.getY() <= ball.getY() && vy<0) { // Collision from below, ball moving up
			vy*=-1;
		} else if (collider.getY() >= ball.getY() && vy>0) { // Collision from above, ball down
			vy*=-1;
		} else if ( ball.getX() >= collider.getX()   
				&& vx<0) { // Collision from the right, ball moving left
			vx*=-1;
		} else if ( ball.getX() <= collider.getX()   
				&& vx>0) { // Collision from the left, ball moving right
			vx*=-1;
		}
		
		remove(collider);
		brickCount++;
		
		score.setLabel("Score: "+brickCount);
	}
	
	/** Checks the win condition 
	 */
	private void checkWinCondition() {
		
		if (brickCount == NBRICKS_PER_ROW*NBRICK_ROWS) {
			
			gamePaused = true;
			GLabel victory = new GLabel("You won!!!");
			victory.setFont("Calibri-bold-50");
			victory.setColor(Color.red);
			add(victory, (WIDTH-victory.getWidth())/2, 
					(HEIGHT-victory.getAscent())/2  );
		
		}
	}
	
	/** Checks whether the game is lost 
	 */	
	private void checkDefeat() {
		if (turn == NTURNS) {
			
			gamePaused = true;
			ball.setVisible(false);
			GLabel defeat = new GLabel("GAME OVER");
			defeat.setFont("Calibri-bold-50");
			defeat.setColor(Color.red);
			add(defeat, (WIDTH-defeat.getWidth())/2, 
					(HEIGHT-defeat.getAscent())/2  );
		}
	}
	
	/** Called when a key is pressed 
	 */
	public void keyPressed( KeyEvent key) {
		
		switch (key.getKeyCode()) {
		case (KeyEvent.VK_RIGHT) : 	// Right arrow to move the paddle left
			if (paddle.getX()<=WIDTH-PADDLE_WIDTH-BRICK_SEP) paddle.move(PADDLE_SPEED, 0);  break;
		case (KeyEvent.VK_LEFT) : 	// Left arrow to move the paddle left
			if (paddle.getX()>=BRICK_SEP)	paddle.move(-PADDLE_SPEED, 0);  break;
		case (KeyEvent.VK_SPACE):	// Space to pause and unpause the game
			if ( gamePaused == false ) gamePaused = true;
			else if ( gamePaused == true ) gamePaused = false; break;
		case (KeyEvent.VK_ESCAPE): System.exit(0); // Esc to exit the game
		}
		
	}
	
	/** Called when the mouse is moved inside the applet window 
	 */
	public void mouseMoved(MouseEvent e) {
		
		if (e.getX()-PADDLE_WIDTH/2>0 && e.getX()+PADDLE_WIDTH/2<WIDTH)  {
			paddle.setLocation(e.getX()-PADDLE_WIDTH/2,HEIGHT-PADDLE_Y_OFFSET-PADDLE_HEIGHT);
		} else if (e.getX()-PADDLE_WIDTH/2<=0) {
			paddle.setLocation(0,HEIGHT-PADDLE_Y_OFFSET-PADDLE_HEIGHT);
		} else if (e.getX()+PADDLE_WIDTH/2>=WIDTH) {
			paddle.setLocation(WIDTH-PADDLE_WIDTH,HEIGHT-PADDLE_Y_OFFSET-PADDLE_HEIGHT);
		}
		
	}
	
	/** New instance of the RandomGenerator 
	 */
	RandomGenerator rgen = new RandomGenerator();
	
	/** Private instance variables */
	
	private GRect paddle;
	private GOval ball;
	private GLabel turnsLeft, score;
	
	boolean gamePaused;		// Starts and stops the game
	private double vx, vy, pauseTime;
	private int turn, brickCount;
	
	/** Constants */
	/** Width and height of application window in pixels */

	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;
	
	/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;
	
	/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;
	
	/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;
	
	/** Paddle speed, in pixels per frame */
	private static final int PADDLE_SPEED = 12;
	
	/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;
	
	/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;
	
	/** Separation between bricks */
	private static final int BRICK_SEP = 4;
	
	/** Width of a brick */
	private static final int BRICK_WIDTH =
	(WIDTH - (NBRICKS_PER_ROW + 1) * BRICK_SEP) / NBRICKS_PER_ROW;
	
	/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;
	
	/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 6;
	
	/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

	/** Number of turns */
	private static final int NTURNS = 3;

	/** Pause between each loop refresh */
	private static final int INIT_PAUSE_TIME = 5;
}
