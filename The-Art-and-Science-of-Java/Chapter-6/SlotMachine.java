
/* Program that simulates playing a slot machine. The program
provides the user with an initial stake of $50 and then let the user play
until either the money runs out or the user decides to quit. During each round,
the program takes away a dollar, simulate the spinning of the wheels,
evaluate the result, and pay the user the appropriate winnings. */


import acm.program.*;
import acm.util.*;

public class SlotMachine extends ConsoleProgram{

	public void run() {
	
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		/* Initial info and instructions */
		
		if (readLine("Would you like some instructions? ").equalsIgnoreCase("yes")) {
			
			println("You are about to play at the slot machines. "+
			"You start with 50 coins and each roll costs 1$. "+
					"The game ends when you type 'exit' or when you lose");
		
		}
		
		println("");

		int cash = INITIAL_CASH;
		
		/* The game */
		
		while (true) {
			
			turnCount++;
			println("Turn "+turnCount);
			
			if(readLine("You have "+cash+"$. Would you like to play"+
			( (turnCount>1)?" again":"" ) +"?").equalsIgnoreCase(FLAG)) break;
			
			cash--;
			
			/* Rolling the machine*/
			
			result1 = rgen.nextInt(1, 6);		
			result2 = rgen.nextInt(1, 6);
			result3 = rgen.nextInt(1, 6);
			
			prize = prize(result1,result2,result3);
			
			
			println( rollToString(result1) + " " + rollToString(result2) + " " + rollToString(result3) +
					"  --  " + ((prize>0)?"You win "+prize+"$":"You lose") + "." );
			println("");
			
			cash+=prize;
			
			
		}
	}
		
	
	/* Method to convert rgen numbers in slot machine labels*/
	
	private String rollToString(int x) {
			
		switch (x) {
		case 1: return "BAR";
		case 2: return "BELL";
		case 3: return "PLUM";
		case 4: return "ORANGE";
		case 5: return "CHERRY";
		case 6: return "LEMON";
		default: return "ERROR";
		}
		
		
	}
	
	/* Method to convert rolls into cash outcomes */
	
	private int prize(int x, int y, int z) {
		
		if (x==5 || y==5 || z==5) { // CHERRY //
			
			if ( (x==5 && y==5) || (y==5 && z==5) || (x==5 && z==5) ) {
				
				if (x==5 && y==5 && z==5) {
					
					return 7;
					
				} else {
					
					return 5;
				}
				
			} else {
				
				return 2;
			
			}
		
		} else if ( ((x==4 && y==4) || (y==4 && z==4) || (x==4 && z==4) ) ) { // 2 x ORANGE //
			
			if ( (x==4 && y==4 && z==4) || x==1 || y==1 || z==1 ) { // + BAR/ORANGE //
				
				return 10;
				
			} else { // + ELSE //
				
				return 0;
				
			}
		} else if ( ((x==3 && y==3) || (y==3 && z==3) || (x==3 && z==3) ) ) { // 2 x PLUM + ...//
			
			if ( (x==3 && y==3 && z==3) || x==1 || y==1 || z==1 ) { // + BAR/PLUM //
				
				return 14;
				
			} else { // + ELSE //
				
				return 0;
				
			}
		} else if ( ((x==2 && y==2) || (y==2 && z==2) || (x==2 && z==2) ) ) { // 2 x BELL + ...//
			
			if ( (x==2 && y==2 && z==2) || x==1 || y==1 || z==1 ) { // + BAR/BELL //
				
				return 20;
				
			} else { // + ELSE //
				
				return 0;
				
			}
		} else if ( x==1 && y==1 && z==1 ) {
			
			return 250;
		
		} else {
			
			return 0;
		
		}
	}
	
	
	RandomGenerator rgen = new RandomGenerator();
	
	private static final int INITIAL_CASH = 50;
	private static final int WINDOW_HEIGHT = 600;
	private static final int WINDOW_WIDTH = 350;
	private static final String FLAG="exit";
	private static int turnCount, result1, result2, result3, prize;
}
