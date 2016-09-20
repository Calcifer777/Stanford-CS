/* Toy program: a class that stores some data about a made up 
 * employee and that can return any piece of this data
 * 
 * The Art and Science of Java - Chapter 6
 */

public class Employee {
	
	/* Setting 4 specification for initializing a new employee object */
	
	public Employee(String a, String b, Double i, Boolean c) {
		name=a;
		supervisor=b;
		salary=i;
		status=c;
	}
	
	public Employee(String a, String b, Double i) {
		this(a,b,i,true);
	}
	
	public Employee(String a, String b) {
		this(a,b,-1.0,true);
	}
	
	public Employee(String a) {
		this(a,"No supervisor",-1.0,true);
	}
	
	public Employee(String a, Double i) {
		this(a,"No supervisor",i,true);
	}
	
	public Employee(String a, Double i, Boolean flag) {
		this(a,"No supervisor",i,flag);
	}
	/** Returns the current employee's name */
	public String getName() {
		return name;
	}
	/** Returns the current employee's supervisor */
	public String getSupervisor() {
		return supervisor;
	}
	/** Returns the current employee's salary */
	public Double getSalary() {
		return salary;
	}
	/** Returns the current employee's status */
	public Boolean getStatus() {
		return status;
	}
	
	/** Changes the employee's name
 	* @param newname The new name assigned to the employee */
	
	public void setName(String newname) {
		name=newname;
	}
	/** Changes the employee's salary
	 *  @param newsalary The new salary of the employee */
	public void setSalary(Double newsalary) {
		salary=newsalary;
	}
	/** Changes the employee's supervisor 
	 * @param newsupervisor The new supervisor assigned to the employee */
	public void setSupervisor(String newsupervisor) {
		supervisor=newsupervisor;
	}
	/** Changes the employee's status
	 * @param newname The new name assigned to the employee */
	public void setStatus(Boolean newstatus) {
		status=newstatus;
	}
	
/*Instance variables*/
	private String name;
	private String supervisor;
	private Double salary;
	private Boolean status;
	
}
