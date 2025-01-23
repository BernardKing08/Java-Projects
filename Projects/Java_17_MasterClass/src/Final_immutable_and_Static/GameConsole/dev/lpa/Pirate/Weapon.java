package Final_immutable_and_Static.GameConsole.dev.lpa.Pirate;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum Weapon {
    KNIFE(0, 10),
    AXE(0, 30),
    MACHETE(1, 40),
    PISTOL(1, 50);

    private final int minLevel;
    private final int hitPoints;

    Weapon(int minLevel, int hitPoints){
        this.minLevel = minLevel;
        this.hitPoints = hitPoints;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public static Weapon getWeaponByChar(char firstInitial){
        for(Weapon w : values()){
            if(w.name().charAt(0) == firstInitial){
                return w;
            }
        }

        return values()[0];
    }

    public static List<Weapon> getWeaponByLevel(int LevelOfPlay){
        List<Weapon> weapons = new ArrayList<>(EnumSet.allOf(Weapon.class));
        weapons.removeIf(w -> (w.minLevel > LevelOfPlay));
        return weapons;
    }
}
