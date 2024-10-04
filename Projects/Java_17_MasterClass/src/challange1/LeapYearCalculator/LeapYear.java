package challange1.LeapYearCalculator;


public class LeapYear{
	
	public static void main(String[] args) {
		System.out.println(isLeapYear(1924));
	}

    // write code here
    public static boolean isLeapYear(int year){
		if((year >= 1) && (year <=9999)) {
			if((year % 4) == 0) {
				if(((year % 100) != 0) || ((year % 400) == 0)) {
					return true; 
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
			
		}
		else {
			return false;
		}
			
		
		
	}
}