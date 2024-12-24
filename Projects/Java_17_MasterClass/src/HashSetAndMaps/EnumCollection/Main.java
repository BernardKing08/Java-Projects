package HashSetAndMaps.EnumCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    enum WeekDay{
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
        List<WeekDay> annsWorkDDays = new ArrayList<>(List.of(WeekDay.MONDAY, WeekDay.TUESDAY, WeekDay.WEDNESDAY, WeekDay.THURSDAY, WeekDay.FRIDAY));

        var annsDaySet = EnumSet.copyOf(annsWorkDDays);
        System.out.println(annsDaySet.getClass().getName());
        annsDaySet.forEach(System.out::println);

        System.out.println("_".repeat(30));
        var allDaySet = EnumSet.allOf(WeekDay.class);
        allDaySet.forEach(System.out::println);

        Set<WeekDay> newPersonSet = EnumSet.complementOf(annsDaySet);
        System.out.println("_".repeat(30));
        newPersonSet.forEach(System.out::println);

        Set<WeekDay> anotherWay = EnumSet.copyOf(allDaySet);
        anotherWay.removeAll(annsDaySet);
        System.out.println("_".repeat(30));
        anotherWay.forEach(System.out::println);

        Set<WeekDay> businessDays = EnumSet.range(WeekDay.MONDAY, WeekDay.FRIDAY);
        System.out.println("---------------------");
        businessDays.forEach(System.out::println);

        Map<WeekDay, String[]> employeeMap = new EnumMap<>(WeekDay.class);

        employeeMap.put(WeekDay.FRIDAY, new String[]{"Ann", "Mary", "Bob"});
        employeeMap.put(WeekDay.MONDAY, new String[]{"Mary", "Bob"});
        employeeMap.forEach(
                (k, v) -> System.out.println(k + " : " + Arrays.toString(v)));

    }
}
