package Inheritance_part1.Work;

public class Employee extends Worker{

	private int employeeID;
	private String hireDate;
	protected static int employeeCount; 
	
	
	public Employee(String name, String birthDate, String hireDate) {
		super(name, birthDate);
		this.employeeID = Employee.employeeCount++;
		this.hireDate = hireDate;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	

}
