
import acm.program.*;

public class IsSorted extends ConsoleProgram {

	public void run() {
		
	}
	
	/** Checks whether an array of integers is sorted in ascending order*/
	private boolean isSorted(int[] array ){
		
		for (int i = 1 ; i <= array.length ; i++ ) {
			
			if (array[i]<array[i-1]) return false;
			
			
		}
		
		return true;
		
		
	}

}
