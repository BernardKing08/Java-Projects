package NestedClasses.LocalClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import NestedClasses.LocalClasses.domain.*;
import NestedClasses.LocalClasses.domain.StoreEmployee;
import NestedClasses.InnerClasses.*;

public class RunMain {
    public static void main(String[] args) {
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Meg", 2019,
                        "Target"),
            new StoreEmployee(10515, "Joe", 2021,
                    "Walmart"),
            new StoreEmployee(10105, "Tom", 2020,
                    "Macys"),
            new StoreEmployee(10215, "Marty", 2018,
                    "Walmart"),
            new StoreEmployee(10322, "Bud", 2016,
                    "Target")));


        var c0 = new EmployeeComparator<StoreEmployee>();
        var c1 = new Employee.EmployeeComparator<StoreEmployee>();
        var c2 = new StoreEmployee().new StoreComparator<StoreEmployee>();

        
        class NameSort<T> implements Comparator<StoreEmployee>{

            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
            
        }

        var c3 = new NameSort<StoreEmployee>();

        //creating an anonymous class
        var c4 = new Comparator<StoreEmployee>() {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        sortIT(storeEmployees, c0);
        sortIT(storeEmployees, c1);
        sortIT(storeEmployees, c2);
        sortIT(storeEmployees, c3);
        sortIT(storeEmployees, new Comparator<StoreEmployee>() {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public static <T> void sortIT(List<T> list, Comparator<? super T> comparator){
        System.out.println("Sorting with comparator: " + comparator.toString());
        list.sort(comparator);
        for(var employee : list){
            System.out.println(employee);
        }

        System.out.println();
    }
}
