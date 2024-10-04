package Generics_2.util;

import java.util.ArrayList;
import java.util.List;

import Generics_2.model.Student;

public class QueryList <T extends Student & QueryItem> extends ArrayList<T>{

    // private List<T> items;

    public QueryList(){
        //no arg constructor
    }

    public QueryList(List<T> items) {
        super();
        //this.items = items;
    }

    public static <S extends QueryItem> List<S> getMatches(List<S> items,
                                                           String field, String value) {
        //adds a given set of objects into the arrayList that matches a specific field and value
        List<S> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }

    public List<T> getMatches(String field, String value) {

        QueryList<T> matches = new QueryList<>();
        for (var item : this) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
}
