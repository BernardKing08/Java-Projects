package Final_immutable_and_Static.GameConsole.dev.lpa;

import Final_immutable_and_Static.GameConsole.dev.lpa.Pirate.Weapon;

public class Main {
    public static void main(String[] args) {
        //Code for shooter game test 
        // var console = new GameConsole<>(new ShooterGame("The Shootout Game"));
        // int playerIndex = console.addPlayer();
        // console.playGame(playerIndex);

        Weapon weapon = Weapon.getWeaponByChar('P');
        System.out.println("weapon = " + weapon + ", hitpoints = " +
                            weapon.getHitPoints() + ", minLevel=" + weapon.getMinLevel());

        var list = Weapon.getWeaponByLevel(1);
        list.forEach(System.out::println);
    }
}
