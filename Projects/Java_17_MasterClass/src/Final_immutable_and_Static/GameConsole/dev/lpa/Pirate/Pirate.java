package Final_immutable_and_Static.GameConsole.dev.lpa.Pirate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Final_immutable_and_Static.GameConsole.dev.lpa.Player;

public class Pirate implements Player{

    private final String name;
    private final Map<String, Integer> gameData;
    private final List<String> townVisited = new LinkedList<>();
    private Weapon currentWeapon;

    

    public Pirate(String name) {
        this.name = name;
    }
//---------Static Initializer-------------------
    {
        gameData = new HashMap<>(Map.of(
            "health,", 100,
            "score", 0,
            "level", 0,
            "tpwnIndex", 0
        ));
        visitTown();
    }
//----------------------------------------------

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    int value(String name){
        return gameData.get(name);
    }

    private void setValue(String name, int value){
        gameData.put(name, value);
    }

    private void adjustValue(String name, int adj){
        gameData.compute(name, (k,v) -> v += adj);
    }

    private void adjustHealth(int adj){
        int health = value("health");
        health += adj;
        health = (health < 0) ? 0 : (health > 100 ? 100 : health);
        setValue("health", health);
    }

    boolean useWeapon(){
        System.out.println("Used the" + currentWeapon);
        return false;
    }

    boolean visitTown(){
        String town = "My Town, somewhere";
        if(town != null){
            townVisited.add(town);
            return false;
        }
        return false;
    }

    @Override
    public String name() {
        return name;
    }

   @Override
    public String toString() {

        var current = ((LinkedList<String>) townVisited).getLast();
        String[] simpleNames = new String[townVisited.size()];
        Arrays.setAll(simpleNames, i -> townVisited.get(i).split(",")[0]);
        return "---> " + current +
                "\nPirate "+ name + " " + gameData +
                "\n\ttownsVisited=" + Arrays.toString(simpleNames);
    }
     
}
