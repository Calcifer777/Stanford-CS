
import acm.program.*;

public class Bottles extends ConsoleProgram {
	
	public void run() {
		int bottles = readInt("Enter bottles number: ");
		for (int i=bottles;i>=1;i--) {
			println(i+" bottles of beer on the wall.");
			println(i+" bottles of beer.");
			println("You take one down, pass it around.");
		}
		println("we have no more bottles, we done.");
	}

}
