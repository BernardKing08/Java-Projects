package Generics_1.Generics_challange;

import java.util.*;

public interface Mappable {
    
    void render();

    static double[] stringToLatLocation(String location){
        var splits = location.split(",");
        double lat = Double.valueOf(splits[0]);
        double lng = Double.valueOf(splits[1]);

        return new double[]{lat, lng};
    }
}

abstract class Point implements Mappable{
    private double[] location = new double[2];

    public Point(String location){
        this.location = Mappable.stringToLatLocation(location);
    }

    @Override
    public void render(){
        System.out.println("Render" + this + "as POINT (" + location() + ")");
    }

    private String location(){
        return Arrays.toString(location);
    }
}

abstract class Line implements Mappable{
    private double[][] locations;

    public Line(String... locations){
        this.locations = new double[locations.length][];
        int index = 0;

        for(var l : locations){
            this.locations[index++] = Mappable.stringToLatLocation(l);
        }

    }

    private String location(){
        return Arrays.deepToString(locations);
    }
}
