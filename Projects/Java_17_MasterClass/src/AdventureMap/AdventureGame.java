package AdventureMap;

public class AdventureGame {
    private static final String GAME_LOCATIONS = """
            
            """;

    private enum Compass{
        E, N, S, W;

        private static final String[] directions = {"East", "North", "South", "west"};

        private String getString(){
            return directions[this.ordinal()];
        }
            
        
    }
}
