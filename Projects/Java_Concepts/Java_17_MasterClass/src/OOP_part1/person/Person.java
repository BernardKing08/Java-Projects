package OOP_part1.person;


public class Person {
    // write code here
    	private String firstName; 
	private String lastName;
	private int age;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age < 0 ? 0 : (age > 100 ? 0 : age);

	}
	
	public boolean isTeen() {
		if(getAge() > 12 && getAge() < 20) 
			return true; 
		else
			return false;
	}
	
	public String getFullName() {
	     if (firstName.isEmpty() && lastName.isEmpty()) {
            return "";
        }
 
        if (firstName.isEmpty()) {
            return lastName;
        }
 
        else if (lastName.isEmpty()) {
            return firstName;
        }
        
        return getFirstName() + " " + getLastName();
	}
	
	
}