package Final_immutable_and_Static.FinalExplored.external;

import java.time.LocalDateTime;

public class Logger {
    
    public static void logToConsole(CharSequence message){
        LocalDateTime dt = LocalDateTime.now();
        System.out.printf("%1$tD %1$tT : %2$%n", dt, message);

        if(message instanceof StringBuilder sb){
            sb.setLength(0);
        }
    }
}
