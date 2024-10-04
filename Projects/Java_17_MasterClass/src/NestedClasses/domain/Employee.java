package NestedClasses.domain;

import java.util.Comparator;

public class Employee {

    //using a static class inside a class
    public static class EmployeeComparator <T extends Employee> implements Comparator<Employee>{

    private String sortType;

    //no arg constructor
    public EmployeeComparator(String sortType) {
        this.sortType = "name";
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        //sorting by year started instead
        if((sortType).equalsIgnoreCase("yearStarted")){
            return o1.yearStarted - o2.yearStarted;
        }

        return o1.name.compareTo(o2.name);
    }
    
}

    private int employeeId;
    private String name;
    private int yearStarted;

    public Employee(){

    }

    public Employee(int employeeId, String name, int yearStarted){
        this.name = name;
        this.employeeId = employeeId;
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "%d %-8s %d".formatted(employeeId, name, yearStarted);
    }
}
