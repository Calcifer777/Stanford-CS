
import acm.program.*;
import java.awt.Color;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;
import java.awt.*;

/** Plays the game of NIM */

public class Nim extends GraphicsProgram {

	/** Initializes the game, setting the window size, adding the coins and 
	 * the mouse listeners.*/
	public void init() {
		
		setSize(WIDTH, HEIGHT);
		
		coinArray = createCoins(COIN_NUMBER);
		
		printCoinArray(coinArray);
		
		addMouseListeners();
		count = COIN_NUMBER;
		flag = false;
	}
	
	/** Runs the game. If the flag is true, it plays the PC's turn; otherwise it waits
	 * for the user's input */
	public void run() {
		
		while (true) {
			
			
			if (flag) {

				checkCount(count,flag);		// Checks if the player lost
				if (count==0) break;
				
				playTurn(count);			// Plays the pc turn, given the number of remaining coins
				
				checkCount(count,flag);		// Checks if the computer lost
				if (count==0) break;
			
			} else {

				pause(1000);
								
			}
			
		}
		
	}
	
	/** Create the array of GOvals / coins 
	 * @param number The length of the array to create */	
	private GOval[] createCoins(int number) {
		
		double diameter = ( WIDTH-OFFSET*(COIN_NUMBER+1)) / COIN_NUMBER;
		
		GOval[] coinArray = new GOval[number];
		
		for (int i = 0; i < number; i++){
			
			coinArray[i] = new GOval(diameter, diameter);
			
		}
		
		return coinArray;
		
	}
	
	/** Draws the array 
	 * @param array The array of object to be added to the canvas*/
	private void printCoinArray(GOval[] array) {
		
		for (int i = 0 ; i < array.length; i++) {
			
			add(array[i], OFFSET+(array[i].getWidth()+OFFSET)*i, (HEIGHT-array[i].getWidth())/2);
			array[i].setFilled(true);
			array[i].setColor(Color.RED);
			
		}
		
	}
	
	/** Checks the number of remaining coins. If 0, prints an end game message 
	 * @param n The number of coins left
	 * @param flag Determines whose turn is the one just concluded. True is the player's; 
	 * false is the PC's*/
	private void checkCount(int n, boolean flag){
		
		if (n==0 && !flag)  {
			
			
			winScreen.setFont("Monaco-bold-32");
			winScreen.setColor(Color.RED);
			GPoint labelLocation = new GPoint( (WIDTH-winScreen.getWidth())/2,
					(HEIGHT-winScreen.getAscent())/ 2);
			add(winScreen, labelLocation); 
			
		}
		
		if (n==0 && flag)  {
			
			loseScreen.setFont("Monaco-bold-32");
			loseScreen.setColor(Color.RED);
			GPoint labelLocation = new GPoint( (WIDTH-loseScreen.getWidth())/2,
					(HEIGHT-loseScreen.getAscent())/ 2);
			add(loseScreen, labelLocation); 
			
		}
		
		
	}
	
	/** Plays the computer turn 
	 * @param n is the number of coins left in play*/	
	private void playTurn(int n) {
		
		// println("TURN OF THE PC");
			
		int coinsToRemove = coinsToRemove(n);
		
		// println("Coins left "+count);
		// println("Coins to remove: "+coinsToRemove);
		
		pcRemoveCoins(n, coinsToRemove);
	}
	
	/** Calculates how many coins to remove 
	 * @param n The number of coins left in the game */ 
	private int coinsToRemove(int n) {
		
		int coinsToRemove=0;
		
		if (n == 1) {
			
			coinsToRemove=1;
			
		} else if ( (n-1)%4==0) {
			
			coinsToRemove = rgen.nextInt(1,3);
		
		} else {
			
			coinsToRemove = (n-1)%4;
		}
		
		return coinsToRemove;
	}
	
	/** Removes the coins after the PC has made its decision.  Colors the coins to remove in yellow, 
	 * removing them after two seconds. 
	 * @param n The number of  coins left
	 * @param coinsToRemove The number of coins to remove*/
	private void pcRemoveCoins(int n, int coinsToRemove) {
		
		for (int i = n-1; i > n-1-coinsToRemove; i--) {
			coinArray[i].setFillColor(Color.YELLOW);
			pause(1000);
		}
		
		pause(2000);
			
		for (int i = n-1; i > n-1-coinsToRemove; i--) {
			
			remove(coinArray[i]);
		
		}
		
		count-=coinsToRemove;
		
		// println("Coins left after the PC turn: "+count);
		
		flag=false;

		
	}
	
	/** Called any time the mouse is pressed */
	public void mousePressed(MouseEvent e){
		
		// println("TURN OF THE PLAYER");

		// println("Coins left: " + count);
		
		/* Returns the selected object */
		
		selectionIndex = currentSelection(e.getPoint());
		// println(selectionIndex);
		/* If the selected object is admissible, it colors it and every object 
		 * on its right of a darker shade of red. */
		
		if (selectionIndex >= 0) {
			int coinsToRemove = count-selectionIndex;
			coinsHighlight(count, coinsToRemove);
		}
			
		
			
	}
	
	/** Returns the index of the coin selected when the mouse is pressed, 
	 * provided that is an admissible move for the player */
	private int currentSelection(Point point) {
		
		int index =-1;
		
		last = new GPoint(point.getLocation());
		// println(last);
		gobj = getElementAt(last);
		// println(gobj.toString());
		
		if (gobj!=null) {

			for (int i = count-1 ; i >=0 ; i--) {
				
				if (gobj.equals(coinArray[i])) {
					index = i;
					// println("Coin selected: "+(selectionIndex+1));
					// println("Index coin selected: "+selectionIndex);
				}
			}

		} else {
			
			 // println("No coin selected");
			
		}
		
		// println("Index: " + index);
		return index;
	}
	
	/** Highlights the coins to be removed */
	private void coinsHighlight(int n, int coinsToRemove) {
		
		if (coinsToRemove <=3) {
			
			for (int i = selectionIndex; i < n ; i++) {
				coinArray[i].setColor(DARK_RED);
			}
			
			for (int i = 0; i < selectionIndex; i++) {
				coinArray[i].setColor(Color.RED);
			}
		
		} else {
			
			 // println("Invalid selection");
		}
		
	}
	
	/*Called on mouse released */
	public void mouseReleased(MouseEvent e){
		
		pause(1000);
		
		// println(selectionIndex);
		// println(count);
		
		if (count-selectionIndex<=3 && selectionIndex>=0) {
		
			for (int i = selectionIndex ;  i < count ; i++) {
				
					remove(coinArray[i]);
					// println("Coins left after the player's turn: "+count);
			}
			
			count = selectionIndex;
			flag=true;
			
		}
		
	}
	
	
	/* Random generator*/
	RandomGenerator rgen = new RandomGenerator();
	
	/* Instance variables */
	private boolean flag= true;
	private GOval[] coinArray;
	private int count, selectionIndex;
	private GPoint last;
	private GObject gobj;
	private GLabel winScreen = new GLabel("YOU WIN!");
	private GLabel loseScreen = new GLabel("THE PC WINS");

	/* Constants */
	private static final int COIN_NUMBER = 11;
	private static final int WIDTH = 600;
	private static final int HEIGHT = 300;
	private static final int OFFSET = 5;
	private static final Color DARK_RED = new Color(200, 0, 0);
	
	
}
