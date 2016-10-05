
import acm.graphics.*;

public class GCalendar extends GCompound{
	
	/** Defines a new GObject class that displays a calendar of a month.
	* @param width The width of the object
	* @param height The width of the object
	* @param days The days in the month
	* @param firstday The day of the week on which the month starts 
	* (Sunday = 1, Monday = 2, Tuesday = 3, and so on)  
	*/
	
	public GCalendar(double width, double height, int days, int firstDay) {
		
		
		/* Number of rows */
		
		int flag = firstDay+days-1;
		
		int rows = 0; 
		
		if (flag==28) {
			rows = 4;
		} else if (flag <=35) {
			rows = 5;
		} else {
			rows=6;
		}

		/* Labels and cells dimensions */
		
		int dayLabelHeight = (int) height/8;
		int gridHeight = (int) height-dayLabelHeight;
		
		/* Size of each calendar cell. Converted to integers 
		 * otherwise some vertical lines might appear thicker */
		
		int cellHeight = (int) gridHeight/rows;
		int cellWidth = (int) width/7;
		
		int fontSize = (int) 2*cellHeight/7;
		String font = "Sansserifs-bold-"+fontSize;
		
		
		/* Day labels */

		for (int i = 1 ; i <= 7 ; i++ ) {
			
			GLabel label = new GLabel("");
			
			switch (i) {
			case 1: 
				label.setLabel("SUN");
				break;
			case 2:
				label.setLabel("MON");
				break;
			case 3:
				label.setLabel("TUE");
				break;
			case 4:
				label.setLabel("WED");
				break;
			case 5:
				label.setLabel("THU");
				break;
			case 6:
				label.setLabel("FRI");
				break;
			case 7:
				label.setLabel("SAT");
				break;
			default: 
				label.setLabel("ERROR");
				break;
			}
			
			int labelWidth = (int) label.getWidth();
			int labelHeight = (int) label.getAscent();
			
			label.setFont("Sansserifs-bold-12");
			add(label, (i-1)*cellWidth+(cellWidth-labelWidth)/2,
					(dayLabelHeight+labelHeight)/2);
			
		}
		
		/* Draws the grid */
		
		for (int i = 1; i<=7 ; i++) { // i is the row number 	
			
			for (int j = 1; j<=rows ; j++) { 	// j is the column number
				
				/* Adds the cells */
				
				add( new GRect((i-1)*cellWidth,dayLabelHeight+(j-1)*cellHeight, cellWidth, cellHeight) );
				
				/* Adds the number of the day */ 
				
				if ( (i>= firstDay || j>1) && i+7*(j-1)-firstDay+1<=days ){
				
					GLabel number = new GLabel(Integer.toString(i+7*(j-1)-firstDay+1));
					number.setFont(font);
					add( number, (i-1)*cellWidth+cellWidth/10,
							dayLabelHeight+(j-1)*cellHeight+number.getAscent()+cellHeight/10);
					
				}
			
			}
		
		}
		
	}
	
}
