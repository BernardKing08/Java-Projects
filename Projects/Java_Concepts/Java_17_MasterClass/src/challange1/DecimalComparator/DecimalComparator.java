package challange1.DecimalComparator;

public class DecimalComparator {
		// write code here
		public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
			int intNum1 = (int) (num1 * 1000);
			int intNum2 = (int) (num2 * 1000);
	
			return intNum1 == intNum2;
		}
}
