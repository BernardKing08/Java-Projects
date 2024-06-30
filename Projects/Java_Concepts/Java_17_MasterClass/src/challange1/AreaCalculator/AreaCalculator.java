package challange1.AreaCalculator;

public class AreaCalculator {

    public static double area(double radius){

        if(radius < 0)
            return -1.0;

        //returns the area of a circle
        return (Math.PI * radius * radius);
    }

    public static double area(double x, double y){
        //validity check
        if((x < 0) || (y < 0)){
            return -1.0;
        }
        //return the area of a rectangle
        return x * y;
    }
    
}
