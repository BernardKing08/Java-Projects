package NestedClasses.domain;

import java.util.Comparator;

public class StoreEmployee extends Employee{
    private String store;

    
    public StoreEmployee() {
        
    }

    public StoreEmployee(int employeeId, String name, int yearStarted, String store) {
        super(employeeId, name, yearStarted);
        this.store = store;
    }

    @Override
    public String toString(){
        return "-8%s %s".formatted(store, super.toString());

    }



    //using an innerclass to immplement comparator
    public class StoreComparator <T extends StoreEmployee> implements Comparator<StoreEmployee>{

        @Override
        public int compare(StoreEmployee o1, StoreEmployee o2) {
            int result = o1.store.compareTo(o2.store);

            //checking if the employees are of the same store
            if(result == 0){
                return new Employee.EmployeeComparator<>("yearstarted").compare(o1, o2);
            }
            return result;
        }
    }
}
