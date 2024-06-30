package challange1.Kilometer_Challange;

public class SpeedConverter {
	
	public static void main(String[] args) {
		printConversion(1.25);
	}
	
	
	// write code here
    public static long toMilesPerHour(double kilometersPerHour){
 
    	if(kilometersPerHour < 0){
    		//returns a value of -1 to the printConversion method
            return -1;
        }
        else{
        	//calculation the value of miles per hour and passes the value to the printConversion
        	return Math.round((kilometersPerHour/1.609));
        }
        
    }
    
    public static void printConversion(double kilometersPerHour) {
    	long milesPerHour = toMilesPerHour(kilometersPerHour);
    	
    	if(milesPerHour < 0) 
    		System.out.println("Invalid Value");
    	else {
    		System.out.println(kilometersPerHour + " km/h = " + milesPerHour + " mi/h");
    	}
    		
    }
}