

/* This toy program prints either as java applet or java 
 * application the "Hello, world" string
 * */

import acm.graphics.*;
import acm.program.*;

public class ILoveJava extends GraphicsProgram {
	private static final long serialVersionUID = 8183546252076407706L;

	public void run() {
		GLabel love = new GLabel("I love Java : /");
		love.setFont("Times-24");
		GLabel signature = new GLabel("My Signature");
		signature.setFont("Times-24");
		add(love, 25,75);
		add(signature,120, 175);
		
	}
	

}
