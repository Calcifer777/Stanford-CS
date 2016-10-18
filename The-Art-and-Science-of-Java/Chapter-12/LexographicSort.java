import java.util.ArrayList;
import acm.program.*;

/**
* Sorts a String array into lexographic order. The implementation uses
* an algorithm called selection sort.
*/
public class LexographicSort extends ConsoleProgram {

	public void run() {
		
		/* Initializing the string list */
		nameList.add("marco");
		nameList.add("giacomo");
		nameList.add("giovanni");
		nameList.add("luca");
		nameList.add("andrea");
		
		println("Name list: "+nameList);
		
		stringSort(nameList);
		
		println("Name list: "+ nameList );
		
	}
	
	/* Modification of the selection sort method*/ 
	private void stringSort(ArrayList<String> array) {
	
		for (int lh = 0; lh < array.size(); lh++) {
	
			int rh = findSmallest (array, lh, array.size());
	
			swapElements(array, lh, rh);
	
		}
		
	}
	
	/* Returns the index of the smallest array element between p1 and p2 - 1 */
	private int findSmallest(ArrayList<String> array, int p1, int p2) {
	
		int smallestIndex = p1;
	
		for (int i = p1 + 1; i < p2 ; i++) {
	
			if ( array.get(i).compareToIgnoreCase(array.get(smallestIndex))<0  ) smallestIndex = i;
	
		}
	
		return smallestIndex;
	}
	
	/* Exchanges the elements in an array at index positions pi and p2. */
	private void swapElements(ArrayList<String> array, int p1, int p2) {
		
		String temp = array.get(p1);
		
		array.set(p1, array.get(p2));
		
		array.set(p2, temp );
	
	}
	
	private ArrayList<String> nameList = new ArrayList<String>();
	
}
