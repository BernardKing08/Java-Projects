package NestedClasses.Comparator;

import java.util.Comparator;
import NestedClasses.domain.Employee;

public class EmployeeComparator <T extends Employee> implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
}
