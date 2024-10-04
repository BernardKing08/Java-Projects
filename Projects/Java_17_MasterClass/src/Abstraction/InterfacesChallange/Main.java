package Abstraction.InterfacesChallange;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        //creating a list that can hold classes that implment the interface mappables
        List<Mappable> mappables = new ArrayList<>();

        //adding objects of building class to the list
        mappables.add(new Building("Lagos empire", UsageType.GOVERNMENT));
        mappables.add(new Building("Ekiti town square", UsageType.ENTERTAINMENT));
        mappables.add(new Building("National Stadium", UsageType.SPORTS));

        //adding objects of utility class to the list
        mappables.add(new UtilityLine("College St", UtilityType.FIBER_OPTIC));
        mappables.add(new UtilityLine("Olympic blvd", UtilityType.WATER));

        for(var m : mappables){
            Mappable.mapIt(m);
        }
    }
}
