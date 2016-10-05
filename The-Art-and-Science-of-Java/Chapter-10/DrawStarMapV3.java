
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import acm.program.GraphicsProgram;
import acm.graphics.*;

/**
* This program creates a five-pointed star every time the user clicks the
* mouse on the canvas. This version includes a JButton to clear the screen,
* a JSlider to choose the size, and a JComboBox to choose the color.
* 
* Uses the LabeledColor class.
* 
* Allows to: drag objects, move objects with the keyboard, enter a name for
* the selected star through a JTextField object.
*/

public class DrawStarMapV3 extends GraphicsProgram {
	
	/* Initializes the graphical user interface */
	
	public void init() {
	
		setBackground(Color.GRAY);
		setSize(800, 450);
		sizeSlider = new JSlider(MIN_SIZE, MAX_SIZE, INITIAL_SIZE);
		
		add(new JButton("Clear"), SOUTH);
		add(new JLabel(" Small"), SOUTH);
		add(sizeSlider, SOUTH);
		add(new JLabel("Large "), SOUTH);
		
		initColorChooser();
		add(colorChooser, SOUTH);

		nameField = new JTextField(MAX_STAR_NAME);
		nameField.addActionListener(this);
		add(new JLabel("Name"), SOUTH);
		add(nameField, SOUTH);
		
		addMouseListeners();
		addActionListeners();
		addKeyListeners();
		
	}
	
	/* Initializes the color chooser */
	
	private void initColorChooser() {
	
		colorChooser = new JComboBox();
		colorChooser.addItem(new LabeledColor( Color.WHITE, "White"));
		colorChooser.addItem(new LabeledColor( Color.RED, "Red"));
		colorChooser.addItem(new LabeledColor(Color.YELLOW, "Yellow"));
		colorChooser.addItem(new LabeledColor(Color.ORANGE, "Orange"));
		colorChooser.addItem(new LabeledColor( Color.GREEN, "Green"));
		colorChooser.addItem(new LabeledColor( Color.BLUE, "Blue"));
		colorChooser.addItem(new LabeledColor( Color.BLACK, "Black"));
		colorChooser.setEditable(false);
	
	}
	
	
	/* Returns the current size */
	
	private double getCurrentSize() {
	
		return sizeSlider.getValue();

	}
	
	/* Returns the current color */
	
	private Color getCurrentColor() {
		return (Color) colorChooser.getSelectedItem();
	}
	
	/* Called whenever the user clicks the mouse */
	
	public void mousePressed(MouseEvent e) {
		
		last = new GPoint(e.getPoint()); 
		gobj = getElementAt(last);
		
		println(gobj);
		
		if (gobj==null) {
			
			newStar = new GStar(getCurrentSize());
			newStar.setFilled(true);
			newStar.setColor(getCurrentColor());
			add(newStar, e.getX(), e.getY());
			lastStar=newStar;
		} 
		
	}
	
	public void mouseDragged( MouseEvent e) {
		
		if (gobj!=null) {
		
			gobj.move(e.getX()-last.getX(), e.getY()-last.getY());
			last = new GPoint(e.getPoint());
			
		}
	
	}
	
	/* Called whenever an action event occurs */
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Clear")) {
			removeAll();
		} 
		
		if (e.getSource() == nameField && lastStar!= null) {

			GLabel label = new GLabel(nameField.getText());
			label.setFont(nameField.getText());
			label.setLocation(lastStar.getX()+lastStar.getWidth(), 
					lastStar.getY()+lastStar.getHeight()/4);
			label.setColor(getCurrentColor());
			add (label);
		}
	}
	
	/* Called when a key is pressed */
	
	public void keyPressed( KeyEvent key) {
		
		if (gobj!=null) {
		
			switch (key.getKeyCode()) {
			
			case (KeyEvent.VK_UP): 		gobj.move(0, -1); break;
			case (KeyEvent.VK_DOWN): 	gobj.move(0, 1); break;
			case (KeyEvent.VK_LEFT): 	gobj.move(-1, 0); break;
			case (KeyEvent.VK_RIGHT): 	gobj.move(1, 0); break;
			case (KeyEvent.VK_DELETE): 	remove(gobj); break;
			
			}
		}
		
	}
	
		
	/* Private constants */
	
	private static final int MIN_SIZE = 1;
	private static final int MAX_SIZE = 50;
	private static final int INITIAL_SIZE = 16;
	private static final int MAX_STAR_NAME=20;
	
	/* Private instance variables */
	
	private JSlider sizeSlider;
	private JComboBox colorChooser;
	private JTextField nameField;
	
	private GPoint last;
	private GObject gobj;
	private GStar newStar;
	private GStar lastStar;
	
}