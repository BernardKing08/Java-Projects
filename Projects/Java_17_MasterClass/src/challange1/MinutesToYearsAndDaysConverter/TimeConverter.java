package challange1.MinutesToYearsAndDaysConverter;

public class TimeConverter {

    public static void main(String[] args) {
        printYearsAndDays(7000);
    }

    
    public static void printYearsAndDays(long minutes){
        if(minutes < 0){
            System.out.println("Invalid Text");
            
            
        }

        else {
            int years = (int) (minutes/525600);
            int minutesLeft = (int) minutes % 525600;

            int days = (int) minutesLeft / 1440;

            System.out.println(minutes + " min = " + years + " y and " + days + " d");
        }
        
    }
}
