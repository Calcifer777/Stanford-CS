
/* SignalTower class used to implement the beacons of Gondor program.
 * The method Lightcurrenttower() uses a stub in this version.
 * 
 * The art and science of Java, chapter 7
 */


/* Class: SignalTower */
/**
* This class defines a signal tower object that passes a message
* to the next tower in a line.
*/

public class SignalTower {
	/* Constructor: SignalTower(name, link) */
	/**
	* Constructs a new signal tower with the following parameters:
	*
	* @param name The name of the tower
	* @param link A link to the next tower, or null if none exists
	*/
	public SignalTower(String name, SignalTower link) {
		towerName = name;
		nextTower = link;
	}
/* Method: signal() */
/**
* This method represents sending a signal to this tower. The effect
* is to light the signal fire here and to send an additional signal
* message to the next tower in the chain, if any.
*/
	public void signal() {
		lightCurrentTower();
		if (nextTower != null) nextTower.signal();
	}

/* Method: lightCurrentTower() */
/**
* This method lights the signal fire for this tower. This version
* supplies a temporary implementation (typically called a "stub")
* that simply prints the name of the tower to the standard output
* channel. If you wanted to redesign this class to be part of a
* graphical application, for example, you could override this
* method to draw an indication of the signal fire on the display.
*/
	public void lightCurrentTower() {
		System.out.println("Lighting " + towerName);
	}

	/* Private instance variables */
	private String towerName; /* The name of this tower */
	private SignalTower nextTower; /* A link to the next tower */
}