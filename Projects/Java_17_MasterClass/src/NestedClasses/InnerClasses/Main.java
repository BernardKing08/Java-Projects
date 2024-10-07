package NestedClasses.InnerClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import NestedClasses.InnerClasses.Comparator.EmployeeComparator;
import NestedClasses.InnerClasses.domain.Employee;
import NestedClasses.InnerClasses.domain.StoreEmployee;



public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(new Employee(10001, "Ralph", 2015),
            new Employee(10005, "Carole", 2021),
            new Employee(10022, "Jane", 2020),
            new Employee(10035, "Mary", 1998),
            new Employee(10007, "Bog", 2022),
            new Employee(10009, "Zain", 2008)));

        //creating a object to carry out comparisons
        // var comparator = new EmployeeComparator<>();
        // employees.sort(comparator);

        employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());
 
        for(Employee e : employees){
            System.out.println(e);
        }
        


        System.out.println("\nStore members");

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(new StoreEmployee(10015, "Meg", 2024, "Walmart"),
            new StoreEmployee(10015, "Craig", 2024, "Walmart"),
            new StoreEmployee(10015, "Kaneau", 2024, "Freedom"),
            new StoreEmployee(10015, "Reynold", 2024, "Disney")));

        //creating a new storeEmployee object to access the inner class
        StoreEmployee storeEmployee = new StoreEmployee();
        var comparator = storeEmployee.new StoreComparator<>();

        storeEmployees.sort(comparator);
        System.out.println("-".repeat(30));
        for(StoreEmployee sw : storeEmployees){
            System.out.println(sw);
        }
    }
}
