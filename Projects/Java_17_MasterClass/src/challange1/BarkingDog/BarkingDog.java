package challange1.BarkingDog;

public class BarkingDog {
    // write code here
     public static boolean shouldWakeUp(boolean barking, int hourOfDay){
		
   	if(barking) {
   		if((hourOfDay >= 0) && (hourOfDay <= 23)) {
   			if(hourOfDay < 8 || hourOfDay > 22) {
   				return true;
   			}
   			else 
   				return false;
   		}
   		else
   			return false;
   	}
   	
   	else {
   		return false;
   	}
   	
	}
}