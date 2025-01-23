package Final_immutable_and_Static.GameConsole.dev.lpa;

public record Shooter(String name) implements Player {

    boolean findPrize() {
        System.out.println("Price found, score should be adjusted.");
        return false;
    }

    boolean useWeapon(String weapon){
        System.out.println("You shot your " + weapon);
        return false;
    }
    
}
