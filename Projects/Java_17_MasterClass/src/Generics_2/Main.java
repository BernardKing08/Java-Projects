package Generics_2;

import Generics_2.util.QueryList;
import Generics_2.model.Student;

import java.util.Comparator;
import java.util.List;

import Generics_2.model.LPAStudent;
import Generics_2.model.LPAStudentComparator;

public class Main {

    public static void main(String[] args) {
        QueryList<LPAStudent> queryList = new QueryList<>();

        for(int i = 0; i < 25; i++){
            queryList.add(new LPAStudent());
        }

        System.out.println("Ordered");
        queryList.sort(Comparator.naturalOrder());
        printList(queryList);

        System.out.println("Matches");
        var matches = ((QueryList<LPAStudent>) queryList.getMatches("percentComplete", "50"))
                                .getMatches("Course", "Python");

        printList(matches);

        matches.sort(new LPAStudentComparator());
        printList(matches);
    }

    public static void printList(List<?> students){
        for(var student : students){{
            System.out.println(student);
        }}
    }
    
}

