package AdventureMap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AdventureGame game = new AdventureGame();
        game.play("road");

        Scanner sc = new Scanner(System.in);

        while(true){
            String direction = sc.nextLine().trim().toUpperCase().substring(0, 1);
            if(direction.equals("Q")) break;
            game.move(direction);
        }
    }
}
