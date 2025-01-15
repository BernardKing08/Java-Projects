package Final_immutable_and_Static.GameConsole.dev.lpa;

import java.util.function.Predicate;

public record GameAction(char key, String prompt, Predicate<Integer> action) {
    
}
