package Inheritance_part1.Work;

public class SalariedEmployee extends Employee{


	private double annualSalary;
	private boolean isRetired;
	
	public SalariedEmployee(String name, String birthDate, String hireDate, double annualSalary, boolean isRetired) {
		super(name, birthDate, hireDate);
		this.annualSalary = annualSalary;
		this.isRetired = isRetired;
	}
	
	
	public double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}

	public boolean isRetired() {
		return isRetired;
	}

	public void setRetired(boolean isRetired) {
		this.isRetired = isRetired;
	}

	@Override
	public double collectPay(){
		double payCheck = annualSalary /26;
		double adjustedPay = (isRetired) ? 0.9 * payCheck : payCheck;

		return (int) adjustedPay;
	}

	public void retire(){
		terminate("12/12/2026");

		isRetired = true;
	}

}
