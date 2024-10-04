package Inheritance_part1.Work;

public class Main {

	public static void main(String[] args) {
		//creating  a employee object
		Employee tim = new Employee("Tim", "11/11/2000", "01/01/2020");
		System.out.println(tim); 
		System.out.println("age" + tim.getAge());
		
		SalariedEmployee joe = new SalariedEmployee("joe", "11/11/1990", "0303/2020", 35000, false);
		System.out.println(joe);
		System.out.println("joe pays" + joe.collectPay());
		joe.retire(); 
		System.out.println("Joe pension check is: " + joe.collectPay());

		HourlyEmployee mary = new HourlyEmployee("mary", "05/05/2000", "12/05/2022", 15);
		System.out.println(mary);
		System.out.println("Marys paycheck is " + mary.collectPay());
		System.out.println("Marys doublecheck is " + mary.getDoublePay());

	}

}
