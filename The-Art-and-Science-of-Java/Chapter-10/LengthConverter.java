
import acm.gui.*;
import acm.program.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/** This program displays a lenght converter of several unit measures. It gives the 
 * third decimal digit approximation of the conversion.*/
public class LengthConverter extends Program {
	
	public void init() {
		
		setLayout(new TableLayout(3,2));
		
		
		leftChooser = new JComboBox();
		initMeasureChooser(leftChooser, UNITS);
		add(leftChooser);
		
		rightChooser = new JComboBox();

		initMeasureChooser(rightChooser, UNITS);
		add(rightChooser);
		
		leftField = new DoubleField();		// (2,1) Left JTextField 
		leftField.setActionCommand("Convert ->");
		addActionListeners(this);
		add(leftField);
		
		rightField = new DoubleField();		// (2,2) Right JTextField
		rightField.setActionCommand("<- Convert");
		addActionListeners(this);
		add(rightField);
		
		add( new JButton(leftButton));	// (3,1) Left converter JButton
		add( new JButton(rightButton));	// (3,2) Right converter JButton 
		
		addActionListeners();
		
	}
	
	/** Sets up the JCombobox
	 *@param box The JComboCox to which to add the list.
	 *@param list The list of the elements to add. It is a string, 
	 *using spaces or commas as delimiters*/ 
	private void initMeasureChooser(JComboBox box, String list) {
		
		StringTokenizer tokenizer = new StringTokenizer(list, " ,;", false);
		
		while (tokenizer.hasMoreTokens()) {
			
			String token = tokenizer.nextToken();
			
			if (!Character.isDigit(token.charAt(0))) {

				box.addItem(token);
			
			}
		}
		
		box.setEditable(false);
	}
	
	/** Unit converter.
	 *@param n1 The measure to be converted.
	 *@param unit1 The unit of the measure to be converted. 
	 *@param unit2 The unit of the measure in which to convert. 
	 **/
	private double converter(double n1, String unit1, String unit2) {
		
		StringTokenizer tokenizer = new StringTokenizer(UNITS, " ,;-", false);
		double n1Converted=0;
		
		while(true) {
			
			String token = tokenizer.nextToken();
			
			if (token.equals(unit1)) {
				
				double unitToInches =Double.parseDouble(tokenizer.nextToken());
				//	System.out.println("unitToInches : "+unitToInches);
				n1Converted = n1*unitToInches;
				//	System.out.println("n1Converted : "+n1Converted);
				break;
				
			}
			
		}
		
		tokenizer = new StringTokenizer(UNITS, " ,;-", false);
		
		while(tokenizer.hasMoreTokens()) {
			
			String token = tokenizer.nextToken();
			
			if (token.equals(unit2)) {
				
				double inchesToUnit =Double.parseDouble(tokenizer.nextToken());
				//	System.out.println("inchesToUnit : "+inchesToUnit);
				return n1Converted/inchesToUnit;
				
			}
			
		}
		
		return 0;
		
	}
	
	/**Listens for a button action
	 */
	public  void actionPerformed(ActionEvent e) {
		
		String cmd = e.getActionCommand();

		if (cmd.equals(leftButton) && !leftField.getText().equals("")) {
			
			String unit1 = leftChooser.getSelectedItem().toString();
			//	System.out.println("unit1"+unit1);
			String unit2 = rightChooser.getSelectedItem().toString();
			//	System.out.println("unit2"+unit2);
			double n1 = leftField.getValue();
			double n = converter(n1,unit1,unit2);
			int nToInteger = (int) (n*10^APPROX_DIGIT);
			rightField.setValue((double) nToInteger/(10^APPROX_DIGIT));	// approximate to the nth decimal digit
			
		} else if(cmd.equals(rightButton)&& !rightField.getText().equals("")) {
			
			String unit1 = rightChooser.getSelectedItem().toString();
			String unit2 = leftChooser.getSelectedItem().toString();
			double n1 = rightField.getValue();
			double n =converter(n1,unit2,unit1);
			int nToInteger = (int) (n*(10^APPROX_DIGIT));			// approximate to the nth decimal digit
			leftField.setValue((double) nToInteger/(10^APPROX_DIGIT));
		}
		
		
	}
	
	/* Private instance variables */
	
	private JComboBox leftChooser, rightChooser;
	private DoubleField leftField, rightField;
	private String leftButton = "Convert ->";
	private String rightButton = "<- Convert";
	
	
	/* Constants */
	
	/* The units in which and to which to convert. Each name is followed by that unit converted in
	 * inches.*/
	private static final String UNITS= "Inches, 1;  Feet, 12;  Yards, 36; Fathoms, 72;"+
			"Rods, 198; Furlongs , 7920; Miles, 63360";
	private static final APPROX_DIGIT = 3;
}
