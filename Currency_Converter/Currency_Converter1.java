import java.util.Scanner;
import java.util.Currency;
import java.util.Locale;
import java.text.NumberFormat;

public class Currency_Converter1{
	static String arr[] = {"en", "en", "en", "fr"}; 
	static String arr1[] = {"CA", "IN", "MO", "FR"};
	static String arr2[] = {"US", "India", "China", "France"};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Number you wish to convert: ");
        double num = sc.nextDouble(); 

        for(int i = 0; i < 4; i++) {
			gerr(num, arr[i], arr1[i], arr2[i]); 
		}

		sc.close();
	}
	
	public static void gerr(double num, String str, String str1, String str2) {
		Locale locale = new Locale(str, str1); 
		Currency curr = Currency.getInstance(locale); 
		NumberFormat format = NumberFormat.getCurrencyInstance(locale); 
		
		System.out.println(str2 + ": " + format.format(num)); 
	}
}