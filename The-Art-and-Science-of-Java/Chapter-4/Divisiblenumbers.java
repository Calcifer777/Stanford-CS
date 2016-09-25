/* Displays numbers divisible by 6 or 7 */

import acm.program.*;

public class Divisiblenumbers extends ConsoleProgram {
	public void run() {
		int n = readInt("Enter n: ");
		for (int i=1;i<=n;i++) {
			if (i % 6 == 0 || i % 7 == 0) {
				println(i);
			}
		}
	}

}
