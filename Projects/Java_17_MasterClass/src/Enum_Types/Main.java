package Enum_Types;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        
        DayOfTheWeek weekDay = DayOfTheWeek.TUES;
        System.out.println(weekDay);
        System.out.println("Weekday ordinal is" + weekDay.ordinal());

        System.out.println(getRandomDay());
    }

    public static DayOfTheWeek getRandomDay(){
        int randomInteger = new Random().nextInt(7);
        var allDays = DayOfTheWeek.values();

        return allDays[randomInteger];
    }
}
