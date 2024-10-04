package Inheritance_part1.Work;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Worker {

	private String name; 
    private String birthData; 
    protected String endDate;

    public Worker() {
		
	}
    
    public Worker(String name, String birthData) {
		
		this.name = name;
		this.birthData = birthData;
	}
    
    
    public String getAge(){
        //formats the date to the rerquired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            // Parse the given date
            LocalDate givenDate = LocalDate.parse(birthData, formatter);
            
            // Get the current date
            LocalDate currentDate = LocalDate.now();
            
            // Calculate the difference
            Period period = Period.between(givenDate, currentDate);
            int yearsDifference = period.getYears();
            
            // Output the result
            String str = String.valueOf(yearsDifference);

            return str;

        } catch (DateTimeParseException e) {
            return e.getMessage();
        }

        
    }

    public double collectPay(){
        return 0;
    }

    public void terminate(String endDate) {
    	this.endDate = endDate; 
    }

	@Override
	public String toString() {
		return "Worker [name=" + name + ", birthData=" + birthData + ", endDate=" + endDate + "]";
	}
    
    
    
}
