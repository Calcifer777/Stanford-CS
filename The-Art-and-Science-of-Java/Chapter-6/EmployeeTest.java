/* Testing the Employee class.
 * 
 *  The art and science of Java, chapter 6*/

import acm.program.*;

public class EmployeeTest extends ConsoleProgram {
	
	public void run() {
		newguy.setSalary(150.0);
		println("Data for the newguy: ");
		println("Name: "+newguy.getName()+".");
		println("Supervisor: "+newguy.getSupervisor()+".");
		println("Salary: "+newguy.getSalary()+".");
		println("Status: "+( (newguy.getStatus()) ? ("active") : ("not active") )+".");
		println("");
		println("Data for the chief: ");
		println("Name: "+chief.getName()+".");
		println("Supervisor: "+chief.getSupervisor()+".");
		println("Salary: "+chief.getSalary()+".");
		println("Status: "+( (chief.getStatus()) ? ("active") : ("not active") )+".");
	}
	Employee chief = new Employee("Masterchief",200.0);
	Employee oldguy = new Employee("Frank",100.0,false);
	Employee newguy = new Employee("Dank","TBD",15.0);
}
