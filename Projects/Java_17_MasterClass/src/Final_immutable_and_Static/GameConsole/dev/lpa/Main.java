package Final_immutable_and_Static.GameConsole.dev.lpa;

public class Main {
    public static void main(String[] args) {
        var console = new GameConsole<>(new ShooterGame("The Shootout Game"));
        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);
    }
}
