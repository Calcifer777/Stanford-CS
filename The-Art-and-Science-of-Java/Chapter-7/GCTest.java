

/* Program that measure the memory freed by the GarbageCollector utility */

import acm.program.*;

public class GCTest extends ConsoleProgram {
	
	private static int OBJECTNUMBER = 1000;
	
	public void run() {
				
		println("Allocating " + OBJECTNUMBER + " Rational objects.");
		
		for (int i=1;i<=OBJECTNUMBER; i++) {
			new Rational();
		}
		
		long freememory1 = myRuntime.freeMemory();
		
		myRuntime.gc();
		
		long freememory2 = myRuntime.freeMemory();
		
		println("Free memory before GC: "+freememory1+".");
		println("Free memory after GC: "+freememory2+".");
		println("Garbage collection freed: "+(freememory2-freememory1)+" bytes.");
	}
	
	Runtime myRuntime = Runtime.getRuntime();
		
}