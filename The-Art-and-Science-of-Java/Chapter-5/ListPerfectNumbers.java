/* Lists all perfect numbers.*/

import acm.program.*;

public class ListPerfectNumbers extends ConsoleProgram {
	
	public void run() {
	
		println("This program lists all perfect nubmers");
		
		println("Perfect numbers less than n:");
		
		int i=1;
		
		while(true) {
			
			if (isPerfect(i)) {
				println(i);
				String flag = readLine("Search another perfect?");
				if (flag.equalsIgnoreCase("No")) break;
			}
			
			i++;
		}
		
		
		
		
	}
	
	
	/* Checks whether n is a perfect number*/
	
	private boolean isPerfect( int n) {
		boolean test;
		int sum = 0;
		for (int i =1 ; i < n ; i++) {
			if (n%i==0) {
				sum+=i;
			}
			
		}
		
		test = (sum==n) ? true : false;
		
		return test;
		
	}
}
