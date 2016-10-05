
import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

/*
* This program puts up a button on the screen, which triggers a
* message inspired by Douglas Adams's novel.
*/

public class HitchhikerButton extends ConsoleProgram {

	/* Initializes the user-interface buttons */

	public void init() {

		add(new JButton("Red"), SOUTH);

		addActionListeners();

	}

	/* Responds to a button action */

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Red")) {
	
			println("Please do not press this button again.");

		}

	}
}