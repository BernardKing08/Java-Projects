package Abstraction.InterfacesChallange;

enum Geomatry{
    LINE, POINT, POLYGON
}

enum PointMarker{
    CIRCLE, PUSH_PIN, STAR, SQUARE, TRIANGLE
}

enum LineMarker{
    DASHED, DOTTED, SOLID
}


public interface Mappable {
    
    String JSON_PROPERTY = """
            "properties": {%s}
            """;

    String getLabel();

    Geomatry getShape();

    String getMarker();

    default String toJSON(){
        return """
                "type": %s, "label": %s, "Marker" : "%s" """.formatted(getShape(), getLabel(), getMarker());
    }

    static void mapIt(Mappable mappable){
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }
}
