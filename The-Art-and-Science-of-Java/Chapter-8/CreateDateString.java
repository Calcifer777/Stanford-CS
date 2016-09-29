/* Returns a string consisting of the day of the month, 
 * a hyphen, the first three letters in the name of
 * the month, another hyphen, and the last two digits 
 * of the year.
 */

import acm.program.*;

public class CreateDateString extends ConsoleProgram {
	
	public void run() {
		
		println("Returns a string converted date. Enter a void line to exit.");
	
		while (true) {
			
			day = readLine("Enter the day: ");
			month = readLine("Enter the month: ");
			year = readLine("Enter the year: ");
			
			if( day=="" || month.equals("")|| year.equals("")) break;
			
			println(createDateString(day, month, year));
			
		}
		
		System.exit(0);

	}
	
	private String createDateString(String day, String month, String year) {

		return day+"-"+month.substring(0,3).toLowerCase()+"-"+year.substring(year.length()-2);
		
	}
	

	/* Instance variables */
	
	private String day,year,month;
	
}
